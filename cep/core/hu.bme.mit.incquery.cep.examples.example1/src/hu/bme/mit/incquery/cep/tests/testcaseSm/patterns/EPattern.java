package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.E;

public class EPattern extends AtomicEventPatternImpl {
	
	public EPattern() {
		super();
		setType(E.class.getCanonicalName());
		setId("EPattern");
	}
}