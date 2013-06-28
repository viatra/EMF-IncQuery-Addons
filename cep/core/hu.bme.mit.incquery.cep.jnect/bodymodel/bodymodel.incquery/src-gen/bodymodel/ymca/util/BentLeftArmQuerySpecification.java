package bodymodel.ymca.util;

import bodymodel.ymca.BentLeftArmMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate BentLeftArmMatcher in a type-safe way.
 * 
 * @see BentLeftArmMatcher
 * @see BentLeftArmMatch
 * 
 */
public final class BentLeftArmQuerySpecification extends BaseGeneratedQuerySpecification<BentLeftArmMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BentLeftArmQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected BentLeftArmMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BentLeftArmMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.bentLeftArm";
    
  }
  
  private BentLeftArmQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<BentLeftArmQuerySpecification> {
    @Override
    public BentLeftArmQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static BentLeftArmQuerySpecification INSTANCE = make();
    
    public static BentLeftArmQuerySpecification make() {
      try {
      	return new BentLeftArmQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
