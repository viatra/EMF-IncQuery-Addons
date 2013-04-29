package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.tests.testcaseSm.events.D;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class DPattern extends AtomicEventPatternImpl {
	public DPattern() {
		super();
		setType(D.class.getCanonicalName());
		setId("DPattern");
	}
}
