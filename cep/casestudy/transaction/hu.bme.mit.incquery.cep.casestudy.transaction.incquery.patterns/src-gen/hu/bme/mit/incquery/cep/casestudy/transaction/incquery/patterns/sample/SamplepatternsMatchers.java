package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestCompoundEventMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentAMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentBMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.LatestEventComponentCMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

@SuppressWarnings("all")
public final class SamplepatternsMatchers {
  private IncQueryEngine engine;
  
  public SamplepatternsMatchers(final IncQueryEngine engine) {
    this.engine = engine;
    
  }
  
  public LatestEventComponentBMatcher getLatestEventComponentBMatcher() throws IncQueryException {
    return LatestEventComponentBMatcher.on(engine);
  }
  
  public LatestEventComponentAMatcher getLatestEventComponentAMatcher() throws IncQueryException {
    return LatestEventComponentAMatcher.on(engine);
  }
  
  public LatestCompoundEventMatcher getLatestCompoundEventMatcher() throws IncQueryException {
    return LatestCompoundEventMatcher.on(engine);
  }
  
  public LatestEventComponentCMatcher getLatestEventComponentCMatcher() throws IncQueryException {
    return LatestEventComponentCMatcher.on(engine);
  }
}
