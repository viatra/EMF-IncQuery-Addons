package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.G;

public class GPattern extends AtomicEventPatternImpl {
	public GPattern() {
		super();
		setType(G.class.getCanonicalName());
		setId("GPattern");
	}
}
