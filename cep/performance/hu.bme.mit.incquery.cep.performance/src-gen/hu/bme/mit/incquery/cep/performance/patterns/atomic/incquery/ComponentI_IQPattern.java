package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentI_IQPattern extends AtomicEventPatternImpl {
  public ComponentI_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentI_IQEvent.class.getCanonicalName());
    setId("ComponentI_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
