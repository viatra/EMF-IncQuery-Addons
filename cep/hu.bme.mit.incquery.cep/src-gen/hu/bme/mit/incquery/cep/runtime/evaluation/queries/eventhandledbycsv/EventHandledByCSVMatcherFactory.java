package hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventhandledbycsv;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventhandledbycsv.EventHandledByCSVMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate EventHandledByCSVMatcher in a type-safe way.
 * 
 * @see EventHandledByCSVMatcher
 * @see EventHandledByCSVMatch
 * 
 */
public final class EventHandledByCSVMatcherFactory extends BaseGeneratedMatcherFactory<EventHandledByCSVMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventHandledByCSVMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EventHandledByCSVMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new EventHandledByCSVMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByCSV";
    
  }
  
  private EventHandledByCSVMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<EventHandledByCSVMatcherFactory> {
    @Override
    public EventHandledByCSVMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EventHandledByCSVMatcherFactory INSTANCE = make();
    
    public static EventHandledByCSVMatcherFactory make() {
      try {
      	return new EventHandledByCSVMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
