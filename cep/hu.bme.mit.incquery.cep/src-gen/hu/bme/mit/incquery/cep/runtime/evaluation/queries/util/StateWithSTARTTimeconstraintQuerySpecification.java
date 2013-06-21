package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithSTARTTimeconstraintMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate StateWithSTARTTimeconstraintMatcher in a type-safe way.
 * 
 * @see StateWithSTARTTimeconstraintMatcher
 * @see StateWithSTARTTimeconstraintMatch
 * 
 */
public final class StateWithSTARTTimeconstraintQuerySpecification extends BaseGeneratedQuerySpecification<StateWithSTARTTimeconstraintMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateWithSTARTTimeconstraintQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected StateWithSTARTTimeconstraintMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateWithSTARTTimeconstraintMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.stateWithSTARTTimeconstraint";
    
  }
  
  private StateWithSTARTTimeconstraintQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<StateWithSTARTTimeconstraintQuerySpecification> {
    @Override
    public StateWithSTARTTimeconstraintQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static StateWithSTARTTimeconstraintQuerySpecification INSTANCE = make();
    
    public static StateWithSTARTTimeconstraintQuerySpecification make() {
      try {
      	return new StateWithSTARTTimeconstraintQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
