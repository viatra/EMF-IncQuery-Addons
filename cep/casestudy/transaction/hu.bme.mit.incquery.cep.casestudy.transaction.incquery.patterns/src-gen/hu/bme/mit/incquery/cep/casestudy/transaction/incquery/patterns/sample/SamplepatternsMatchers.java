package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.NewTransactionEventMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.OldCompoundTransactionMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

@SuppressWarnings("all")
public final class SamplepatternsMatchers {
  private IncQueryEngine engine;
  
  public SamplepatternsMatchers(final IncQueryEngine engine) {
    this.engine = engine;
    
  }
  
  public NewTransactionEventMatcher getNewTransactionEventMatcher() throws IncQueryException {
    return NewTransactionEventMatcher.on(engine);
  }
  
  public OldCompoundTransactionMatcher getOldCompoundTransactionMatcher() throws IncQueryException {
    return OldCompoundTransactionMatcher.on(engine);
  }
}
