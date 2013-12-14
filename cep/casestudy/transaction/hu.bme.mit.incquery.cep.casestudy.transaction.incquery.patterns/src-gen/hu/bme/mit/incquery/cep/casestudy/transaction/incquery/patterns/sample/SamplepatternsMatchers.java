package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample;

import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentAMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentBMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.ComponentCMatcher;
import hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.CompoundEventMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

@SuppressWarnings("all")
public final class SamplepatternsMatchers {
  private IncQueryEngine engine;
  
  public SamplepatternsMatchers(final IncQueryEngine engine) {
    this.engine = engine;
    
  }
  
  public ComponentCMatcher getComponentCMatcher() throws IncQueryException {
    return ComponentCMatcher.on(engine);
  }
  
  public ComponentAMatcher getComponentAMatcher() throws IncQueryException {
    return ComponentAMatcher.on(engine);
  }
  
  public CompoundEventMatcher getCompoundEventMatcher() throws IncQueryException {
    return CompoundEventMatcher.on(engine);
  }
  
  public ComponentBMatcher getComponentBMatcher() throws IncQueryException {
    return ComponentBMatcher.on(engine);
  }
}
