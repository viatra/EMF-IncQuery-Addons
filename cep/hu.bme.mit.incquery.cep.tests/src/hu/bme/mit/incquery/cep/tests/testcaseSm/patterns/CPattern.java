package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;

public class CPattern extends AtomicEventPatternImpl {
	public CPattern() {
		super();
		setType(C.class);
		setId("CPattern");
	}
}
