package hu.bme.mit.incquery.cep.performance.md.patterns.util;

import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentH;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.performance.md.patterns.componentH pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentHProcessor implements IMatchProcessor<ComponentHMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTe the value of pattern parameter te in the currently processed match 
   * 
   */
  public abstract void process(final TransactionComponentH pTe);
  
  @Override
  public void process(final ComponentHMatch match) {
    process(match.getTe());
    
  }
}
