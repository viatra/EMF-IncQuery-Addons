package bodymodel;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.RightHand;

/**
 * Pattern-specific match representation of the bodymodel.RightHandAboveHead pattern, 
 * to be used in conjunction with {@link RightHandAboveHeadMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RightHandAboveHeadMatcher
 * @see RightHandAboveHeadProcessor
 * 
 */
public abstract class RightHandAboveHeadMatch extends BasePatternMatch {
  private RightHand fRH;
  
  private Head fH;
  
  private static List<String> parameterNames = makeImmutableList("RH", "H");
  
  private RightHandAboveHeadMatch(final RightHand pRH, final Head pH) {
    this.fRH = pRH;
    this.fH = pH;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("RH".equals(parameterName)) return this.fRH;
    if ("H".equals(parameterName)) return this.fH;
    return null;
    
  }
  
  public RightHand getRH() {
    return this.fRH;
    
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
  
  public void setH(final Head pH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fH = pH;
    
  }
  
  @Override
  public String patternName() {
    return "bodymodel.RightHandAboveHead";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return RightHandAboveHeadMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRH, fH};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"RH\"=" + prettyPrintValue(fRH) + ", ");
    result.append("\"H\"=" + prettyPrintValue(fH));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRH == null) ? 0 : fRH.hashCode()); 
    result = prime * result + ((fH == null) ? 0 : fH.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RightHandAboveHeadMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    RightHandAboveHeadMatch other = (RightHandAboveHeadMatch) obj;
    if (fRH == null) {if (other.fRH != null) return false;}
    else if (!fRH.equals(other.fRH)) return false;
    if (fH == null) {if (other.fH != null) return false;}
    else if (!fH.equals(other.fH)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return RightHandAboveHeadMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends RightHandAboveHeadMatch {
    Mutable(final RightHand pRH, final Head pH) {
      super(pRH, pH);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends RightHandAboveHeadMatch {
    Immutable(final RightHand pRH, final Head pH) {
      super(pRH, pH);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
