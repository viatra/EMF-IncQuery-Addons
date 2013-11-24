package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestCompoundEventMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentAMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentBMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentCMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in samplepatterns.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare 
 * an EMF-IncQuery engine for matching all patterns originally defined in file samplepatterns.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample, the group contains the definition of the following patterns: <ul>
 * <li>latestEventComponentA</li>
 * <li>latestEventComponentB</li>
 * <li>latestEventComponentC</li>
 * <li>latestCompoundEvent</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Samplepatterns extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Samplepatterns instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Samplepatterns();
    }
    return INSTANCE;
    
  }
  
  private static Samplepatterns INSTANCE;
  
  private Samplepatterns() throws IncQueryException {
    querySpecifications.add(LatestCompoundEventMatcher.querySpecification());
    querySpecifications.add(LatestEventComponentCMatcher.querySpecification());
    querySpecifications.add(LatestEventComponentBMatcher.querySpecification());
    querySpecifications.add(LatestEventComponentAMatcher.querySpecification());
    
  }
}
