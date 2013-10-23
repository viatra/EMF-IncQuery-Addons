package hu.bme.mit.incquery.cep.casestudy.transaction.events;

import hu.bme.mit.incquery.cep.api.AbstractEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentA extends AbstractEventInstance {
  public ComponentA(final IEventSource eventSource) {
    super(eventSource);
  }
  
  private String transactionId;
  
  public String getTransactionId() {
    return this.transactionId;
  }
  
  public void setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
  }
  
  private long timestamp;
  
  public long getTimestamp() {
    return this.timestamp;
  }
  
  public void setTimestamp(final long timestamp) {
    this.timestamp = timestamp;
  }
  
  private String customerId;
  
  public String getCustomerId() {
    return this.customerId;
  }
  
  public void setCustomerId(final String customerId) {
    this.customerId = customerId;
  }
}
