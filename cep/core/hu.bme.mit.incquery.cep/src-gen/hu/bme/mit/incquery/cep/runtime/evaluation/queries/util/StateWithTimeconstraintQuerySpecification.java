package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithTimeconstraintMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate StateWithTimeconstraintMatcher in a type-safe way.
 * 
 * @see StateWithTimeconstraintMatcher
 * @see StateWithTimeconstraintMatch
 * 
 */
@SuppressWarnings("all")
public final class StateWithTimeconstraintQuerySpecification extends BaseGeneratedQuerySpecification<StateWithTimeconstraintMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateWithTimeconstraintQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected StateWithTimeconstraintMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateWithTimeconstraintMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.stateWithTimeconstraint";
    
  }
  
  private StateWithTimeconstraintQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<StateWithTimeconstraintQuerySpecification> {
    @Override
    public StateWithTimeconstraintQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static StateWithTimeconstraintQuerySpecification INSTANCE = make();
    
    public static StateWithTimeconstraintQuerySpecification make() {
      try {
      	return new StateWithTimeconstraintQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
