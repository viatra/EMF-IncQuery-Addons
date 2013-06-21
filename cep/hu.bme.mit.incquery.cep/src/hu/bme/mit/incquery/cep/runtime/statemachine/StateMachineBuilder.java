package hu.bme.mit.incquery.cep.runtime.statemachine;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StateMachineBuilder {

	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	private InternalExecutionModel model;
	private List<AtomicEventPattern> flattenedAtomicEventPatterns;
	private List<String> flattenedAtomicEventTypes;
	private InitState initState;
	private FinalState finalState;
	private StateMachine sm;
	private EventPattern rootPattern;

	public StateMachineBuilder(InternalExecutionModel model, EventPattern rootPattern) {
		this.model = model;
		this.rootPattern = rootPattern;
		model.eResource().getContents().add(rootPattern);
	}

	public StateMachine buildStateMachine() {
		sm = SM_FACTORY.createStateMachine();

		flattenedAtomicEventPatterns = SMUtils.flattenEventPatterns(rootPattern);
		flattenedAtomicEventTypes = SMUtils.getFlattenedEventTypeList(flattenedAtomicEventPatterns);

		buildInitialTrace();
		if (flattenedAtomicEventPatterns.size() > 1) {
			buildAlternativeTraces();
		}

		sm.getStates().add(SM_FACTORY.createTrapState());

		sm.setEventPattern(rootPattern);
		model.getStateMachines().add(sm);

		return sm;
	}

	private void buildInitialTrace() {
		initState = SM_FACTORY.createInitState();
		sm.getStates().add(initState);

		List<State> states = new ArrayList<State>();
		State latestState = initState;

		for (AtomicEventPattern ep : flattenedAtomicEventPatterns) {
			if (!ep.equals(flattenedAtomicEventPatterns.get(flattenedAtomicEventPatterns.size() - 1))) {
				State currentState = SM_FACTORY.createState();
				states.add(currentState);

				createTransition(latestState, currentState, createEventGuard(ep));

				latestState = currentState;
			}

			else {
				finalState = createFinalState(ep);
				states.add(finalState);

				createTransition(latestState, finalState, createEventGuard(ep));
			}
		}

		sm.getStates().addAll(states);
	}

	private void buildAlternativeTraces() {
		State currentState = finalState;

		while (!(currentState.equals(initState) && getAvailableAtomicEventPatterns(currentState).isEmpty())) {
			if (currentState instanceof FinalState) {
				currentState = stepBack(currentState);
			}

			List<State> states = new ArrayList<State>();
			List<AtomicEventPattern> availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);

			while (availableAtomicEventPatterns.isEmpty()) {
				currentState = stepBack(currentState);
				availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);
				if (availableAtomicEventPatterns.isEmpty() && currentState.equals(initState)) {
					return;
				}
			}

			availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);

			while (!availableAtomicEventPatterns.isEmpty()) {
				AtomicEventPattern nextEventPattern = getAvailableAtomicEventPatterns(currentState).get(0);

				State foundState = findTrace(currentState, nextEventPattern.getType());
				if (foundState == null) {
					State nextState = SM_FACTORY.createState();
					states.add(nextState);
					createTransition(currentState, nextState, createEventGuard(nextEventPattern));
					currentState = nextState;
					availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);
				} else if (foundState != null) {
					State nextState = foundState;
					createTransition(currentState, nextState, createEventGuard(nextEventPattern));
					availableAtomicEventPatterns.remove(nextEventPattern);
				}
			}

			sm.getStates().addAll(states);
		}
	}

	private FinalState createFinalState(AtomicEventPattern ep) {
		FinalState finalState = SM_FACTORY.createFinalState();
		finalState.setLabel("final");
		return finalState;
	}

	private State findTrace(State state, String nextEventType) {
		List<String> eventsToLookFor = getUsedAtomicEventPatterns(state);
		eventsToLookFor.add(nextEventType);

		for (State s : sm.getStates()) {
			List<String> usedEventPatterns = getUsedAtomicEventPatterns(s);
			if (!(usedEventPatterns.size() == eventsToLookFor.size())) {
				continue;
			}

			for (String e1 : eventsToLookFor) {
				usedEventPatterns.remove(e1);
			}

			if (usedEventPatterns.isEmpty()) {
				return s;
			}
		}

		return null;
	}

	private List<String> getUsedAtomicEventPatterns(State state) {
		List<String> events = new ArrayList<String>();
		State currentState = state;
		while (!(currentState instanceof InitState)) {
			String usedEvent = currentState.getInTransitions().get(0).getGuard().getEventType().getType();
			events.add(usedEvent);
			currentState = stepBack(currentState);
		}
		return events;
	}

	private List<AtomicEventPattern> getAvailableAtomicEventPatterns(State state) {
		List<AtomicEventPattern> events = new ArrayList<AtomicEventPattern>();

		for (AtomicEventPattern ep : flattenedAtomicEventPatterns) {
			if (isAvailable(ep, state)) {
				events.add(ep);
			}
		}
		return events;
	}
	
