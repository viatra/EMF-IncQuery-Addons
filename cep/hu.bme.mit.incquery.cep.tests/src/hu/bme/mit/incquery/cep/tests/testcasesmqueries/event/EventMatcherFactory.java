package hu.bme.mit.incquery.cep.tests.testcasesmqueries.event;

import hu.bme.mit.incquery.cep.tests.testcasesmqueries.event.EventMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate EventMatcher in a type-safe way.
 * 
 * @see EventMatcher
 * @see EventMatch
 * 
 */
public final class EventMatcherFactory extends BaseGeneratedMatcherFactory<EventMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new EventMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.test.querygeneration2";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.tests.testcasesmqueries.event";
    
  }
  
  private EventMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<EventMatcherFactory> {
    @Override
    public EventMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EventMatcherFactory INSTANCE = make();
    
    public static EventMatcherFactory make() {
      try {
      	return new EventMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
