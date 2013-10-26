package hu.bme.mit.incquery.cep.runtime.evaluation.queries;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledTransition pattern, 
 * to be used in conjunction with {@link EnabledTransitionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EnabledTransitionMatcher
 * @see EnabledTransitionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EnabledTransitionMatch extends BasePatternMatch {
  private Transition fT;
  
  private EventToken fEt;
  
  private Event fE;
  
  private static List<String> parameterNames = makeImmutableList("t", "et", "e");
  
  private EnabledTransitionMatch(final Transition pT, final EventToken pEt, final Event pE) {
    this.fT = pT;
    this.fEt = pEt;
    this.fE = pE;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("t".equals(parameterName)) return this.fT;
    if ("et".equals(parameterName)) return this.fEt;
    if ("e".equals(parameterName)) return this.fE;
    return null;
    
  }
  
  public Transition getT() {
    return this.fT;
    
  }
  
  public EventToken getEt() {
    return this.fEt;
    
  }
  
  public Event getE() {
    return this.fE;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("t".equals(parameterName) ) {
    	this.fT = (hu.bme.mit.incquery.cep.metamodels.internalsm.Transition) newValue;
    	return true;
    }
    if ("et".equals(parameterName) ) {
    	this.fEt = (hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken) newValue;
    	return true;
    }
    if ("e".equals(parameterName) ) {
    	this.fE = (hu.bme.mit.incquery.cep.metamodels.cep.Event) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setT(final Transition pT) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT = pT;
    
  }
  
  public void setEt(final EventToken pEt) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEt = pEt;
    
  }
  
  public void setE(final Event pE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fE = pE;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledTransition";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EnabledTransitionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fT, fEt, fE};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"t\"=" + prettyPrintValue(fT) + ", ");
    result.append("\"et\"=" + prettyPrintValue(fEt) + ", ");
    result.append("\"e\"=" + prettyPrintValue(fE));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fT == null) ? 0 : fT.hashCode()); 
    result = prime * result + ((fEt == null) ? 0 : fEt.hashCode()); 
    result = prime * result + ((fE == null) ? 0 : fE.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EnabledTransitionMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EnabledTransitionMatch other = (EnabledTransitionMatch) obj;
    if (fT == null) {if (other.fT != null) return false;}
    else if (!fT.equals(other.fT)) return false;
    if (fEt == null) {if (other.fEt != null) return false;}
    else if (!fEt.equals(other.fEt)) return false;
    if (fE == null) {if (other.fE != null) return false;}
    else if (!fE.equals(other.fE)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EnabledTransitionMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends EnabledTransitionMatch {
    Mutable(final Transition pT, final EventToken pEt, final Event pE) {
      super(pT, pEt, pE);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends EnabledTransitionMatch {
    Immutable(final Transition pT, final EventToken pEt, final Event pE) {
      super(pT, pEt, pE);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
