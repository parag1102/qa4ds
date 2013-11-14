
/* First created by JCasGen Sun Nov 10 17:39:32 EST 2013 */
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
 * Updated by JCasGen Mon Nov 11 18:25:41 EST 2013
 * @generated */
public class DecisionTemplate_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DecisionTemplate_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DecisionTemplate_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DecisionTemplate(addr, DecisionTemplate_Type.this);
  			   DecisionTemplate_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DecisionTemplate(addr, DecisionTemplate_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DecisionTemplate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_vars;
  /** @generated */
  final int     casFeatCode_vars;
  /** @generated */ 
  public int getVars(int addr) {
        if (featOkTst && casFeat_vars == null)
      jcas.throwFeatMissing("vars", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return ll_cas.ll_getRefValue(addr, casFeatCode_vars);
  }
  /** @generated */    
  public void setVars(int addr, int v) {
        if (featOkTst && casFeat_vars == null)
      jcas.throwFeatMissing("vars", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    ll_cas.ll_setRefValue(addr, casFeatCode_vars, v);}
    
  
 
  /** @generated */
  final Feature casFeat_question;
  /** @generated */
  final int     casFeatCode_question;
  /** @generated */ 
  public String getQuestion(int addr) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_question);
  }
  /** @generated */    
  public void setQuestion(int addr, String v) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    ll_cas.ll_setStringValue(addr, casFeatCode_question, v);}
    
  
 
  /** @generated */
  final Feature casFeat_factors;
  /** @generated */
  final int     casFeatCode_factors;
  /** @generated */ 
  public int getFactors(int addr) {
        if (featOkTst && casFeat_factors == null)
      jcas.throwFeatMissing("factors", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return ll_cas.ll_getRefValue(addr, casFeatCode_factors);
  }
  /** @generated */    
  public void setFactors(int addr, int v) {
        if (featOkTst && casFeat_factors == null)
      jcas.throwFeatMissing("factors", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    ll_cas.ll_setRefValue(addr, casFeatCode_factors, v);}
    
  
 
  /** @generated */
  final Feature casFeat_primitive;
  /** @generated */
  final int     casFeatCode_primitive;
  /** @generated */ 
  public boolean getPrimitive(int addr) {
        if (featOkTst && casFeat_primitive == null)
      jcas.throwFeatMissing("primitive", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_primitive);
  }
  /** @generated */    
  public void setPrimitive(int addr, boolean v) {
        if (featOkTst && casFeat_primitive == null)
      jcas.throwFeatMissing("primitive", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_primitive, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DecisionTemplate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_vars = jcas.getRequiredFeatureDE(casType, "vars", "uima.cas.StringList", featOkTst);
    casFeatCode_vars  = (null == casFeat_vars) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_vars).getCode();

 
    casFeat_question = jcas.getRequiredFeatureDE(casType, "question", "uima.cas.String", featOkTst);
    casFeatCode_question  = (null == casFeat_question) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_question).getCode();

 
    casFeat_factors = jcas.getRequiredFeatureDE(casType, "factors", "uima.cas.FSList", featOkTst);
    casFeatCode_factors  = (null == casFeat_factors) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_factors).getCode();

 
    casFeat_primitive = jcas.getRequiredFeatureDE(casType, "primitive", "uima.cas.Boolean", featOkTst);
    casFeatCode_primitive  = (null == casFeat_primitive) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_primitive).getCode();

  }
}



    