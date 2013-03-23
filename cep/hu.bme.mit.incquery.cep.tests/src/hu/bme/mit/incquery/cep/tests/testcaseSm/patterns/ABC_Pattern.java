package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.incquery.cep.metamodels.cep.AbstractEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

public class ABC_Pattern extends ComplexEventPatternImpl {
	public ABC_Pattern() {
		super();
		setOperator(ComplexOperator.ORDERED);
		List<AbstractEventPattern> atomicEventPatternsForCP = new ArrayList<AbstractEventPattern>();
		atomicEventPatternsForCP.add(new APattern());
		atomicEventPatternsForCP.add(new BPattern());
		atomicEventPatternsForCP.add(new CPattern());
		eSet(CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS, atomicEventPatternsForCP);
	}
}