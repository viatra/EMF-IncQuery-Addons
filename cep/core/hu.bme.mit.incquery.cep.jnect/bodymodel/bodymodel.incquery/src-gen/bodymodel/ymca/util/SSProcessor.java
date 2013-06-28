package bodymodel.ymca.util;

import bodymodel.ymca.SSMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.CenterHip;
import org.jnect.bodymodel.RightHand;

/**
 * A match processor tailored for the bodymodel.ymca.SS pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class SSProcessor implements IMatchProcessor<SSMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRH the value of pattern parameter RH in the currently processed match 
   * @param pCH the value of pattern parameter CH in the currently processed match 
   * 
   */
  public abstract void process(final RightHand pRH, final CenterHip pCH);
  
  @Override
  public void process(final SSMatch match) {
    process(match.getRH(), match.getCH());  				
    
  }
}
