package hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentC_IQPattern extends AtomicEventPatternImpl {
  public ComponentC_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.performance.events.incquery.ComponentC_IQEvent.class.getCanonicalName());
    setId("ComponentC_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
