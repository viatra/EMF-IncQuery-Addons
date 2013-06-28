package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.F;

public class FPattern extends AtomicEventPatternImpl {
	
	public FPattern() {
		super();
		setType(F.class.getCanonicalName());
		setId("FPattern");
	}
}