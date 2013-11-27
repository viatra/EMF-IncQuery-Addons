package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.componentC_Appeared pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentC_AppearedProcessor implements IMatchProcessor<ComponentC_AppearedMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTe the value of pattern parameter te in the currently processed match 
   * @param pTId the value of pattern parameter tId in the currently processed match 
   * 
   */
  public abstract void process(final TransactionComponentC pTe, final String pTId);
  
  @Override
  public void process(final ComponentC_AppearedMatch match) {
    process(match.getTe(), match.getTId());
    
  }
}
