
import hu.bme.mit.incquery.cep.api.AbstractEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

import java.util.List;

import com.google.common.collect.Lists;

@SuppressWarnings("all")
public class ComponentA extends AbstractEventInstance {
	private List<Object> parameters = Lists.newArrayList();

	public Object getParameter(int i) {
		return parameters.get(i);
	}

	public List<Object> getParameters() {
		return parameters;
	}

	public ComponentA(final IEventSource eventSource) {
		super(eventSource);
		parameters.add(transactionId);
		parameters.add(timestamp);
		parameters.add(customerId);
	}

	private String transactionId;

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(final String transactionId) {
		this.transactionId = transactionId;
		parameters.set(0, transactionId);
	}

	private long timestamp;

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final long timestamp) {
		this.timestamp = timestamp;
		parameters.set(1, timestamp);
	}

	private String customerId;

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(final String customerId) {
		this.customerId = customerId;
		parameters.set(2, customerId);
	}
}
