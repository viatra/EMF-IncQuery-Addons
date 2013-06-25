package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.EventHandledByStateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByState pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EventHandledByStateProcessor implements IMatchProcessor<EventHandledByStateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pS the value of pattern parameter s in the currently processed match 
   * @param pE the value of pattern parameter e in the currently processed match 
   * 
   */
  public abstract void process(final State pS, final Event pE);
  
  @Override
  public void process(final EventHandledByStateMatch match) {
    process(match.getS(), match.getE());  				
    
  }
}
