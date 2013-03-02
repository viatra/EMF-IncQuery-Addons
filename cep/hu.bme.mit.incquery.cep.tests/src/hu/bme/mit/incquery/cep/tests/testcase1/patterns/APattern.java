package hu.bme.mit.incquery.cep.tests.testcase1.patterns;

import hu.bme.mit.incquery.cep.eventmodel.AtomicEventPattern;
import hu.bme.mit.incquery.cep.tests.testcase1.events.A;


public class APattern extends AtomicEventPattern {
	
	public APattern(Class<A> type) {
		super(type);
	}
}