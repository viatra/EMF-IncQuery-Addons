package bodymodel.ymca.util;

import bodymodel.ymca.StretchedRightArmMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate StretchedRightArmMatcher in a type-safe way.
 * 
 * @see StretchedRightArmMatcher
 * @see StretchedRightArmMatch
 * 
 */
public final class StretchedRightArmQuerySpecification extends BaseGeneratedQuerySpecification<StretchedRightArmMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StretchedRightArmQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected StretchedRightArmMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StretchedRightArmMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.stretchedRightArm";
    
  }
  
  private StretchedRightArmQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<StretchedRightArmQuerySpecification> {
    @Override
    public StretchedRightArmQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static StretchedRightArmQuerySpecification INSTANCE = make();
    
    public static StretchedRightArmQuerySpecification make() {
      try {
      	return new StretchedRightArmQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
