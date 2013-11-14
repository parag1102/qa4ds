package edu.cmu.lti.oaqa.qa4ds.input;

import java.util.Collection;
import java.util.List;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate;
import edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput;

public class DecisionTemplateInputFactory {

  static DecisionTemplateInput create(JCas jcas, DecisionTemplate template, List<String> values) {
    DecisionTemplateInput input = new DecisionTemplateInput(jcas);
    input.setTemplate(template);
    setValues(jcas, input, values);
    return input;
  }

  static Collection<String> getValues(JCas jcas, DecisionTemplateInput template) {
    return FSCollectionFactory.create(template.getValues());
  }

  static void setValues(JCas jcas, DecisionTemplateInput input, List<String> values) {
    input.setValues(FSCollectionFactory.createStringList(jcas, values));
  }

}
