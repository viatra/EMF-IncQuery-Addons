package bodymodel.ymca.util;

import bodymodel.ymca.BentRightArmMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * A match processor tailored for the bodymodel.ymca.bentRightArm pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class BentRightArmProcessor implements IMatchProcessor<BentRightArmMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRH the value of pattern parameter RH in the currently processed match 
   * @param pRE the value of pattern parameter RE in the currently processed match 
   * @param pRS the value of pattern parameter RS in the currently processed match 
   * 
   */
  public abstract void process(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS);
  
  @Override
  public void process(final BentRightArmMatch match) {
    process(match.getRH(), match.getRE(), match.getRS());  				
    
  }
}
