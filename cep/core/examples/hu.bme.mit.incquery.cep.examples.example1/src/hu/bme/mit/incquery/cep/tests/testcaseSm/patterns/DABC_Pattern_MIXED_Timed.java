package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

import java.util.ArrayList;
import java.util.List;

public class DABC_Pattern_MIXED_Timed extends ComplexEventPatternImpl {
	public DABC_Pattern_MIXED_Timed() {
		super();
		setOperator(ComplexOperator.ORDERED);
		List<EventPattern> atomicEventPatternsForCP = new ArrayList<EventPattern>();
		atomicEventPatternsForCP.add(new DPattern());
		atomicEventPatternsForCP.add(new ABC_Pattern_UNORDERED_Timed());
		getCompositionEvents().addAll(atomicEventPatternsForCP);
		GlobalTimewindow timewindow = CepFactory.eINSTANCE.createGlobalTimewindow();
		timewindow.setLength(1500l);
		setGlobalTimewindow(timewindow);
		setId("DABCPattern");
	}
}