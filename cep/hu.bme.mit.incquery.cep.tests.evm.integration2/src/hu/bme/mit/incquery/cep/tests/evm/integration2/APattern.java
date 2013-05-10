package hu.bme.mit.incquery.cep.tests.evm.integration2;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class APattern extends AtomicEventPatternImpl {
	
	public APattern() {
		super();
		setType(A.class.getCanonicalName());
		setId("APattern");
	}
}