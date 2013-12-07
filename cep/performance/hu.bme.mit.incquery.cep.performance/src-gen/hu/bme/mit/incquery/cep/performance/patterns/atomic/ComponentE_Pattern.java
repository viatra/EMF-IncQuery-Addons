package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentE_Pattern extends AtomicEventPatternImpl {
  public ComponentE_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentE_Event.class.getCanonicalName());
    setId("ComponentE_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
