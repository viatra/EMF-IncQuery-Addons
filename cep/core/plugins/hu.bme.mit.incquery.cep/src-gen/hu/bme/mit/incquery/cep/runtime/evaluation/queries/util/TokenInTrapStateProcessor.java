package hu.bme.mit.incquery.cep.runtime.evaluation.queries.util;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.TokenInTrapStateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.tokenInTrapState pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TokenInTrapStateProcessor implements IMatchProcessor<TokenInTrapStateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEt the value of pattern parameter et in the currently processed match 
   * 
   */
  public abstract void process(final EventToken pEt);
  
  @Override
  public void process(final TokenInTrapStateMatch match) {
    process(match.getEt());
    
  }
}
