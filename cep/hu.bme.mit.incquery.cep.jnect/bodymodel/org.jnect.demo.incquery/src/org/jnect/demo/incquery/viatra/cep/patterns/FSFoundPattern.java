package org.jnect.demo.incquery.viatra.cep.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

import org.jnect.demo.incquery.viatra.cep.events.FS_found;

public class FSFoundPattern extends AtomicEventPatternImpl{
	public FSFoundPattern() {
		super();
		setType(FS_found.class.getCanonicalName());
		setId("FSFoundPattern");
	}
}
