package hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery;

import hu.bme.mit.incquery.cep.api.ParameterizableIncQueryPatternEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

@SuppressWarnings("all")
public class ComponentC_Appeared_IQEvent extends ParameterizableIncQueryPatternEventInstance {
  private String transactionId;
  
  private String supplierId;
  
  public ComponentC_Appeared_IQEvent(final IEventSource eventSource) {
    super(eventSource);
    getParameters().add(transactionId);
    getParameters().add(supplierId);
    
  }
  
  public String getTransactionId() {
    return this.transactionId;
  }
  
  public void setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
    getParameters().set(0, transactionId);
  }
  
  public String getSupplierId() {
    return this.supplierId;
  }
  
  public void setSupplierId(final String supplierId) {
    this.supplierId = supplierId;
    getParameters().set(1, supplierId);
  }
}
