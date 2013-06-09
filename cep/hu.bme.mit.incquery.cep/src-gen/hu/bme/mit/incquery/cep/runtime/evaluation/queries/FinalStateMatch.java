package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalState pattern, 
 * to be used in conjunction with {@link FinalStateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FinalStateMatcher
 * @see FinalStateProcessor
 * 
 */
public abstract class FinalStateMatch extends BasePatternMatch {
  private State fS;
  
  private CurrentStateVisitor fCv;
  
  private static List<String> parameterNames = makeImmutableList("s", "cv");
  
  private FinalStateMatch(final State pS, final CurrentStateVisitor pCv) {
    this.fS = pS;
    this.fCv = pCv;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("s".equals(parameterName)) return this.fS;
    if ("cv".equals(parameterName)) return this.fCv;
    return null;
    
  }
  
  public State getS() {
    return this.fS;
    
  }
  
  public CurrentStateVisitor getCv() {
    return this.fCv;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("s".equals(parameterName) ) {
    	this.fS = (hu.bme.mit.incquery.cep.metamodels.internalsm.State) newValue;
    	return true;
    }
    if ("cv".equals(parameterName) ) {
    	this.fCv = (hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setS(final State pS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fS = pS;
    
  }
  
  public void setCv(final CurrentStateVisitor pCv) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCv = pCv;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalState";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return FinalStateMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fS, fCv};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"s\"=" + prettyPrintValue(fS) + ", ");
    result.append("\"cv\"=" + prettyPrintValue(fCv));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fS == null) ? 0 : fS.hashCode()); 
    result = prime * result + ((fCv == null) ? 0 : fCv.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof FinalStateMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    FinalStateMatch other = (FinalStateMatch) obj;
    if (fS == null) {if (other.fS != null) return false;}
    else if (!fS.equals(other.fS)) return false;
    if (fCv == null) {if (other.fCv != null) return false;}
    else if (!fCv.equals(other.fCv)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return FinalStateMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends FinalStateMatch {
    Mutable(final State pS, final CurrentStateVisitor pCv) {
      super(pS, pCv);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends FinalStateMatch {
    Immutable(final State pS, final CurrentStateVisitor pCv) {
      super(pS, pCv);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
