package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.tokenInTrapState pattern, 
 * to be used in conjunction with {@link TokenInTrapStateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TokenInTrapStateMatcher
 * @see TokenInTrapStateProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TokenInTrapStateMatch extends BasePatternMatch {
  private EventToken fEt;
  
  private static List<String> parameterNames = makeImmutableList("et");
  
  private TokenInTrapStateMatch(final EventToken pEt) {
    this.fEt = pEt;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("et".equals(parameterName)) return this.fEt;
    return null;
    
  }
  
  public EventToken getEt() {
    return this.fEt;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("et".equals(parameterName) ) {
    	this.fEt = (hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setEt(final EventToken pEt) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEt = pEt;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.tokenInTrapState";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return TokenInTrapStateMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEt};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"et\"=" + prettyPrintValue(fEt));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEt == null) ? 0 : fEt.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TokenInTrapStateMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TokenInTrapStateMatch other = (TokenInTrapStateMatch) obj;
    if (fEt == null) {if (other.fEt != null) return false;}
    else if (!fEt.equals(other.fEt)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TokenInTrapStateMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends TokenInTrapStateMatch {
    Mutable(final EventToken pEt) {
      super(pEt);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends TokenInTrapStateMatch {
    Immutable(final EventToken pEt) {
      super(pEt);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
