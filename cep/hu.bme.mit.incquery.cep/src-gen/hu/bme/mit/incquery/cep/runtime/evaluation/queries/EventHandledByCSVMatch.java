package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByCSV pattern, 
 * to be used in conjunction with {@link EventHandledByCSVMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EventHandledByCSVMatcher
 * @see EventHandledByCSVProcessor
 * 
 */
public abstract class EventHandledByCSVMatch extends BasePatternMatch {
  private EventCollection fE;
  
  private CurrentStateVisitor fCsv;
  
  private static List<String> parameterNames = makeImmutableList("e", "csv");
  
  private EventHandledByCSVMatch(final EventCollection pE, final CurrentStateVisitor pCsv) {
    this.fE = pE;
    this.fCsv = pCsv;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("e".equals(parameterName)) return this.fE;
    if ("csv".equals(parameterName)) return this.fCsv;
    return null;
    
  }
  
  public EventCollection getE() {
    return this.fE;
    
  }
  
  public CurrentStateVisitor getCsv() {
    return this.fCsv;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("e".equals(parameterName) ) {
    	this.fE = (hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection) newValue;
    	return true;
    }
    if ("csv".equals(parameterName) ) {
    	this.fCsv = (hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setE(final EventCollection pE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fE = pE;
    
  }
  
  public void setCsv(final CurrentStateVisitor pCsv) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCsv = pCsv;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByCSV";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EventHandledByCSVMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fE, fCsv};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"e\"=" + prettyPrintValue(fE) + ", ");
    result.append("\"csv\"=" + prettyPrintValue(fCsv));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fE == null) ? 0 : fE.hashCode()); 
    result = prime * result + ((fCsv == null) ? 0 : fCsv.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EventHandledByCSVMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EventHandledByCSVMatch other = (EventHandledByCSVMatch) obj;
    if (fE == null) {if (other.fE != null) return false;}
    else if (!fE.equals(other.fE)) return false;
    if (fCsv == null) {if (other.fCsv != null) return false;}
    else if (!fCsv.equals(other.fCsv)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EventHandledByCSVMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends EventHandledByCSVMatch {
    Mutable(final EventCollection pE, final CurrentStateVisitor pCsv) {
      super(pE, pCsv);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends EventHandledByCSVMatch {
    Immutable(final EventCollection pE, final CurrentStateVisitor pCsv) {
      super(pE, pCsv);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
