package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EventHandledByCSVMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate EventHandledByCSVMatcher in a type-safe way.
 * 
 * @see EventHandledByCSVMatcher
 * @see EventHandledByCSVMatch
 * 
 */
public final class EventHandledByCSVQuerySpecification extends BaseGeneratedQuerySpecification<EventHandledByCSVMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventHandledByCSVQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EventHandledByCSVMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EventHandledByCSVMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByCSV";
    
  }
  
  private EventHandledByCSVQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<EventHandledByCSVQuerySpecification> {
    @Override
    public EventHandledByCSVQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EventHandledByCSVQuerySpecification INSTANCE = make();
    
    public static EventHandledByCSVQuerySpecification make() {
      try {
      	return new EventHandledByCSVQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
