package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentA_Appeared_IQPattern extends AtomicEventPatternImpl {
  public ComponentA_Appeared_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_Appeared_IQEvent.class.getCanonicalName());
    setId("ComponentA_Appeared_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
