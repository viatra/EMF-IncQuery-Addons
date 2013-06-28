package bodymodel.util;

import bodymodel.RightHandAboveHeadMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate RightHandAboveHeadMatcher in a type-safe way.
 * 
 * @see RightHandAboveHeadMatcher
 * @see RightHandAboveHeadMatch
 * 
 */
public final class RightHandAboveHeadQuerySpecification extends BaseGeneratedQuerySpecification<RightHandAboveHeadMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RightHandAboveHeadQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected RightHandAboveHeadMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RightHandAboveHeadMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.RightHandAboveHead";
    
  }
  
  private RightHandAboveHeadQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<RightHandAboveHeadQuerySpecification> {
    @Override
    public RightHandAboveHeadQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static RightHandAboveHeadQuerySpecification INSTANCE = make();
    
    public static RightHandAboveHeadQuerySpecification make() {
      try {
      	return new RightHandAboveHeadQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
