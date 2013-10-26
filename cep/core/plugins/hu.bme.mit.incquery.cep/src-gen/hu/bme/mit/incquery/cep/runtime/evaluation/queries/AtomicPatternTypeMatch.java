package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.atomicPatternType pattern, 
 * to be used in conjunction with {@link AtomicPatternTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AtomicPatternTypeMatcher
 * @see AtomicPatternTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AtomicPatternTypeMatch extends BasePatternMatch {
  private AtomicEventPattern fA;
  
  private String fT;
  
  private static List<String> parameterNames = makeImmutableList("a", "t");
  
  private AtomicPatternTypeMatch(final AtomicEventPattern pA, final String pT) {
    this.fA = pA;
    this.fT = pT;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("a".equals(parameterName)) return this.fA;
    if ("t".equals(parameterName)) return this.fT;
    return null;
    
  }
  
  public AtomicEventPattern getA() {
    return this.fA;
    
  }
  
  public String getT() {
    return this.fT;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("a".equals(parameterName) ) {
    	this.fA = (hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern) newValue;
    	return true;
    }
    if ("t".equals(parameterName) ) {
    	this.fT = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setA(final AtomicEventPattern pA) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fA = pA;
    
  }
  
  public void setT(final String pT) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT = pT;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.atomicPatternType";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return AtomicPatternTypeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fA, fT};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"a\"=" + prettyPrintValue(fA) + ", ");
    result.append("\"t\"=" + prettyPrintValue(fT));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fA == null) ? 0 : fA.hashCode()); 
    result = prime * result + ((fT == null) ? 0 : fT.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AtomicPatternTypeMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AtomicPatternTypeMatch other = (AtomicPatternTypeMatch) obj;
    if (fA == null) {if (other.fA != null) return false;}
    else if (!fA.equals(other.fA)) return false;
    if (fT == null) {if (other.fT != null) return false;}
    else if (!fT.equals(other.fT)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return AtomicPatternTypeMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends AtomicPatternTypeMatch {
    Mutable(final AtomicEventPattern pA, final String pT) {
      super(pA, pT);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends AtomicPatternTypeMatch {
    Immutable(final AtomicEventPattern pA, final String pT) {
      super(pA, pT);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
