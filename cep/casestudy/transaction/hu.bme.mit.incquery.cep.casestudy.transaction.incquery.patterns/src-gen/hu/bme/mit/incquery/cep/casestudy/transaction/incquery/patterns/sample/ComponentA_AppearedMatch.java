package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentA;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.componentA_Appeared pattern, 
 * to be used in conjunction with {@link ComponentA_AppearedMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ComponentA_AppearedMatcher
 * @see ComponentA_AppearedProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentA_AppearedMatch extends BasePatternMatch {
  private TransactionComponentA fTe;
  
  private String fTId;
  
  private static List<String> parameterNames = makeImmutableList("te", "tId");
  
  private ComponentA_AppearedMatch(final TransactionComponentA pTe, final String pTId) {
    this.fTe = pTe;
    this.fTId = pTId;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("te".equals(parameterName)) return this.fTe;
    if ("tId".equals(parameterName)) return this.fTId;
    return null;
    
  }
  
  public TransactionComponentA getTe() {
    return this.fTe;
    
  }
  
  public String getTId() {
    return this.fTId;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("te".equals(parameterName) ) {
    	this.fTe = (hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentA) newValue;
    	return true;
    }
    if ("tId".equals(parameterName) ) {
    	this.fTId = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTe(final TransactionComponentA pTe) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTe = pTe;
    
  }
  
  public void setTId(final String pTId) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTId = pTId;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.componentA_Appeared";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ComponentA_AppearedMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTe, fTId};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"te\"=" + prettyPrintValue(fTe) + ", ");
    result.append("\"tId\"=" + prettyPrintValue(fTId));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTe == null) ? 0 : fTe.hashCode()); 
    result = prime * result + ((fTId == null) ? 0 : fTId.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ComponentA_AppearedMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ComponentA_AppearedMatch other = (ComponentA_AppearedMatch) obj;
    if (fTe == null) {if (other.fTe != null) return false;}
    else if (!fTe.equals(other.fTe)) return false;
    if (fTId == null) {if (other.fTId != null) return false;}
    else if (!fTId.equals(other.fTId)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return ComponentA_AppearedMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends ComponentA_AppearedMatch {
    Mutable(final TransactionComponentA pTe, final String pTId) {
      super(pTe, pTId);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends ComponentA_AppearedMatch {
    Immutable(final TransactionComponentA pTe, final String pTId) {
      super(pTe, pTId);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
