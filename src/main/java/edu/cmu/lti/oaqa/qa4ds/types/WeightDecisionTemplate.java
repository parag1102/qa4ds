

/* First created by JCasGen Sun Nov 10 17:40:30 EST 2013 */
package edu.cmu.lti.oaqa.qa4ds.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Mon Nov 11 18:25:41 EST 2013
 * XML source: /home/yangzi/QA/qa4ds/src/main/resources/edu/cmu/lti/oaqa/qa4ds/QA4DSTypes.xml
 * @generated */
public class WeightDecisionTemplate extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(WeightDecisionTemplate.class);
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
  protected WeightDecisionTemplate() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public WeightDecisionTemplate(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public WeightDecisionTemplate(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: template

  /** getter for template - gets 
   * @generated */
  public DecisionTemplate getTemplate() {
    if (WeightDecisionTemplate_Type.featOkTst && ((WeightDecisionTemplate_Type)jcasType).casFeat_template == null)
      jcasType.jcas.throwFeatMissing("template", "edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
    return (DecisionTemplate)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((WeightDecisionTemplate_Type)jcasType).casFeatCode_template)));}
    
  /** setter for template - sets  
   * @generated */
  public void setTemplate(DecisionTemplate v) {
    if (WeightDecisionTemplate_Type.featOkTst && ((WeightDecisionTemplate_Type)jcasType).casFeat_template == null)
      jcasType.jcas.throwFeatMissing("template", "edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
    jcasType.ll_cas.ll_setRefValue(addr, ((WeightDecisionTemplate_Type)jcasType).casFeatCode_template, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: weight

  /** getter for weight - gets 
   * @generated */
  public double getWeight() {
    if (WeightDecisionTemplate_Type.featOkTst && ((WeightDecisionTemplate_Type)jcasType).casFeat_weight == null)
      jcasType.jcas.throwFeatMissing("weight", "edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((WeightDecisionTemplate_Type)jcasType).casFeatCode_weight);}
    
  /** setter for weight - sets  
   * @generated */
  public void setWeight(double v) {
    if (WeightDecisionTemplate_Type.featOkTst && ((WeightDecisionTemplate_Type)jcasType).casFeat_weight == null)
      jcasType.jcas.throwFeatMissing("weight", "edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((WeightDecisionTemplate_Type)jcasType).casFeatCode_weight, v);}    
  }

    