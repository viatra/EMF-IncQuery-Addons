package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithSTOPTimeconstraintMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate StateWithSTOPTimeconstraintMatcher in a type-safe way.
 * 
 * @see StateWithSTOPTimeconstraintMatcher
 * @see StateWithSTOPTimeconstraintMatch
 * 
 */
@SuppressWarnings("all")
public final class StateWithSTOPTimeconstraintQuerySpecification extends BaseGeneratedQuerySpecification<StateWithSTOPTimeconstraintMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateWithSTOPTimeconstraintQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected StateWithSTOPTimeconstraintMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateWithSTOPTimeconstraintMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.stateWithSTOPTimeconstraint";
    
  }
  
  private StateWithSTOPTimeconstraintQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<StateWithSTOPTimeconstraintQuerySpecification> {
    @Override
    public StateWithSTOPTimeconstraintQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static StateWithSTOPTimeconstraintQuerySpecification INSTANCE = make();
    
    public static StateWithSTOPTimeconstraintQuerySpecification make() {
      try {
      	return new StateWithSTOPTimeconstraintQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
