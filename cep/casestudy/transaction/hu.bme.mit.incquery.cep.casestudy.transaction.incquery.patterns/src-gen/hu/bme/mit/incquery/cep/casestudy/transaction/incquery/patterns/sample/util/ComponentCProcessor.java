package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentCMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.componentC pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentCProcessor implements IMatchProcessor<ComponentCMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTe the value of pattern parameter te in the currently processed match 
   * @param pTId the value of pattern parameter tId in the currently processed match 
   * @param pSId the value of pattern parameter sId in the currently processed match 
   * 
   */
  public abstract void process(final TransactionComponentC pTe, final String pTId, final String pSId);
  
  @Override
  public void process(final ComponentCMatch match) {
    process(match.getTe(), match.getTId(), match.getSId());
    
  }
}
