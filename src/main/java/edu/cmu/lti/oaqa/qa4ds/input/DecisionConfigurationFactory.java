package edu.cmu.lti.oaqa.qa4ds.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.input.Question;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionValue;

public final class DecisionConfigurationFactory {

  private static Yaml yaml = new Yaml();

  static DecisionConfiguration loadFromResource(JCas jcas, String templatePath,
          Map<String, String> var2value, String confPath) throws IOException,
          DecisionConfigurationException {
    return createComposite(jcas, loadTemplateResource(templatePath), var2value,
            loadConfigurationResource(confPath));
  }

  @SuppressWarnings("unchecked")
  private static Map<String, Object> loadTemplateResource(String templatePath) {
    String parsedResourcePath = ResourceUtil.getResourceLocation(templatePath);
    InputStream is = DecisionConfigurationFactory.class.getResourceAsStream(parsedResourcePath);
    return (Map<String, Object>) yaml.load(is);
  }

  @SuppressWarnings("unchecked")
  private static Map<String, String> loadConfigurationResource(String confPath) {
    String parsedConfPath = ResourceUtil.getResourceLocation(confPath);
    InputStream is = DecisionConfigurationFactory.class.getResourceAsStream(parsedConfPath);
    return (Map<String, String>) yaml.load(is);
  }

  @SuppressWarnings("unchecked")
  private static DecisionConfiguration createComposite(JCas jcas, Map<String, Object> templateData,
          Map<String, String> var2value, Map<String, String> confData) throws IOException,
          DecisionConfigurationException {
    DecisionConfiguration parent = createPrimitive(jcas, templateData, var2value, confData);
    if (!templateData.containsKey("factors")) {
      return parent;
    }
    // load optional parameter factors
    parent.setPrimitive(false);
    List<DecisionConfiguration> factors = Lists.newArrayList();
    for (Map<String, Object> factor : (List<Map<String, Object>>) templateData.get("factors")) {
      if (factor.containsKey("inherit")) {
        Map<String, Object> factorData = loadTemplateResource((String) factor.get("inherit"));
        factor.remove("inherit");
        factor.putAll(factorData);
      }
      DecisionConfiguration child = createComposite(jcas, factor, var2value, confData);
      factors.add(child);
    }
    DecisionConfigurationUtil.setFactors(jcas, parent, factors);
    return parent;
  }

  @SuppressWarnings("unchecked")
  private static DecisionConfiguration createPrimitive(JCas jcas, Map<String, Object> templateData,
          Map<String, String> var2value, Map<String, String> confData)
          throws DecisionConfigurationException {
    // load optional parameter name
    String templateName = null;
    if (templateData.containsKey("name")) {
      templateName = (String) templateData.get("name");
    }
    // load mandatory parameter question
    String question = (String) templateData.get("question");
    // load optional parameter vars
    List<String> vars = Lists.newArrayList();
    if (templateData.containsKey("vars")) {
      vars = (List<String>) templateData.get("vars");
    }
    // load optional parameter weight
    double weight = Double.NaN;
    if (templateData.containsKey("weight")) {
      weight = (Double) templateData.get("weight");
    }
    // retrieve configuration
    String configuration = null;
    if (confData.containsKey(templateName)) {
      configuration = confData.get(templateName);
    } else {
      configuration = confData.get("default");
    }
    // construct var2value from current vars and var2value passed from the parent
    Map<String, String> factorVar2value = Maps.filterKeys(var2value, Predicates.in(vars));
    if (factorVar2value.size() < vars.size()) {
      Set<String> missingVars = Sets
              .difference(ImmutableSet.copyOf(vars), factorVar2value.keySet());
      throw new DecisionConfigurationException("Variables " + missingVars
              + " are defined in template, but no values assigned.");
    }
    return createPrimitive(jcas, templateName, question, factorVar2value, weight, configuration);
  }

  private static DecisionConfiguration createPrimitive(JCas jcas, String templateName,
          String templateQuestion, Map<String, String> var2value, double weight,
          String configuration) {
    return create(jcas, templateName, templateQuestion, var2value,
            Lists.<DecisionConfiguration> newArrayList(), true, weight, configuration);
  }

  private static DecisionConfiguration create(JCas jcas, String templateName,
          String templateQuestion, Map<String, String> var2value,
          List<DecisionConfiguration> factors, boolean primitive, double weight,
          String configuration) {
    QuestionValueListPair pair = QuestionValueListPair.create(jcas, templateQuestion, var2value);
    return create(jcas, templateName, pair.getQuestion(), factors, primitive, weight,
            configuration, pair.getValues());
  }

  private static DecisionConfiguration create(JCas jcas, String templateName, Question question,
          List<DecisionConfiguration> factors, boolean primitive, double weight,
          String configuration, List<DecisionValue> values) {
    DecisionConfiguration ret = new DecisionConfiguration(jcas);
    ret.setTemplateName(templateName);
    ret.setQuestion(question);
    DecisionConfigurationUtil.setFactors(jcas, ret, factors);
    ret.setPrimitive(primitive);
    ret.setWeight(weight);
    ret.setConfiguration(configuration);
    DecisionConfigurationUtil.setValues(jcas, ret, values);
    return ret;
  }

}
