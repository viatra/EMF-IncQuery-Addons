package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EventHandledByEventTokenMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByEventToken pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EventHandledByEventTokenProcessor implements IMatchProcessor<EventHandledByEventTokenMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEt the value of pattern parameter et in the currently processed match 
   * @param pE the value of pattern parameter e in the currently processed match 
   * 
   */
  public abstract void process(final EventToken pEt, final Event pE);
  
  @Override
  public void process(final EventHandledByEventTokenMatch match) {
    process(match.getEt(), match.getE());
    
  }
}
