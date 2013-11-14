
/* First created by JCasGen Sun Nov 10 17:40:30 EST 2013 */
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
public class WeightDecisionTemplate_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (WeightDecisionTemplate_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = WeightDecisionTemplate_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new WeightDecisionTemplate(addr, WeightDecisionTemplate_Type.this);
  			   WeightDecisionTemplate_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new WeightDecisionTemplate(addr, WeightDecisionTemplate_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = WeightDecisionTemplate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
 
  /** @generated */
  final Feature casFeat_template;
  /** @generated */
  final int     casFeatCode_template;
  /** @generated */ 
  public int getTemplate(int addr) {
        if (featOkTst && casFeat_template == null)
      jcas.throwFeatMissing("template", "edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
    return ll_cas.ll_getRefValue(addr, casFeatCode_template);
  }
  /** @generated */    
  public void setTemplate(int addr, int v) {
        if (featOkTst && casFeat_template == null)
      jcas.throwFeatMissing("template", "edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
    ll_cas.ll_setRefValue(addr, casFeatCode_template, v);}
    
  
 
  /** @generated */
  final Feature casFeat_weight;
  /** @generated */
  final int     casFeatCode_weight;
  /** @generated */ 
  public double getWeight(int addr) {
        if (featOkTst && casFeat_weight == null)
      jcas.throwFeatMissing("weight", "edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_weight);
  }
  /** @generated */    
  public void setWeight(int addr, double v) {
        if (featOkTst && casFeat_weight == null)
      jcas.throwFeatMissing("weight", "edu.cmu.lti.oaqa.qa4ds.types.WeightDecisionTemplate");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_weight, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public WeightDecisionTemplate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_template = jcas.getRequiredFeatureDE(casType, "template", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate", featOkTst);
    casFeatCode_template  = (null == casFeat_template) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_template).getCode();

 
    casFeat_weight = jcas.getRequiredFeatureDE(casType, "weight", "uima.cas.Double", featOkTst);
    casFeatCode_weight  = (null == casFeat_weight) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_weight).getCode();

  }
}



    