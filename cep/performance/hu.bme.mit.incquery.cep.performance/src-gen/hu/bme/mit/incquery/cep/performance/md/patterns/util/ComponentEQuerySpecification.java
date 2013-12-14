package hu.bme.mit.incquery.cep.performance.md.patterns.util;

import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentEMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate ComponentEMatcher in a type-safe way.
 * 
 * @see ComponentEMatcher
 * @see ComponentEMatch
 * 
 */
@SuppressWarnings("all")
public final class ComponentEQuerySpecification extends BaseGeneratedQuerySpecification<ComponentEMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ComponentEQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected ComponentEMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ComponentEMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep.performance";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.performance.md.patterns.componentE";
    
  }
  
  private ComponentEQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<ComponentEQuerySpecification> {
    @Override
    public ComponentEQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static ComponentEQuerySpecification INSTANCE = make();
    
    public static ComponentEQuerySpecification make() {
      try {
      	return new ComponentEQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
