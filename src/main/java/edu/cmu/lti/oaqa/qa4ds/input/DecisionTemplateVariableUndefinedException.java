package edu.cmu.lti.oaqa.qa4ds.input;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

public class DecisionTemplateVariableUndefinedException extends Exception {

  private static final long serialVersionUID = 1L;

  private Set<String> parent;

  private Set<String> child;

  public DecisionTemplateVariableUndefinedException(Collection<String> parent,
          Collection<String> child) {
    this.parent = Sets.newHashSet(parent);
    this.child = Sets.newHashSet(child);
  }

  @Override
  public String getMessage() {
    return "Variables " + Sets.difference(child, parent)
            + " defined in factors but undefined in parent question.";
  }

}
