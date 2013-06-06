package bodymodel.ymca.util;

import bodymodel.ymca.FeetAreCloseMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate FeetAreCloseMatcher in a type-safe way.
 * 
 * @see FeetAreCloseMatcher
 * @see FeetAreCloseMatch
 * 
 */
public final class FeetAreCloseQuerySpecification extends BaseGeneratedQuerySpecification<FeetAreCloseMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FeetAreCloseQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FeetAreCloseMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FeetAreCloseMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.feetAreClose";
    
  }
  
  private FeetAreCloseQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<FeetAreCloseQuerySpecification> {
    @Override
    public FeetAreCloseQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static FeetAreCloseQuerySpecification INSTANCE = make();
    
    public static FeetAreCloseQuerySpecification make() {
      try {
      	return new FeetAreCloseQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
