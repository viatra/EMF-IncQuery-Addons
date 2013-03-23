package hu.bme.mit.incquery.cep.tests.testcaseEmf.events;

import hu.bme.mit.incquery.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.metamodels.cep.impl.EventImpl;

public class A extends EventImpl {
	public A(IEventSource eventSource) {
		super();
		setEventSource(eventSource);
	}
}