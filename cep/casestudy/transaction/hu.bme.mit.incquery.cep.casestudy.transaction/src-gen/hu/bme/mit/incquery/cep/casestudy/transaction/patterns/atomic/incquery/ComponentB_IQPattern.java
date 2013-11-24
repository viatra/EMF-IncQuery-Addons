package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentB_IQPattern extends AtomicEventPatternImpl {
  public ComponentB_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_IQEvent.class.getCanonicalName());
    setId("ComponentB_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
