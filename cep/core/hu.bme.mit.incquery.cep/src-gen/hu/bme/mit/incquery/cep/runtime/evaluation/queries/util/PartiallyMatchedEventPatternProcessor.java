package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.PartiallyMatchedEventPatternMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.partiallyMatchedEventPattern pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class PartiallyMatchedEventPatternProcessor implements IMatchProcessor<PartiallyMatchedEventPatternMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEt the value of pattern parameter et in the currently processed match 
   * @param pS the value of pattern parameter s in the currently processed match 
   * 
   */
  public abstract void process(final EventToken pEt, final State pS);
  
  @Override
  public void process(final PartiallyMatchedEventPatternMatch match) {
    process(match.getEt(), match.getS());  				
    
  }
}
