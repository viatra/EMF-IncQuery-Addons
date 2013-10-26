package hu.bme.mit.incquery.cep.casestudy.transaction.events;

import com.google.common.collect.Lists;
import hu.bme.mit.incquery.cep.api.AbstractEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import java.util.List;

@SuppressWarnings("all")
public class ComponentC extends AbstractEventInstance {
  private List<Object> parameters = Lists.newArrayList();
  
  private String transactionId;
  
  private long timestamp;
  
  private String supplierId;
  
  public ComponentC(final IEventSource eventSource) {
    super(eventSource);
    parameters.add(transactionId);
    parameters.add(timestamp);
    parameters.add(supplierId);
    
  }
  
  public List<Object> getParameters() {
    return this.parameters;
  }
  
  public Object getParameter(final int i) {
    return parameters.get(i);
  }
  
  public String getTransactionId() {
    return this.transactionId;
  }
  
  public void setTransactionId(final String transactionId) {
    this.transactionId = transactionId;
  }
  
  public long getTimestamp() {
    return this.timestamp;
  }
  
  public void setTimestamp(final long timestamp) {
    this.timestamp = timestamp;
  }
  
  public String getSupplierId() {
    return this.supplierId;
  }
  
  public void setSupplierId(final String supplierId) {
    this.supplierId = supplierId;
  }
}
