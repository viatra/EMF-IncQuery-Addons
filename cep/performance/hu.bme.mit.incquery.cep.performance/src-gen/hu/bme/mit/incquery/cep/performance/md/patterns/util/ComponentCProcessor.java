package hu.bme.mit.incquery.cep.performance.md.patterns.util;

import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentCMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.performance.md.patterns.componentC pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentCProcessor implements IMatchProcessor<ComponentCMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTe the value of pattern parameter te in the currently processed match 
   * 
   */
  public abstract void process(final Object pTe);
  
  @Override
  public void process(final ComponentCMatch match) {
    process(match.getTe());
    
  }
}
