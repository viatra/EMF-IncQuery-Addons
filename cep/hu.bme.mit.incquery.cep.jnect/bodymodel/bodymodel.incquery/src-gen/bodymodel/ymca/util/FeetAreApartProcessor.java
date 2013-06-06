package bodymodel.ymca.util;

import bodymodel.ymca.FeetAreApartMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.LeftFoot;
import org.jnect.bodymodel.RightFoot;

/**
 * A match processor tailored for the bodymodel.ymca.feetAreApart pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class FeetAreApartProcessor implements IMatchProcessor<FeetAreApartMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pLF the value of pattern parameter LF in the currently processed match 
   * @param pRF the value of pattern parameter RF in the currently processed match 
   * 
   */
  public abstract void process(final LeftFoot pLF, final RightFoot pRF);
  
  @Override
  public void process(final FeetAreApartMatch match) {
    process(match.getLF(), match.getRF());  				
    
  }
}
