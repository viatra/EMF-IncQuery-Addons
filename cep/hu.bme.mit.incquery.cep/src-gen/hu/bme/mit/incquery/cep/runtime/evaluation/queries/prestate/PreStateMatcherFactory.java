package hu.bme.mit.incquery.cep.runtime.evaluation.queries.prestate;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.prestate.PreStateMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate PreStateMatcher in a type-safe way.
 * 
 * @see PreStateMatcher
 * @see PreStateMatch
 * 
 */
public final class PreStateMatcherFactory extends BaseGeneratedMatcherFactory<PreStateMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PreStateMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PreStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new PreStateMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.preState";
    
  }
  
  private PreStateMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<PreStateMatcherFactory> {
    @Override
    public PreStateMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static PreStateMatcherFactory INSTANCE = make();
    
    public static PreStateMatcherFactory make() {
      try {
      	return new PreStateMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
