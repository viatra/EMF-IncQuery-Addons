package hu.bme.mit.incquery.cep.performance.md.patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.performance.md.patterns.componentC pattern, 
 * to be used in conjunction with {@link ComponentCMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ComponentCMatcher
 * @see ComponentCProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentCMatch extends BasePatternMatch {
  private Object fTe;
  
  private static List<String> parameterNames = makeImmutableList("te");
  
  private ComponentCMatch(final Object pTe) {
    this.fTe = pTe;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("te".equals(parameterName)) return this.fTe;
    return null;
    
  }
  
  public Object getTe() {
    return this.fTe;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("te".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTe = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTe(final Object pTe) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTe = pTe;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.performance.md.patterns.componentC";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ComponentCMatch.parameterNames;
    
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
    if (!(obj instanceof ComponentCMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ComponentCMatch other = (ComponentCMatch) obj;
    if (fTe == null) {if (other.fTe != null) return false;}
    else if (!fTe.equals(other.fTe)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return ComponentCMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends ComponentCMatch {
    Mutable(final Object pTe) {
      super(pTe);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends ComponentCMatch {
    Immutable(final Object pTe) {
      super(pTe);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
