package edu.cmu.lti.oaqa.qa4ds.input;

import com.google.common.base.Predicate;

import edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate;

public class MatchesQuestionWeight implements Predicate<WeightDecisionTemplate> {

  private String question;

  private double weight;

  public MatchesQuestionWeight(String question, double weight) {
    this.question = question;
    this.weight = weight;
  }

  @Override
  public boolean apply(WeightDecisionTemplate template) {
    return question.equals(template.getTemplate().getQuestion()) && weight == template.getWeight();
  }

}
