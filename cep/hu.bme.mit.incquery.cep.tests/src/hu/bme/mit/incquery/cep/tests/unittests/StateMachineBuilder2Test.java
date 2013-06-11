package hu.bme.mit.incquery.cep.tests.unittests;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assume.assumeNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;
import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;
import hu.bme.mit.incquery.cep.runtime.statemachine.StateMachineBuilder2;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@Ignore
@RunWith(Parameterized.class)
public class StateMachineBuilder2Test {

	private enum EventPatternType {
		ATOMIC, ORDERED, UNORDERED, MIXED;
	}

	@Parameters
	public static List<EventPatternType[]> data() {
		return Arrays.asList(new EventPatternType[][] { { EventPatternType.ATOMIC }, { EventPatternType.ORDERED },
				{ EventPatternType.UNORDERED }, { EventPatternType.MIXED } });
	}

	private StateMachineBuilder2 smBuilder;
	private InternalExecutionModel model;
	private EventPatternType eventPatternType;

	public StateMachineBuilder2Test(EventPatternType eventPatternType) {
		this.eventPatternType = eventPatternType;
	}

	@Before
	public void setUp() throws Exception {
		model = InternalsmFactory.eINSTANCE.createInternalExecutionModel();
	}

	@After
	public void tearDown() throws Exception {
		smBuilder = null;
		model = null;
		eventPatternType = null;
	}

	@Test
	public void testBuildStateMachine() {
		assumeNotNull(eventPatternType);

		EventPattern testEventPattern = getTestEventPattern(eventPatternType);
		assertNotNull(testEventPattern);

		int expected = calculateNumberOfStates(testEventPattern, eventPatternType);
		assertFalse(expected == 0);

		smBuilder = new StateMachineBuilder2(model, testEventPattern);
		StateMachine stateMachine = smBuilder.buildStateMachine();
		assertNotNull(stateMachine);

		Assert.assertEquals(expected, stateMachine.getStates().size());
	}

	private int calculateNumberOfStates(EventPattern pattern, EventPatternType type) {
		if (type.equals(EventPatternType.ATOMIC)) {
			return 1 + 2;
		}
		if (type.equals(EventPatternType.ORDERED)) {
			return SMUtils.flattenComplexPatterns(pattern).size() + 2;
		}
		if (type.equals(EventPatternType.UNORDERED)) {
			return (1 << SMUtils.flattenComplexPatterns(pattern).size()) + 1;
		}
		if (type.equals(EventPatternType.MIXED)) {
			return -1; // TODO
		}
		return 0;
	}

	private EventPattern getTestEventPattern(EventPatternType type) {
		EventPattern eventPattern = null;
		switch (type) {
		case ATOMIC:
			eventPattern = getAtomicPattern();
			break;
		case ORDERED:
			eventPattern = getOrderedPattern();
			break;
		case UNORDERED:
			eventPattern = getUnorderedPattern();
			break;
		case MIXED:
			eventPattern = getMixedPattern();
			break;
		}
		return eventPattern;
	}

	private EventPattern getAtomicPattern() {
		EventPattern eventPattern = mock(EventPattern.class, withSettings().extraInterfaces(InternalEObject.class));
		when(eventPattern.getId()).thenReturn("testPattern");

		EList<EventPattern> returnables = new BasicEList<EventPattern>();
		AtomicEventPattern atomicEventPattern = mock(AtomicEventPattern.class);
		returnables.add(atomicEventPattern);
		when(eventPattern.getCompositionEvents()).thenReturn(returnables);
		when(atomicEventPattern.getType()).thenReturn("test1");
		return eventPattern;
	}

	private EventPattern getOrderedPattern() {
		ComplexEventPattern complexEventPattern = mock(ComplexEventPattern.class, withSettings().extraInterfaces(InternalEObject.class));
		when(complexEventPattern.getOperator()).thenReturn(ComplexOperator.ORDERED);
		when(complexEventPattern.getId()).thenReturn("complexPattern1");

		AtomicEventPattern atomicEventPattern1 = mock(AtomicEventPattern.class);
		AtomicEventPattern atomicEventPattern2 = mock(AtomicEventPattern.class);
		AtomicEventPattern atomicEventPattern3 = mock(AtomicEventPattern.class);

		when(atomicEventPattern1.getType()).thenReturn("test1");
		when(atomicEventPattern1.getId()).thenReturn("atomicPattern1");
		when(atomicEventPattern2.getType()).thenReturn("test2");
		when(atomicEventPattern2.getId()).thenReturn("atomicPattern2");
		when(atomicEventPattern3.getType()).thenReturn("test3");
		when(atomicEventPattern3.getId()).thenReturn("atomicPattern3");
		when(atomicEventPattern1.eContainer()).thenReturn(complexEventPattern);
		when(atomicEventPattern2.eContainer()).thenReturn(complexEventPattern);
		when(atomicEventPattern3.eContainer()).thenReturn(complexEventPattern);

		EList<EventPattern> returnables2 = new BasicEList<EventPattern>();
		returnables2.add(atomicEventPattern1);
		returnables2.add(atomicEventPattern2);
		returnables2.add(atomicEventPattern3);
		when(complexEventPattern.getCompositionEvents()).thenReturn(returnables2);

		return complexEventPattern;
	}

	private EventPattern getUnorderedPattern() {
		ComplexEventPattern complexEventPattern = mock(ComplexEventPattern.class, withSettings().extraInterfaces(InternalEObject.class));
		when(complexEventPattern.getOperator()).thenReturn(ComplexOperator.UNORDERED);
		when(complexEventPattern.getId()).thenReturn("complexPattern1");

		AtomicEventPattern atomicEventPattern1 = mock(AtomicEventPattern.class);
		when(atomicEventPattern1.eContainer()).thenReturn(complexEventPattern);
		AtomicEventPattern atomicEventPattern2 = mock(AtomicEventPattern.class);
		when(atomicEventPattern2.eContainer()).thenReturn(complexEventPattern);
		AtomicEventPattern atomicEventPattern3 = mock(AtomicEventPattern.class);

		when(atomicEventPattern1.getType()).thenReturn("test1");
		when(atomicEventPattern1.getId()).thenReturn("atomicPattern1");
		when(atomicEventPattern2.getType()).thenReturn("test2");
		when(atomicEventPattern2.getId()).thenReturn("atomicPattern2");
		when(atomicEventPattern3.getType()).thenReturn("test3");
		when(atomicEventPattern3.getId()).thenReturn("atomicPattern3");
		when(atomicEventPattern1.eContainer()).thenReturn(complexEventPattern);
		when(atomicEventPattern2.eContainer()).thenReturn(complexEventPattern);
		when(atomicEventPattern3.eContainer()).thenReturn(complexEventPattern);

		EList<EventPattern> returnables2 = new BasicEList<EventPattern>();
		returnables2.add(atomicEventPattern1);
		returnables2.add(atomicEventPattern2);
		returnables2.add(atomicEventPattern3);
		when(complexEventPattern.getCompositionEvents()).thenReturn(returnables2);

		return complexEventPattern;
	}

	private EventPattern getMixedPattern() {
		return null;
	}

}