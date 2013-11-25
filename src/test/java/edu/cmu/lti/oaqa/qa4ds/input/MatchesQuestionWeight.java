package edu.cmu.lti.oaqa.qa4ds.input;

import com.google.common.base.Predicate;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;

public class MatchesQuestionWeight implements Predicate<DecisionConfiguration> {

  private String question;

  private double weight;

  public MatchesQuestionWeight(String question, double weight) {
    this.question = question;
    this.weight = weight;
  }

  @Override
  public boolean apply(DecisionConfiguration decision) {
    return question.equals(decision.getQuestion().getText()) && weight == decision.getWeight();
  }

}
