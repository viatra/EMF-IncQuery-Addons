package hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledtransition.EnabledTransitionMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate EnabledTransitionMatcher in a type-safe way.
 * 
 * @see EnabledTransitionMatcher
 * @see EnabledTransitionMatch
 * 
 */
public final class EnabledTransitionMatcherFactory extends BaseGeneratedMatcherFactory<EnabledTransitionMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EnabledTransitionMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EnabledTransitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new EnabledTransitionMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledTransition";
    
  }
  
  private EnabledTransitionMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<EnabledTransitionMatcherFactory> {
    @Override
    public EnabledTransitionMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EnabledTransitionMatcherFactory INSTANCE = make();
    
    public static EnabledTransitionMatcherFactory make() {
      try {
      	return new EnabledTransitionMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
