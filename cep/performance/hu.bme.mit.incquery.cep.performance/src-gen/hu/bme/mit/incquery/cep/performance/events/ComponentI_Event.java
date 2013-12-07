package hu.bme.mit.incquery.cep.performance.events;

import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentI_Event extends ParameterizableEventInstance {
  public ComponentI_Event(final IEventSource eventSource) {
    super(eventSource);
    
  }
}
