package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.J;

public class JPattern extends AtomicEventPatternImpl {
	
	public JPattern() {
		super();
		setType(J.class.getCanonicalName());
		setId("JPattern");
	}
}