package org.eclipse.incquery.cep.tests.testcase1.patterns;

import java.util.List;

import org.eclipse.incquery.cep.api.model.ComplexEventPattern;
import org.eclipse.incquery.cep.api.model.IEventPattern;

public class ABPattern extends ComplexEventPattern {
	
	public ABPattern(List<IEventPattern> compositionEventPatterns) {
		super(compositionEventPatterns);
	}
	
}
