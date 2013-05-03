package hu.bme.mit.incquery.cep.runtime.evaluation.queries.transition;

import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.transition.TransitionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.transition pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TransitionProcessor implements IMatchProcessor<TransitionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT the value of pattern parameter t in the currently processed match 
   * 
   */
  public abstract void process(final Transition t);
  
  @Override
  public void process(final TransitionMatch match) {
    process(match.getT());  				
    
  }
}
