package hu.bme.mit.incquery.cep.tests.testcase1.patterns;

import hu.bme.mit.incquery.cep.tests.testcase1.events.B;
import hu.bme.mit.obsolete.incquery.cep.eventmodel.AtomicEventPattern;


public class BPattern extends AtomicEventPattern {
	
	public BPattern(Class<B> type) {
		super(type);
	}
	
}
