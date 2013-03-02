package hu.bme.mit.incquery.cep.tests.testcase1.patterns;

import hu.bme.mit.incquery.cep.eventmodel.AtomicEventPattern;
import hu.bme.mit.incquery.cep.tests.testcase1.events.B;


public class BPattern extends AtomicEventPattern {
	
	public BPattern(Class<B> type) {
		super(type);
	}
	
}
