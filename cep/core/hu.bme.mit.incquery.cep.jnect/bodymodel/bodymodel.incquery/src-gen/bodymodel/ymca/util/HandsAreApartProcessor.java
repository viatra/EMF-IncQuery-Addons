package bodymodel.ymca.util;

import bodymodel.ymca.HandsAreApartMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.LeftHand;
import org.jnect.bodymodel.RightHand;

/**
 * A match processor tailored for the bodymodel.ymca.handsAreApart pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class HandsAreApartProcessor implements IMatchProcessor<HandsAreApartMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLH the value of pattern parameter LH in the currently processed match 
   * @param pRH the value of pattern parameter RH in the currently processed match 
   * 
   */
  public abstract void process(final LeftHand pLH, final RightHand pRH);
  
  @Override
  public void process(final HandsAreApartMatch match) {
    process(match.getLH(), match.getRH());  				
    
  }
}
