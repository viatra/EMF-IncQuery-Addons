package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentI_Pattern extends AtomicEventPatternImpl {
  public ComponentI_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentI_Event.class.getCanonicalName());
    setId("ComponentI_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
