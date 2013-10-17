package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.guardAtomicPattern pattern, 
 * to be used in conjunction with {@link GuardAtomicPatternMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GuardAtomicPatternMatcher
 * @see GuardAtomicPatternProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GuardAtomicPatternMatch extends BasePatternMatch {
  private Guard fGuard;
  
  private AtomicEventPattern fAtomicPattern;
  
  private static List<String> parameterNames = makeImmutableList("guard", "atomicPattern");
  
  private GuardAtomicPatternMatch(final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
    this.fGuard = pGuard;
    this.fAtomicPattern = pAtomicPattern;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("guard".equals(parameterName)) return this.fGuard;
    if ("atomicPattern".equals(parameterName)) return this.fAtomicPattern;
    return null;
    
  }
  
  public Guard getGuard() {
    return this.fGuard;
    
  }
  
  public AtomicEventPattern getAtomicPattern() {
    return this.fAtomicPattern;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("guard".equals(parameterName) ) {
    	this.fGuard = (hu.bme.mit.incquery.cep.metamodels.internalsm.Guard) newValue;
    	return true;
    }
    if ("atomicPattern".equals(parameterName) ) {
    	this.fAtomicPattern = (hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setGuard(final Guard pGuard) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGuard = pGuard;
    
  }
  
  public void setAtomicPattern(final AtomicEventPattern pAtomicPattern) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAtomicPattern = pAtomicPattern;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.guardAtomicPattern";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return GuardAtomicPatternMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fGuard, fAtomicPattern};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"guard\"=" + prettyPrintValue(fGuard) + ", ");
    result.append("\"atomicPattern\"=" + prettyPrintValue(fAtomicPattern));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fGuard == null) ? 0 : fGuard.hashCode()); 
    result = prime * result + ((fAtomicPattern == null) ? 0 : fAtomicPattern.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof GuardAtomicPatternMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    GuardAtomicPatternMatch other = (GuardAtomicPatternMatch) obj;
    if (fGuard == null) {if (other.fGuard != null) return false;}
    else if (!fGuard.equals(other.fGuard)) return false;
    if (fAtomicPattern == null) {if (other.fAtomicPattern != null) return false;}
    else if (!fAtomicPattern.equals(other.fAtomicPattern)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return GuardAtomicPatternMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends GuardAtomicPatternMatch {
    Mutable(final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
      super(pGuard, pAtomicPattern);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends GuardAtomicPatternMatch {
    Immutable(final Guard pGuard, final AtomicEventPattern pAtomicPattern) {
      super(pGuard, pAtomicPattern);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
