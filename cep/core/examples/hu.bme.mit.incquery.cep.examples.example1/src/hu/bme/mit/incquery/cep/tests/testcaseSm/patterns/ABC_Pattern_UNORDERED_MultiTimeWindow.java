package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

import java.util.ArrayList;
import java.util.List;

public class ABC_Pattern_UNORDERED_MultiTimeWindow extends ComplexEventPatternImpl {
	public ABC_Pattern_UNORDERED_MultiTimeWindow() {
		super();
		setOperator(ComplexOperator.UNORDERED);
		List<EventPattern> atomicEventPatternsForCP = new ArrayList<EventPattern>();
		atomicEventPatternsForCP.add(new APattern());
		atomicEventPatternsForCP.add(new BPattern());
		atomicEventPatternsForCP.add(new CPattern());
		getCompositionEvents().addAll(atomicEventPatternsForCP);
		
		
		GlobalTimewindow timewindow = CepFactory.eINSTANCE.createGlobalTimewindow();
		timewindow.setLength(1500l);
		
		setGlobalTimewindow(timewindow);
		setId("ABCPattern");
	}
}