package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.oldCompoundTransaction pattern, 
 * to be used in conjunction with {@link OldCompoundTransactionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OldCompoundTransactionMatcher
 * @see OldCompoundTransactionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class OldCompoundTransactionMatch extends BasePatternMatch {
  private hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent fCte;
  
  private Long fTs;
  
  private static List<String> parameterNames = makeImmutableList("cte", "ts");
  
  private OldCompoundTransactionMatch(final hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent pCte, final Long pTs) {
    this.fCte = pCte;
    this.fTs = pTs;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cte".equals(parameterName)) return this.fCte;
    if ("ts".equals(parameterName)) return this.fTs;
    return null;
    
  }
  
  public hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent getCte() {
    return this.fCte;
    
  }
  
  public Long getTs() {
    return this.fTs;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cte".equals(parameterName) ) {
    	this.fCte = (hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent) newValue;
    	return true;
    }
    if ("ts".equals(parameterName) ) {
    	this.fTs = (java.lang.Long) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setCte(final hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent pCte) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCte = pCte;
    
  }
  
  public void setTs(final Long pTs) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTs = pTs;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.oldCompoundTransaction";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return OldCompoundTransactionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCte, fTs};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cte\"=" + prettyPrintValue(fCte) + ", ");
    result.append("\"ts\"=" + prettyPrintValue(fTs));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCte == null) ? 0 : fCte.hashCode()); 
    result = prime * result + ((fTs == null) ? 0 : fTs.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OldCompoundTransactionMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    OldCompoundTransactionMatch other = (OldCompoundTransactionMatch) obj;
    if (fCte == null) {if (other.fCte != null) return false;}
    else if (!fCte.equals(other.fCte)) return false;
    if (fTs == null) {if (other.fTs != null) return false;}
    else if (!fTs.equals(other.fTs)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return OldCompoundTransactionMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends OldCompoundTransactionMatch {
    Mutable(final hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent pCte, final Long pTs) {
      super(pCte, pTs);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends OldCompoundTransactionMatch {
    Immutable(final hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent pCte, final Long pTs) {
      super(pCte, pTs);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
