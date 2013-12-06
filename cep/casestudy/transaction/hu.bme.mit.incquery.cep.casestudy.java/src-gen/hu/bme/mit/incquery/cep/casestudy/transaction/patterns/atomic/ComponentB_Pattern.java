package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentB_Pattern extends AtomicEventPatternImpl {
  public ComponentB_Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB_Event.class.getCanonicalName());
    setId("ComponentB_Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
