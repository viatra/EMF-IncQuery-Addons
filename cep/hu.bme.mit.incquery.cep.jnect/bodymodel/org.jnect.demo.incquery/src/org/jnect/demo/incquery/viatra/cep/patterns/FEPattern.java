package org.jnect.demo.incquery.viatra.cep.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

import org.jnect.demo.incquery.viatra.cep.events.FE;

public class FEPattern extends AtomicEventPatternImpl{
	public FEPattern() {
		super();
		setType(FE.class.getCanonicalName());
		setId("FEPattern");
	}
}
