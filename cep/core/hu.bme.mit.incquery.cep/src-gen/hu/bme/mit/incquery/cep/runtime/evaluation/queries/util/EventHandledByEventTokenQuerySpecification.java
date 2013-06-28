package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EventHandledByEventTokenMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate EventHandledByEventTokenMatcher in a type-safe way.
 * 
 * @see EventHandledByEventTokenMatcher
 * @see EventHandledByEventTokenMatch
 * 
 */
public final class EventHandledByEventTokenQuerySpecification extends BaseGeneratedQuerySpecification<EventHandledByEventTokenMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventHandledByEventTokenQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EventHandledByEventTokenMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EventHandledByEventTokenMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByEventToken";
    
  }
  
  private EventHandledByEventTokenQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<EventHandledByEventTokenQuerySpecification> {
    @Override
    public EventHandledByEventTokenQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EventHandledByEventTokenQuerySpecification INSTANCE = make();
    
    public static EventHandledByEventTokenQuerySpecification make() {
      try {
      	return new EventHandledByEventTokenQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
