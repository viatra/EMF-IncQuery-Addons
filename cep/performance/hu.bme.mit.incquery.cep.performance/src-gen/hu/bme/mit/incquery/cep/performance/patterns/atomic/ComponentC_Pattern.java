package hu.bme.mit.incquery.cep.performance.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentC_Pattern extends AtomicEventPatternImpl {
  public ComponentC_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.ComponentC_Event.class.getCanonicalName());
    setId("ComponentC_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
