package edu.cmu.lti.oaqa.qa4ds.input;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import org.apache.uima.UIMAException;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput;

public class DecisionTemplateInputTest {

  @Test
  public void testSingle() throws UIMAException, IOException,
          DecisionTemplateVariableUndefinedException, DecisionTemplateInputValuesUnmatchException {
    String resourcePath = "input.buying-267-william-st-pittsburgh-pa-15203-one-layer";
    TypeSystemDescription tsDesc = TypeSystemDescriptionFactory.createTypeSystemDescription(
            "edu.cmu.lti.oaqa.qa4ds.QA4DSTypes", "edu.cmu.lti.oaqa.frameworkTypesDescriptor");
    CollectionReader cr = CollectionReaderFactory.createReader(
            DecisionTemplateInputCollectionReader.class, tsDesc, "file", resourcePath,
            "cse.driver.experiment.stageIdd", 0, "persistence-provider",
            "inherit: ecd.default-experiment-persistence-provider");
    // get single cas from collection
    JCas jcas = JCasFactory.createJCas(tsDesc);
    assertTrue(cr.hasNext());
    cr.getNext(jcas.getCas());
    Collection<DecisionTemplateInput> inputs = JCasUtil.select(jcas, DecisionTemplateInput.class);
    // test single input element
    assertTrue(inputs.size() == 1);
    DecisionTemplateInput input = Iterables.getOnlyElement(inputs);
    DecisionTemplate template = input.getTemplate();
    assertTrue(template.getName().equals("buying-a-house-one-layer"));
    assertTrue(DecisionTemplateFactory.getVars(template).equals(
            Lists.<String> newArrayList("PROPERTY")));
    assertTrue(template.getQuestion().equals("Is it worthwhile to buy PROPERTY?"));
    assertTrue(DecisionTemplateFactory.getFactors(template).isEmpty());
    String value = Iterables.getOnlyElement(DecisionTemplateInputFactory.getValues(jcas, input));
    assertTrue(value.equals("267 William St., Pittsburgh, PA 15203"));
    assertTrue(!cr.hasNext());
  }

  @Test
  public void testMultiple() throws UIMAException, IOException,
          DecisionTemplateVariableUndefinedException, DecisionTemplateInputValuesUnmatchException {
    String resourcePath = "input.buying-multiple-houses";
    TypeSystemDescription tsDesc = TypeSystemDescriptionFactory.createTypeSystemDescription(
            "edu.cmu.lti.oaqa.qa4ds.QA4DSTypes", "edu.cmu.lti.oaqa.frameworkTypesDescriptor");
    CollectionReader cr = CollectionReaderFactory.createReader(
            DecisionTemplateInputCollectionReader.class, tsDesc, "file", resourcePath,
            "cse.driver.experiment.stageIdd", 0, "persistence-provider",
            "inherit: ecd.default-experiment-persistence-provider");
    // get the third cas from collection
    JCas jcas = JCasFactory.createJCas(tsDesc);
    assertTrue(cr.hasNext());
    cr.getNext(jcas.getCas());
    assertTrue(cr.hasNext());
    cr.getNext(jcas.getCas());
    assertTrue(cr.hasNext());
    cr.getNext(jcas.getCas());
    Collection<DecisionTemplateInput> inputs = JCasUtil.select(jcas, DecisionTemplateInput.class);
    // test single input element
    assertTrue(inputs.size() == 1);
    DecisionTemplateInput input = Iterables.getOnlyElement(inputs);
    DecisionTemplate template = input.getTemplate();
    assertTrue(template.getName().equals("buying-a-house-two-layers"));
    String value = Iterables.getOnlyElement(DecisionTemplateInputFactory.getValues(jcas, input));
    assertTrue(value.equals("410 William St., Mount Washington, PA 15211"));
  }

}
