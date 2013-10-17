package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.GuardAtomicPatternMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate GuardAtomicPatternMatcher in a type-safe way.
 * 
 * @see GuardAtomicPatternMatcher
 * @see GuardAtomicPatternMatch
 * 
 */
@SuppressWarnings("all")
public final class GuardAtomicPatternQuerySpecification extends BaseGeneratedQuerySpecification<GuardAtomicPatternMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static GuardAtomicPatternQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected GuardAtomicPatternMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return GuardAtomicPatternMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.guardAtomicPattern";
    
  }
  
  private GuardAtomicPatternQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<GuardAtomicPatternQuerySpecification> {
    @Override
    public GuardAtomicPatternQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static GuardAtomicPatternQuerySpecification INSTANCE = make();
    
    public static GuardAtomicPatternQuerySpecification make() {
      try {
      	return new GuardAtomicPatternQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
