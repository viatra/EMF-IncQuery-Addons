package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate FinishedStateMachineMatcher in a type-safe way.
 * 
 * @see FinishedStateMachineMatcher
 * @see FinishedStateMachineMatch
 * 
 */
@SuppressWarnings("all")
public final class FinishedStateMachineQuerySpecification extends BaseGeneratedQuerySpecification<FinishedStateMachineMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FinishedStateMachineQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FinishedStateMachineMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FinishedStateMachineMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedStateMachine";
    
  }
  
  private FinishedStateMachineQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<FinishedStateMachineQuerySpecification> {
    @Override
    public FinishedStateMachineQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static FinishedStateMachineQuerySpecification INSTANCE = make();
    
    public static FinishedStateMachineQuerySpecification make() {
      try {
      	return new FinishedStateMachineQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
