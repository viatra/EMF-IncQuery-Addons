package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestCompoundEventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.latestCompoundEvent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LatestCompoundEventProcessor implements IMatchProcessor<LatestCompoundEventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pE the value of pattern parameter e in the currently processed match 
   * 
   */
  public abstract void process(final CompoundTransactionEvent pE);
  
  @Override
  public void process(final LatestCompoundEventMatch match) {
    process(match.getE());
    
  }
}
