package edu.cmu.lti.oaqa.qa4ds.merger;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class ParentAnswerMerger extends AbstractSimpleMerger {

  @Override
  protected Map<String, Float> mergeFactors(SimpleFactorMergingData parent,
          List<SimpleFactorMergingData> children) {
    Map<String, Float> text2score = Maps.newHashMap();
    for (SimpleAnswerData answer : parent.getAnswers()) {
      text2score.put(answer.getText(), Collections.max(answer.getConfidences()));
    }
    return text2score;
  }
}
