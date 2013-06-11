package hu.bme.mit.incquery.cep.tests.unittests;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.Assert;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;


public class SMUtilsTests {
	
	SMUtils smUtils;
	
	@Test
	public void isEnabledTest(){
		Transition transition= mock(Transition.class);
		Guard guard = mock(Guard.class);
		when(transition.getGuard()).thenReturn(guard);
		when(guard.getEventType()).thenReturn("testTheSame");
		Event event = mock(Event.class);
		
		when(event.getTypeId()).thenReturn("testTheSame");
		assertTrue(SMUtils.isEnabled(transition, event));
		
		when(event.getTypeId()).thenReturn("testTheDifferent");
		assertFalse(SMUtils.isEnabled(transition, event));
	}
	
	@Test
	public void isFinalTest(){
		FinalState finalMock = mock(FinalState.class);
		State nonFinalMock = mock(State.class);
		
		assertTrue(SMUtils.isFinal(finalMock));
		assertFalse(SMUtils.isFinal(nonFinalMock));
	}
	
	@Test
	public void getTrapStateTest(){
		StateMachine stateMachine = mock(StateMachine.class);
		TrapState trapState = mock(TrapState.class);
		EList<State> states = new BasicEList<State>();
		states.add(trapState);
		when(stateMachine.getStates()).thenReturn(states);
		
		assertSame(trapState, SMUtils.getTrapState(stateMachine));
		
		State nonTrapState = mock(State.class);
		states = new BasicEList<State>();
		states.add(nonTrapState);
		when(stateMachine.getStates()).thenReturn(states);
		
		assertNotSame(trapState, SMUtils.getTrapState(stateMachine));
		assertNull(SMUtils.getTrapState(stateMachine));
	}
	
	@Test
	public void flattenComplexPatternsTest() {
		fail("Not implemented yet.");
		//TODO
//		ComplexEventPattern ce = CepFactory.eINSTANCE.createComplexEventPattern();
//		ComplexEventPattern c1 = CepFactory.eINSTANCE.createComplexEventPattern();
//		ComplexEventPattern c2 = CepFactory.eINSTANCE.createComplexEventPattern();
//		ComplexEventPattern c3 = CepFactory.eINSTANCE.createComplexEventPattern();
//		
//		AtomicEventPattern a1 = CepFactory.eINSTANCE.createAtomicEventPattern();
//		a1.setId("a1");
//		AtomicEventPattern a2 = CepFactory.eINSTANCE.createAtomicEventPattern();
//		a2.setId("a2");
//		AtomicEventPattern a3 = CepFactory.eINSTANCE.createAtomicEventPattern();
//		a3.setId("a3");
//		AtomicEventPattern a4 = CepFactory.eINSTANCE.createAtomicEventPattern();
//		a4.setId("a4");
//		AtomicEventPattern a5 = CepFactory.eINSTANCE.createAtomicEventPattern();
//		a5.setId("a5");
//		
//		c1.getCompositionEvents().add(a1);
//		c1.getCompositionEvents().add(a5);
//		c1.setOperator(ComplexOperator.ORDERED);
//		
//		c2.getCompositionEvents().add(c3);
//		c2.getCompositionEvents().add(a2);
//		c2.setOperator(ComplexOperator.ORDERED);
//		
//		c3.getCompositionEvents().add(a3);
//		c3.getCompositionEvents().add(a4);
//		c3.setOperator(ComplexOperator.ORDERED);
//		
//		ce.getCompositionEvents().add(c1);
//		ce.getCompositionEvents().add(c2);
//		ce.setOperator(ComplexOperator.ORDERED);
//		
//		List<AtomicEventPattern> flattenedList = SMUtils.flattenComplexPatterns(ce);
//		
//		for (AtomicEventPattern atomicEventPattern : flattenedList) {
//			System.out.println(atomicEventPattern.getId());
//		}
	}
}
