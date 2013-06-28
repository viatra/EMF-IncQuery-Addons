package bodymodel.ymca.util;

import bodymodel.ymca.HandsAreCloseMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.RightHand;

/**
 * A match processor tailored for the bodymodel.ymca.handsAreClose pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class HandsAreCloseProcessor implements IMatchProcessor<HandsAreCloseMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLH the value of pattern parameter LH in the currently processed match 
   * @param pRH the value of pattern parameter RH in the currently processed match 
   * 
   */
  public abstract void process(final LeftHand pLH, final RightHand pRH);
  
  @Override
  public void process(final HandsAreCloseMatch match) {
    process(match.getLH(), match.getRH());  				
    
  }
}
