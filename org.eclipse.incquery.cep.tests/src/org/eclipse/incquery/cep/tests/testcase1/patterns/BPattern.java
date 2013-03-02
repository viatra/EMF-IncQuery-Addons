package org.eclipse.incquery.cep.tests.testcase1.patterns;

import org.eclipse.incquery.cep.api.model.AtomicEventPattern;
import org.eclipse.incquery.cep.tests.testcase1.events.B;

public class BPattern extends AtomicEventPattern {
	
	public BPattern(Class<B> type) {
		super(type);
	}
	
}
