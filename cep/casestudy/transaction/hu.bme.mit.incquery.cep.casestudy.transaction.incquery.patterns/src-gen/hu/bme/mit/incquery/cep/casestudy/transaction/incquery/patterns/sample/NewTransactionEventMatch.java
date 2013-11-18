package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.newTransactionEvent pattern, 
 * to be used in conjunction with {@link NewTransactionEventMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NewTransactionEventMatcher
 * @see NewTransactionEventProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NewTransactionEventMatch extends BasePatternMatch {
  private hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA fTe;
  
  private static List<String> parameterNames = makeImmutableList("te");
  
  private NewTransactionEventMatch(final hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA pTe) {
    this.fTe = pTe;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("te".equals(parameterName)) return this.fTe;
    return null;
    
  }
  
  public hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA getTe() {
    return this.fTe;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("te".equals(parameterName) ) {
    	this.fTe = (hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTe(final hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA pTe) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTe = pTe;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.newTransactionEvent";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return NewTransactionEventMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTe};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"te\"=" + prettyPrintValue(fTe));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTe == null) ? 0 : fTe.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NewTransactionEventMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    NewTransactionEventMatch other = (NewTransactionEventMatch) obj;
    if (fTe == null) {if (other.fTe != null) return false;}
    else if (!fTe.equals(other.fTe)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return NewTransactionEventMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends NewTransactionEventMatch {
    Mutable(final hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA pTe) {
      super(pTe);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends NewTransactionEventMatch {
    Immutable(final hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA pTe) {
      super(pTe);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
