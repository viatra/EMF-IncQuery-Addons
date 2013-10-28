package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class DummyEvent2Pattern extends AtomicEventPatternImpl {
  public DummyEvent2Pattern() {
    super();
    setType(hu.bme.mit.incquery.cep.casestudy.transaction.events.DummyEvent2.class.getCanonicalName());
    setId("DummyEvent2Pattern");
    
  }
  
  public boolean checkStaticBindings() {
    return true;
  }
}
