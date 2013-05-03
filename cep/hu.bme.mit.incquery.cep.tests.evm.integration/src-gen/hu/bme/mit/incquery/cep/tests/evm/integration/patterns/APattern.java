package hu.bme.mit.incquery.cep.tests.evm.integration.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.evm.integration.events.A;

public class APattern extends AtomicEventPatternImpl {
	
	public APattern() {
		super();
		setType(A.class.getCanonicalName());
		setId("APattern");
	}
}