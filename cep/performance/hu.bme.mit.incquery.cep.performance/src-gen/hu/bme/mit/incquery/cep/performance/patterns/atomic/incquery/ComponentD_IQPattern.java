package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentD_IQPattern extends AtomicEventPatternImpl {
  public ComponentD_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentD_IQEvent.class.getCanonicalName());
    setId("ComponentD_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
