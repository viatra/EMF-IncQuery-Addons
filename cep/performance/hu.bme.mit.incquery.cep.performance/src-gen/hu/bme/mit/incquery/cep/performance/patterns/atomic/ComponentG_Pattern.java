package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentG_Pattern extends AtomicEventPatternImpl {
  public ComponentG_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentG_Event.class.getCanonicalName());
    setId("ComponentG_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
