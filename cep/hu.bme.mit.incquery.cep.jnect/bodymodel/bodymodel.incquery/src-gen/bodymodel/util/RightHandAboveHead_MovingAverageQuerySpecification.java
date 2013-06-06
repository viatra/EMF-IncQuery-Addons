package bodymodel.util;

import bodymodel.RightHandAboveHead_MovingAverageMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate RightHandAboveHead_MovingAverageMatcher in a type-safe way.
 * 
 * @see RightHandAboveHead_MovingAverageMatcher
 * @see RightHandAboveHead_MovingAverageMatch
 * 
 */
public final class RightHandAboveHead_MovingAverageQuerySpecification extends BaseGeneratedQuerySpecification<RightHandAboveHead_MovingAverageMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RightHandAboveHead_MovingAverageQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected RightHandAboveHead_MovingAverageMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RightHandAboveHead_MovingAverageMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.RightHandAboveHead_MovingAverage";
    
  }
  
  private RightHandAboveHead_MovingAverageQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<RightHandAboveHead_MovingAverageQuerySpecification> {
    @Override
    public RightHandAboveHead_MovingAverageQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static RightHandAboveHead_MovingAverageQuerySpecification INSTANCE = make();
    
    public static RightHandAboveHead_MovingAverageQuerySpecification make() {
      try {
      	return new RightHandAboveHead_MovingAverageQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
