package bodymodel.ymca;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftShoulder;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightShoulder;

/**
 * Pattern-specific match representation of the bodymodel.ymca.upperArmsInY pattern, 
 * to be used in conjunction with {@link UpperArmsInYMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see UpperArmsInYMatcher
 * @see UpperArmsInYProcessor
 * 
 */
public abstract class UpperArmsInYMatch extends BasePatternMatch {
  private LeftElbow fLE;
  
  private LeftShoulder fLS;
  
  private RightElbow fRE;
  
  private RightShoulder fRS;
  
  private static List<String> parameterNames = makeImmutableList("LE", "LS", "RE", "RS");
  
  private UpperArmsInYMatch(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
    this.fLE = pLE;
    this.fLS = pLS;
    this.fRE = pRE;
    this.fRS = pRS;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("LE".equals(parameterName)) return this.fLE;
    if ("LS".equals(parameterName)) return this.fLS;
    if ("RE".equals(parameterName)) return this.fRE;
    if ("RS".equals(parameterName)) return this.fRS;
    return null;
    
  }
  
  public LeftElbow getLE() {
    return this.fLE;
    
  }
  
  public LeftShoulder getLS() {
    return this.fLS;
    
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
    if ("LE".equals(parameterName) ) {
    	this.fLE = (org.jnect.bodymodel.LeftElbow) newValue;
    	return true;
    }
    if ("LS".equals(parameterName) ) {
    	this.fLS = (org.jnect.bodymodel.LeftShoulder) newValue;
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
  
  public void setLE(final LeftElbow pLE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLE = pLE;
    
  }
  
  public void setLS(final LeftShoulder pLS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLS = pLS;
    
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
    return "bodymodel.ymca.upperArmsInY";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return UpperArmsInYMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fLE, fLS, fRE, fRS};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"LE\"=" + prettyPrintValue(fLE) + ", ");
    result.append("\"LS\"=" + prettyPrintValue(fLS) + ", ");
    result.append("\"RE\"=" + prettyPrintValue(fRE) + ", ");
    result.append("\"RS\"=" + prettyPrintValue(fRS));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fLE == null) ? 0 : fLE.hashCode()); 
    result = prime * result + ((fLS == null) ? 0 : fLS.hashCode()); 
    result = prime * result + ((fRE == null) ? 0 : fRE.hashCode()); 
    result = prime * result + ((fRS == null) ? 0 : fRS.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof UpperArmsInYMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    UpperArmsInYMatch other = (UpperArmsInYMatch) obj;
    if (fLE == null) {if (other.fLE != null) return false;}
    else if (!fLE.equals(other.fLE)) return false;
    if (fLS == null) {if (other.fLS != null) return false;}
    else if (!fLS.equals(other.fLS)) return false;
    if (fRE == null) {if (other.fRE != null) return false;}
    else if (!fRE.equals(other.fRE)) return false;
    if (fRS == null) {if (other.fRS != null) return false;}
    else if (!fRS.equals(other.fRS)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return UpperArmsInYMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends UpperArmsInYMatch {
    Mutable(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
      super(pLE, pLS, pRE, pRS);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends UpperArmsInYMatch {
    Immutable(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS) {
      super(pLE, pLS, pRE, pRS);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
