package edu.cmu.lti.oaqa.qa4ds.merger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.Answer;
import org.oaqa.model.answer.AnswerList;
import org.oaqa.model.gerp.Evidence;
import org.oaqa.model.gerp.PruningDecision;
import org.oaqa.model.gerp.Rank;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Floats;

public class AnswerListFactory {

  public static AnswerList create(JCas jcas, List<Answer> answers) {
    AnswerList ret = new AnswerList(jcas);
    ret.setAnswerList(FSCollectionFactory.createFSArray(jcas, answers));
    return ret;
  }

  public static AnswerList create(JCas jcas, Map<String, Float> finalAnswer, String mergerPath) {
    List<Answer> answers = Lists.newArrayList();
    for (Map.Entry<String, Float> entry : finalAnswer.entrySet()) {
      // add answer text
      Answer answer = new Answer(jcas);
      answer.setText(entry.getKey());
      // add score as an evidence
      Evidence evidence = new Evidence(jcas);
      evidence.setConfidence(entry.getValue());
      List<Evidence> evidences = Lists.newArrayList(evidence);
      answer.setEvidences(FSCollectionFactory.createFSList(jcas, evidences));
      // add generator and pruning decisions
      answer.setGenerators(FSCollectionFactory.createStringList(jcas,
              Lists.newArrayList(mergerPath)));
      PruningDecision result = new PruningDecision(jcas);
      result.setDecision(false);
      answer.setPruningDecisions(FSCollectionFactory.createFSList(jcas, Lists.newArrayList(result)));
    }
    Collections.sort(answers, new Comparator<Answer>() {

      @Override
      public int compare(Answer o1, Answer o2) {
        List<Evidence> evidences1 = (List<Evidence>) FSCollectionFactory.create(o1.getEvidences(),
                Evidence.class);
        float score1 = (Iterables.getOnlyElement(evidences1)).getConfidence();
        List<Evidence> evidences2 = (List<Evidence>) FSCollectionFactory.create(o2.getEvidences(),
                Evidence.class);
        float score2 = (Iterables.getOnlyElement(evidences2)).getConfidence();
        return -Floats.compare(score1, score2);
      }
    });
    int i = 0;
    for (Answer answer : answers) {
      // set ranks
      Rank rank = new Rank(jcas);
      rank.setRank(i++);
      answer.setRanks(FSCollectionFactory.createFSList(jcas, Lists.newArrayList(rank)));
    }
    return create(jcas, answers);
  }
}
