package hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledtransition;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledtransition.EnabledTransitionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledTransition pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EnabledTransitionProcessor implements IMatchProcessor<EnabledTransitionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT the value of pattern parameter t in the currently processed match 
   * @param pE the value of pattern parameter e in the currently processed match 
   * 
   */
  public abstract void process(final Transition t, final Event e);
  
  @Override
  public void process(final EnabledTransitionMatch match) {
    process(match.getT(), match.getE());  				
    
  }
}
