package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.I;

public class IPattern extends AtomicEventPatternImpl {
	public IPattern() {
		super();
		setType(I.class.getCanonicalName());
		setId("IPattern");
	}
}
