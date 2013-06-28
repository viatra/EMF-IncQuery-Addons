package bodymodel.ymca.util;

import bodymodel.ymca.LeftHandAboveHeadMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate LeftHandAboveHeadMatcher in a type-safe way.
 * 
 * @see LeftHandAboveHeadMatcher
 * @see LeftHandAboveHeadMatch
 * 
 */
public final class LeftHandAboveHeadQuerySpecification extends BaseGeneratedQuerySpecification<LeftHandAboveHeadMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LeftHandAboveHeadQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected LeftHandAboveHeadMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LeftHandAboveHeadMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.leftHandAboveHead";
    
  }
  
  private LeftHandAboveHeadQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<LeftHandAboveHeadQuerySpecification> {
    @Override
    public LeftHandAboveHeadQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static LeftHandAboveHeadQuerySpecification INSTANCE = make();
    
    public static LeftHandAboveHeadQuerySpecification make() {
      try {
      	return new LeftHandAboveHeadQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
