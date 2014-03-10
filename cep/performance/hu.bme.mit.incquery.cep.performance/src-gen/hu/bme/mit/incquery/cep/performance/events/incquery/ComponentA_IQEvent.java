package hu.bme.mit.incquery.cep.performance.events.incquery;

import hu.bme.mit.incquery.cep.api.ParameterizableIncQueryPatternEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentA_IQEvent extends ParameterizableIncQueryPatternEventInstance {
  public ComponentA_IQEvent(final IEventSource eventSource) {
    super(eventSource);
    
  }
}
