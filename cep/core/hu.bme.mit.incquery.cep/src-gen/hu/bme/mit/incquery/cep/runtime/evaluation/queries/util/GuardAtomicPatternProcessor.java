package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.GuardAtomicPatternMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.guardAtomicPattern pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class GuardAtomicPatternProcessor implements IMatchProcessor<GuardAtomicPatternMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pGuard the value of pattern parameter guard in the currently processed match 
   * @param pAtomicPattern the value of pattern parameter atomicPattern in the currently processed match 
   * 
   */
  public abstract void process(final Guard pGuard, final AtomicEventPattern pAtomicPattern);
  
  @Override
  public void process(final GuardAtomicPatternMatch match) {
    process(match.getGuard(), match.getAtomicPattern());  				
    
  }
}
