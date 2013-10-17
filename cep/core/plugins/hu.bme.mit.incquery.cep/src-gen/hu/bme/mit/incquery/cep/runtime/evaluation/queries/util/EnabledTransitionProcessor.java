package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EnabledTransitionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.enabledTransition pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EnabledTransitionProcessor implements IMatchProcessor<EnabledTransitionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT the value of pattern parameter t in the currently processed match 
   * @param pEt the value of pattern parameter et in the currently processed match 
   * 
   */
  public abstract void process(final Transition pT, final EventToken pEt);
  
  @Override
  public void process(final EnabledTransitionMatch match) {
    process(match.getT(), match.getEt());
    
  }
}
