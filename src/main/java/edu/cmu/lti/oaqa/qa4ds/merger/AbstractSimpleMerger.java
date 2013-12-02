package edu.cmu.lti.oaqa.qa4ds.merger;

import java.util.List;
import java.util.Map;

import org.apache.uima.cas.CASException;
import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.Answer;
import org.oaqa.model.answer.AnswerList;
import org.oaqa.model.gerp.Evidence;
import org.oaqa.model.gerp.Rank;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.qa4ds.input.DecisionConfigurationUtil;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration;
import edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists;

public abstract class AbstractSimpleMerger extends AbstractMerger {

  protected abstract Map<String, Float> mergeFactors(SimpleFactorMergingData parent,
          List<SimpleFactorMergingData> children);

  @Override
  protected AnswerList mergeFactors(DecisionConfiguration decision,
          MergedAnswerLists mergedAnswerLists) throws CASException {
    // add merging data for parent factor
    SimpleFactorMergingData parent = new SimpleFactorMergingData(decision,
            mergedAnswerLists.getParent());
    // retrieve sub-factors
    List<DecisionConfiguration> factors = ImmutableList.copyOf(DecisionConfigurationUtil
            .getFactors(decision));
    // retrieve sub-answers and evidences
    List<AnswerList> factorAnswerLists = ImmutableList.copyOf(FSCollectionFactory.create(
            mergedAnswerLists.getChildren(), AnswerList.class));
    assert factors.size() == factorAnswerLists.size();
    List<SimpleFactorMergingData> children = Lists.newArrayList();
    for (int i = 0; i < factors.size(); i++) {
      children.add(new SimpleFactorMergingData(factors.get(i), factorAnswerLists.get(i)));
    }
    // do task
    Map<String, Float> text2score = mergeFactors(parent, children);
    // book keeping
    JCas jcas = decision.getCAS().getJCas();
    return AnswerListFactory.create(jcas, text2score, getClass().getCanonicalName());
  }

  public static class SimpleFactorMergingData {

    private String templateName;

    private String templateQuestion;

    private double templateWeight;

    private List<SimpleAnswerData> answers;

    public SimpleFactorMergingData(DecisionConfiguration decision, AnswerList answers) {
      super();
      this.templateName = decision.getTemplateName();
      this.templateQuestion = decision.getQuestion().getText();
      this.templateWeight = decision.getWeight();
      this.answers = Lists.transform(
              (List<Answer>) FSCollectionFactory.create(answers.getAnswerList(), Answer.class),
              new Function<Answer, SimpleAnswerData>() {

                @Override
                public SimpleAnswerData apply(Answer input) {
                  return new SimpleAnswerData(input);
                }
              });
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((answers == null) ? 0 : answers.hashCode());
      result = prime * result + ((templateName == null) ? 0 : templateName.hashCode());
      result = prime * result + ((templateQuestion == null) ? 0 : templateQuestion.hashCode());
      long temp;
      temp = Double.doubleToLongBits(templateWeight);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      SimpleFactorMergingData other = (SimpleFactorMergingData) obj;
      if (answers == null) {
        if (other.answers != null)
          return false;
      } else if (!answers.equals(other.answers))
        return false;
      if (templateName == null) {
        if (other.templateName != null)
          return false;
      } else if (!templateName.equals(other.templateName))
        return false;
      if (templateQuestion == null) {
        if (other.templateQuestion != null)
          return false;
      } else if (!templateQuestion.equals(other.templateQuestion))
        return false;
      if (Double.doubleToLongBits(templateWeight) != Double.doubleToLongBits(other.templateWeight))
        return false;
      return true;
    }

    public String getTemplateName() {
      return templateName;
    }

    public void setTemplateName(String templateName) {
      this.templateName = templateName;
    }

    public String getTemplateQuestion() {
      return templateQuestion;
    }

    public void setTemplateQuestion(String templateQuestion) {
      this.templateQuestion = templateQuestion;
    }

    public double getTemplateWeight() {
      return templateWeight;
    }

    public void setTemplateWeight(double templateWeight) {
      this.templateWeight = templateWeight;
    }

    public List<SimpleAnswerData> getAnswers() {
      return answers;
    }

    public void setAnswers(List<SimpleAnswerData> answers) {
      this.answers = answers;
    }

  }

  public static class SimpleAnswerData {

    private String text;

    private List<Float> confidences;

    private List<Integer> ranks;

    public SimpleAnswerData(String text, List<Float> confidences, List<Integer> ranks) {
      super();
      this.text = text;
      this.confidences = confidences;
      this.ranks = ranks;
    }

    public SimpleAnswerData(Answer answer) {
      this.text = answer.getText();
      List<Evidence> evidences = ImmutableList.copyOf(FSCollectionFactory.create(
              answer.getEvidences(), Evidence.class));
      this.confidences = Lists.transform(evidences, new Function<Evidence, Float>() {

        @Override
        public Float apply(Evidence input) {
          return input.getConfidence();
        }
      });
      List<Rank> ranks = ImmutableList.copyOf(FSCollectionFactory.create(answer.getRanks(),
              Rank.class));
      this.ranks = Lists.transform(ranks, new Function<Rank, Integer>() {

        @Override
        public Integer apply(Rank input) {
          return input.getRank();
        }
      });
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((confidences == null) ? 0 : confidences.hashCode());
      result = prime * result + ((ranks == null) ? 0 : ranks.hashCode());
      result = prime * result + ((text == null) ? 0 : text.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      SimpleAnswerData other = (SimpleAnswerData) obj;
      if (confidences == null) {
        if (other.confidences != null)
          return false;
      } else if (!confidences.equals(other.confidences))
        return false;
      if (ranks == null) {
        if (other.ranks != null)
          return false;
      } else if (!ranks.equals(other.ranks))
        return false;
      if (text == null) {
        if (other.text != null)
          return false;
      } else if (!text.equals(other.text))
        return false;
      return true;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public List<Float> getConfidences() {
      return confidences;
    }

    public void setConfidences(List<Float> confidences) {
      this.confidences = confidences;
    }

    public List<Integer> getRanks() {
      return ranks;
    }

    public void setRanks(List<Integer> ranks) {
      this.ranks = ranks;
    }

  }

}
