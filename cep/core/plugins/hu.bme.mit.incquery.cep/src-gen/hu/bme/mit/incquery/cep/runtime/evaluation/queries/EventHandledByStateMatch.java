package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByState pattern, 
 * to be used in conjunction with {@link EventHandledByStateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EventHandledByStateMatcher
 * @see EventHandledByStateProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EventHandledByStateMatch extends BasePatternMatch {
  private State fS;
  
  private Event fE;
  
  private static List<String> parameterNames = makeImmutableList("s", "e");
  
  private EventHandledByStateMatch(final State pS, final Event pE) {
    this.fS = pS;
    this.fE = pE;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("s".equals(parameterName)) return this.fS;
    if ("e".equals(parameterName)) return this.fE;
    return null;
    
  }
  
  public State getS() {
    return this.fS;
    
  }
  
  public Event getE() {
    return this.fE;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("s".equals(parameterName) ) {
    	this.fS = (hu.bme.mit.incquery.cep.metamodels.internalsm.State) newValue;
    	return true;
    }
    if ("e".equals(parameterName) ) {
    	this.fE = (hu.bme.mit.incquery.cep.metamodels.cep.Event) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setS(final State pS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fS = pS;
    
  }
  
  public void setE(final Event pE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fE = pE;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByState";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EventHandledByStateMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fS, fE};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"s\"=" + prettyPrintValue(fS) + ", ");
    result.append("\"e\"=" + prettyPrintValue(fE));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fS == null) ? 0 : fS.hashCode()); 
    result = prime * result + ((fE == null) ? 0 : fE.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EventHandledByStateMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EventHandledByStateMatch other = (EventHandledByStateMatch) obj;
    if (fS == null) {if (other.fS != null) return false;}
    else if (!fS.equals(other.fS)) return false;
    if (fE == null) {if (other.fE != null) return false;}
    else if (!fE.equals(other.fE)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EventHandledByStateMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends EventHandledByStateMatch {
    Mutable(final State pS, final Event pE) {
      super(pS, pE);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends EventHandledByStateMatch {
    Immutable(final State pS, final Event pE) {
      super(pS, pE);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
