package bodymodel.ymca.util;

import bodymodel.ymca.StretchedLeftArmMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.LeftShoulder;

/**
 * A match processor tailored for the bodymodel.ymca.stretchedLeftArm pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class StretchedLeftArmProcessor implements IMatchProcessor<StretchedLeftArmMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLH the value of pattern parameter LH in the currently processed match 
   * @param pLE the value of pattern parameter LE in the currently processed match 
   * @param pLS the value of pattern parameter LS in the currently processed match 
   * 
   */
  public abstract void process(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS);
  
  @Override
  public void process(final StretchedLeftArmMatch match) {
    process(match.getLH(), match.getLE(), match.getLS());  				
    
  }
}
