package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentL_Pattern extends AtomicEventPatternImpl {
  public ComponentL_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentL_Event.class.getCanonicalName());
    setId("ComponentL_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
