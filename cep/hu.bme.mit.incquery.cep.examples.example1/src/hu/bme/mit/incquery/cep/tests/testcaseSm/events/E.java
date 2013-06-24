package hu.bme.mit.incquery.cep.tests.testcaseSm.events;

import hu.bme.mit.incquery.cep.api.AbstractEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

public class E extends AbstractEventInstance {
	
	public E(IEventSource eventSource) {
		super(eventSource);
	}
}