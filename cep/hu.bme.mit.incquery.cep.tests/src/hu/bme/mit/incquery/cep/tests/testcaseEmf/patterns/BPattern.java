package hu.bme.mit.incquery.cep.tests.testcaseEmf.patterns;

import hu.bme.mit.incquery.cep.model.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseEmf.events.B;

public class BPattern extends AtomicEventPatternImpl {
	public BPattern() {
		super();
		setType(B.class);
	}
}
