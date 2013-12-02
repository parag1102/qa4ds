package edu.cmu.lti.oaqa.qa4ds.input;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionValue;

public class DecisionConfigurationUtil {

  private static class GetsMapValue<T> implements Function<Map<String, T>, T> {

    private String key;

    private GetsMapValue(String key) {
      this.key = key;
    }

    @Override
    public T apply(Map<String, T> input) {
      return input.get(key);
    }

  }

  private static Yaml yaml = new Yaml();

  public static List<String> getAnalyzers(DecisionConfiguration decision) {
    String configuration = decision.getConfiguration();
    @SuppressWarnings("unchecked")
    Map<String, List<Map<String, String>>> key2components = (Map<String, List<Map<String, String>>>) yaml
            .load(configuration);
    return Lists.transform(key2components.get("analyzers"), new GetsMapValue<String>("inherit"));
  }

  public static List<String> getMergers(DecisionConfiguration decision) {
    String configuration = decision.getConfiguration();
    @SuppressWarnings("unchecked")
    Map<String, List<Map<String, String>>> key2components = (Map<String, List<Map<String, String>>>) yaml
            .load(configuration);
    return Lists.transform(key2components.get("mergers"), new GetsMapValue<String>("inherit"));
  }

  public static List<Map<String, Object>> getMergerDescriptions(DecisionConfiguration decision) {
    String configuration = decision.getConfiguration();
    @SuppressWarnings("unchecked")
    Map<String, List<Map<String, Object>>> key2components = (Map<String, List<Map<String, Object>>>) yaml
            .load(configuration);
    return key2components.get("mergers");
  }

  static DecisionConfiguration getFactorByTemplateName(DecisionConfiguration decision,
          String templateName) {
    return Iterables.getOnlyElement(Iterables.filter(getFactors(decision), new MatchesTemplateName(
            templateName)));
  }

  public static Collection<DecisionConfiguration> getFactors(DecisionConfiguration decision) {
    return FSCollectionFactory.create(decision.getFactors(), DecisionConfiguration.class);
  }

  static void setFactors(JCas jcas, DecisionConfiguration parent,
          List<DecisionConfiguration> factors) {
    parent.setFactors(FSCollectionFactory.createFSList(jcas, factors));
  }

  public static Collection<DecisionValue> getValues(DecisionConfiguration decision) {
    return FSCollectionFactory.create(decision.getValues(), DecisionValue.class);
  }

  static void setValues(JCas jcas, DecisionConfiguration template, List<DecisionValue> values) {
    template.setValues(FSCollectionFactory.createFSList(jcas, values));
  }

}
