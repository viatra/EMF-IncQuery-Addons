package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class DummyEvent22Pattern extends AtomicEventPatternImpl {
  public DummyEvent22Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.DummyEvent22.class.getCanonicalName());
    setId("DummyEvent22Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
