package bodymodel.ymca;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * Pattern-specific match representation of the bodymodel.ymca.C pattern, 
 * to be used in conjunction with {@link CMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CMatcher
 * @see CProcessor
 * 
 */
public abstract class CMatch extends BasePatternMatch {
  private RightHand fRH;
  
  private RightElbow fRE;
  
  private RightShoulder fRS;
  
  private LeftHand fLH;
  
  private LeftElbow fLE;
  
  private Head fH;
  
  private static List<String> parameterNames = makeImmutableList("RH", "RE", "RS", "LH", "LE", "H");
  
  private CMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final Head pH) {
    this.fRH = pRH;
    this.fRE = pRE;
    this.fRS = pRS;
    this.fLH = pLH;
    this.fLE = pLE;
    this.fH = pH;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("RH".equals(parameterName)) return this.fRH;
    if ("RE".equals(parameterName)) return this.fRE;
    if ("RS".equals(parameterName)) return this.fRS;
    if ("LH".equals(parameterName)) return this.fLH;
    if ("LE".equals(parameterName)) return this.fLE;
    if ("H".equals(parameterName)) return this.fH;
    return null;
    
  }
  
  public RightHand getRH() {
    return this.fRH;
    
  }
  
  public RightElbow getRE() {
    return this.fRE;
    
  }
  
  public RightShoulder getRS() {
    return this.fRS;
    
  }
  
  public LeftHand getLH() {
    return this.fLH;
    
  }
  
  public LeftElbow getLE() {
    return this.fLE;
    
  }
  
  public Head getH() {
    return this.fH;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("RH".equals(parameterName) ) {
    	this.fRH = (org.jnect.bodymodel.RightHand) newValue;
    	return true;
    }
    if ("RE".equals(parameterName) ) {
    	this.fRE = (org.jnect.bodymodel.RightElbow) newValue;
    	return true;
    }
    if ("RS".equals(parameterName) ) {
    	this.fRS = (org.jnect.bodymodel.RightShoulder) newValue;
    	return true;
    }
    if ("LH".equals(parameterName) ) {
    	this.fLH = (org.jnect.bodymodel.LeftHand) newValue;
    	return true;
    }
    if ("LE".equals(parameterName) ) {
    	this.fLE = (org.jnect.bodymodel.LeftElbow) newValue;
    	return true;
    }
    if ("H".equals(parameterName) ) {
    	this.fH = (org.jnect.bodymodel.Head) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRH(final RightHand pRH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRH = pRH;
    
  }
  
  public void setRE(final RightElbow pRE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRE = pRE;
    
  }
  
  public void setRS(final RightShoulder pRS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRS = pRS;
    
  }
  
  public void setLH(final LeftHand pLH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLH = pLH;
    
  }
  
  public void setLE(final LeftElbow pLE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLE = pLE;
    
  }
  
  public void setH(final Head pH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fH = pH;
    
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.C";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return CMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRH, fRE, fRS, fLH, fLE, fH};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"RH\"=" + prettyPrintValue(fRH) + ", ");
    result.append("\"RE\"=" + prettyPrintValue(fRE) + ", ");
    result.append("\"RS\"=" + prettyPrintValue(fRS) + ", ");
    result.append("\"LH\"=" + prettyPrintValue(fLH) + ", ");
    result.append("\"LE\"=" + prettyPrintValue(fLE) + ", ");
    result.append("\"H\"=" + prettyPrintValue(fH));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRH == null) ? 0 : fRH.hashCode()); 
    result = prime * result + ((fRE == null) ? 0 : fRE.hashCode()); 
    result = prime * result + ((fRS == null) ? 0 : fRS.hashCode()); 
    result = prime * result + ((fLH == null) ? 0 : fLH.hashCode()); 
    result = prime * result + ((fLE == null) ? 0 : fLE.hashCode()); 
    result = prime * result + ((fH == null) ? 0 : fH.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof CMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    CMatch other = (CMatch) obj;
    if (fRH == null) {if (other.fRH != null) return false;}
    else if (!fRH.equals(other.fRH)) return false;
    if (fRE == null) {if (other.fRE != null) return false;}
    else if (!fRE.equals(other.fRE)) return false;
    if (fRS == null) {if (other.fRS != null) return false;}
    else if (!fRS.equals(other.fRS)) return false;
    if (fLH == null) {if (other.fLH != null) return false;}
    else if (!fLH.equals(other.fLH)) return false;
    if (fLE == null) {if (other.fLE != null) return false;}
    else if (!fLE.equals(other.fLE)) return false;
    if (fH == null) {if (other.fH != null) return false;}
    else if (!fH.equals(other.fH)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return CMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends CMatch {
    Mutable(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final Head pH) {
      super(pRH, pRE, pRS, pLH, pLE, pH);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends CMatch {
    Immutable(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final Head pH) {
      super(pRH, pRE, pRS, pLH, pLE, pH);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
