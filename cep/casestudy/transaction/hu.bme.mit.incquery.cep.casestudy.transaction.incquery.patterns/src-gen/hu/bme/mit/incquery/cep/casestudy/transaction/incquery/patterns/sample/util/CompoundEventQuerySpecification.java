package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.CompoundEventMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate CompoundEventMatcher in a type-safe way.
 * 
 * @see CompoundEventMatcher
 * @see CompoundEventMatch
 * 
 */
@SuppressWarnings("all")
public final class CompoundEventQuerySpecification extends BaseGeneratedQuerySpecification<CompoundEventMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static CompoundEventQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected CompoundEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return CompoundEventMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.compoundEvent";
    
  }
  
  private CompoundEventQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<CompoundEventQuerySpecification> {
    @Override
    public CompoundEventQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static CompoundEventQuerySpecification INSTANCE = make();
    
    public static CompoundEventQuerySpecification make() {
      try {
      	return new CompoundEventQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
