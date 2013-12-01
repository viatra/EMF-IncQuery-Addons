package hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery;

import hu.bme.mit.incquery.cep.api.ParameterizableIncQueryPatternEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentB_IQEvent extends ParameterizableIncQueryPatternEventInstance {
  private String transactionId;
  
  public ComponentB_IQEvent(final IEventSource eventSource) {
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
