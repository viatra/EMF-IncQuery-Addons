package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.AtomicPatternTypeMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate AtomicPatternTypeMatcher in a type-safe way.
 * 
 * @see AtomicPatternTypeMatcher
 * @see AtomicPatternTypeMatch
 * 
 */
public final class AtomicPatternTypeQuerySpecification extends BaseGeneratedQuerySpecification<AtomicPatternTypeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AtomicPatternTypeQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected AtomicPatternTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AtomicPatternTypeMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.atomicPatternType";
    
  }
  
  private AtomicPatternTypeQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<AtomicPatternTypeQuerySpecification> {
    @Override
    public AtomicPatternTypeQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static AtomicPatternTypeQuerySpecification INSTANCE = make();
    
    public static AtomicPatternTypeQuerySpecification make() {
      try {
      	return new AtomicPatternTypeQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
