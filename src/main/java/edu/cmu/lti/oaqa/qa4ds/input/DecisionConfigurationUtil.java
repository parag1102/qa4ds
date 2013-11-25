package edu.cmu.lti.oaqa.qa4ds.input;

import java.util.Collection;
import java.util.List;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;

import com.google.common.collect.Iterables;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionValue;

public class DecisionConfigurationUtil {

  static DecisionConfiguration getFactorByTemplateName(DecisionConfiguration decision,
          String templateName) {
    return Iterables.getOnlyElement(Iterables.filter(getFactors(decision), new MatchesTemplateName(
            templateName)));
  }

  static Collection<DecisionConfiguration> getFactors(DecisionConfiguration decision) {
    return FSCollectionFactory.create(decision.getFactors(), DecisionConfiguration.class);
  }

  static void setFactors(JCas jcas, DecisionConfiguration parent,
          List<DecisionConfiguration> factors) {
    parent.setFactors(FSCollectionFactory.createFSList(jcas, factors));
  }

  static Collection<DecisionValue> getValues(DecisionConfiguration decision) {
    return FSCollectionFactory.create(decision.getValues(), DecisionValue.class);
  }

  static void setValues(JCas jcas, DecisionConfiguration template, List<DecisionValue> values) {
    template.setValues(FSCollectionFactory.createFSList(jcas, values));
  }

}
