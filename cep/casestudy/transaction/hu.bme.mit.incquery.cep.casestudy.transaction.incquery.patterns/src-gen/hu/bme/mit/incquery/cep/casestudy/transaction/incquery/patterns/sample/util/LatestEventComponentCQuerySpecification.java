package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentCMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate LatestEventComponentCMatcher in a type-safe way.
 * 
 * @see LatestEventComponentCMatcher
 * @see LatestEventComponentCMatch
 * 
 */
@SuppressWarnings("all")
public final class LatestEventComponentCQuerySpecification extends BaseGeneratedQuerySpecification<LatestEventComponentCMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LatestEventComponentCQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected LatestEventComponentCMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LatestEventComponentCMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.latestEventComponentC";
    
  }
  
  private LatestEventComponentCQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<LatestEventComponentCQuerySpecification> {
    @Override
    public LatestEventComponentCQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static LatestEventComponentCQuerySpecification INSTANCE = make();
    
    public static LatestEventComponentCQuerySpecification make() {
      try {
      	return new LatestEventComponentCQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
