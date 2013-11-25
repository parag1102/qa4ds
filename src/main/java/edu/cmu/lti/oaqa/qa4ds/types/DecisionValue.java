

/* First created by JCasGen Wed Nov 20 20:57:28 EST 2013 */
package edu.cmu.lti.oaqa.qa4ds.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Nov 20 21:04:59 EST 2013
 * XML source: /home/yangzi/QA/qa4ds/src/main/resources/edu/cmu/lti/oaqa/qa4ds/QA4DSTypes.xml
 * @generated */
public class DecisionValue extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DecisionValue.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected DecisionValue() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DecisionValue(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DecisionValue(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DecisionValue(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: variable

  /** getter for variable - gets 
   * @generated */
  public String getVariable() {
    if (DecisionValue_Type.featOkTst && ((DecisionValue_Type)jcasType).casFeat_variable == null)
      jcasType.jcas.throwFeatMissing("variable", "edu.cmu.lti.oaqa.qa4ds.types.DecisionValue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DecisionValue_Type)jcasType).casFeatCode_variable);}
    
  /** setter for variable - sets  
   * @generated */
  public void setVariable(String v) {
    if (DecisionValue_Type.featOkTst && ((DecisionValue_Type)jcasType).casFeat_variable == null)
      jcasType.jcas.throwFeatMissing("variable", "edu.cmu.lti.oaqa.qa4ds.types.DecisionValue");
    jcasType.ll_cas.ll_setStringValue(addr, ((DecisionValue_Type)jcasType).casFeatCode_variable, v);}    
  }

    