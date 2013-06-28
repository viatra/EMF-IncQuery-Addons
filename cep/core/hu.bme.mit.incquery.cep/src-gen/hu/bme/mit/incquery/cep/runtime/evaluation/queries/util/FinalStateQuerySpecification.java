package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinalStateMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate FinalStateMatcher in a type-safe way.
 * 
 * @see FinalStateMatcher
 * @see FinalStateMatch
 * 
 */
public final class FinalStateQuerySpecification extends BaseGeneratedQuerySpecification<FinalStateMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FinalStateQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FinalStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FinalStateMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalState";
    
  }
  
  private FinalStateQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<FinalStateQuerySpecification> {
    @Override
    public FinalStateQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static FinalStateQuerySpecification INSTANCE = make();
    
    public static FinalStateQuerySpecification make() {
      try {
      	return new FinalStateQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
