package edu.cmu.lti.oaqa.qa4ds.input;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.yaml.snakeyaml.Yaml;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.framework.DataElement;
import edu.cmu.lti.oaqa.framework.collection.IterableCollectionReader;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;
import edu.cmu.lti.oaqa.qa4ds.util.EcdUtil;

public class DecisionConfigurationCollectionReader extends IterableCollectionReader {

  private static Yaml yaml = new Yaml();

  private List<InputPair> inputs = Lists.newArrayList();

  private int count = -1;

  private String confPath;

  @SuppressWarnings("unchecked")
  @Override
  protected Iterator<DataElement> getInputSet() throws ResourceInitializationException {
    // load input file
    String inputPath = EcdUtil.getResourceLocation((String) getConfigParameterValue("input"));
    InputStream is = getClass().getResourceAsStream(inputPath);
    List<Map<String, Object>> data = (List<Map<String, Object>>) yaml.load(is);
    // create (template, values) pairs
    String template = null;
    Map<String, String> values = null;
    for (Map<String, Object> datum : data) {
      if (datum.containsKey("template")) {
        template = (String) datum.get("template");
      }
      if (datum.containsKey("values") && template != null) {
        values = (Map<String, String>) datum.get("values");
        inputs.add(new InputPair(template, values));
      }
    }
    // load configuration file
    confPath = (String) getConfigParameterValue("conf");
    // return input pair iterator
    return new Iterator<DataElement>() {

      @Override
      public void remove() {
        // Do nothing
      }

      @Override
      public DataElement next() {
        count++;
        InputPair pair = inputs.get(count);
        return new DataElement(getDataset(), String.valueOf(count), pair.toString(), getUUID());
      }

      @Override
      public boolean hasNext() {
        return count + 1 < inputs.size();
      }
    };
  }

  // default decorator to add input and decision template into the JCas loaded from input yaml.
  @Override
  protected void decorate(JCas jcas) throws AnalysisEngineProcessException {
    InputPair pair = inputs.get(count);
    try {
      String templatePath = pair.getKey();
      Map<String, String> var2value = pair.getValue();
      DecisionConfiguration input = DecisionConfigurationFactory.loadFromResource(jcas,
              templatePath, var2value, confPath);
      input.addToIndexes(jcas);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
    // call other decorators
    super.decorate(jcas);
  }

}
