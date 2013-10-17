package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate EnabledTransitionMatcher in a type-safe way.
 * 
 * @see EnabledTransitionMatcher
 * @see EnabledTransitionMatch
 * 
 */
@SuppressWarnings("all")
public final class EnabledTransitionQuerySpecification extends BaseGeneratedQuerySpecification<EnabledTransitionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EnabledTransitionQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EnabledTransitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EnabledTransitionMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledTransition";
    
  }
  
  private EnabledTransitionQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<EnabledTransitionQuerySpecification> {
    @Override
    public EnabledTransitionQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static EnabledTransitionQuerySpecification INSTANCE = make();
    
    public static EnabledTransitionQuerySpecification make() {
      try {
      	return new EnabledTransitionQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
