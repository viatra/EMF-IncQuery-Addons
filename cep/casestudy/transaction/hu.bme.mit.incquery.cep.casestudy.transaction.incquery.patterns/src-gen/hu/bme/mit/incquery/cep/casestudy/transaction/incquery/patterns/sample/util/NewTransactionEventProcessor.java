package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.ComponentA;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.NewTransactionEventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.newTransactionEvent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NewTransactionEventProcessor implements IMatchProcessor<NewTransactionEventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTe the value of pattern parameter te in the currently processed match 
   * 
   */
  public abstract void process(final ComponentA pTe);
  
  @Override
  public void process(final NewTransactionEventMatch match) {
    process(match.getTe());
    
  }
}
