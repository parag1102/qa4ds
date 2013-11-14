
/* First created by JCasGen Mon Nov 11 18:25:41 EST 2013 */
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
public class DecisionTemplateInput_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DecisionTemplateInput_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DecisionTemplateInput_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DecisionTemplateInput(addr, DecisionTemplateInput_Type.this);
  			   DecisionTemplateInput_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DecisionTemplateInput(addr, DecisionTemplateInput_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DecisionTemplateInput.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
 
  /** @generated */
  final Feature casFeat_template;
  /** @generated */
  final int     casFeatCode_template;
  /** @generated */ 
  public int getTemplate(int addr) {
        if (featOkTst && casFeat_template == null)
      jcas.throwFeatMissing("template", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
    return ll_cas.ll_getRefValue(addr, casFeatCode_template);
  }
  /** @generated */    
  public void setTemplate(int addr, int v) {
        if (featOkTst && casFeat_template == null)
      jcas.throwFeatMissing("template", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
    ll_cas.ll_setRefValue(addr, casFeatCode_template, v);}
    
  
 
  /** @generated */
  final Feature casFeat_values;
  /** @generated */
  final int     casFeatCode_values;
  /** @generated */ 
  public int getValues(int addr) {
        if (featOkTst && casFeat_values == null)
      jcas.throwFeatMissing("values", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
    return ll_cas.ll_getRefValue(addr, casFeatCode_values);
  }
  /** @generated */    
  public void setValues(int addr, int v) {
        if (featOkTst && casFeat_values == null)
      jcas.throwFeatMissing("values", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplateInput");
    ll_cas.ll_setRefValue(addr, casFeatCode_values, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DecisionTemplateInput_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_template = jcas.getRequiredFeatureDE(casType, "template", "edu.cmu.lti.oaqa.qa4ds.types.DecisionTemplate", featOkTst);
    casFeatCode_template  = (null == casFeat_template) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_template).getCode();

 
    casFeat_values = jcas.getRequiredFeatureDE(casType, "values", "uima.cas.StringList", featOkTst);
    casFeatCode_values  = (null == casFeat_values) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_values).getCode();

  }
}



    