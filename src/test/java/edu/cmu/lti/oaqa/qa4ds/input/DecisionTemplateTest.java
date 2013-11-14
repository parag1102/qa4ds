package edu.cmu.lti.oaqa.qa4ds.input;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate;
import edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate;

public class DecisionTemplateTest {

  @Test
  public void testOneLayer() throws MalformedURLException, IOException, UIMAException,
          DecisionTemplateVariableUndefinedException {
    JCas jcas = JCasFactory.createJCas("edu.cmu.lti.oaqa.qa4ds.QA4DSTypes");
    DecisionTemplate template = DecisionTemplateFactory.loadFromResource(jcas,
            "template.buying-a-house-one-layer");
    assertTrue(template.getName().equals("buying-a-house-one-layer"));
    assertTrue(DecisionTemplateFactory.getVars(template).equals(
            Lists.<String> newArrayList("PROPERTY")));
    assertTrue(template.getQuestion().equals("Is it worthwhile to buy PROPERTY?"));
    assertTrue(DecisionTemplateFactory.getFactors(template).isEmpty());
    jcas.release();
  }

  @Test
  public void testTwoLayers() throws MalformedURLException, IOException, UIMAException,
          DecisionTemplateVariableUndefinedException {
    JCas jcas = JCasFactory.createJCas("edu.cmu.lti.oaqa.qa4ds.QA4DSTypes");
    DecisionTemplate template = DecisionTemplateFactory.loadFromResource(jcas,
            "template.buying-a-house-two-layers");
    MatchesQuestionWeight questionWeight = new MatchesQuestionWeight(
            "What is PROPERTY worth in today's market?", -0.5);
    assertTrue(Iterables.any(DecisionTemplateFactory.getFactors(template), questionWeight));
    jcas.release();
  }

  @Test
  public void testThreeLayers() throws MalformedURLException, IOException, UIMAException,
          DecisionTemplateVariableUndefinedException {
    JCas jcas = JCasFactory.createJCas("edu.cmu.lti.oaqa.qa4ds.QA4DSTypes");
    DecisionTemplate template = DecisionTemplateFactory.loadFromResource(jcas,
            "template.buying-a-house-three-layers");
    MatchesQuestionWeight questionWeight = new MatchesQuestionWeight(
            "Is PROPERTY in a flood plain?", -1.5);
    WeightDecisionTemplate subfactor = Iterables.getOnlyElement(Iterables.filter(
            DecisionTemplateFactory.getFactors(template), questionWeight));
    questionWeight = new MatchesQuestionWeight(
            "Does the water in the area of PROPERTY level fluctuate?", 0.3);
    assertTrue(Iterables.any(DecisionTemplateFactory.getFactors(subfactor.getTemplate()),
            questionWeight));
    jcas.release();
  }

  @Test
  public void testComposite() throws MalformedURLException, IOException, UIMAException,
          DecisionTemplateVariableUndefinedException {
    JCas jcas = JCasFactory.createJCas("edu.cmu.lti.oaqa.qa4ds.QA4DSTypes");
    DecisionTemplate template = DecisionTemplateFactory.loadFromResource(jcas,
            "template.buying-a-house-composite");
    MatchesQuestionWeight questionWeight = new MatchesQuestionWeight(
            "Is PROPERTY in a flood plain?", -1.5);
    WeightDecisionTemplate subfactor = Iterables.getOnlyElement(Iterables.filter(
            DecisionTemplateFactory.getFactors(template), questionWeight));
    questionWeight = new MatchesQuestionWeight(
            "Does the water in the area of PROPERTY level fluctuate?", 0.3);
    assertTrue(Iterables.any(DecisionTemplateFactory.getFactors(subfactor.getTemplate()),
            questionWeight));
    jcas.release();
  }

}
