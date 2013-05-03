package hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatch;
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
   * @param pCv the value of pattern parameter cv in the currently processed match 
   * 
   */
  public abstract void process(final StateMachine sm, final CurrentStateVisitor cv);
  
  @Override
  public void process(final FinishedStateMachineMatch match) {
    process(match.getSm(), match.getCv());  				
    
  }
}
