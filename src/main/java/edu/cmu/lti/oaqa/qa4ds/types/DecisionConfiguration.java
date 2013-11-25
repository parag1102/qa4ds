

/* First created by JCasGen Wed Nov 20 21:04:59 EST 2013 */
package edu.cmu.lti.oaqa.qa4ds.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.oaqa.model.input.Question;
import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Wed Nov 20 21:04:59 EST 2013
 * XML source: /home/yangzi/QA/qa4ds/src/main/resources/edu/cmu/lti/oaqa/qa4ds/QA4DSTypes.xml
 * @generated */
public class DecisionConfiguration extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DecisionConfiguration.class);
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
  protected DecisionConfiguration() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DecisionConfiguration(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DecisionConfiguration(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: templateName

  /** getter for templateName - gets 
   * @generated */
  public String getTemplateName() {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_templateName == null)
      jcasType.jcas.throwFeatMissing("templateName", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_templateName);}
    
  /** setter for templateName - sets  
   * @generated */
  public void setTemplateName(String v) {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_templateName == null)
      jcasType.jcas.throwFeatMissing("templateName", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    jcasType.ll_cas.ll_setStringValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_templateName, v);}    
   
    
  //*--------------*
  //* Feature: question

  /** getter for question - gets 
   * @generated */
  public Question getQuestion() {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return (Question)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_question)));}
    
  /** setter for question - sets  
   * @generated */
  public void setQuestion(Question v) {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    jcasType.ll_cas.ll_setRefValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_question, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: factors

  /** getter for factors - gets 
   * @generated */
  public FSList getFactors() {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_factors == null)
      jcasType.jcas.throwFeatMissing("factors", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_factors)));}
    
  /** setter for factors - sets  
   * @generated */
  public void setFactors(FSList v) {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_factors == null)
      jcasType.jcas.throwFeatMissing("factors", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    jcasType.ll_cas.ll_setRefValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_factors, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: primitive

  /** getter for primitive - gets 
   * @generated */
  public boolean getPrimitive() {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_primitive == null)
      jcasType.jcas.throwFeatMissing("primitive", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_primitive);}
    
  /** setter for primitive - sets  
   * @generated */
  public void setPrimitive(boolean v) {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_primitive == null)
      jcasType.jcas.throwFeatMissing("primitive", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_primitive, v);}    
   
    
  //*--------------*
  //* Feature: weight

  /** getter for weight - gets 
   * @generated */
  public double getWeight() {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_weight == null)
      jcasType.jcas.throwFeatMissing("weight", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_weight);}
    
  /** setter for weight - sets  
   * @generated */
  public void setWeight(double v) {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_weight == null)
      jcasType.jcas.throwFeatMissing("weight", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_weight, v);}    
   
    
  //*--------------*
  //* Feature: configuration

  /** getter for configuration - gets 
   * @generated */
  public String getConfiguration() {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_configuration == null)
      jcasType.jcas.throwFeatMissing("configuration", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_configuration);}
    
  /** setter for configuration - sets  
   * @generated */
  public void setConfiguration(String v) {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_configuration == null)
      jcasType.jcas.throwFeatMissing("configuration", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    jcasType.ll_cas.ll_setStringValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_configuration, v);}    
   
    
  //*--------------*
  //* Feature: values

  /** getter for values - gets 
   * @generated */
  public FSList getValues() {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_values == null)
      jcasType.jcas.throwFeatMissing("values", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_values)));}
    
  /** setter for values - sets  
   * @generated */
  public void setValues(FSList v) {
    if (DecisionConfiguration_Type.featOkTst && ((DecisionConfiguration_Type)jcasType).casFeat_values == null)
      jcasType.jcas.throwFeatMissing("values", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    jcasType.ll_cas.ll_setRefValue(addr, ((DecisionConfiguration_Type)jcasType).casFeatCode_values, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    