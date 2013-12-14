package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentE_IQPattern extends AtomicEventPatternImpl {
  public ComponentE_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentE_IQEvent.class.getCanonicalName());
    setId("ComponentE_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
