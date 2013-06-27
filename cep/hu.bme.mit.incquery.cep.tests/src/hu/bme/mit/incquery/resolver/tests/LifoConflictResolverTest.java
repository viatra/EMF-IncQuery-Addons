package hu.bme.mit.incquery.resolver.tests;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import hu.bme.mit.incquery.resolver.LifoConflictResolver;

import java.util.Collections;
import java.util.List;

import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.ConflictSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class LifoConflictResolverTest {

	private LifoConflictResolver resolver;
	private ConflictSet conflictSet;
	private List<Activation<?>> activationsToBeInserted;

	@Before
	public void setUp() {
		resolver = new LifoConflictResolver();
		conflictSet = resolver.createConflictSet();
		prepareConflictSet();
	}

	@After
	public void tearDown() {
		resolver = null;
		conflictSet = null;
		activationsToBeInserted = null;
	}

	@SuppressWarnings("unchecked")
	private void prepareConflictSet() {
		Activation<?> mock1 = mock(Activation.class);
		Activation<?> mock2 = mock(Activation.class);
		Activation<?> mock3 = mock(Activation.class);

		activationsToBeInserted = Lists.newArrayList(mock1, mock2, mock3);

		conflictSet.addActivation(mock1);
		conflictSet.addActivation(mock2);
		conflictSet.addActivation(mock3);
	}

	@Test
	public void testInsertionOrder() {
		List<Activation<?>> conflictingActivations = Lists.newArrayList(conflictSet.getConflictingActivations());
		Collections.reverse(activationsToBeInserted);
		assertEquals(conflictingActivations, activationsToBeInserted);
	}

	@Test
	public void testGetConflictingActivationsAsSet() {
		Collections.reverse(activationsToBeInserted);

		while (conflictSet.getConflictingActivations().size() > 0) {
			List<Activation<?>> nextActivations = Lists.newArrayList(conflictSet.getNextActivations());
			assertEquals(1, nextActivations.size());
			assertTrue(conflictSet.removeActivation(nextActivations.get(0)));
			assertEquals(activationsToBeInserted.remove(0), nextActivations.get(0));
		}
	}

	@Test
	public void testGetConflictingActivationsAsSingleActivations() {
		Collections.reverse(activationsToBeInserted);

		while (conflictSet.getConflictingActivations().size() > 0) {
			Activation<?> nextActivation = conflictSet.getNextActivation();
			assertTrue(conflictSet.removeActivation(nextActivation));
			assertEquals(activationsToBeInserted.remove(0), nextActivation);
		}
	}

	@Test
	public void testAddAndRetrieve() {
		Collections.reverse(activationsToBeInserted);

		Activation<?> nextActivation = conflictSet.getNextActivation();
		assertEquals(activationsToBeInserted.remove(0), nextActivation);

		Activation<?> newActivationMockToBeAdded = mock(Activation.class);
		conflictSet.addActivation(newActivationMockToBeAdded);
		Activation<?> nextRetrievedActivation = conflictSet.getNextActivation();
		assertEquals(newActivationMockToBeAdded, nextRetrievedActivation);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullActivationRetrieval() {
		while(true){
			conflictSet.removeActivation(conflictSet.getNextActivation()); //throws IAE if there's no next activation
		}
	}
	
	@Test
	public void testEmptyList() {
		while(conflictSet.getNextActivation()!=null){
			conflictSet.removeActivation(conflictSet.getNextActivation());
		}
		
		assertNull(conflictSet.getNextActivation());
	}
}
