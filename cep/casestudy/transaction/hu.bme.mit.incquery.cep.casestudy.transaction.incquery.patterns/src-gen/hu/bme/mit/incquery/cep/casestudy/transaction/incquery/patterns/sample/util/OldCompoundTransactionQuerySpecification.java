package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.OldCompoundTransactionMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate OldCompoundTransactionMatcher in a type-safe way.
 * 
 * @see OldCompoundTransactionMatcher
 * @see OldCompoundTransactionMatch
 * 
 */
@SuppressWarnings("all")
public final class OldCompoundTransactionQuerySpecification extends BaseGeneratedQuerySpecification<OldCompoundTransactionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OldCompoundTransactionQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected OldCompoundTransactionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OldCompoundTransactionMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.oldCompoundTransaction";
    
  }
  
  private OldCompoundTransactionQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<OldCompoundTransactionQuerySpecification> {
    @Override
    public OldCompoundTransactionQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static OldCompoundTransactionQuerySpecification INSTANCE = make();
    
    public static OldCompoundTransactionQuerySpecification make() {
      try {
      	return new OldCompoundTransactionQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
