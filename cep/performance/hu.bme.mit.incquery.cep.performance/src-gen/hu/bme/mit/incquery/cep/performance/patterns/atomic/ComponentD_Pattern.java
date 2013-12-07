package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentD_Pattern extends AtomicEventPatternImpl {
  public ComponentD_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentD_Event.class.getCanonicalName());
    setId("ComponentD_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
