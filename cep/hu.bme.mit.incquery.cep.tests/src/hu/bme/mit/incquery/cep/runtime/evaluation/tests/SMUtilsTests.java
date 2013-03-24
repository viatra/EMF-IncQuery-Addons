package hu.bme.mit.incquery.cep.runtime.evaluation.tests;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;

import java.util.List;

import org.junit.Test;

public class SMUtilsTests {
	
	@Test
	public void test() {
		ComplexEventPattern ce = CepFactory.eINSTANCE.createComplexEventPattern();
		ComplexEventPattern c1 = CepFactory.eINSTANCE.createComplexEventPattern();
		ComplexEventPattern c2 = CepFactory.eINSTANCE.createComplexEventPattern();
		ComplexEventPattern c3 = CepFactory.eINSTANCE.createComplexEventPattern();
		
		AtomicEventPattern a1 = CepFactory.eINSTANCE.createAtomicEventPattern();
		a1.setId("a1");
		AtomicEventPattern a2 = CepFactory.eINSTANCE.createAtomicEventPattern();
		a2.setId("a2");
		AtomicEventPattern a3 = CepFactory.eINSTANCE.createAtomicEventPattern();
		a3.setId("a3");
		AtomicEventPattern a4 = CepFactory.eINSTANCE.createAtomicEventPattern();
		a4.setId("a4");
		AtomicEventPattern a5 = CepFactory.eINSTANCE.createAtomicEventPattern();
		a5.setId("a5");
		
		c1.getCompositionEvents().add(a1);
		c1.getCompositionEvents().add(a5);
		c1.setOperator(ComplexOperator.ORDERED);
		
		c2.getCompositionEvents().add(c3);
		c2.getCompositionEvents().add(a2);
		c2.setOperator(ComplexOperator.ORDERED);
		
		c3.getCompositionEvents().add(a3);
		c3.getCompositionEvents().add(a4);
		c3.setOperator(ComplexOperator.ORDERED);
		
		ce.getCompositionEvents().add(c1);
		ce.getCompositionEvents().add(c2);
		ce.setOperator(ComplexOperator.ORDERED);
		
		List<AtomicEventPattern> flattenedList = SMUtils.flattenComplexPatterns(ce);
		
		for (AtomicEventPattern atomicEventPattern : flattenedList) {
			System.out.println(atomicEventPattern.getId());
		}
	}
}
