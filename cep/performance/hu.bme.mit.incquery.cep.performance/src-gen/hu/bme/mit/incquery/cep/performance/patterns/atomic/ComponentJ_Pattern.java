package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentJ_Pattern extends AtomicEventPatternImpl {
  public ComponentJ_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentJ_Event.class.getCanonicalName());
    setId("ComponentJ_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
