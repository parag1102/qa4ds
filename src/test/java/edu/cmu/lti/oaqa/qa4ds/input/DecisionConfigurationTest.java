package edu.cmu.lti.oaqa.qa4ds.input;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.uima.UIMAException;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import com.google.common.collect.Iterables;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;

public class DecisionConfigurationTest {

  @Test
  public void testSingleInputDefaultConf() throws UIMAException, IOException {
    String inputPath = "input.buying-267-william-st-pittsburgh-pa-15203-one-layer";
    String confPath = "qa4ds.default-decision-conf";
    TypeSystemDescription tsDesc = TypeSystemDescriptionFactory.createTypeSystemDescription(
            "edu.cmu.lti.oaqa.qa4ds.QA4DSTypes", "edu.cmu.lti.oaqa.frameworkTypesDescriptor");
    CollectionReader cr = CollectionReaderFactory.createReader(
            DecisionConfigurationCollectionReader.class, tsDesc, "input", inputPath, "conf",
            confPath, "cse.driver.experiment.stageIdd", 0, "persistence-provider",
            "inherit: ecd.default-experiment-persistence-provider");
    // get single cas from collection
    JCas jcas = JCasFactory.createJCas(tsDesc);
    assertTrue(cr.hasNext());
    cr.getNext(jcas.getCas());
    Collection<DecisionConfiguration> inputs = JCasUtil.select(jcas, DecisionConfiguration.class);
    // test single input element
    assertTrue(inputs.size() == 1);
    DecisionConfiguration input = Iterables.getOnlyElement(inputs);
    assertTrue(input.getTemplateName().equals("buying-a-house-one-layer"));
    assertTrue(input.getQuestion().getText()
            .equals("Is it worthwhile to buy 267 William St., Pittsburgh, PA 15203?"));
    assertTrue(DecisionConfigurationUtil.getFactors(input).isEmpty());
    jcas.release();
  }

  @Test
  public void testMultipleInputsDefaultConf() throws UIMAException, IOException {
    String inputPath = "input.buying-multiple-houses";
    String confPath = "qa4ds.default-decision-conf";
    TypeSystemDescription tsDesc = TypeSystemDescriptionFactory.createTypeSystemDescription(
            "edu.cmu.lti.oaqa.qa4ds.QA4DSTypes", "edu.cmu.lti.oaqa.frameworkTypesDescriptor");
    CollectionReader cr = CollectionReaderFactory.createReader(
            DecisionConfigurationCollectionReader.class, tsDesc, "input", inputPath, "conf",
            confPath, "cse.driver.experiment.stageIdd", 0, "persistence-provider",
            "inherit: ecd.default-experiment-persistence-provider");
    // get the third cas from collection
    // skip the first one
    assertTrue(cr.hasNext());
    JCas jcas = JCasFactory.createJCas(tsDesc);
    cr.getNext(jcas.getCas());
    jcas.release();
    // skip the second one
    assertTrue(cr.hasNext());
    jcas = JCasFactory.createJCas(tsDesc);
    cr.getNext(jcas.getCas());
    jcas.release();
    // get the third one
    assertTrue(cr.hasNext());
    jcas = JCasFactory.createJCas(tsDesc);
    cr.getNext(jcas.getCas());
    Collection<DecisionConfiguration> inputs = JCasUtil.select(jcas, DecisionConfiguration.class);
    // test single input element
    assertTrue(inputs.size() == 1);
    DecisionConfiguration input = Iterables.getOnlyElement(inputs);
    assertTrue(input.getTemplateName().equals("buying-a-house-two-layers"));
    assertTrue(input.getQuestion().getText()
            .equals("Is it worthwhile to buy 410 William St., Mount Washington, PA 15211?"));
    assertTrue(!DecisionConfigurationUtil.getFactors(input).isEmpty());
    jcas.release();
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testSingleInputComplexConf() throws UIMAException, IOException {
    String inputPath = "input.buying-267-william-st-pittsburgh-pa-15203-two-layers";
    String confPath = "qa4ds.complex-decision-conf";
    TypeSystemDescription tsDesc = TypeSystemDescriptionFactory.createTypeSystemDescription(
            "edu.cmu.lti.oaqa.qa4ds.QA4DSTypes", "edu.cmu.lti.oaqa.frameworkTypesDescriptor");
    CollectionReader cr = CollectionReaderFactory.createReader(
            DecisionConfigurationCollectionReader.class, tsDesc, "input", inputPath, "conf",
            confPath, "cse.driver.experiment.stageIdd", 0, "persistence-provider",
            "inherit: ecd.default-experiment-persistence-provider");
    // get single cas from collection
    JCas jcas = JCasFactory.createJCas(tsDesc);
    assertTrue(cr.hasNext());
    cr.getNext(jcas.getCas());
    Collection<DecisionConfiguration> inputs = JCasUtil.select(jcas, DecisionConfiguration.class);
    // test outer configuration
    assertTrue(inputs.size() == 1);
    DecisionConfiguration input = Iterables.getOnlyElement(inputs);
    assertTrue(input.getTemplateName().equals("buying-a-house-two-layers"));
    Yaml yaml = new Yaml();
    Map<String, List<String>> conf = ((Map<String, List<String>>) yaml.load(input
            .getConfiguration()));
    assertTrue(conf.get("analyzers").size() == 1);
    // test inner configuration 1
    conf = ((Map<String, List<String>>) yaml.load(DecisionConfigurationUtil
            .getFactorByTemplateName(input, "property-flood-composite").getConfiguration()));
    assertTrue(conf.get("analyzers").size() == 2);
    // test inner configuration 2
    conf = ((Map<String, List<String>>) yaml.load(DecisionConfigurationUtil
            .getFactorByTemplateName(input, "seller-flexible-price-composite").getConfiguration()));
    assertTrue(conf.get("analyzers").size() == 1);
    jcas.release();
  }
}
