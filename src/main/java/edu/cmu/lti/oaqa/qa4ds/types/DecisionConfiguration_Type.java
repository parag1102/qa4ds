
/* First created by JCasGen Wed Nov 20 21:04:59 EST 2013 */
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
 * Updated by JCasGen Wed Nov 20 21:04:59 EST 2013
 * @generated */
public class DecisionConfiguration_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DecisionConfiguration_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DecisionConfiguration_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DecisionConfiguration(addr, DecisionConfiguration_Type.this);
  			   DecisionConfiguration_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DecisionConfiguration(addr, DecisionConfiguration_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DecisionConfiguration.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
 
  /** @generated */
  final Feature casFeat_templateName;
  /** @generated */
  final int     casFeatCode_templateName;
  /** @generated */ 
  public String getTemplateName(int addr) {
        if (featOkTst && casFeat_templateName == null)
      jcas.throwFeatMissing("templateName", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return ll_cas.ll_getStringValue(addr, casFeatCode_templateName);
  }
  /** @generated */    
  public void setTemplateName(int addr, String v) {
        if (featOkTst && casFeat_templateName == null)
      jcas.throwFeatMissing("templateName", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    ll_cas.ll_setStringValue(addr, casFeatCode_templateName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_question;
  /** @generated */
  final int     casFeatCode_question;
  /** @generated */ 
  public int getQuestion(int addr) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return ll_cas.ll_getRefValue(addr, casFeatCode_question);
  }
  /** @generated */    
  public void setQuestion(int addr, int v) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    ll_cas.ll_setRefValue(addr, casFeatCode_question, v);}
    
  
 
  /** @generated */
  final Feature casFeat_factors;
  /** @generated */
  final int     casFeatCode_factors;
  /** @generated */ 
  public int getFactors(int addr) {
        if (featOkTst && casFeat_factors == null)
      jcas.throwFeatMissing("factors", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return ll_cas.ll_getRefValue(addr, casFeatCode_factors);
  }
  /** @generated */    
  public void setFactors(int addr, int v) {
        if (featOkTst && casFeat_factors == null)
      jcas.throwFeatMissing("factors", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    ll_cas.ll_setRefValue(addr, casFeatCode_factors, v);}
    
  
 
  /** @generated */
  final Feature casFeat_primitive;
  /** @generated */
  final int     casFeatCode_primitive;
  /** @generated */ 
  public boolean getPrimitive(int addr) {
        if (featOkTst && casFeat_primitive == null)
      jcas.throwFeatMissing("primitive", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_primitive);
  }
  /** @generated */    
  public void setPrimitive(int addr, boolean v) {
        if (featOkTst && casFeat_primitive == null)
      jcas.throwFeatMissing("primitive", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_primitive, v);}
    
  
 
  /** @generated */
  final Feature casFeat_weight;
  /** @generated */
  final int     casFeatCode_weight;
  /** @generated */ 
  public double getWeight(int addr) {
        if (featOkTst && casFeat_weight == null)
      jcas.throwFeatMissing("weight", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_weight);
  }
  /** @generated */    
  public void setWeight(int addr, double v) {
        if (featOkTst && casFeat_weight == null)
      jcas.throwFeatMissing("weight", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_weight, v);}
    
  
 
  /** @generated */
  final Feature casFeat_configuration;
  /** @generated */
  final int     casFeatCode_configuration;
  /** @generated */ 
  public String getConfiguration(int addr) {
        if (featOkTst && casFeat_configuration == null)
      jcas.throwFeatMissing("configuration", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return ll_cas.ll_getStringValue(addr, casFeatCode_configuration);
  }
  /** @generated */    
  public void setConfiguration(int addr, String v) {
        if (featOkTst && casFeat_configuration == null)
      jcas.throwFeatMissing("configuration", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    ll_cas.ll_setStringValue(addr, casFeatCode_configuration, v);}
    
  
 
  /** @generated */
  final Feature casFeat_values;
  /** @generated */
  final int     casFeatCode_values;
  /** @generated */ 
  public int getValues(int addr) {
        if (featOkTst && casFeat_values == null)
      jcas.throwFeatMissing("values", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    return ll_cas.ll_getRefValue(addr, casFeatCode_values);
  }
  /** @generated */    
  public void setValues(int addr, int v) {
        if (featOkTst && casFeat_values == null)
      jcas.throwFeatMissing("values", "edu.cmu.lti.oaqa.qa4ds.types.DecisionConfiguration");
    ll_cas.ll_setRefValue(addr, casFeatCode_values, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DecisionConfiguration_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_templateName = jcas.getRequiredFeatureDE(casType, "templateName", "uima.cas.String", featOkTst);
    casFeatCode_templateName  = (null == casFeat_templateName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_templateName).getCode();

 
    casFeat_question = jcas.getRequiredFeatureDE(casType, "question", "org.oaqa.model.input.Question", featOkTst);
    casFeatCode_question  = (null == casFeat_question) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_question).getCode();

 
    casFeat_factors = jcas.getRequiredFeatureDE(casType, "factors", "uima.cas.FSList", featOkTst);
    casFeatCode_factors  = (null == casFeat_factors) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_factors).getCode();

 
    casFeat_primitive = jcas.getRequiredFeatureDE(casType, "primitive", "uima.cas.Boolean", featOkTst);
    casFeatCode_primitive  = (null == casFeat_primitive) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_primitive).getCode();

 
    casFeat_weight = jcas.getRequiredFeatureDE(casType, "weight", "uima.cas.Double", featOkTst);
    casFeatCode_weight  = (null == casFeat_weight) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_weight).getCode();

 
    casFeat_configuration = jcas.getRequiredFeatureDE(casType, "configuration", "uima.cas.String", featOkTst);
    casFeatCode_configuration  = (null == casFeat_configuration) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_configuration).getCode();

 
    casFeat_values = jcas.getRequiredFeatureDE(casType, "values", "uima.cas.FSList", featOkTst);
    casFeatCode_values  = (null == casFeat_values) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_values).getCode();

  }
}



    