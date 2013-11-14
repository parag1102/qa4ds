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
import edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput;

public class DecisionTemplateInputCollectionReader extends IterableCollectionReader {

  private List<InputPair> inputs = Lists.newArrayList();

  private int count = -1;

  @SuppressWarnings("unchecked")
  @Override
  protected Iterator<DataElement> getInputSet() throws ResourceInitializationException {
    // load input file
    String resource = (String) getConfigParameterValue("file");
    String parsedResourcePath = ResourceUtil.getResourceLocation(resource);
    Yaml yaml = new Yaml();
    InputStream is = getClass().getResourceAsStream(parsedResourcePath);
    List<Map<String, Object>> data = (List<Map<String, Object>>) yaml.load(is);
    // create (template, values) pairs
    String template = null;
    List<String> values = null;
    for (Map<String, Object> datum : data) {
      if (datum.containsKey("template")) {
        template = (String) datum.get("template");
      }
      if (datum.containsKey("values") && template != null) {
        values = (List<String>) datum.get("values");
        inputs.add(new InputPair(template, values));
      }
    }
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

  // Default decorator to add input and decision template into the JCas loaded from input yaml.
  @Override
  protected void decorate(JCas jcas) throws AnalysisEngineProcessException {
    super.decorate(jcas);
    InputPair pair = inputs.get(count);
    try {
      DecisionTemplate template = DecisionTemplateFactory.loadFromResource(jcas, pair.getKey());
      if (DecisionTemplateFactory.getVars(template).size() != pair.getValue().size()) {
        throw new DecisionTemplateInputValuesUnmatchException(DecisionTemplateFactory.getVars(
                template).size(), pair.getValue().size());
      }
      DecisionTemplateInput input = DecisionTemplateInputFactory.create(jcas, template,
              pair.getValue());
      input.addToIndexes(jcas);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

}
