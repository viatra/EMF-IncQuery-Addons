package hu.bme.mit.incquery.cep.tests;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		AtomicEventPattern atomicEventPattern = mock(AtomicEventPattern.class);
		when(guard.getEventType()).thenReturn(atomicEventPattern);
		when(atomicEventPattern.getType()).thenReturn("testTheSame");
		Event event = mock(Event.class);
		
		when(event.getType()).thenReturn("testTheSame");
		assertTrue(SMUtils.isEnabled(transition, event));
		
		when(event.getType()).thenReturn("testTheDifferent");
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
	public void flattenEventPatternsTest() {
		//TODO unordered+mixed case
		ComplexEventPattern rootPattern = mock(ComplexEventPattern.class);
		ComplexEventPattern c1 = mock(ComplexEventPattern.class);
		ComplexEventPattern c2 = mock(ComplexEventPattern.class);
		ComplexEventPattern c3 = mock(ComplexEventPattern.class);
		
		List<AtomicEventPattern> baseAtomicEventPatternList = prepareAtomicEventPatterns();
		
		for(int i=0; i<10; i++){
			List<AtomicEventPattern> atomicEventPatterns = new ArrayList<AtomicEventPattern>(baseAtomicEventPatternList);
			Collections.shuffle(atomicEventPatterns);
			List<AtomicEventPattern> referenceListOfPatterns = new ArrayList<AtomicEventPattern>(atomicEventPatterns);
			
			BasicEList<EventPattern> c1Components = new BasicEList<EventPattern>();
			c1Components.add(atomicEventPatterns.remove(0));
			c1Components.add(atomicEventPatterns.remove(0));
			when(c1.getCompositionEvents()).thenReturn(c1Components);
			when(c1.getOperator()).thenReturn(ComplexOperator.ORDERED);
			
			BasicEList<EventPattern> c2Components = new BasicEList<EventPattern>();
			c1Components.add(c3);
			c1Components.add(atomicEventPatterns.remove(0));
			when(c2.getCompositionEvents()).thenReturn(c2Components);
			when(c2.getOperator()).thenReturn(ComplexOperator.ORDERED);
			
			BasicEList<EventPattern> c3Components = new BasicEList<EventPattern>();
			c1Components.add(atomicEventPatterns.remove(0));
			c1Components.add(atomicEventPatterns.remove(0));
			when(c3.getCompositionEvents()).thenReturn(c3Components);
			when(c3.getOperator()).thenReturn(ComplexOperator.ORDERED);
			
			BasicEList<EventPattern> rootComponents = new BasicEList<EventPattern>();
			rootComponents.add(c1);
			rootComponents.add(c2);
			when(rootPattern.getCompositionEvents()).thenReturn(rootComponents);
			when(rootPattern.getOperator()).thenReturn(ComplexOperator.ORDERED);
			
			List<AtomicEventPattern> flattenedList = SMUtils.flattenEventPatterns(rootPattern);
			
			for (AtomicEventPattern atomicEventPattern : flattenedList) {
				//System.out.println(atomicEventPattern.getId() + " -- " + referenceListOfPatterns.remove(0).getId());
				assertEquals(referenceListOfPatterns.remove(0).getId(), atomicEventPattern.getId());
			}
		}
		
	}
	
	private List<AtomicEventPattern> prepareAtomicEventPatterns(){
		List<AtomicEventPattern> atomicEvents = new ArrayList<AtomicEventPattern>();
		
		AtomicEventPattern a1 = mock(AtomicEventPattern.class);
		when(a1.getId()).thenReturn("a1");
		atomicEvents.add(a1);
		
		AtomicEventPattern a2 = mock(AtomicEventPattern.class);
		when(a2.getId()).thenReturn("a2");
		atomicEvents.add(a2);
		
		AtomicEventPattern a3 = mock(AtomicEventPattern.class);
		when(a3.getId()).thenReturn("a3");
		atomicEvents.add(a3);
		
		AtomicEventPattern a4 = mock(AtomicEventPattern.class);
		when(a4.getId()).thenReturn("a4");
		atomicEvents.add(a4);
		
		AtomicEventPattern a5 = mock(AtomicEventPattern.class);
		when(a5.getId()).thenReturn("a5");
		atomicEvents.add(a5);
		
		return atomicEvents;
	}
}
