package org.jnect.demo.incquery.viatra.cep.patterns;

import org.jnect.demo.incquery.viatra.cep.events.FS_lost;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl;

public class FSLostPattern extends AtomicEventPatternImpl{
	public FSLostPattern() {
		super();
		setType(FS_lost.class.getCanonicalName());
		setId("FSLostPattern");
	}
}
