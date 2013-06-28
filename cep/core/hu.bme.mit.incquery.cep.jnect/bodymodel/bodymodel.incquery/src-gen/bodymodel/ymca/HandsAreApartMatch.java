package bodymodel.ymca;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.RightHand;

/**
 * Pattern-specific match representation of the bodymodel.ymca.handsAreApart pattern, 
 * to be used in conjunction with {@link HandsAreApartMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see HandsAreApartMatcher
 * @see HandsAreApartProcessor
 * 
 */
public abstract class HandsAreApartMatch extends BasePatternMatch {
  private LeftHand fLH;
  
  private RightHand fRH;
  
  private static List<String> parameterNames = makeImmutableList("LH", "RH");
  
  private HandsAreApartMatch(final LeftHand pLH, final RightHand pRH) {
    this.fLH = pLH;
    this.fRH = pRH;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("LH".equals(parameterName)) return this.fLH;
    if ("RH".equals(parameterName)) return this.fRH;
    return null;
    
  }
  
  public LeftHand getLH() {
    return this.fLH;
    
  }
  
  public RightHand getRH() {
    return this.fRH;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("LH".equals(parameterName) ) {
    	this.fLH = (org.jnect.bodymodel.LeftHand) newValue;
    	return true;
    }
    if ("RH".equals(parameterName) ) {
    	this.fRH = (org.jnect.bodymodel.RightHand) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setLH(final LeftHand pLH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLH = pLH;
    
  }
  
  public void setRH(final RightHand pRH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRH = pRH;
    
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.handsAreApart";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return HandsAreApartMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fLH, fRH};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"LH\"=" + prettyPrintValue(fLH) + ", ");
    result.append("\"RH\"=" + prettyPrintValue(fRH));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fLH == null) ? 0 : fLH.hashCode()); 
    result = prime * result + ((fRH == null) ? 0 : fRH.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof HandsAreApartMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    HandsAreApartMatch other = (HandsAreApartMatch) obj;
    if (fLH == null) {if (other.fLH != null) return false;}
    else if (!fLH.equals(other.fLH)) return false;
    if (fRH == null) {if (other.fRH != null) return false;}
    else if (!fRH.equals(other.fRH)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return HandsAreApartMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends HandsAreApartMatch {
    Mutable(final LeftHand pLH, final RightHand pRH) {
      super(pLH, pRH);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends HandsAreApartMatch {
    Immutable(final LeftHand pLH, final RightHand pRH) {
      super(pLH, pRH);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
