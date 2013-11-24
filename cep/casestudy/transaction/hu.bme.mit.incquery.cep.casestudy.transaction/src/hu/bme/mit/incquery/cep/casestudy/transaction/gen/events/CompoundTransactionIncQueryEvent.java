package hu.bme.mit.incquery.cep.casestudy.transaction.gen.events;

import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

public class CompoundTransactionIncQueryEvent extends ParameterizableEventInstance {

	private String transactionId;
	private String customerId;
	private long timestampA;
	private long timestampB;
	private long timestampC;

	public CompoundTransactionIncQueryEvent(final IEventSource eventSource) {
		super(eventSource);
		getParameters().add(transactionId);
		getParameters().add(customerId);
		getParameters().add(timestampA);
		getParameters().add(timestampB);
		getParameters().add(timestampC);
	}

	public void setTransactionId(final String transactionId) {
		this.transactionId = transactionId;
		getParameters().set(0, transactionId);
	}
	
	public void setCustomerId(final String customerId) {
		this.customerId = customerId;
		getParameters().set(1, customerId);
	}

	public void setTimestampA(final long timestampA) {
		this.timestampA = timestampA;
		getParameters().set(2, timestampA);
	}

	public void setTimestampB(final long timestampB) {
		this.timestampB = timestampB;
		getParameters().set(3, timestampB);
	}

	public void setTimestampC(final long timestampC) {
		this.timestampC = timestampC;
		getParameters().set(4, timestampC);
	}

	public String getTransactionId() {
		return transactionId;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public long getTimestampA() {
		return timestampA;
	}

	public long getTimestampB() {
		return timestampB;
	}

	public long getTimestampC() {
		return timestampC;
	}
}
