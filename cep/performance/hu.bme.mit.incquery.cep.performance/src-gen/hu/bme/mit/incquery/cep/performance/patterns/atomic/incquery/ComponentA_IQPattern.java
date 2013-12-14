package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentA_IQPattern extends AtomicEventPatternImpl {
  public ComponentA_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentA_IQEvent.class.getCanonicalName());
    setId("ComponentA_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
