
/* First created by JCasGen Wed Nov 20 20:57:28 EST 2013 */
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
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Nov 20 21:04:59 EST 2013
 * @generated */
public class DecisionValue_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DecisionValue_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DecisionValue_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DecisionValue(addr, DecisionValue_Type.this);
  			   DecisionValue_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DecisionValue(addr, DecisionValue_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DecisionValue.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.qa4ds.types.DecisionValue");
 
  /** @generated */
  final Feature casFeat_variable;
  /** @generated */
  final int     casFeatCode_variable;
  /** @generated */ 
  public String getVariable(int addr) {
        if (featOkTst && casFeat_variable == null)
      jcas.throwFeatMissing("variable", "edu.cmu.lti.oaqa.qa4ds.types.DecisionValue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_variable);
  }
  /** @generated */    
  public void setVariable(int addr, String v) {
        if (featOkTst && casFeat_variable == null)
      jcas.throwFeatMissing("variable", "edu.cmu.lti.oaqa.qa4ds.types.DecisionValue");
    ll_cas.ll_setStringValue(addr, casFeatCode_variable, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DecisionValue_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_variable = jcas.getRequiredFeatureDE(casType, "variable", "uima.cas.String", featOkTst);
    casFeatCode_variable  = (null == casFeat_variable) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_variable).getCode();

  }
}



    