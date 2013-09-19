package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedStateMachine pattern, 
 * to be used in conjunction with {@link FinishedStateMachineMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FinishedStateMachineMatcher
 * @see FinishedStateMachineProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class FinishedStateMachineMatch extends BasePatternMatch {
  private StateMachine fSm;
  
  private EventToken fEt;
  
  private static List<String> parameterNames = makeImmutableList("sm", "et");
  
  private FinishedStateMachineMatch(final StateMachine pSm, final EventToken pEt) {
    this.fSm = pSm;
    this.fEt = pEt;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sm".equals(parameterName)) return this.fSm;
    if ("et".equals(parameterName)) return this.fEt;
    return null;
    
  }
  
  public StateMachine getSm() {
    return this.fSm;
    
  }
  
  public EventToken getEt() {
    return this.fEt;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sm".equals(parameterName) ) {
    	this.fSm = (hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine) newValue;
    	return true;
    }
    if ("et".equals(parameterName) ) {
    	this.fEt = (hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSm(final StateMachine pSm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSm = pSm;
    
  }
  
  public void setEt(final EventToken pEt) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEt = pEt;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedStateMachine";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return FinishedStateMachineMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSm, fEt};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sm\"=" + prettyPrintValue(fSm) + ", ");
    result.append("\"et\"=" + prettyPrintValue(fEt));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSm == null) ? 0 : fSm.hashCode()); 
    result = prime * result + ((fEt == null) ? 0 : fEt.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof FinishedStateMachineMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    FinishedStateMachineMatch other = (FinishedStateMachineMatch) obj;
    if (fSm == null) {if (other.fSm != null) return false;}
    else if (!fSm.equals(other.fSm)) return false;
    if (fEt == null) {if (other.fEt != null) return false;}
    else if (!fEt.equals(other.fEt)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return FinishedStateMachineMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends FinishedStateMachineMatch {
    Mutable(final StateMachine pSm, final EventToken pEt) {
      super(pSm, pEt);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends FinishedStateMachineMatch {
    Immutable(final StateMachine pSm, final EventToken pEt) {
      super(pSm, pEt);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
