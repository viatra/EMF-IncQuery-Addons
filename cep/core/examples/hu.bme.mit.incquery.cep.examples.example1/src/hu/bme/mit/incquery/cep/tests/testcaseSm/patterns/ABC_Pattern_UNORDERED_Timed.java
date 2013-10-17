package hu.bme.mit.incquery.cep.tests.testcaseSm.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

import java.util.ArrayList;
import java.util.List;

public class ABC_Pattern_UNORDERED_Timed extends ComplexEventPatternImpl {
	public ABC_Pattern_UNORDERED_Timed() {
		super();
		setOperator(ComplexOperator.UNORDERED);
		List<EventPattern> atomicEventPatternsForCP = new ArrayList<EventPattern>();
		atomicEventPatternsForCP.add(new APattern());
		atomicEventPatternsForCP.add(new BPattern());
		atomicEventPatternsForCP.add(new CPattern());
		eSet(CepPackage.COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS, atomicEventPatternsForCP);
		Timewindow timewindow = CepFactory.eINSTANCE.createTimewindow();
		timewindow.setLength(2500l);
		eSet(CepPackage.COMPLEX_EVENT_PATTERN__TIMEWINDOW, timewindow);
		setId("ABCPattern");
	}
}