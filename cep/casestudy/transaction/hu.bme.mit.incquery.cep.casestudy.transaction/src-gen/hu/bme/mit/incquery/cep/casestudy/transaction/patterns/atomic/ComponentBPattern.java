package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ComponentBPattern extends AtomicEventPatternImpl {
  public ComponentBPattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB.class.getCanonicalName());
    setId("ComponentBPattern");
  }
}
