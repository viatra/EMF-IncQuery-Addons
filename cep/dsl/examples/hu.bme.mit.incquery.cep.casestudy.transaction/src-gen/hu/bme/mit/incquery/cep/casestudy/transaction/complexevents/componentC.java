package hu.bme.mit.incquery.cep.casestudy.transaction.complexevents;

import hu.bme.mit.incquery.cep.api.AbstractEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class componentC extends AbstractEventInstance {
  public componentC(final IEventSource eventSource) {
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
  
  private String supplierId;
  
  public String getSupplierId() {
    return this.supplierId;
  }
  
  public void setSupplierId(final String supplierId) {
    this.supplierId = supplierId;
  }
}
