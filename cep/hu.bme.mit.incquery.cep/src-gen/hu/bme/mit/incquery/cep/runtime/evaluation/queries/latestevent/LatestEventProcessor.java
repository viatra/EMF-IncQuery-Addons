package hu.bme.mit.incquery.cep.runtime.evaluation.queries.latestevent;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.latestevent.LatestEventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.latestEvent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class LatestEventProcessor implements IMatchProcessor<LatestEventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pE the value of pattern parameter e in the currently processed match 
   * 
   */
  public abstract void process(final Event e);
  
  @Override
  public void process(final LatestEventMatch match) {
    process(match.getE());  				
    
  }
}
