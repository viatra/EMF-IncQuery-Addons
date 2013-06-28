package bodymodel.ymca.util;

import bodymodel.ymca.BEMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate BEMatcher in a type-safe way.
 * 
 * @see BEMatcher
 * @see BEMatch
 * 
 */
public final class BEQuerySpecification extends BaseGeneratedQuerySpecification<BEMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BEQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected BEMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BEMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.BE";
    
  }
  
  private BEQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<BEQuerySpecification> {
    @Override
    public BEQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static BEQuerySpecification INSTANCE = make();
    
    public static BEQuerySpecification make() {
      try {
      	return new BEQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
