package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentBMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate LatestEventComponentBMatcher in a type-safe way.
 * 
 * @see LatestEventComponentBMatcher
 * @see LatestEventComponentBMatch
 * 
 */
@SuppressWarnings("all")
public final class LatestEventComponentBQuerySpecification extends BaseGeneratedQuerySpecification<LatestEventComponentBMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LatestEventComponentBQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected LatestEventComponentBMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LatestEventComponentBMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.latestEventComponentB";
    
  }
  
  private LatestEventComponentBQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<LatestEventComponentBQuerySpecification> {
    @Override
    public LatestEventComponentBQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static LatestEventComponentBQuerySpecification INSTANCE = make();
    
    public static LatestEventComponentBQuerySpecification make() {
      try {
      	return new LatestEventComponentBQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
