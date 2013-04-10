package hu.bme.mit.incquery.cep.tests.evm.integration.patterns;

import hu.bme.mit.incquery.cep.tests.evm.integration.events.C;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class CPattern extends AtomicEventPatternImpl {
	public CPattern() {
		super();
		setType(C.class.getCanonicalName());
		setId("CPattern");
	}
}
