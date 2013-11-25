package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentA;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentAMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.latestEventComponentA pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LatestEventComponentAProcessor implements IMatchProcessor<LatestEventComponentAMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTe the value of pattern parameter te in the currently processed match 
   * @param pTId the value of pattern parameter tId in the currently processed match 
   * 
   */
  public abstract void process(final TransactionComponentA pTe, final String pTId);
  
  @Override
  public void process(final LatestEventComponentAMatch match) {
    process(match.getTe(), match.getTId());
    
  }
}
