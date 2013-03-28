package hu.bme.mit.incquery.cep.tests.testcasesmqueries.statemachine;

import hu.bme.mit.incquery.cep.tests.testcasesmqueries.statemachine.StateMachineMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate StateMachineMatcher in a type-safe way.
 * 
 * @see StateMachineMatcher
 * @see StateMachineMatch
 * 
 */
public final class StateMachineMatcherFactory extends BaseGeneratedMatcherFactory<StateMachineMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateMachineMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected StateMachineMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new StateMachineMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.test.querygeneration2";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.tests.testcasesmqueries.stateMachine";
    
  }
  
  private StateMachineMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<StateMachineMatcherFactory> {
    @Override
    public StateMachineMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static StateMachineMatcherFactory INSTANCE = make();
    
    public static StateMachineMatcherFactory make() {
      try {
      	return new StateMachineMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
