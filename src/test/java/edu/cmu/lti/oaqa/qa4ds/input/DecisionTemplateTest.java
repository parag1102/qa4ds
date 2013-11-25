package edu.cmu.lti.oaqa.qa4ds.input;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;

public class DecisionTemplateTest {

  private static Map<String, String> var2value = Maps.newHashMap();

  @BeforeClass
  public static void setUp() {
    var2value = Maps.newHashMap();
    var2value.put("PROPERTY", "267 William St., Pittsburgh, PA 15203");
  }

  private static String confPath = "qa4ds.default-decision-conf";

  @Test
  public void testOneLayer() throws MalformedURLException, IOException, UIMAException,
          DecisionConfigurationException {
    JCas jcas = JCasFactory.createJCas("edu.cmu.lti.oaqa.qa4ds.QA4DSTypes");
    DecisionConfiguration template = DecisionConfigurationFactory.loadFromResource(jcas,
            "template.buying-a-house-one-layer", var2value, confPath);
    assertTrue(template.getTemplateName().equals("buying-a-house-one-layer"));
    assertTrue(template.getQuestion().getText()
            .equals("Is it worthwhile to buy 267 William St., Pittsburgh, PA 15203?"));
    assertTrue(DecisionConfigurationUtil.getFactors(template).isEmpty());
    jcas.release();
  }

  @Test
  public void testTwoLayers() throws MalformedURLException, IOException, UIMAException,
          DecisionConfigurationException {
    JCas jcas = JCasFactory.createJCas("edu.cmu.lti.oaqa.qa4ds.QA4DSTypes");
    DecisionConfiguration template = DecisionConfigurationFactory.loadFromResource(jcas,
            "template.buying-a-house-two-layers", var2value, confPath);
    MatchesQuestionWeight questionWeight = new MatchesQuestionWeight(
            "What is 267 William St., Pittsburgh, PA 15203 worth in today's market?", -0.5);
    assertTrue(Iterables.any(DecisionConfigurationUtil.getFactors(template), questionWeight));
    jcas.release();
  }

  @Test
  public void testThreeLayers() throws MalformedURLException, IOException, UIMAException,
          DecisionConfigurationException {
    JCas jcas = JCasFactory.createJCas("edu.cmu.lti.oaqa.qa4ds.QA4DSTypes");
    DecisionConfiguration template = DecisionConfigurationFactory.loadFromResource(jcas,
            "template.buying-a-house-three-layers", var2value, confPath);
    MatchesQuestionWeight questionWeight = new MatchesQuestionWeight(
            "Is 267 William St., Pittsburgh, PA 15203 in a flood plain?", -1.5);
    DecisionConfiguration subfactor = Iterables.getOnlyElement(Iterables.filter(
            DecisionConfigurationUtil.getFactors(template), questionWeight));
    questionWeight = new MatchesQuestionWeight(
            "Does the water in the area of 267 William St., Pittsburgh, PA 15203 level fluctuate?",
            0.3);
    assertTrue(Iterables.any(DecisionConfigurationUtil.getFactors(subfactor), questionWeight));
    jcas.release();
  }

  @Test
  public void testComposite() throws MalformedURLException, IOException, UIMAException,
          DecisionConfigurationException {
    JCas jcas = JCasFactory.createJCas("edu.cmu.lti.oaqa.qa4ds.QA4DSTypes");
    DecisionConfiguration template = DecisionConfigurationFactory.loadFromResource(jcas,
            "template.buying-a-house-composite", var2value, confPath);
    MatchesQuestionWeight questionWeight = new MatchesQuestionWeight(
            "Is 267 William St., Pittsburgh, PA 15203 in a flood plain?", -1.5);
    DecisionConfiguration subfactor = Iterables.getOnlyElement(Iterables.filter(
            DecisionConfigurationUtil.getFactors(template), questionWeight));
    questionWeight = new MatchesQuestionWeight(
            "Does the water in the area of 267 William St., Pittsburgh, PA 15203 level fluctuate?",
            0.3);
    assertTrue(Iterables.any(DecisionConfigurationUtil.getFactors(subfactor), questionWeight));
    jcas.release();
  }

}
