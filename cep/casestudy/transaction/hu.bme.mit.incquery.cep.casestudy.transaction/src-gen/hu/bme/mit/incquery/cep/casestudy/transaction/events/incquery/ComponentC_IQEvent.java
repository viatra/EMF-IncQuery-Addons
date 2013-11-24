package hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery;

import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentC_IQEvent extends ParameterizableEventInstance {
  private String transactionId;
  
  private long timestamp;
  
  private String supplierId;
  
  public ComponentC_IQEvent(final IEventSource eventSource) {
    super(eventSource);
    getParameters().add(transactionId);
    getParameters().add(timestamp);
    getParameters().add(supplierId);
    
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
  
  public String getSupplierId() {
    return this.supplierId;
  }
  
  public void setSupplierId(final String supplierId) {
    this.supplierId = supplierId;
    getParameters().set(2, supplierId);
  }
}
