

/* First created by JCasGen Sun Nov 10 17:39:31 EST 2013 */
package edu.cmu.lti.oaqa.qa4ds.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Mon Nov 11 18:25:41 EST 2013
 * XML source: /home/yangzi/QA/qa4ds/src/main/resources/edu/cmu/lti/oaqa/qa4ds/QA4DSTypes.xml
 * @generated */
public class DecisionTemplate extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DecisionTemplate.class);
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
  protected DecisionTemplate() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DecisionTemplate(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DecisionTemplate(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public String getName() {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    jcasType.ll_cas.ll_setStringValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: vars

  /** getter for vars - gets 
   * @generated */
  public StringList getVars() {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_vars == null)
      jcasType.jcas.throwFeatMissing("vars", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_vars)));}
    
  /** setter for vars - sets  
   * @generated */
  public void setVars(StringList v) {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_vars == null)
      jcasType.jcas.throwFeatMissing("vars", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    jcasType.ll_cas.ll_setRefValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_vars, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: question

  /** getter for question - gets 
   * @generated */
  public String getQuestion() {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_question);}
    
  /** setter for question - sets  
   * @generated */
  public void setQuestion(String v) {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    jcasType.ll_cas.ll_setStringValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_question, v);}    
   
    
  //*--------------*
  //* Feature: factors

  /** getter for factors - gets 
   * @generated */
  public FSList getFactors() {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_factors == null)
      jcasType.jcas.throwFeatMissing("factors", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_factors)));}
    
  /** setter for factors - sets  
   * @generated */
  public void setFactors(FSList v) {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_factors == null)
      jcasType.jcas.throwFeatMissing("factors", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    jcasType.ll_cas.ll_setRefValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_factors, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: primitive

  /** getter for primitive - gets 
   * @generated */
  public boolean getPrimitive() {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_primitive == null)
      jcasType.jcas.throwFeatMissing("primitive", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_primitive);}
    
  /** setter for primitive - sets  
   * @generated */
  public void setPrimitive(boolean v) {
    if (DecisionTemplate_Type.featOkTst && ((DecisionTemplate_Type)jcasType).casFeat_primitive == null)
      jcasType.jcas.throwFeatMissing("primitive", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((DecisionTemplate_Type)jcasType).casFeatCode_primitive, v);}    
  }

    