package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PreStateMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate PreStateMatcher in a type-safe way.
 * 
 * @see PreStateMatcher
 * @see PreStateMatch
 * 
 */
public final class PreStateQuerySpecification extends BaseGeneratedQuerySpecification<PreStateMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PreStateQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PreStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PreStateMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.preState";
    
  }
  
  private PreStateQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<PreStateQuerySpecification> {
    @Override
    public PreStateQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static PreStateQuerySpecification INSTANCE = make();
    
    public static PreStateQuerySpecification make() {
      try {
      	return new PreStateQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
