package org.eclipse.incquery.cep.tests.testcase1.patterns;

import org.eclipse.incquery.cep.api.model.AtomicEventPattern;
import org.eclipse.incquery.cep.tests.testcase1.events.A;

public class APattern extends AtomicEventPattern {
	
	public APattern(Class<A> type) {
		super(type);
	}
}