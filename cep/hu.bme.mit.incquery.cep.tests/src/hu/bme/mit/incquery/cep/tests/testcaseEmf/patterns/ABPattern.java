package hu.bme.mit.incquery.cep.tests.testcaseEmf.patterns;

import hu.bme.mit.incquery.metamodels.cep.AbstractEventPattern;
import hu.bme.mit.incquery.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.metamodels.cep.impl.ComplexEventPatternImpl;

import java.util.List;

public class ABPattern extends ComplexEventPatternImpl {
	public ABPattern(List<AbstractEventPattern> compositionEventPatterns) {
		super();
		setOperator(ComplexOperator.ORDERED);
		eSet(CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS, compositionEventPatterns);
	}
}
