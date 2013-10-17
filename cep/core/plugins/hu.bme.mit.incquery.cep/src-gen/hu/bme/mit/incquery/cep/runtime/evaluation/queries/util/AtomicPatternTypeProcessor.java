package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.AtomicPatternTypeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.atomicPatternType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AtomicPatternTypeProcessor implements IMatchProcessor<AtomicPatternTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pA the value of pattern parameter a in the currently processed match 
   * @param pT the value of pattern parameter t in the currently processed match 
   * 
   */
  public abstract void process(final AtomicEventPattern pA, final String pT);
  
  @Override
  public void process(final AtomicPatternTypeMatch match) {
    process(match.getA(), match.getT());
    
  }
}
