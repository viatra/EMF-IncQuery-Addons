package hu.bme.mit.incquery.cep.tests.testcase1.patterns;

import hu.bme.mit.obsolete.incquery.cep.eventmodel.ComplexEventPattern;
import hu.bme.mit.obsolete.incquery.cep.eventmodel.ComplexOperator;
import hu.bme.mit.obsolete.incquery.cep.eventmodel.IEventPattern;

import java.util.List;

public class ABPattern extends ComplexEventPattern {
	
	public ABPattern(List<IEventPattern> compositionEventPatterns) {
		super(compositionEventPatterns, ComplexOperator.ORDERED);
	}
	
}
