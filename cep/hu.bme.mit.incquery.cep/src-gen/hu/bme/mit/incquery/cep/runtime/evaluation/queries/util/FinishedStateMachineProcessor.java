package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.FinishedStateMachineMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedStateMachine pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class FinishedStateMachineProcessor implements IMatchProcessor<FinishedStateMachineMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSm the value of pattern parameter sm in the currently processed match 
   * @param pEt the value of pattern parameter et in the currently processed match 
   * 
   */
  public abstract void process(final StateMachine pSm, final EventToken pEt);
  
  @Override
  public void process(final FinishedStateMachineMatch match) {
    process(match.getSm(), match.getEt());  				
    
  }
}
