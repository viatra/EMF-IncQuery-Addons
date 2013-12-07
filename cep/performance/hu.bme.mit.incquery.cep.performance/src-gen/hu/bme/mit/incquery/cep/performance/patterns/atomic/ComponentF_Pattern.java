package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentF_Pattern extends AtomicEventPatternImpl {
  public ComponentF_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentF_Event.class.getCanonicalName());
    setId("ComponentF_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
