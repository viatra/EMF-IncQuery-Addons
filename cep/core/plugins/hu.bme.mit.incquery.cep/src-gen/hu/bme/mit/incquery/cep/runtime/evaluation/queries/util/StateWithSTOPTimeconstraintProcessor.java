package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.StateWithSTOPTimeconstraintMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.stateWithSTOPTimeconstraint pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StateWithSTOPTimeconstraintProcessor implements IMatchProcessor<StateWithSTOPTimeconstraintMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pS the value of pattern parameter s in the currently processed match 
   * @param pTc the value of pattern parameter tc in the currently processed match 
   * 
   */
  public abstract void process(final State pS, final TimeConstraint pTc);
  
  @Override
  public void process(final StateWithSTOPTimeconstraintMatch match) {
    process(match.getS(), match.getTc());
    
  }
}
