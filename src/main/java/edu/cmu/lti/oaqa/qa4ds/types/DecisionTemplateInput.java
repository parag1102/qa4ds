

/* First created by JCasGen Mon Nov 11 18:25:41 EST 2013 */
package edu.cmu.lti.oaqa.qa4ds.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Mon Nov 11 18:25:41 EST 2013
 * XML source: /home/yangzi/QA/qa4ds/src/main/resources/edu/cmu/lti/oaqa/qa4ds/QA4DSTypes.xml
 * @generated */
public class DecisionTemplateInput extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DecisionTemplateInput.class);
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
  protected DecisionTemplateInput() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DecisionTemplateInput(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DecisionTemplateInput(JCas jcas) {
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
    if (DecisionTemplateInput_Type.featOkTst && ((DecisionTemplateInput_Type)jcasType).casFeat_template == null)
      jcasType.jcas.throwFeatMissing("template", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
    return (DecisionTemplate)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DecisionTemplateInput_Type)jcasType).casFeatCode_template)));}
    
  /** setter for template - sets  
   * @generated */
  public void setTemplate(DecisionTemplate v) {
    if (DecisionTemplateInput_Type.featOkTst && ((DecisionTemplateInput_Type)jcasType).casFeat_template == null)
      jcasType.jcas.throwFeatMissing("template", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
    jcasType.ll_cas.ll_setRefValue(addr, ((DecisionTemplateInput_Type)jcasType).casFeatCode_template, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: values

  /** getter for values - gets 
   * @generated */
  public StringList getValues() {
    if (DecisionTemplateInput_Type.featOkTst && ((DecisionTemplateInput_Type)jcasType).casFeat_values == null)
      jcasType.jcas.throwFeatMissing("values", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DecisionTemplateInput_Type)jcasType).casFeatCode_values)));}
    
  /** setter for values - sets  
   * @generated */
  public void setValues(StringList v) {
    if (DecisionTemplateInput_Type.featOkTst && ((DecisionTemplateInput_Type)jcasType).casFeat_values == null)
      jcasType.jcas.throwFeatMissing("values", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
    jcasType.ll_cas.ll_setRefValue(addr, ((DecisionTemplateInput_Type)jcasType).casFeatCode_values, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    