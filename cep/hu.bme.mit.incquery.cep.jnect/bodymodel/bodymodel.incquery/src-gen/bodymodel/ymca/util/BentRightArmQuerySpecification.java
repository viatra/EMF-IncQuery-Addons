package bodymodel.ymca.util;

import bodymodel.ymca.BentRightArmMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate BentRightArmMatcher in a type-safe way.
 * 
 * @see BentRightArmMatcher
 * @see BentRightArmMatch
 * 
 */
public final class BentRightArmQuerySpecification extends BaseGeneratedQuerySpecification<BentRightArmMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BentRightArmQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected BentRightArmMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BentRightArmMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.bentRightArm";
    
  }
  
  private BentRightArmQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<BentRightArmQuerySpecification> {
    @Override
    public BentRightArmQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static BentRightArmQuerySpecification INSTANCE = make();
    
    public static BentRightArmQuerySpecification make() {
      try {
      	return new BentRightArmQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
