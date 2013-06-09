package org.jnect.demo.incquery.viatra.cep.events;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class SSPattern extends AtomicEventPatternImpl{
	public SSPattern() {
		super();
		setType(SS.class.getCanonicalName());
		setId("SSPattern");
	}
}
