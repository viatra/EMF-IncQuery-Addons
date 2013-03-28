package hu.bme.mit.incquery.cep.tests.testcasesmqueries.statemachine;

import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.tests.testcasesmqueries.stateMachine pattern, 
 * to be used in conjunction with {@link StateMachineMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StateMachineMatcher
 * @see StateMachineProcessor
 * 
 */
public abstract class StateMachineMatch extends BasePatternMatch {
  private StateMachine fSm;
  
  private static String[] parameterNames = {"sm"};
  
  private StateMachineMatch(final StateMachine pSm) {
    this.fSm = pSm;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sm".equals(parameterName)) return this.fSm;
    return null;
    
  }
  
  public StateMachine getSm() {
    return this.fSm;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sm".equals(parameterName) ) {
    	this.fSm = (hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSm(final StateMachine pSm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSm = pSm;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.tests.testcasesmqueries.stateMachine";
    
  }
  
  @Override
  public String[] parameterNames() {
    return StateMachineMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSm};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sm\"=" + prettyPrintValue(fSm));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSm == null) ? 0 : fSm.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StateMachineMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    StateMachineMatch other = (StateMachineMatch) obj;
    if (fSm == null) {if (other.fSm != null) return false;}
    else if (!fSm.equals(other.fSm)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return StateMachineMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends StateMachineMatch {
    Mutable(final StateMachine pSm) {
      super(pSm);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends StateMachineMatch {
    Immutable(final StateMachine pSm) {
      super(pSm);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
