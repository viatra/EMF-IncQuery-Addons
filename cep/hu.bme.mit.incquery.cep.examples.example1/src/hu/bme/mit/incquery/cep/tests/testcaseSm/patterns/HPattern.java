package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.H;

public class HPattern extends AtomicEventPatternImpl {
	
	public HPattern() {
		super();
		setType(H.class.getCanonicalName());
		setId("HPattern");
	}
}