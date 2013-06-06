package bodymodel.ymca.util;

import bodymodel.ymca.RightHandAboveHeadMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.RightHand;

/**
 * A match processor tailored for the bodymodel.ymca.rightHandAboveHead pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class RightHandAboveHeadProcessor implements IMatchProcessor<RightHandAboveHeadMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRH the value of pattern parameter RH in the currently processed match 
   * @param pH the value of pattern parameter H in the currently processed match 
   * 
   */
  public abstract void process(final RightHand pRH, final Head pH);
  
  @Override
  public void process(final RightHandAboveHeadMatch match) {
    process(match.getRH(), match.getH());  				
    
  }
}
