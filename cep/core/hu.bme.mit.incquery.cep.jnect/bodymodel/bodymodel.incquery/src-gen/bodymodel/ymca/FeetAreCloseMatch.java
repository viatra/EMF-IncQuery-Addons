package bodymodel.ymca;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.LeftFoot;
import org.jnect.bodymodel.RightFoot;

/**
 * Pattern-specific match representation of the bodymodel.ymca.feetAreClose pattern, 
 * to be used in conjunction with {@link FeetAreCloseMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FeetAreCloseMatcher
 * @see FeetAreCloseProcessor
 * 
 */
public abstract class FeetAreCloseMatch extends BasePatternMatch {
  private LeftFoot fLF;
  
  private RightFoot fRF;
  
  private static List<String> parameterNames = makeImmutableList("LF", "RF");
  
  private FeetAreCloseMatch(final LeftFoot pLF, final RightFoot pRF) {
    this.fLF = pLF;
    this.fRF = pRF;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("LF".equals(parameterName)) return this.fLF;
    if ("RF".equals(parameterName)) return this.fRF;
    return null;
    
  }
  
  public LeftFoot getLF() {
    return this.fLF;
    
  }
  
  public RightFoot getRF() {
    return this.fRF;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("LF".equals(parameterName) ) {
    	this.fLF = (org.jnect.bodymodel.LeftFoot) newValue;
    	return true;
    }
    if ("RF".equals(parameterName) ) {
    	this.fRF = (org.jnect.bodymodel.RightFoot) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setLF(final LeftFoot pLF) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLF = pLF;
    
  }
  
  public void setRF(final RightFoot pRF) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRF = pRF;
    
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.feetAreClose";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return FeetAreCloseMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fLF, fRF};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"LF\"=" + prettyPrintValue(fLF) + ", ");
    result.append("\"RF\"=" + prettyPrintValue(fRF));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fLF == null) ? 0 : fLF.hashCode()); 
    result = prime * result + ((fRF == null) ? 0 : fRF.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof FeetAreCloseMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    FeetAreCloseMatch other = (FeetAreCloseMatch) obj;
    if (fLF == null) {if (other.fLF != null) return false;}
    else if (!fLF.equals(other.fLF)) return false;
    if (fRF == null) {if (other.fRF != null) return false;}
    else if (!fRF.equals(other.fRF)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return FeetAreCloseMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends FeetAreCloseMatch {
    Mutable(final LeftFoot pLF, final RightFoot pRF) {
      super(pLF, pRF);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends FeetAreCloseMatch {
    Immutable(final LeftFoot pLF, final RightFoot pRF) {
      super(pLF, pRF);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
