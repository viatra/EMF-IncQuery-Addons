package bodymodel.ymca.util;

import bodymodel.ymca.FSMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate FSMatcher in a type-safe way.
 * 
 * @see FSMatcher
 * @see FSMatch
 * 
 */
public final class FSQuerySpecification extends BaseGeneratedQuerySpecification<FSMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FSQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FSMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FSMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.FS";
    
  }
  
  private FSQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<FSQuerySpecification> {
    @Override
    public FSQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static FSQuerySpecification INSTANCE = make();
    
    public static FSQuerySpecification make() {
      try {
      	return new FSQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
