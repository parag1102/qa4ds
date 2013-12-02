package edu.cmu.lti.oaqa.qa4ds.merger;

import java.util.List;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.AnswerList;

import edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists;

public class MergedAnswerListsFactory {

  public static MergedAnswerLists create(JCas jcas, AnswerList parent) {
    MergedAnswerLists ret = new MergedAnswerLists(jcas);
    ret.setParent(parent);
    return ret;
  }

  public static MergedAnswerLists create(JCas jcas, AnswerList parent, List<AnswerList> children) {
    MergedAnswerLists ret = new MergedAnswerLists(jcas);
    ret.setParent(parent);
    ret.setChildren(FSCollectionFactory.createFSList(jcas, children));
    return ret;
  }
}
