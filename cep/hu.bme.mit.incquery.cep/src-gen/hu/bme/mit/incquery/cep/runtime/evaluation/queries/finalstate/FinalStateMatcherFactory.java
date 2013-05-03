package hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalstate;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalstate.FinalStateMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate FinalStateMatcher in a type-safe way.
 * 
 * @see FinalStateMatcher
 * @see FinalStateMatch
 * 
 */
public final class FinalStateMatcherFactory extends BaseGeneratedMatcherFactory<FinalStateMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FinalStateMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FinalStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new FinalStateMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalState";
    
  }
  
  private FinalStateMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<FinalStateMatcherFactory> {
    @Override
    public FinalStateMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static FinalStateMatcherFactory INSTANCE = make();
    
    public static FinalStateMatcherFactory make() {
      try {
      	return new FinalStateMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
