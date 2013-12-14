package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentJ_IQPattern extends AtomicEventPatternImpl {
  public ComponentJ_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentJ_IQEvent.class.getCanonicalName());
    setId("ComponentJ_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
