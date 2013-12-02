

/* First created by JCasGen Sat Nov 30 21:13:01 EST 2013 */
package edu.cmu.lti.oaqa.qa4ds.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.answer.AnswerList;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Sat Nov 30 21:13:01 EST 2013
 * XML source: /home/yangzi/QA/qa4ds/src/main/resources/edu/cmu/lti/oaqa/qa4ds/QA4DSTypes.xml
 * @generated */
public class MergedAnswerLists extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(MergedAnswerLists.class);
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
  protected MergedAnswerLists() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public MergedAnswerLists(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public MergedAnswerLists(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: children

  /** getter for children - gets 
   * @generated */
  public FSList getChildren() {
    if (MergedAnswerLists_Type.featOkTst && ((MergedAnswerLists_Type)jcasType).casFeat_children == null)
      jcasType.jcas.throwFeatMissing("children", "edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((MergedAnswerLists_Type)jcasType).casFeatCode_children)));}
    
  /** setter for children - sets  
   * @generated */
  public void setChildren(FSList v) {
    if (MergedAnswerLists_Type.featOkTst && ((MergedAnswerLists_Type)jcasType).casFeat_children == null)
      jcasType.jcas.throwFeatMissing("children", "edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
    jcasType.ll_cas.ll_setRefValue(addr, ((MergedAnswerLists_Type)jcasType).casFeatCode_children, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: parent

  /** getter for parent - gets 
   * @generated */
  public AnswerList getParent() {
    if (MergedAnswerLists_Type.featOkTst && ((MergedAnswerLists_Type)jcasType).casFeat_parent == null)
      jcasType.jcas.throwFeatMissing("parent", "edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
    return (AnswerList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((MergedAnswerLists_Type)jcasType).casFeatCode_parent)));}
    
  /** setter for parent - sets  
   * @generated */
  public void setParent(AnswerList v) {
    if (MergedAnswerLists_Type.featOkTst && ((MergedAnswerLists_Type)jcasType).casFeat_parent == null)
      jcasType.jcas.throwFeatMissing("parent", "edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
    jcasType.ll_cas.ll_setRefValue(addr, ((MergedAnswerLists_Type)jcasType).casFeatCode_parent, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    