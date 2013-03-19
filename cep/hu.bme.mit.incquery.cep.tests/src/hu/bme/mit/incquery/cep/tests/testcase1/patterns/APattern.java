package hu.bme.mit.incquery.cep.tests.testcase1.patterns;

import hu.bme.mit.incquery.cep.tests.testcase1.events.A;
import hu.bme.mit.obsolete.incquery.cep.eventmodel.AtomicEventPattern;


public class APattern extends AtomicEventPattern {
	
	public APattern(Class<A> type) {
		super(type);
	}
}