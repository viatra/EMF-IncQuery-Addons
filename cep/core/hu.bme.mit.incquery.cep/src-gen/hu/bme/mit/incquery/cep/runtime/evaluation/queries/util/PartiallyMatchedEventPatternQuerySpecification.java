package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PartiallyMatchedEventPatternMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate PartiallyMatchedEventPatternMatcher in a type-safe way.
 * 
 * @see PartiallyMatchedEventPatternMatcher
 * @see PartiallyMatchedEventPatternMatch
 * 
 */
public final class PartiallyMatchedEventPatternQuerySpecification extends BaseGeneratedQuerySpecification<PartiallyMatchedEventPatternMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PartiallyMatchedEventPatternQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PartiallyMatchedEventPatternMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PartiallyMatchedEventPatternMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.partiallyMatchedEventPattern";
    
  }
  
  private PartiallyMatchedEventPatternQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<PartiallyMatchedEventPatternQuerySpecification> {
    @Override
    public PartiallyMatchedEventPatternQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static PartiallyMatchedEventPatternQuerySpecification INSTANCE = make();
    
    public static PartiallyMatchedEventPatternQuerySpecification make() {
      try {
      	return new PartiallyMatchedEventPatternQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
