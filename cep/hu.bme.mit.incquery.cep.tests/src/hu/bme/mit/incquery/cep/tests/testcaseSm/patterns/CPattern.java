package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class CPattern extends AtomicEventPatternImpl {
	public CPattern() {
		super();
		setType(C.class);
	}
}
