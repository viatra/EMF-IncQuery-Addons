package hu.bme.mit.incquery.cep.tests.evm.integration.events;

import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.EventImpl;

public class AbstractEventInstance extends EventImpl {
	public AbstractEventInstance(IEventSource eventSource) {
		super();
		setEventSource(eventSource);
		setTypeId(this.getClass().getCanonicalName());
	}
}
