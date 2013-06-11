package org.jnect.demo.incquery.viatra.cep.patterns;

import org.jnect.demo.incquery.viatra.cep.events.FS;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class FSPattern extends AtomicEventPatternImpl{
	public FSPattern() {
		super();
		setType(FS.class.getCanonicalName());
		setId("FSPattern");
	}
}
