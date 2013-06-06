package bodymodel.ymca.util;

import bodymodel.ymca.UpperArmsInYMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate UpperArmsInYMatcher in a type-safe way.
 * 
 * @see UpperArmsInYMatcher
 * @see UpperArmsInYMatch
 * 
 */
public final class UpperArmsInYQuerySpecification extends BaseGeneratedQuerySpecification<UpperArmsInYMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UpperArmsInYQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected UpperArmsInYMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UpperArmsInYMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.upperArmsInY";
    
  }
  
  private UpperArmsInYQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<UpperArmsInYQuerySpecification> {
    @Override
    public UpperArmsInYQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static UpperArmsInYQuerySpecification INSTANCE = make();
    
    public static UpperArmsInYQuerySpecification make() {
      try {
      	return new UpperArmsInYQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
