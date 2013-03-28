package hu.bme.mit.incquery.cep.tests.testcasesmqueries.event;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.event.EventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.tests.testcasesmqueries.event pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EventProcessor implements IMatchProcessor<EventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pE the value of pattern parameter e in the currently processed match 
   * 
   */
  public abstract void process(final Event e);
  
  @Override
  public void process(final EventMatch match) {
    process(match.getE());  				
    
  }
}
