package edu.cmu.lti.oaqa.qa4ds.input;

public class DecisionTemplateInputValuesUnmatchException extends Exception {

  private static final long serialVersionUID = 1L;

  private int varSize;

  private int valueSize;

  public DecisionTemplateInputValuesUnmatchException(int varSize, int valueSize) {
    this.varSize = varSize;
    this.valueSize = valueSize;
  }

  @Override
  public String getMessage() {
    return varSize + " value(s) expected, but " + valueSize + " given.";
  }

}
