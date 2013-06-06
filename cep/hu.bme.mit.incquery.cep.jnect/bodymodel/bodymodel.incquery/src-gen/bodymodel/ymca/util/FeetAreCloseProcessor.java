package bodymodel.ymca.util;

import bodymodel.ymca.FeetAreCloseMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.LeftFoot;
import org.jnect.bodymodel.RightFoot;

/**
 * A match processor tailored for the bodymodel.ymca.feetAreClose pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class FeetAreCloseProcessor implements IMatchProcessor<FeetAreCloseMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLF the value of pattern parameter LF in the currently processed match 
   * @param pRF the value of pattern parameter RF in the currently processed match 
   * 
   */
  public abstract void process(final LeftFoot pLF, final RightFoot pRF);
  
  @Override
  public void process(final FeetAreCloseMatch match) {
    process(match.getLF(), match.getRF());  				
    
  }
}
