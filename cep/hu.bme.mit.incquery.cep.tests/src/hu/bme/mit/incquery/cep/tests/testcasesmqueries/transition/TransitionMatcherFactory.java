package hu.bme.mit.incquery.cep.tests.testcasesmqueries.transition;

import hu.bme.mit.incquery.cep.tests.testcasesmqueries.transition.TransitionMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TransitionMatcher in a type-safe way.
 * 
 * @see TransitionMatcher
 * @see TransitionMatch
 * 
 */
public final class TransitionMatcherFactory extends BaseGeneratedMatcherFactory<TransitionMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TransitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TransitionMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.test.querygeneration2";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.tests.testcasesmqueries.transition";
    
  }
  
  private TransitionMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TransitionMatcherFactory> {
    @Override
    public TransitionMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TransitionMatcherFactory INSTANCE = make();
    
    public static TransitionMatcherFactory make() {
      try {
      	return new TransitionMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
