package hu.bme.mit.incquery.cep.performance.md.patterns.util;

import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentDMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate ComponentDMatcher in a type-safe way.
 * 
 * @see ComponentDMatcher
 * @see ComponentDMatch
 * 
 */
@SuppressWarnings("all")
public final class ComponentDQuerySpecification extends BaseGeneratedQuerySpecification<ComponentDMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ComponentDQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected ComponentDMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ComponentDMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.performance";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.performance.md.patterns.componentD";
    
  }
  
  private ComponentDQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<ComponentDQuerySpecification> {
    @Override
    public ComponentDQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static ComponentDQuerySpecification INSTANCE = make();
    
    public static ComponentDQuerySpecification make() {
      try {
      	return new ComponentDQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
