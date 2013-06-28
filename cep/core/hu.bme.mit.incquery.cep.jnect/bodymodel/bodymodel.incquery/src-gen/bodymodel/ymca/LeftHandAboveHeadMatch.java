package bodymodel.ymca;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.LeftHand;

/**
 * Pattern-specific match representation of the bodymodel.ymca.leftHandAboveHead pattern, 
 * to be used in conjunction with {@link LeftHandAboveHeadMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LeftHandAboveHeadMatcher
 * @see LeftHandAboveHeadProcessor
 * 
 */
public abstract class LeftHandAboveHeadMatch extends BasePatternMatch {
  private LeftHand fLH;
  
  private Head fH;
  
  private static List<String> parameterNames = makeImmutableList("LH", "H");
  
  private LeftHandAboveHeadMatch(final LeftHand pLH, final Head pH) {
    this.fLH = pLH;
    this.fH = pH;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("LH".equals(parameterName)) return this.fLH;
    if ("H".equals(parameterName)) return this.fH;
    return null;
    
  }
  
  public LeftHand getLH() {
    return this.fLH;
    
  }
  
  public Head getH() {
    return this.fH;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("LH".equals(parameterName) ) {
    	this.fLH = (org.jnect.bodymodel.LeftHand) newValue;
    	return true;
    }
    if ("H".equals(parameterName) ) {
    	this.fH = (org.jnect.bodymodel.Head) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setLH(final LeftHand pLH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLH = pLH;
    
  }
  
  public void setH(final Head pH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fH = pH;
    
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.leftHandAboveHead";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return LeftHandAboveHeadMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fLH, fH};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"LH\"=" + prettyPrintValue(fLH) + ", ");
    result.append("\"H\"=" + prettyPrintValue(fH));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fLH == null) ? 0 : fLH.hashCode()); 
    result = prime * result + ((fH == null) ? 0 : fH.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LeftHandAboveHeadMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    LeftHandAboveHeadMatch other = (LeftHandAboveHeadMatch) obj;
    if (fLH == null) {if (other.fLH != null) return false;}
    else if (!fLH.equals(other.fLH)) return false;
    if (fH == null) {if (other.fH != null) return false;}
    else if (!fH.equals(other.fH)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return LeftHandAboveHeadMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends LeftHandAboveHeadMatch {
    Mutable(final LeftHand pLH, final Head pH) {
      super(pLH, pH);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends LeftHandAboveHeadMatch {
    Immutable(final LeftHand pLH, final Head pH) {
      super(pLH, pH);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
