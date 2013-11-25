package edu.cmu.lti.oaqa.qa4ds.input;

import java.util.List;
import java.util.Map;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.input.Question;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionValue;
import edu.cmu.lti.oaqa.qa4ds.util.StringReplacer;
import edu.cmu.lti.oaqa.qa4ds.util.StringReplacer.Replacement;

public class QuestionValueListPair {

  private Question question;

  private List<DecisionValue> values;

  public static QuestionValueListPair create(final JCas jcas, String templateQuestion,
          List<String> varStrings, List<String> valueStrings) {
    StringReplacer replacer = StringReplacer.on(varStrings, valueStrings);
    return create(jcas, templateQuestion, replacer);
  }

  public static QuestionValueListPair create(final JCas jcas, String templateQuestion,
          Map<String, String> var2value) {
    StringReplacer replacer = StringReplacer.on(var2value);
    return create(jcas, templateQuestion, replacer);
  }

  private static QuestionValueListPair create(final JCas jcas, String templateQuestion,
          StringReplacer replacer) {
    // replace variables with values in the question template
    String questionString = replacer.replace(templateQuestion);
    List<Replacement> replacements = replacer.getReplacementDetails();
    // construct question and values
    Question question = new Question(jcas, 0, questionString.length());
    question.setText(questionString);
    List<DecisionValue> values = Lists.transform(replacements,
            new Function<Replacement, DecisionValue>() {

              @Override
              public DecisionValue apply(Replacement repl) {
                DecisionValue ret = new DecisionValue(jcas, repl.getReplacedBegin(), repl
                        .getReplacedEnd());
                ret.setVariable(repl.getOriginalString());
                return ret;
              }
            });
    return new QuestionValueListPair(question, values);
  }

  private QuestionValueListPair(Question question, List<DecisionValue> values) {
    this.question = question;
    this.values = values;
  }

  public Question getQuestion() {
    return question;
  }

  public List<DecisionValue> getValues() {
    return values;
  }

}
