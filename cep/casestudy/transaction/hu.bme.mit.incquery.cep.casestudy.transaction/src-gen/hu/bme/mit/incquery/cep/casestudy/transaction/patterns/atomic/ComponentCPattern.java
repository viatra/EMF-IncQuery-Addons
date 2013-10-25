package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentCPattern extends AtomicEventPatternImpl {
  public ComponentCPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC.class.getCanonicalName());
    setId("ComponentCPattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
