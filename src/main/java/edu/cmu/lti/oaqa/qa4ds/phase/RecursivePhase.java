package edu.cmu.lti.oaqa.qa4ds.phase;

import java.util.List;
import java.util.Set;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.analysis_engine.JCasIterator;
import org.apache.uima.cas.AbstractCas;
import org.apache.uima.fit.component.JCasMultiplier_ImplBase;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.oaqa.model.answer.AnswerList;
import org.oaqa.model.gerp.Evidence;
import org.oaqa.model.input.Question;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.ExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.phase.BasePhase;
import edu.cmu.lti.oaqa.ecd.phase.BasePhaseLoaderUtil;
import edu.cmu.lti.oaqa.qa4ds.input.DecisionConfigurationUtil;
import edu.cmu.lti.oaqa.qa4ds.merger.MergedAnswerListsFactory;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;
import edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists;

public class RecursivePhase extends JCasMultiplier_ImplBase {

  private TypeSystemDescription typeSystemDesc;

  /*
   * parameters
   */
  private String experimentUuid;

  private int stageId;

  private int phaseId;

  private String name;

  private String persistenceProvider;

  /*
   * variables
   */
  private JCas origJcas;

  private List<AnswerList>[] answerListCombinations;

  private AnalysisEngineDescription[] mergerDescriptions;

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    typeSystemDesc = TypeSystemDescriptionFactory.createTypeSystemDescription();
    // global configuration
    experimentUuid = (String) context
            .getConfigParameterValue(BaseExperimentBuilder.EXPERIMENT_UUID_PROPERTY);
    stageId = (Integer) context.getConfigParameterValue(BaseExperimentBuilder.STAGE_ID_PROPERTY);
    phaseId = (Integer) context.getConfigParameterValue(BasePhase.QA_INTERNAL_PHASEID);
    // phase configuration
    name = (String) context.getConfigParameterValue("name");
    persistenceProvider = (String) context.getConfigParameterValue("persistence-provider");
  }

  @SuppressWarnings("unchecked")
  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    // read configuration and run analyzers for the main question
    this.origJcas = jcas;
    DecisionConfiguration decision = JCasUtil.selectSingle(jcas, DecisionConfiguration.class);
    Set<AnswerList> parentAnswerListOptions = Sets.newHashSet();
    for (String analyzer : DecisionConfigurationUtil.getAnalyzers(decision)) {
      try {
        Set<AnswerList> analyzerAnswerLists = executeQuestionAnsweringAnalysisEngine(analyzer,
                decision.getQuestion(), decision.getValues());
        parentAnswerListOptions.addAll(analyzerAnswerLists);
      } catch (Exception e) {
        throw new AnalysisEngineProcessException(e);
      }
    }
    List<Set<AnswerList>> allAnswerListOptions = Lists.newArrayList();
    allAnswerListOptions.add(parentAnswerListOptions);
    // check if primitive -- return condition for the recursive phase
    if (!decision.getPrimitive()) {
      // run recursive phase for each factor
      int factorNo = 0;
      for (DecisionConfiguration factor : DecisionConfigurationUtil.getFactors(decision)) {
        String factorName = name + "." + factorNo++;
        try {
          Set<AnswerList> factorAnswerListOptions = executeDecisionMakingRecursivePhase(factor,
                  factorName);
          allAnswerListOptions.add(factorAnswerListOptions);
        } catch (ResourceInitializationException e) {
          throw new AnalysisEngineProcessException(e);
        }
      }
    }
    Set<List<AnswerList>> cartesianProductOfAnswerLists = Sets
            .cartesianProduct(allAnswerListOptions);
    answerListCombinations = Iterables.toArray(cartesianProductOfAnswerLists, List.class);
    // retrieve and store merger descriptors, which will be initialized and further executed (lazy
    // load) on each combination of factor answer lists later in the next();
    mergerDescriptions = BasePhaseLoaderUtil.loadOptions(DecisionConfigurationUtil
            .getMergerDescriptions(decision));
  }

  private Set<AnswerList> executeQuestionAnsweringAnalysisEngine(String aeResource,
          Question question, FSList values) throws Exception {
    // create empty cas containing the question
    JCas questionJcas = getEmptyJCas();
    question.addToIndexes(questionJcas);
    values.addToIndexes(questionJcas);
    // execute qa pipeline
    ExperimentBuilder builder = new BaseExperimentBuilder(experimentUuid, aeResource,
            typeSystemDesc);
    AnalysisEngine ae = builder.buildPipeline(builder.getConfiguration(), "pipeline", -1, null,
            true);
    JCasIterator it = ae.processAndOutputNewCASes(questionJcas);
    Set<AnswerList> answerLists = Sets.newHashSet();
    while (it.hasNext()) {
      answerLists.addAll(JCasUtil.select(it.next(), AnswerList.class));
    }
    questionJcas.release();
    return answerLists;
  }

  private Set<AnswerList> executeDecisionMakingRecursivePhase(DecisionConfiguration decision,
          String decisionName) throws ResourceInitializationException,
          AnalysisEngineProcessException {
    // create empty cas containing the decision
    JCas decisionJcas = getEmptyJCas();
    decision.addToIndexes(decisionJcas);
    // execute recursive phase
    AnalysisEngine ae = AnalysisEngineFactory.createEngine(this.getClass(), typeSystemDesc,
            BaseExperimentBuilder.EXPERIMENT_UUID_PROPERTY, experimentUuid,
            BaseExperimentBuilder.STAGE_ID_PROPERTY, stageId, BasePhase.QA_INTERNAL_PHASEID,
            phaseId, "name", decisionName, "persistence-provider", persistenceProvider);
    JCasIterator it = ae.processAndOutputNewCASes(decisionJcas);
    Set<AnswerList> answerLists = Sets.newHashSet();
    while (it.hasNext()) {
      // add merged answer list (input) as the evidence to the resulting answer list
      JCas jcas = it.next();
      MergedAnswerLists mergedAnswerLists = JCasUtil.selectSingle(jcas, MergedAnswerLists.class);
      Evidence evidence = new Evidence(jcas);
      evidence.setConfidence(1.0f);
      evidence.setAdditionalEvidences(FSCollectionFactory.createFSList(jcas,
              Lists.newArrayList(mergedAnswerLists)));
      AnswerList answerList = JCasUtil.selectSingle(jcas, AnswerList.class);
      answerList.setEvidences(FSCollectionFactory.createFSList(jcas, Lists.newArrayList(evidence)));
      // add answer list generated by merger to the pool
      answerLists.add(answerList);
    }
    decisionJcas.release();
    return answerLists;
  }

  private int answerListCombinationIndex = 0;

  private int mergerDescriptionIndex = 0;

  private AnalysisEngine currentMerger = null;

  @Override
  public boolean hasNext() throws AnalysisEngineProcessException {
    // check if primitive
    if (mergerDescriptions.length == 0) {
      return answerListCombinationIndex < answerListCombinations.length;
    }
    return answerListCombinationIndex < answerListCombinations.length
            || mergerDescriptionIndex < mergerDescriptions.length;
  }

  @Override
  public AbstractCas next() throws AnalysisEngineProcessException {
    // check if primitive
    if (mergerDescriptions.length == 0) {
      List<AnswerList> answerListCombination = answerListCombinations[answerListCombinationIndex++];
      AnswerList parentAnswerList = answerListCombination.get(0);
      return copyParent(parentAnswerList);
    }
    // if all answer list combinations have been executed by the current merger, then move onto the
    // next merger
    if (answerListCombinationIndex >= answerListCombinations.length
            && mergerDescriptionIndex < mergerDescriptions.length) {
      answerListCombinationIndex = 0;
      currentMerger = null;
      mergerDescriptionIndex++;
    }
    // initialize merger at the beginning or the combination list is rewinded.
    if (currentMerger == null) {
      try {
        currentMerger = AnalysisEngineFactory
                .createEngine(mergerDescriptions[mergerDescriptionIndex]);
      } catch (ResourceInitializationException e) {
        throw new AnalysisEngineProcessException(e);
      }
    }
    // execute merger
    List<AnswerList> answerListCombination = answerListCombinations[answerListCombinationIndex++];
    AnswerList parentAnswerList = answerListCombination.get(0);
    List<AnswerList> factorAnswerLists = ImmutableList.copyOf(Iterables.skip(answerListCombination,
            1));
    return executeMerger(currentMerger, parentAnswerList, factorAnswerLists);
  }

  private JCas copyParent(AnswerList parentAnswerList) {
    JCas jcas = getEmptyJCas();
    JCasUtil.selectSingle(origJcas, DecisionConfiguration.class).addToIndexes(jcas);
    MergedAnswerListsFactory.create(jcas, parentAnswerList).addToIndexes(jcas);
    return jcas;
  }

  private JCas executeMerger(AnalysisEngine merger, AnswerList parentAnswerList,
          List<AnswerList> factorAnswerLists) throws AnalysisEngineProcessException {
    // create jcas that contains decision and answer lists
    JCas jcas = getEmptyJCas();
    JCasUtil.selectSingle(origJcas, DecisionConfiguration.class).addToIndexes(jcas);
    MergedAnswerListsFactory.create(jcas, parentAnswerList, factorAnswerLists).addToIndexes(jcas);
    // execute merger
    merger.process(jcas);
    return jcas;
  }
}
