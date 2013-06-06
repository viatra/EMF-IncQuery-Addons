package bodymodel;

import bodymodel.RightHandAboveHeadMatcher;
import bodymodel.RightHandAboveHead_MovingAverageMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in bodymodel.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare 
 * an EMF-IncQuery engine for matching all patterns originally defined in file bodymodel.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package bodymodel, the group contains the definition of the following patterns: <ul>
 * <li>RightHandAboveHead</li>
 * <li>RightHandAboveHead_MovingAverage</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
public final class Bodymodel extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Bodymodel instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Bodymodel();
    }
    return INSTANCE;
    
  }
  
  private static Bodymodel INSTANCE;
  
  private Bodymodel() throws IncQueryException {
    querySpecifications.add(RightHandAboveHeadMatcher.querySpecification());
    querySpecifications.add(RightHandAboveHead_MovingAverageMatcher.querySpecification());
    
  }
}
