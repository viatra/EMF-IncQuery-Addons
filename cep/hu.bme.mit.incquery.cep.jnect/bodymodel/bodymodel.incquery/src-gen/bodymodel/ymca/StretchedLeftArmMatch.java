package bodymodel.ymca;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.LeftShoulder;

/**
 * Pattern-specific match representation of the bodymodel.ymca.stretchedLeftArm pattern, 
 * to be used in conjunction with {@link StretchedLeftArmMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StretchedLeftArmMatcher
 * @see StretchedLeftArmProcessor
 * 
 */
public abstract class StretchedLeftArmMatch extends BasePatternMatch {
  private LeftHand fLH;
  
  private LeftElbow fLE;
  
  private LeftShoulder fLS;
  
  private static List<String> parameterNames = makeImmutableList("LH", "LE", "LS");
  
  private StretchedLeftArmMatch(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
    this.fLH = pLH;
    this.fLE = pLE;
    this.fLS = pLS;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("LH".equals(parameterName)) return this.fLH;
    if ("LE".equals(parameterName)) return this.fLE;
    if ("LS".equals(parameterName)) return this.fLS;
    return null;
    
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
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
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
    return false;
    
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
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.stretchedLeftArm";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return StretchedLeftArmMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fLH, fLE, fLS};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"LH\"=" + prettyPrintValue(fLH) + ", ");
    result.append("\"LE\"=" + prettyPrintValue(fLE) + ", ");
    result.append("\"LS\"=" + prettyPrintValue(fLS));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fLH == null) ? 0 : fLH.hashCode()); 
    result = prime * result + ((fLE == null) ? 0 : fLE.hashCode()); 
    result = prime * result + ((fLS == null) ? 0 : fLS.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StretchedLeftArmMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    StretchedLeftArmMatch other = (StretchedLeftArmMatch) obj;
    if (fLH == null) {if (other.fLH != null) return false;}
    else if (!fLH.equals(other.fLH)) return false;
    if (fLE == null) {if (other.fLE != null) return false;}
    else if (!fLE.equals(other.fLE)) return false;
    if (fLS == null) {if (other.fLS != null) return false;}
    else if (!fLS.equals(other.fLS)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return StretchedLeftArmMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends StretchedLeftArmMatch {
    Mutable(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
      super(pLH, pLE, pLS);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends StretchedLeftArmMatch {
    Immutable(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS) {
      super(pLH, pLE, pLS);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
