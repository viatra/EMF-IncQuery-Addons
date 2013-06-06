package bodymodel.ymca.util;

import bodymodel.ymca.UpperArmsInYMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.LeftElbow;
import org.jnect.bodymodel.LeftShoulder;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightShoulder;

/**
 * A match processor tailored for the bodymodel.ymca.upperArmsInY pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class UpperArmsInYProcessor implements IMatchProcessor<UpperArmsInYMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLE the value of pattern parameter LE in the currently processed match 
   * @param pLS the value of pattern parameter LS in the currently processed match 
   * @param pRE the value of pattern parameter RE in the currently processed match 
   * @param pRS the value of pattern parameter RS in the currently processed match 
   * 
   */
  public abstract void process(final LeftElbow pLE, final LeftShoulder pLS, final RightElbow pRE, final RightShoulder pRS);
  
  @Override
  public void process(final UpperArmsInYMatch match) {
    process(match.getLE(), match.getLS(), match.getRE(), match.getRS());  				
    
  }
}
