package org.jnect.demo.incquery.viatra.cep.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

import org.jnect.demo.incquery.viatra.cep.events.FE_lost;

public class FELostPattern extends AtomicEventPatternImpl{
	public FELostPattern() {
		super();
		setType(FE_lost.class.getCanonicalName());
		setId("FELostPattern");
	}
}
