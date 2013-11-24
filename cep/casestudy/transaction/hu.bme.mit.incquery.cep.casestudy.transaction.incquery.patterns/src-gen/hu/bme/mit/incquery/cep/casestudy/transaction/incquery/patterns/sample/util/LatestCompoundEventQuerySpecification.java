package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestCompoundEventMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate LatestCompoundEventMatcher in a type-safe way.
 * 
 * @see LatestCompoundEventMatcher
 * @see LatestCompoundEventMatch
 * 
 */
@SuppressWarnings("all")
public final class LatestCompoundEventQuerySpecification extends BaseGeneratedQuerySpecification<LatestCompoundEventMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LatestCompoundEventQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected LatestCompoundEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LatestCompoundEventMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.latestCompoundEvent";
    
  }
  
  private LatestCompoundEventQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<LatestCompoundEventQuerySpecification> {
    @Override
    public LatestCompoundEventQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static LatestCompoundEventQuerySpecification INSTANCE = make();
    
    public static LatestCompoundEventQuerySpecification make() {
      try {
      	return new LatestCompoundEventQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
