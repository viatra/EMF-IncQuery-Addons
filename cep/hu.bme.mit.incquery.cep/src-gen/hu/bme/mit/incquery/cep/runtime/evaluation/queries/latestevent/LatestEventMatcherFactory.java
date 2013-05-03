package hu.bme.mit.incquery.cep.runtime.evaluation.queries.latestevent;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.latestevent.LatestEventMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate LatestEventMatcher in a type-safe way.
 * 
 * @see LatestEventMatcher
 * @see LatestEventMatch
 * 
 */
public final class LatestEventMatcherFactory extends BaseGeneratedMatcherFactory<LatestEventMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LatestEventMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected LatestEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new LatestEventMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.latestEvent";
    
  }
  
  private LatestEventMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<LatestEventMatcherFactory> {
    @Override
    public LatestEventMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static LatestEventMatcherFactory INSTANCE = make();
    
    public static LatestEventMatcherFactory make() {
      try {
      	return new LatestEventMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
