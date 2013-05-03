package hu.bme.mit.incquery.cep.tests.evm.integration.events;

import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.evaluation.AbstractEventInstance;

public class A extends AbstractEventInstance {
	
	public A(IEventSource eventSource) {
		super(eventSource);
	}
}