package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentA_Pattern extends AtomicEventPatternImpl {
  public ComponentA_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentA_Event.class.getCanonicalName());
    setId("ComponentA_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
