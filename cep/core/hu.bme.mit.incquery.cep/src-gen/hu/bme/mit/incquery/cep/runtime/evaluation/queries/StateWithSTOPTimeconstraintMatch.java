package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.stateWithSTOPTimeconstraint pattern, 
 * to be used in conjunction with {@link StateWithSTOPTimeconstraintMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StateWithSTOPTimeconstraintMatcher
 * @see StateWithSTOPTimeconstraintProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StateWithSTOPTimeconstraintMatch extends BasePatternMatch {
  private State fS;
  
  private TimeConstraint fTc;
  
  private static List<String> parameterNames = makeImmutableList("s", "tc");
  
  private StateWithSTOPTimeconstraintMatch(final State pS, final TimeConstraint pTc) {
    this.fS = pS;
    this.fTc = pTc;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("s".equals(parameterName)) return this.fS;
    if ("tc".equals(parameterName)) return this.fTc;
    return null;
    
  }
  
  public State getS() {
    return this.fS;
    
  }
  
  public TimeConstraint getTc() {
    return this.fTc;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("s".equals(parameterName) ) {
    	this.fS = (hu.bme.mit.incquery.cep.metamodels.internalsm.State) newValue;
    	return true;
    }
    if ("tc".equals(parameterName) ) {
    	this.fTc = (hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setS(final State pS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fS = pS;
    
  }
  
  public void setTc(final TimeConstraint pTc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTc = pTc;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.stateWithSTOPTimeconstraint";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return StateWithSTOPTimeconstraintMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fS, fTc};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"s\"=" + prettyPrintValue(fS) + ", ");
    result.append("\"tc\"=" + prettyPrintValue(fTc));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fS == null) ? 0 : fS.hashCode()); 
    result = prime * result + ((fTc == null) ? 0 : fTc.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StateWithSTOPTimeconstraintMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    StateWithSTOPTimeconstraintMatch other = (StateWithSTOPTimeconstraintMatch) obj;
    if (fS == null) {if (other.fS != null) return false;}
    else if (!fS.equals(other.fS)) return false;
    if (fTc == null) {if (other.fTc != null) return false;}
    else if (!fTc.equals(other.fTc)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return StateWithSTOPTimeconstraintMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends StateWithSTOPTimeconstraintMatch {
    Mutable(final State pS, final TimeConstraint pTc) {
      super(pS, pTc);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends StateWithSTOPTimeconstraintMatch {
    Immutable(final State pS, final TimeConstraint pTc) {
      super(pS, pTc);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
