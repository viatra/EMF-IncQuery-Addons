package org.jnect.demo.incquery.viatra.cep.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

import org.jnect.demo.incquery.viatra.cep.events.FE_found;

public class FEFoundPattern extends AtomicEventPatternImpl{
	public FEFoundPattern() {
		super();
		setType(FE_found.class.getCanonicalName());
		setId("FEFoundPattern");
	}
}
