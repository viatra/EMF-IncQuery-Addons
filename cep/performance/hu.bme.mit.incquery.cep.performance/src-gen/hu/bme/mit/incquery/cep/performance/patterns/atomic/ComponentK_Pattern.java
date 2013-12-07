package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentK_Pattern extends AtomicEventPatternImpl {
  public ComponentK_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentK_Event.class.getCanonicalName());
    setId("ComponentK_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
