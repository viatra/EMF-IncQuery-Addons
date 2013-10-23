package hu.bme.mit.incquery.cep.casestudy.transaction.events;

import hu.bme.mit.incquery.cep.api.AbstractEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentB extends AbstractEventInstance {
  public ComponentB(final IEventSource eventSource) {
    super(eventSource);
  }
  
  private String transactionId;
  
  public String getTransactionId() {
    return this.transactionId;
  }
  
  private long timestamp;
  
  public long getTimestamp() {
    return this.timestamp;
  }
  
  public void setTimestamp(final long timestamp) {
    this.timestamp = timestamp;
  }
}
