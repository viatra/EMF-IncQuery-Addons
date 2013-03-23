package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;

public class APattern extends AtomicEventPatternImpl {
	
	public APattern() {
		super();
		setType(A.class);
	}
}