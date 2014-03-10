package hu.bme.mit.incquery.cep.performance.md.patterns.util;

import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate ComponentHMatcher in a type-safe way.
 * 
 * @see ComponentHMatcher
 * @see ComponentHMatch
 * 
 */
@SuppressWarnings("all")
public final class ComponentHQuerySpecification extends BaseGeneratedQuerySpecification<ComponentHMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ComponentHQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected ComponentHMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ComponentHMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.performance";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.performance.md.patterns.componentH";
    
  }
  
  private ComponentHQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<ComponentHQuerySpecification> {
    @Override
    public ComponentHQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static ComponentHQuerySpecification INSTANCE = make();
    
    public static ComponentHQuerySpecification make() {
      try {
      	return new ComponentHQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
