package edu.cmu.lti.oaqa.qa4ds.merger;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class WeightedSumMerger extends AbstractSimpleMerger {

  @Override
  protected Map<String, Float> mergeFactors(SimpleFactorMergingData parent,
          List<SimpleFactorMergingData> children) {
    Map<String, Float> text2score = Maps.newHashMap();
    for (SimpleFactorMergingData datum : Iterables.concat(Lists.newArrayList(parent), children)) {
      double templateWeight = datum.getTemplateWeight();
      for (SimpleAnswerData answer : datum.getAnswers()) {
        String text = answer.getText();
        if (!text2score.containsKey(text)) {
          text2score.put(text, 0.0f);
        }
        double score = text2score.get(text) + Collections.max(answer.getConfidences())
                * templateWeight;
        text2score.put(text, (float) score);
      }
    }
    return text2score;
  }

}
