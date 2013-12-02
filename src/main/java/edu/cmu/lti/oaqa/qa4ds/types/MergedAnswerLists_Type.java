
/* First created by JCasGen Sat Nov 30 21:13:01 EST 2013 */
package edu.cmu.lti.oaqa.qa4ds.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** 
 * Updated by JCasGen Sat Nov 30 21:13:01 EST 2013
 * @generated */
public class MergedAnswerLists_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (MergedAnswerLists_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = MergedAnswerLists_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new MergedAnswerLists(addr, MergedAnswerLists_Type.this);
  			   MergedAnswerLists_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new MergedAnswerLists(addr, MergedAnswerLists_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MergedAnswerLists.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
 
  /** @generated */
  final Feature casFeat_children;
  /** @generated */
  final int     casFeatCode_children;
  /** @generated */ 
  public int getChildren(int addr) {
        if (featOkTst && casFeat_children == null)
      jcas.throwFeatMissing("children", "edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
    return ll_cas.ll_getRefValue(addr, casFeatCode_children);
  }
  /** @generated */    
  public void setChildren(int addr, int v) {
        if (featOkTst && casFeat_children == null)
      jcas.throwFeatMissing("children", "edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
    ll_cas.ll_setRefValue(addr, casFeatCode_children, v);}
    
  
 
  /** @generated */
  final Feature casFeat_parent;
  /** @generated */
  final int     casFeatCode_parent;
  /** @generated */ 
  public int getParent(int addr) {
        if (featOkTst && casFeat_parent == null)
      jcas.throwFeatMissing("parent", "edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
    return ll_cas.ll_getRefValue(addr, casFeatCode_parent);
  }
  /** @generated */    
  public void setParent(int addr, int v) {
        if (featOkTst && casFeat_parent == null)
      jcas.throwFeatMissing("parent", "edu.cmu.lti.oaqa.qa4ds.types.MergedAnswerLists");
    ll_cas.ll_setRefValue(addr, casFeatCode_parent, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public MergedAnswerLists_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_children = jcas.getRequiredFeatureDE(casType, "children", "uima.cas.FSList", featOkTst);
    casFeatCode_children  = (null == casFeat_children) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_children).getCode();

 
    casFeat_parent = jcas.getRequiredFeatureDE(casType, "parent", "org.oaqa.model.answer.AnswerList", featOkTst);
    casFeatCode_parent  = (null == casFeat_parent) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_parent).getCode();

  }
}



    