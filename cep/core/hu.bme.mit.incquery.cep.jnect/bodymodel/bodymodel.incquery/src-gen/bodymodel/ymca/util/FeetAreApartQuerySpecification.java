package bodymodel.ymca.util;

import bodymodel.ymca.FeetAreApartMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate FeetAreApartMatcher in a type-safe way.
 * 
 * @see FeetAreApartMatcher
 * @see FeetAreApartMatch
 * 
 */
public final class FeetAreApartQuerySpecification extends BaseGeneratedQuerySpecification<FeetAreApartMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FeetAreApartQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FeetAreApartMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FeetAreApartMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.feetAreApart";
    
  }
  
  private FeetAreApartQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<FeetAreApartQuerySpecification> {
    @Override
    public FeetAreApartQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static FeetAreApartQuerySpecification INSTANCE = make();
    
    public static FeetAreApartQuerySpecification make() {
      try {
      	return new FeetAreApartQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
