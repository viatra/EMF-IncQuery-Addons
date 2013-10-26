package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate TokenInTrapStateMatcher in a type-safe way.
 * 
 * @see TokenInTrapStateMatcher
 * @see TokenInTrapStateMatch
 * 
 */
@SuppressWarnings("all")
public final class TokenInTrapStateQuerySpecification extends BaseGeneratedQuerySpecification<TokenInTrapStateMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TokenInTrapStateQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TokenInTrapStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TokenInTrapStateMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.incquery.cep";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.incquery.cep.runtime.evaluation.queries.tokenInTrapState";
    
  }
  
  private TokenInTrapStateQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<TokenInTrapStateQuerySpecification> {
    @Override
    public TokenInTrapStateQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static TokenInTrapStateQuerySpecification INSTANCE = make();
    
    public static TokenInTrapStateQuerySpecification make() {
      try {
      	return new TokenInTrapStateQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
