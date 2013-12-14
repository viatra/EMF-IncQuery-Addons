package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentG_IQPattern extends AtomicEventPatternImpl {
  public ComponentG_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentG_IQEvent.class.getCanonicalName());
    setId("ComponentG_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
