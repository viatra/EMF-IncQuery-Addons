package hu.bme.mit.incquery.cep.performance.md.patterns.util;

import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentGMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate ComponentGMatcher in a type-safe way.
 * 
 * @see ComponentGMatcher
 * @see ComponentGMatch
 * 
 */
@SuppressWarnings("all")
public final class ComponentGQuerySpecification extends BaseGeneratedQuerySpecification<ComponentGMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ComponentGQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected ComponentGMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ComponentGMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.performance";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.performance.md.patterns.componentG";
    
  }
  
  private ComponentGQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<ComponentGQuerySpecification> {
    @Override
    public ComponentGQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static ComponentGQuerySpecification INSTANCE = make();
    
    public static ComponentGQuerySpecification make() {
      try {
      	return new ComponentGQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
