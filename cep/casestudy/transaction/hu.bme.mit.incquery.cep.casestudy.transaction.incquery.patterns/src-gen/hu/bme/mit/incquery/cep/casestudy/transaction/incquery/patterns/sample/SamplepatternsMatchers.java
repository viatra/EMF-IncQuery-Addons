package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentA_AppearedMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentB_AppearedMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentC_AppearedMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.CompoundEventMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

@SuppressWarnings("all")
public final class SamplepatternsMatchers {
  private IncQueryEngine engine;
  
  public SamplepatternsMatchers(final IncQueryEngine engine) {
    this.engine = engine;
    
  }
  
  public CompoundEventMatcher getCompoundEventMatcher() throws IncQueryException {
    return CompoundEventMatcher.on(engine);
  }
  
  public ComponentC_AppearedMatcher getComponentC_AppearedMatcher() throws IncQueryException {
    return ComponentC_AppearedMatcher.on(engine);
  }
  
  public ComponentB_AppearedMatcher getComponentB_AppearedMatcher() throws IncQueryException {
    return ComponentB_AppearedMatcher.on(engine);
  }
  
  public ComponentA_AppearedMatcher getComponentA_AppearedMatcher() throws IncQueryException {
    return ComponentA_AppearedMatcher.on(engine);
  }
}
