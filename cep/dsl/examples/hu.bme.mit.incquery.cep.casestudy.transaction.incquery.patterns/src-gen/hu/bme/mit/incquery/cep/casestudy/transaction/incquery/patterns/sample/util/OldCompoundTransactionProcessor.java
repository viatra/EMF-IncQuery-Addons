package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.OldCompoundTransactionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.oldCompoundTransaction pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OldCompoundTransactionProcessor implements IMatchProcessor<OldCompoundTransactionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCte the value of pattern parameter cte in the currently processed match 
   * @param pTs the value of pattern parameter ts in the currently processed match 
   * 
   */
  public abstract void process(final CompoundTransactionEvent pCte, final Long pTs);
  
  @Override
  public void process(final OldCompoundTransactionMatch match) {
    process(match.getCte(), match.getTs());
    
  }
}
