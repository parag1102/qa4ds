package edu.cmu.lti.oaqa.qa4ds.input;

import com.google.common.base.Predicate;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;

public class MatchesTemplateName implements Predicate<DecisionConfiguration> {

  private String templateName;

  public MatchesTemplateName(String templateName) {
    this.templateName = templateName;
  }

  @Override
  public boolean apply(DecisionConfiguration input) {
    return input.getTemplateName().equals(templateName);
  }

}
