package org.jnect.demo.incquery.viatra.cep.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

import java.util.ArrayList;
import java.util.List;

public class FS_FE_Pattern extends ComplexEventPatternImpl {
	public FS_FE_Pattern() {
		super();
		setOperator(ComplexOperator.ORDERED);
		List<EventPattern> atomicEventPatternsForCP = new ArrayList<EventPattern>();
		atomicEventPatternsForCP.add(new FEFoundPattern());
		atomicEventPatternsForCP.add(new FELostPattern());
		atomicEventPatternsForCP.add(new FSFoundPattern());
		atomicEventPatternsForCP.add(new FSLostPattern());
		eSet(CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS, atomicEventPatternsForCP);
		setId("FE_FS_Pattern");
	}
}
