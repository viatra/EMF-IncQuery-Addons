package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.initState pattern, 
 * to be used in conjunction with {@link InitStateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InitStateMatcher
 * @see InitStateProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InitStateMatch extends BasePatternMatch {
  private InitState fS;
  
  private static List<String> parameterNames = makeImmutableList("s");
  
  private InitStateMatch(final InitState pS) {
    this.fS = pS;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("s".equals(parameterName)) return this.fS;
    return null;
    
  }
  
  public InitState getS() {
    return this.fS;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("s".equals(parameterName) ) {
    	this.fS = (hu.bme.mit.incquery.cep.metamodels.internalsm.InitState) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setS(final InitState pS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fS = pS;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.initState";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return InitStateMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fS};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"s\"=" + prettyPrintValue(fS));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fS == null) ? 0 : fS.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InitStateMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    InitStateMatch other = (InitStateMatch) obj;
    if (fS == null) {if (other.fS != null) return false;}
    else if (!fS.equals(other.fS)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return InitStateMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends InitStateMatch {
    Mutable(final InitState pS) {
      super(pS);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends InitStateMatch {
    Immutable(final InitState pS) {
      super(pS);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
