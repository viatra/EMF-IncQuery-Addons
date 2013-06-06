package bodymodel.ymca;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.CenterHip;
import org.jnect.bodymodel.RightHand;

/**
 * Pattern-specific match representation of the bodymodel.ymca.SS pattern, 
 * to be used in conjunction with {@link SSMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SSMatcher
 * @see SSProcessor
 * 
 */
public abstract class SSMatch extends BasePatternMatch {
  private RightHand fRH;
  
  private CenterHip fCH;
  
  private static List<String> parameterNames = makeImmutableList("RH", "CH");
  
  private SSMatch(final RightHand pRH, final CenterHip pCH) {
    this.fRH = pRH;
    this.fCH = pCH;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("RH".equals(parameterName)) return this.fRH;
    if ("CH".equals(parameterName)) return this.fCH;
    return null;
    
  }
  
  public RightHand getRH() {
    return this.fRH;
    
  }
  
  public CenterHip getCH() {
    return this.fCH;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("RH".equals(parameterName) ) {
    	this.fRH = (org.jnect.bodymodel.RightHand) newValue;
    	return true;
    }
    if ("CH".equals(parameterName) ) {
    	this.fCH = (org.jnect.bodymodel.CenterHip) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRH(final RightHand pRH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRH = pRH;
    
  }
  
  public void setCH(final CenterHip pCH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCH = pCH;
    
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.SS";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SSMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRH, fCH};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"RH\"=" + prettyPrintValue(fRH) + ", ");
    result.append("\"CH\"=" + prettyPrintValue(fCH));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRH == null) ? 0 : fRH.hashCode()); 
    result = prime * result + ((fCH == null) ? 0 : fCH.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SSMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SSMatch other = (SSMatch) obj;
    if (fRH == null) {if (other.fRH != null) return false;}
    else if (!fRH.equals(other.fRH)) return false;
    if (fCH == null) {if (other.fCH != null) return false;}
    else if (!fCH.equals(other.fCH)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return SSMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends SSMatch {
    Mutable(final RightHand pRH, final CenterHip pCH) {
      super(pRH, pCH);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends SSMatch {
    Immutable(final RightHand pRH, final CenterHip pCH) {
      super(pRH, pCH);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
