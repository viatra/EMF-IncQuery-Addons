package bodymodel.ymca.util;

import bodymodel.ymca.SSMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate SSMatcher in a type-safe way.
 * 
 * @see SSMatcher
 * @see SSMatch
 * 
 */
public final class SSQuerySpecification extends BaseGeneratedQuerySpecification<SSMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SSQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected SSMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SSMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.SS";
    
  }
  
  private SSQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<SSQuerySpecification> {
    @Override
    public SSQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static SSQuerySpecification INSTANCE = make();
    
    public static SSQuerySpecification make() {
      try {
      	return new SSQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
