package hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery;

import hu.bme.mit.incquery.cep.api.ParameterizableIncQueryPatternEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentA_IQEvent extends ParameterizableIncQueryPatternEventInstance {
  private String transactionId;
  
  private String customerId;
  
  private long timestamp;
  
  public ComponentA_IQEvent(final IEventSource eventSource) {
    super(eventSource);
    getParameters().add(transactionId);
    getParameters().add(customerId);
    getParameters().add(timestamp);
    
  }
  
  public String getTransactionId() {
    return this.transactionId;
  }
  
  public void setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    getParameters().set(0, transactionId);
  }
  
  public String getCustomerId() {
    return this.customerId;
  }
  
  public void setCustomerId(final String customerId) {
    this.customerId = customerId;
    getParameters().set(1, customerId);
  }
  
  public long getTimestamp() {
    return this.timestamp;
  }
  
  public void setTimestamp(final long timestamp) {
    this.timestamp = timestamp;
    getParameters().set(2, timestamp);
  }
}
