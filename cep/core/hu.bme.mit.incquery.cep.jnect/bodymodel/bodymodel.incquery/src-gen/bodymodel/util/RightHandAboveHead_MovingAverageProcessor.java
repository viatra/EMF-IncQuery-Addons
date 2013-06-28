package bodymodel.util;

import bodymodel.RightHandAboveHead_MovingAverageMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.RightHand;

/**
 * A match processor tailored for the bodymodel.RightHandAboveHead_MovingAverage pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class RightHandAboveHead_MovingAverageProcessor implements IMatchProcessor<RightHandAboveHead_MovingAverageMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRH the value of pattern parameter RH in the currently processed match 
   * @param pH the value of pattern parameter H in the currently processed match 
   * 
   */
  public abstract void process(final RightHand pRH, final Head pH);
  
  @Override
  public void process(final RightHandAboveHead_MovingAverageMatch match) {
    process(match.getRH(), match.getH());  				
    
  }
}
