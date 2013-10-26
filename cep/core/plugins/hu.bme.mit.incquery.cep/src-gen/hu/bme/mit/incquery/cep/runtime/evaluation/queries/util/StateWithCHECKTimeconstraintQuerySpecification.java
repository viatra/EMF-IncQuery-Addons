package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithCHECKTimeconstraintMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate StateWithCHECKTimeconstraintMatcher in a type-safe way.
 * 
 * @see StateWithCHECKTimeconstraintMatcher
 * @see StateWithCHECKTimeconstraintMatch
 * 
 */
@SuppressWarnings("all")
public final class StateWithCHECKTimeconstraintQuerySpecification extends BaseGeneratedQuerySpecification<StateWithCHECKTimeconstraintMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateWithCHECKTimeconstraintQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected StateWithCHECKTimeconstraintMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateWithCHECKTimeconstraintMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.stateWithCHECKTimeconstraint";
    
  }
  
  private StateWithCHECKTimeconstraintQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<StateWithCHECKTimeconstraintQuerySpecification> {
    @Override
    public StateWithCHECKTimeconstraintQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static StateWithCHECKTimeconstraintQuerySpecification INSTANCE = make();
    
    public static StateWithCHECKTimeconstraintQuerySpecification make() {
      try {
      	return new StateWithCHECKTimeconstraintQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
