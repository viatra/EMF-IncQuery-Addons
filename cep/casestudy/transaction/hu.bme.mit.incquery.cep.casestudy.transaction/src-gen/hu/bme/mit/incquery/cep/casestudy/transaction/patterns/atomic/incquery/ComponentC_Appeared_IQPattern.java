package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.incquery;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentC_Appeared_IQPattern extends AtomicEventPatternImpl {
  public ComponentC_Appeared_IQPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_Appeared_IQEvent.class.getCanonicalName());
    setId("ComponentC_Appeared_IQPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
