package hu.bme.mit.incquery.cep.runtime.evaluation.queries.prestate;

import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.prestate.PreStateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.preState pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class PreStateProcessor implements IMatchProcessor<PreStateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT the value of pattern parameter t in the currently processed match 
   * @param pS the value of pattern parameter s in the currently processed match 
   * 
   */
  public abstract void process(final Transition t, final State s);
  
  @Override
  public void process(final PreStateMatch match) {
    process(match.getT(), match.getS());  				
    
  }
}
