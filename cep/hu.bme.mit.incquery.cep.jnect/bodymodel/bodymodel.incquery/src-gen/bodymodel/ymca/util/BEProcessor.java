package bodymodel.ymca.util;

import bodymodel.ymca.BEMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.LeftShoulder;

/**
 * A match processor tailored for the bodymodel.ymca.BE pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class BEProcessor implements IMatchProcessor<BEMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLH the value of pattern parameter LH in the currently processed match 
   * @param pLE the value of pattern parameter LE in the currently processed match 
   * @param pLS the value of pattern parameter LS in the currently processed match 
   * @param pH the value of pattern parameter H in the currently processed match 
   * 
   */
  public abstract void process(final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH);
  
  @Override
  public void process(final BEMatch match) {
    process(match.getLH(), match.getLE(), match.getLS(), match.getH());  				
    
  }
}
