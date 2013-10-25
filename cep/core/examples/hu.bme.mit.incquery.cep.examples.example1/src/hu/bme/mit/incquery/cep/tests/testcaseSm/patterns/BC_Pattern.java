package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

import java.util.ArrayList;
import java.util.List;

public class BC_Pattern extends ComplexEventPatternImpl {
	public BC_Pattern() {
		super();
		setOperator(ComplexOperator.ORDERED);
		List<EventPattern> atomicEventPatternsForCP = new ArrayList<EventPattern>();
		atomicEventPatternsForCP.add(new BPattern());
		atomicEventPatternsForCP.add(new CPattern());
		getCompositionEvents().addAll(atomicEventPatternsForCP);
		setId("BCPattern");
	}
}
