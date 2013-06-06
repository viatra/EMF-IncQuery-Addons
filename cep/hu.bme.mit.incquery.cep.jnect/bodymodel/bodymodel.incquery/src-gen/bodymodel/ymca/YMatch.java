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
import org.jnect.bodymodel.LeftShoulder;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * Pattern-specific match representation of the bodymodel.ymca.Y pattern, 
 * to be used in conjunction with {@link YMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see YMatcher
 * @see YProcessor
 * 
 */
public abstract class YMatch extends BasePatternMatch {
  private RightHand fRH;
  
  private RightElbow fRE;
  
  private RightShoulder fRS;
  
  private LeftHand fLH;
  
  private LeftElbow fLE;
  
  private LeftShoulder fLS;
  
  private Head fH;
  
  private static List<String> parameterNames = makeImmutableList("RH", "RE", "RS", "LH", "LE", "LS", "H");
  
  private YMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
    this.fRH = pRH;
    this.fRE = pRE;
    this.fRS = pRS;
    this.fLH = pLH;
    this.fLE = pLE;
    this.fLS = pLS;
    this.fH = pH;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("RH".equals(parameterName)) return this.fRH;
    if ("RE".equals(parameterName)) return this.fRE;
    if ("RS".equals(parameterName)) return this.fRS;
    if ("LH".equals(parameterName)) return this.fLH;
    if ("LE".equals(parameterName)) return this.fLE;
    if ("LS".equals(parameterName)) return this.fLS;
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
  
  public LeftShoulder getLS() {
    return this.fLS;
    
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
    if ("LS".equals(parameterName) ) {
    	this.fLS = (org.jnect.bodymodel.LeftShoulder) newValue;
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
  
  public void setLS(final LeftShoulder pLS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLS = pLS;
    
  }
  
  public void setH(final Head pH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fH = pH;
    
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.Y";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return YMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRH, fRE, fRS, fLH, fLE, fLS, fH};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"RH\"=" + prettyPrintValue(fRH) + ", ");
    result.append("\"RE\"=" + prettyPrintValue(fRE) + ", ");
    result.append("\"RS\"=" + prettyPrintValue(fRS) + ", ");
    result.append("\"LH\"=" + prettyPrintValue(fLH) + ", ");
    result.append("\"LE\"=" + prettyPrintValue(fLE) + ", ");
    result.append("\"LS\"=" + prettyPrintValue(fLS) + ", ");
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
    result = prime * result + ((fLS == null) ? 0 : fLS.hashCode()); 
    result = prime * result + ((fH == null) ? 0 : fH.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof YMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    YMatch other = (YMatch) obj;
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
    if (fLS == null) {if (other.fLS != null) return false;}
    else if (!fLS.equals(other.fLS)) return false;
    if (fH == null) {if (other.fH != null) return false;}
    else if (!fH.equals(other.fH)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return YMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends YMatch {
    Mutable(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
      super(pRH, pRE, pRS, pLH, pLE, pLS, pH);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends YMatch {
    Immutable(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH) {
      super(pRH, pRE, pRS, pLH, pLE, pLS, pH);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
