package hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate FinishedStateMachineMatcher in a type-safe way.
 * 
 * @see FinishedStateMachineMatcher
 * @see FinishedStateMachineMatch
 * 
 */
public final class FinishedStateMachineMatcherFactory extends BaseGeneratedMatcherFactory<FinishedStateMachineMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FinishedStateMachineMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FinishedStateMachineMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new FinishedStateMachineMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedStateMachine";
    
  }
  
  private FinishedStateMachineMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<FinishedStateMachineMatcherFactory> {
    @Override
    public FinishedStateMachineMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static FinishedStateMachineMatcherFactory INSTANCE = make();
    
    public static FinishedStateMachineMatcherFactory make() {
      try {
      	return new FinishedStateMachineMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
