package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EventHandledByStateMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate EventHandledByStateMatcher in a type-safe way.
 * 
 * @see EventHandledByStateMatcher
 * @see EventHandledByStateMatch
 * 
 */
@SuppressWarnings("all")
public final class EventHandledByStateQuerySpecification extends BaseGeneratedQuerySpecification<EventHandledByStateMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventHandledByStateQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EventHandledByStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EventHandledByStateMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByState";
    
  }
  
  private EventHandledByStateQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<EventHandledByStateQuerySpecification> {
    @Override
    public EventHandledByStateQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static EventHandledByStateQuerySpecification INSTANCE = make();
    
    public static EventHandledByStateQuerySpecification make() {
      try {
      	return new EventHandledByStateQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
