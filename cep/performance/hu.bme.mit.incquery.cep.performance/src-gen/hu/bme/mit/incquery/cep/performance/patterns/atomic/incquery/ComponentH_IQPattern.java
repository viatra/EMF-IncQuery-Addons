package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentH_IQPattern extends AtomicEventPatternImpl {
  public ComponentH_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentH_IQEvent.class.getCanonicalName());
    setId("ComponentH_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
