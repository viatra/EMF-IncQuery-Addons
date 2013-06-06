package bodymodel.ymca.util;

import bodymodel.ymca.StretchedLeftArmMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate StretchedLeftArmMatcher in a type-safe way.
 * 
 * @see StretchedLeftArmMatcher
 * @see StretchedLeftArmMatch
 * 
 */
public final class StretchedLeftArmQuerySpecification extends BaseGeneratedQuerySpecification<StretchedLeftArmMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StretchedLeftArmQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected StretchedLeftArmMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StretchedLeftArmMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.stretchedLeftArm";
    
  }
  
  private StretchedLeftArmQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<StretchedLeftArmQuerySpecification> {
    @Override
    public StretchedLeftArmQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static StretchedLeftArmQuerySpecification INSTANCE = make();
    
    public static StretchedLeftArmQuerySpecification make() {
      try {
      	return new StretchedLeftArmQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
