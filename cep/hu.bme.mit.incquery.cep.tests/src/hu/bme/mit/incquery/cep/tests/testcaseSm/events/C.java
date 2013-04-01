package hu.bme.mit.incquery.cep.tests.testcaseSm.events;

import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.EventImpl;

public class C extends EventImpl {
	
	public C(IEventSource eventSource) {
		super();
		setEventSource(eventSource);
		setId("hu.bme.mit.incquery.cep.tests.testcaseSm.events.C");
	}
}
