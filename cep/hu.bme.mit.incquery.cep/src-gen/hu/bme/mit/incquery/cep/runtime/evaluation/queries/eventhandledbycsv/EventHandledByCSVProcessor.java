package hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventhandledbycsv;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventhandledbycsv.EventHandledByCSVMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.eventHandledByCSV pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EventHandledByCSVProcessor implements IMatchProcessor<EventHandledByCSVMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pE the value of pattern parameter e in the currently processed match 
   * @param pCsv the value of pattern parameter csv in the currently processed match 
   * 
   */
  public abstract void process(final EventCollection e, final CurrentStateVisitor csv);
  
  @Override
  public void process(final EventHandledByCSVMatch match) {
    process(match.getE(), match.getCsv());  				
    
  }
}
