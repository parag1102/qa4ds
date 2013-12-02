package edu.cmu.lti.oaqa.qa4ds.merger;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.AnswerList;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;
import edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists;

public abstract class AbstractMerger extends JCasAnnotator_ImplBase {

  protected abstract AnswerList mergeFactors(DecisionConfiguration decision,
          MergedAnswerLists mergedAnswerLists) throws CASException;

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    DecisionConfiguration decision = JCasUtil.selectSingle(jcas, DecisionConfiguration.class);
    MergedAnswerLists inputAnswerList = JCasUtil.selectSingle(jcas, MergedAnswerLists.class);
    try {
      AnswerList outputAnswerList = mergeFactors(decision, inputAnswerList);
      outputAnswerList.addToIndexes(jcas);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

}
