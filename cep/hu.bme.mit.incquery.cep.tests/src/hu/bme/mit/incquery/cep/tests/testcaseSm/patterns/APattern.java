package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class APattern extends AtomicEventPatternImpl {
	
	public APattern() {
		super();
		setType(A.class.getCanonicalName());
		setId("APattern");
	}
}