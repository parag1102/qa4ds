package edu.cmu.lti.oaqa.qa4ds.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;
import org.yaml.snakeyaml.Yaml;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate;
import edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate;

public final class DecisionTemplateFactory {

  @SuppressWarnings("unchecked")
  static DecisionTemplate loadFromResource(JCas jcas, String resourcePath) throws IOException,
          DecisionTemplateVariableUndefinedException {
    String parsedResourcePath = ResourceUtil.getResourceLocation(resourcePath);
    Yaml yaml = new Yaml();
    InputStream is = DecisionTemplateFactory.class.getResourceAsStream(parsedResourcePath);
    Map<String, Object> data = (Map<String, Object>) yaml.load(is);
    return createComposite(jcas, data);
  }

  @SuppressWarnings("unchecked")
  private static DecisionTemplate createComposite(JCas jcas, Map<String, Object> data)
          throws IOException, DecisionTemplateVariableUndefinedException {
    DecisionTemplate parent = createPrimitive(jcas, data);
    if (!data.containsKey("factors")) {
      return parent;
    }
    // load optional parameter factors
    parent.setPrimitive(false);
    List<WeightDecisionTemplate> factors = Lists.newArrayList();
    for (Map<String, Object> factor : (List<Map<String, Object>>) data.get("factors")) {
      DecisionTemplate child = factor.containsKey("inherit") ? loadFromResource(jcas,
              (String) factor.get("inherit")) : createComposite(jcas, factor);
      // check if the variables defined in subfactors are covered by the parent
      if (!getVars(parent).containsAll(getVars(child))) {
        throw new DecisionTemplateVariableUndefinedException(getVars(parent), getVars(child));
      }
      double weight = (Double) factor.get("weight");
      factors.add(create(jcas, child, weight));
    }
    setFactors(jcas, parent, factors);
    return parent;
  }

  @SuppressWarnings("unchecked")
  private static DecisionTemplate createPrimitive(JCas jcas, Map<String, Object> data) {
    // load optional parameter name
    String name = null;
    if (data.containsKey("name")) {
      name = (String) data.get("name");
    }
    // load mandatory parameter question
    String question = (String) data.get("question");
    // load optional parameter vars
    List<String> vars = Lists.newArrayList();
    if (data.containsKey("vars")) {
      vars = (List<String>) data.get("vars");
    }
    return createPrimitive(jcas, name, vars, question);
  }

  static DecisionTemplate createComposite(JCas jcas, String name, List<String> vars,
          String question, List<WeightDecisionTemplate> factors) {
    return create(jcas, name, vars, question, factors, false);
  }

  static DecisionTemplate createPrimitive(JCas jcas, String name, List<String> vars, String question) {
    return create(jcas, name, vars, question, Lists.<WeightDecisionTemplate> newArrayList(), true);
  }

  private static WeightDecisionTemplate create(JCas jcas, DecisionTemplate template, double weight) {
    WeightDecisionTemplate ret = new WeightDecisionTemplate(jcas);
    ret.setTemplate(template);
    ret.setWeight(weight);
    return ret;
  }

  private static DecisionTemplate create(JCas jcas, String name, List<String> vars,
          String question, List<WeightDecisionTemplate> factors, boolean primitive) {
    DecisionTemplate ret = new DecisionTemplate(jcas);
    ret.setName(name);
    setVars(jcas, ret, vars);
    ret.setQuestion(question);
    setFactors(jcas, ret, factors);
    ret.setPrimitive(primitive);
    return ret;
  }

  static Collection<String> getVars(DecisionTemplate template) {
    return FSCollectionFactory.create(template.getVars());
  }

  static void setVars(JCas jcas, DecisionTemplate template, List<String> vars) {
    template.setVars(FSCollectionFactory.createStringList(jcas, vars));
  }

  static Collection<WeightDecisionTemplate> getFactors(DecisionTemplate template) {
    return FSCollectionFactory.create(template.getFactors(), WeightDecisionTemplate.class);
  }

  static void setFactors(JCas jcas, DecisionTemplate parent, List<WeightDecisionTemplate> factors) {
    parent.setFactors(FSCollectionFactory.createFSList(jcas, factors));
  }

}
