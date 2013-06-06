package bodymodel.ymca.util;

import bodymodel.ymca.LeftHandAboveHeadMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.LeftHand;

/**
 * A match processor tailored for the bodymodel.ymca.leftHandAboveHead pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class LeftHandAboveHeadProcessor implements IMatchProcessor<LeftHandAboveHeadMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLH the value of pattern parameter LH in the currently processed match 
   * @param pH the value of pattern parameter H in the currently processed match 
   * 
   */
  public abstract void process(final LeftHand pLH, final Head pH);
  
  @Override
  public void process(final LeftHandAboveHeadMatch match) {
    process(match.getLH(), match.getH());  				
    
  }
}
