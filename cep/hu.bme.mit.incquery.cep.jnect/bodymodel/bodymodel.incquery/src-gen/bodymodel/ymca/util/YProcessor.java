package bodymodel.ymca.util;

import bodymodel.ymca.YMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.LeftShoulder;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * A match processor tailored for the bodymodel.ymca.Y pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class YProcessor implements IMatchProcessor<YMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRH the value of pattern parameter RH in the currently processed match 
   * @param pRE the value of pattern parameter RE in the currently processed match 
   * @param pRS the value of pattern parameter RS in the currently processed match 
   * @param pLH the value of pattern parameter LH in the currently processed match 
   * @param pLE the value of pattern parameter LE in the currently processed match 
   * @param pLS the value of pattern parameter LS in the currently processed match 
   * @param pH the value of pattern parameter H in the currently processed match 
   * 
   */
  public abstract void process(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final LeftHand pLH, final LeftElbow pLE, final LeftShoulder pLS, final Head pH);
  
  @Override
  public void process(final YMatch match) {
    process(match.getRH(), match.getRE(), match.getRS(), match.getLH(), match.getLE(), match.getLS(), match.getH());  				
    
  }
}
