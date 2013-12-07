package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentM_Pattern extends AtomicEventPatternImpl {
  public ComponentM_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentM_Event.class.getCanonicalName());
    setId("ComponentM_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
