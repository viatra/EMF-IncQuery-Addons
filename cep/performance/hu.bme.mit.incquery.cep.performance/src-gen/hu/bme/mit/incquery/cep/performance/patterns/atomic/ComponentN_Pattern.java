package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentN_Pattern extends AtomicEventPatternImpl {
  public ComponentN_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentN_Event.class.getCanonicalName());
    setId("ComponentN_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
