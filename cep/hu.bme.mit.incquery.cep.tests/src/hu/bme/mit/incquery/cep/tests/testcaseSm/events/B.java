package hu.bme.mit.incquery.cep.tests.testcaseSm.events;

import hu.bme.mit.incquery.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.metamodels.cep.impl.EventImpl;

public class B extends EventImpl {
	
	public B(IEventSource eventSource) {
		super();
		setEventSource(eventSource);
	}
}