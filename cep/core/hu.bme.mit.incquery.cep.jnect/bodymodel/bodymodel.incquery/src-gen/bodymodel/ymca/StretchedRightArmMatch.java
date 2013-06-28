package bodymodel.ymca;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * Pattern-specific match representation of the bodymodel.ymca.stretchedRightArm pattern, 
 * to be used in conjunction with {@link StretchedRightArmMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StretchedRightArmMatcher
 * @see StretchedRightArmProcessor
 * 
 */
public abstract class StretchedRightArmMatch extends BasePatternMatch {
  private RightHand fRH;
  
  private RightElbow fRE;
  
  private RightShoulder fRS;
  
  private static List<String> parameterNames = makeImmutableList("RH", "RE", "RS");
  
  private StretchedRightArmMatch(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    this.fRH = pRH;
    this.fRE = pRE;
    this.fRS = pRS;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("RH".equals(parameterName)) return this.fRH;
    if ("RE".equals(parameterName)) return this.fRE;
    if ("RS".equals(parameterName)) return this.fRS;
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
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.stretchedRightArm";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return StretchedRightArmMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRH, fRE, fRS};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"RH\"=" + prettyPrintValue(fRH) + ", ");
    result.append("\"RE\"=" + prettyPrintValue(fRE) + ", ");
    result.append("\"RS\"=" + prettyPrintValue(fRS));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRH == null) ? 0 : fRH.hashCode()); 
    result = prime * result + ((fRE == null) ? 0 : fRE.hashCode()); 
    result = prime * result + ((fRS == null) ? 0 : fRS.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StretchedRightArmMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    StretchedRightArmMatch other = (StretchedRightArmMatch) obj;
    if (fRH == null) {if (other.fRH != null) return false;}
    else if (!fRH.equals(other.fRH)) return false;
    if (fRE == null) {if (other.fRE != null) return false;}
    else if (!fRE.equals(other.fRE)) return false;
    if (fRS == null) {if (other.fRS != null) return false;}
    else if (!fRS.equals(other.fRS)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return StretchedRightArmMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends StretchedRightArmMatch {
    Mutable(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
      super(pRH, pRE, pRS);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends StretchedRightArmMatch {
    Immutable(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
      super(pRH, pRE, pRS);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
