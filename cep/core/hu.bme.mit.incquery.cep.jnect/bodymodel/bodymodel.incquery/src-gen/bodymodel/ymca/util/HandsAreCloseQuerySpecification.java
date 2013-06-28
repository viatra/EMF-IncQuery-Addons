package bodymodel.ymca.util;

import bodymodel.ymca.HandsAreCloseMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate HandsAreCloseMatcher in a type-safe way.
 * 
 * @see HandsAreCloseMatcher
 * @see HandsAreCloseMatch
 * 
 */
public final class HandsAreCloseQuerySpecification extends BaseGeneratedQuerySpecification<HandsAreCloseMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static HandsAreCloseQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected HandsAreCloseMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return HandsAreCloseMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.handsAreClose";
    
  }
  
  private HandsAreCloseQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<HandsAreCloseQuerySpecification> {
    @Override
    public HandsAreCloseQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static HandsAreCloseQuerySpecification INSTANCE = make();
    
    public static HandsAreCloseQuerySpecification make() {
      try {
      	return new HandsAreCloseQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
