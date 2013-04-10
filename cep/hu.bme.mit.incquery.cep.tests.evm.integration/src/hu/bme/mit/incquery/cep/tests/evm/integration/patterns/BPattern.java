package hu.bme.mit.incquery.cep.tests.evm.integration.patterns;

import hu.bme.mit.incquery.cep.tests.evm.integration.events.B;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class BPattern extends AtomicEventPatternImpl {
	public BPattern() {
		super();
		setType(B.class.getCanonicalName());
		setId("BPattern");
	}
}
