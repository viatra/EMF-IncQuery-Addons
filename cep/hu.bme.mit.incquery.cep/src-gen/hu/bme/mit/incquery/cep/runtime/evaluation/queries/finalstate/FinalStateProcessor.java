package hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalstate;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalstate.FinalStateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalState pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class FinalStateProcessor implements IMatchProcessor<FinalStateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pS the value of pattern parameter s in the currently processed match 
   * @param pCv the value of pattern parameter cv in the currently processed match 
   * 
   */
  public abstract void process(final State s, final CurrentStateVisitor cv);
  
  @Override
  public void process(final FinalStateMatch match) {
    process(match.getS(), match.getCv());  				
    
  }
}
