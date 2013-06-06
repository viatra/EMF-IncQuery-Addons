package bodymodel.ymca.util;

import bodymodel.ymca.HandsAreApartMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate HandsAreApartMatcher in a type-safe way.
 * 
 * @see HandsAreApartMatcher
 * @see HandsAreApartMatch
 * 
 */
public final class HandsAreApartQuerySpecification extends BaseGeneratedQuerySpecification<HandsAreApartMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static HandsAreApartQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected HandsAreApartMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return HandsAreApartMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "bodymodel.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "bodymodel.ymca.handsAreApart";
    
  }
  
  private HandsAreApartQuerySpecification() throws IncQueryException {
    super();
  }
  public static class Provider implements IQuerySpecificationProvider<HandsAreApartQuerySpecification> {
    @Override
    public HandsAreApartQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static HandsAreApartQuerySpecification INSTANCE = make();
    
    public static HandsAreApartQuerySpecification make() {
      try {
      	return new HandsAreApartQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
