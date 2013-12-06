package hu.bme.mit.incquery.cep.casestudy.transaction.events;

import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentB_Event extends ParameterizableEventInstance {
  private String transactionId;
  
  public ComponentB_Event(final IEventSource eventSource) {
    super(eventSource);
    getParameters().add(transactionId);
    
  }
  
  public String getTransactionId() {
    return this.transactionId;
  }
  
  public void setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    getParameters().set(0, transactionId);
  }
}
