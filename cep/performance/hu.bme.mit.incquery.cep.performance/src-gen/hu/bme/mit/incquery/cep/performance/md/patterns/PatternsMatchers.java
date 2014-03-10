package hu.bme.mit.incquery.cep.performance.md.patterns;

import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentAMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentBMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentCMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentDMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentEMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentFMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentGMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentHMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentIMatcher;
import hu.bme.mit.incquery.cep.performance.md.patterns.ComponentJMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

@SuppressWarnings("all")
public final class PatternsMatchers {
  private IncQueryEngine engine;
  
  public PatternsMatchers(final IncQueryEngine engine) {
    this.engine = engine;
    
  }
  
  public ComponentCMatcher getComponentCMatcher() throws IncQueryException {
    return ComponentCMatcher.on(engine);
  }
  
  public ComponentGMatcher getComponentGMatcher() throws IncQueryException {
    return ComponentGMatcher.on(engine);
  }
  
  public ComponentAMatcher getComponentAMatcher() throws IncQueryException {
    return ComponentAMatcher.on(engine);
  }
  
  public ComponentIMatcher getComponentIMatcher() throws IncQueryException {
    return ComponentIMatcher.on(engine);
  }
  
  public ComponentHMatcher getComponentHMatcher() throws IncQueryException {
    return ComponentHMatcher.on(engine);
  }
  
  public ComponentEMatcher getComponentEMatcher() throws IncQueryException {
    return ComponentEMatcher.on(engine);
  }
  
  public ComponentDMatcher getComponentDMatcher() throws IncQueryException {
    return ComponentDMatcher.on(engine);
  }
  
  public ComponentJMatcher getComponentJMatcher() throws IncQueryException {
    return ComponentJMatcher.on(engine);
  }
  
  public ComponentFMatcher getComponentFMatcher() throws IncQueryException {
    return ComponentFMatcher.on(engine);
  }
  
  public ComponentBMatcher getComponentBMatcher() throws IncQueryException {
    return ComponentBMatcher.on(engine);
  }
}
