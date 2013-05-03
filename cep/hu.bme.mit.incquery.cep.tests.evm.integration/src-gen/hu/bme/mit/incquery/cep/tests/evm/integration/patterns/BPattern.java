package hu.bme.mit.incquery.cep.tests.evm.integration.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.evm.integration.events.B;

public class BPattern extends AtomicEventPatternImpl {
	public BPattern() {
		super();
		setType(B.class.getCanonicalName());
		setId("BPattern");
	}
}
