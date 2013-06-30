package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.partiallyMatchedEventPattern pattern, 
 * to be used in conjunction with {@link PartiallyMatchedEventPatternMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PartiallyMatchedEventPatternMatcher
 * @see PartiallyMatchedEventPatternProcessor
 * 
 */
public abstract class PartiallyMatchedEventPatternMatch extends BasePatternMatch {
  private EventToken fEt;
  
  private State fS;
  
  private static List<String> parameterNames = makeImmutableList("et", "s");
  
  private PartiallyMatchedEventPatternMatch(final EventToken pEt, final State pS) {
    this.fEt = pEt;
    this.fS = pS;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("et".equals(parameterName)) return this.fEt;
    if ("s".equals(parameterName)) return this.fS;
    return null;
    
  }
  
  public EventToken getEt() {
    return this.fEt;
    
  }
  
  public State getS() {
    return this.fS;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("et".equals(parameterName) ) {
    	this.fEt = (hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken) newValue;
    	return true;
    }
    if ("s".equals(parameterName) ) {
    	this.fS = (hu.bme.mit.incquery.cep.metamodels.internalsm.State) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setEt(final EventToken pEt) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEt = pEt;
    
  }
  
  public void setS(final State pS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fS = pS;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.partiallyMatchedEventPattern";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PartiallyMatchedEventPatternMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEt, fS};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"et\"=" + prettyPrintValue(fEt) + ", ");
    result.append("\"s\"=" + prettyPrintValue(fS));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEt == null) ? 0 : fEt.hashCode()); 
    result = prime * result + ((fS == null) ? 0 : fS.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PartiallyMatchedEventPatternMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PartiallyMatchedEventPatternMatch other = (PartiallyMatchedEventPatternMatch) obj;
    if (fEt == null) {if (other.fEt != null) return false;}
    else if (!fEt.equals(other.fEt)) return false;
    if (fS == null) {if (other.fS != null) return false;}
    else if (!fS.equals(other.fS)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return PartiallyMatchedEventPatternMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends PartiallyMatchedEventPatternMatch {
    Mutable(final EventToken pEt, final State pS) {
      super(pEt, pS);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends PartiallyMatchedEventPatternMatch {
    Immutable(final EventToken pEt, final State pS) {
      super(pEt, pS);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
