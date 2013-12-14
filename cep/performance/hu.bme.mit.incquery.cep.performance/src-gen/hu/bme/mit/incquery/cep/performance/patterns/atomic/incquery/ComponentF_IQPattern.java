package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentF_IQPattern extends AtomicEventPatternImpl {
  public ComponentF_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentF_IQEvent.class.getCanonicalName());
    setId("ComponentF_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