//	private List<AtomicEventPattern> getAvailableAtomicEventPatterns(State state) {
//		List<AtomicEventPattern> events = new ArrayList<AtomicEventPattern>();
//
//		for (AtomicEventPattern ep : flattenedAtomicEventPatterns) {
//			if (isAvailable(ep, state)) {
//				events.add(ep);
//			}
//		}
//		return events;
//	}

	private boolean isAvailable(AtomicEventPattern ep, State state) {
		if (appearsOnOutTransition(ep.getType(), state)) {
			return false;
		}
		
		List<String> usedAtomicEventPatterns = getUsedAtomicEventPatterns(state);
		int usedTimes = Collections.frequency(usedAtomicEventPatterns, ep.getType());
		
		int availableTimes = Collections.frequency(flattenedAtomicEventTypes, ep.getType());
		
		if(appearsOnOutTransition(ep.getType(), state)){
			usedTimes++;
		}
		
		if(!(usedTimes<availableTimes)){
			return false;
		}

		if (checkPrerequisites(ep, state)) {
			return true;
		}

		return false;
	}

	private boolean isRootPattern(EventPattern pattern) {
		if (pattern.getId().equals(rootPattern.getId())) {
			return true;
		}
		return false;
	}

	private boolean checkPrerequisites(EventPattern pattern, State state) {
		if (pattern.eContainer() == null || pattern.eContainer() instanceof AtomicEventPattern) {
			return false;
		}

		ComplexEventPattern cePattern = (ComplexEventPattern) pattern.eContainer();

		while (true) {
			if (cePattern == null) {
				break;
			}
			if (isOrdered(cePattern)) {
				List<EventPattern> compositionEvents = cePattern.getCompositionEvents();
				int patternPosition = getPatternPositionInContainerPattern(pattern);

				if (patternPosition == 0 && !isRootPattern(cePattern)) {
					continue;
				}

				for (int i = 0; i < patternPosition; i++) {
					EventPattern patternToCheck = compositionEvents.get(i);
					if (patternToCheck instanceof AtomicEventPattern) {
						if (!getUsedAtomicEventPatterns(state)
								.contains(((AtomicEventPattern) patternToCheck).getType())) {
							return false;
						}
					}
				}
			}

			if (isRootPattern(cePattern)) {
				break;
			}
			pattern = cePattern;
			cePattern = (ComplexEventPattern) cePattern.eContainer();
		}
		return true;
	}

	private int getPatternPositionInContainerPattern(EventPattern patternToFind) {
		if (isRootPattern(patternToFind)) {
			return 0;
		}
		ComplexEventPattern container = (ComplexEventPattern) patternToFind.eContainer();
		int patternPosition = 0;

		for (EventPattern ep : container.getCompositionEvents()) {
			if (ep.equals(patternToFind)) {
				break;
			}
			patternPosition++;
		}

		return patternPosition;
	}

	private boolean appearsOnOutTransition(String eventType, State state) {
		if (state.getOutTransitions().isEmpty()) {
			return false;
		}

		for (Transition t : state.getOutTransitions()) {
			if (t.getGuard().getEventType().getType().equalsIgnoreCase(eventType)) {
				return true;
			}
		}
		return false;
	}

	private State stepBack(State state) {
		return state.getInTransitions().get(0).getPreState();
	}

	private Transition createTransition(State preState, State postState, Guard guard) {
		Transition t = SM_FACTORY.createTransition();
		t.setGuard(guard);
		t.setPreState(preState);
		t.setPostState(postState);
		return t;
	}

	private Guard createEventGuard(AtomicEventPattern atomicEventPattern) {
		Guard g = SM_FACTORY.createGuard();
		g.setEventType(atomicEventPattern);
		return g;
	}

//	private Guard createEventGuard(String eventType) {
//		Guard g = SM_FACTORY.createGuard();
//		g.setEventType(eventType);
//		return g;
//	}

	private boolean isOrdered(ComplexEventPattern cePattern) {
		if (cePattern.getOperator().equals(ComplexOperator.ORDERED)
				|| cePattern.getOperator().equals(ComplexOperator.ORDERED_T)) {
			return true;
		}
		return false;
	}
}