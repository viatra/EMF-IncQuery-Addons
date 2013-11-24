package hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery;

import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentA_IQEvent extends ParameterizableEventInstance {
  private String transactionId;
  
  private long timestamp;
  
  private String customerId;
  
  public ComponentA_IQEvent(final IEventSource eventSource) {
    super(eventSource);
    getParameters().add(transactionId);
    getParameters().add(timestamp);
    getParameters().add(customerId);
    
  }
  
  public String getTransactionId() {
    return this.transactionId;
  }
  
  public void setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    getParameters().set(0, transactionId);
  }
  
  public long getTimestamp() {
    return this.timestamp;
  }
  
  public void setTimestamp(final long timestamp) {
    this.timestamp = timestamp;
    getParameters().set(1, timestamp);
  }
  
  public String getCustomerId() {
    return this.customerId;
  }
  
  public void setCustomerId(final String customerId) {
    this.customerId = customerId;
    getParameters().set(2, customerId);
  }
}
