package edu.cmu.lti.oaqa.qa4ds.input;

import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionValue;

public class DecisionValueFactory {

  public static DecisionValue create(JCas jcas, int begin, int end, String variable) {
    DecisionValue ret = new DecisionValue(jcas, begin, end);
    ret.setVariable(variable);
    return ret;
  }

}
