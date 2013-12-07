package hu.bme.mit.incquery.cep.performance.events;

import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentB_Event extends ParameterizableEventInstance {
  public ComponentB_Event(final IEventSource eventSource) {
    super(eventSource);
    
  }
}
