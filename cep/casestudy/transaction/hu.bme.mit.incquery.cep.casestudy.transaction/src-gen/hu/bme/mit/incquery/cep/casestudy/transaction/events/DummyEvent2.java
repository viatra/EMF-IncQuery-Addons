package hu.bme.mit.incquery.cep.casestudy.transaction.events;

import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class DummyEvent2 extends ParameterizableEventInstance {
  public DummyEvent2(final IEventSource eventSource) {
    super(eventSource);
    
  }
}
