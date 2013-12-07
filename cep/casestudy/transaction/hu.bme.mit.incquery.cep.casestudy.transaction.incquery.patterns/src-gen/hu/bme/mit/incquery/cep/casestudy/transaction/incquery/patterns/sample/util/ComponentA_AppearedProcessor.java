package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentA;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.componentA_Appeared pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentA_AppearedProcessor implements IMatchProcessor<ComponentA_AppearedMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTe the value of pattern parameter te in the currently processed match 
   * @param pTId the value of pattern parameter tId in the currently processed match 
   * @param pCId the value of pattern parameter cId in the currently processed match 
   * 
   */
  public abstract void process(final TransactionComponentA pTe, final String pTId, final String pCId);
  
  @Override
  public void process(final ComponentA_AppearedMatch match) {
    process(match.getTe(), match.getTId(), match.getCId());
    
  }
}
