package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentAPattern extends AtomicEventPatternImpl {
  public ComponentAPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA.class.getCanonicalName());
    setId("ComponentAPattern");
  }
}
