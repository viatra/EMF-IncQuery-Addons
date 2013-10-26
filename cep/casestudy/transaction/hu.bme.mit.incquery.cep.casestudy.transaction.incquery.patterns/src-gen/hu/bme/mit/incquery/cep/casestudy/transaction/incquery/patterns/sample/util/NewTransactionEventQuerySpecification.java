package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.NewTransactionEventMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate NewTransactionEventMatcher in a type-safe way.
 * 
 * @see NewTransactionEventMatcher
 * @see NewTransactionEventMatch
 * 
 */
@SuppressWarnings("all")
public final class NewTransactionEventQuerySpecification extends BaseGeneratedQuerySpecification<NewTransactionEventMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NewTransactionEventQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected NewTransactionEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NewTransactionEventMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.newTransactionEvent";
    
  }
  
  private NewTransactionEventQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<NewTransactionEventQuerySpecification> {
    @Override
    public NewTransactionEventQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static NewTransactionEventQuerySpecification INSTANCE = make();
    
    public static NewTransactionEventQuerySpecification make() {
      try {
      	return new NewTransactionEventQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
