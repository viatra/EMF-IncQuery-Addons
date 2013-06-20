package hu.bme.mit.incquery.cep.runtime.statemachine;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Action;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class StateMachineBuilder2 {

	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	private InternalExecutionModel model;
	private List<String> flattenedAtomicEventTypes;
	private Map<AtomicEventPattern, List<Timewindow>> flattenedAtomicEventPatterns2;
	private InitState initState;
	private FinalState finalState;
	private Action action;
	private StateMachine sm;
	private EventPattern rootPattern;
	private Map<Timewindow, UUID> window2constraintMapping;

	public StateMachineBuilder2(InternalExecutionModel model, EventPattern rootPattern) {
		this.model = model;
		this.rootPattern = rootPattern;
		window2constraintMapping = new LinkedHashMap<Timewindow, UUID>();
	}

	public StateMachine buildStateMachine() {
		sm = SM_FACTORY.createStateMachine();

		action = SM_FACTORY.createAction();
		action.setMsgToLog("\t\tCEP: Event pattern " + rootPattern.getId() + " recognized");

		flattenedAtomicEventPatterns2 = SMUtils.flattenEventPatterns2(rootPattern);
		flattenedAtomicEventTypes = SMUtils.getFlattenedEventTypeList(flattenedAtomicEventPatterns2);

		buildInitialTrace();
		if (flattenedAtomicEventPatterns2.size() > 1) {
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

		for (AtomicEventPattern ep : flattenedAtomicEventPatterns2.keySet()) {
			if (!ep.equals(getLastElement(flattenedAtomicEventPatterns2.keySet()))) {
				State currentState = SM_FACTORY.createState();
				states.add(currentState);

				createTransition(latestState, currentState, createEventGuard(ep));
				if (latestState.equals(initState)) {
					createTimeConstraints(currentState, ep, TimeConstraintType.START);
				} else {
					createTimeConstraints(currentState, ep);
				}

				latestState = currentState;
			}

			else {
				finalState = createFinalState(ep);
				finalState.getActions().add(action);
				createTimeConstraints(finalState, ep, TimeConstraintType.STOP);
				states.add(finalState);

				createTransition(latestState, finalState, createEventGuard(ep));
			}
		}

		sm.getStates().addAll(states);
	}

	private void createTimeConstraints(State currentState, AtomicEventPattern ep) {
		if (SMUtils.isFinal(currentState)) {
			createTimeConstraints(currentState, ep, TimeConstraintType.STOP);
			return;
		} else
			createTimeConstraints(currentState, ep, TimeConstraintType.CHECK);
	}

	private void createTimeConstraints(State currentState, AtomicEventPattern ep, TimeConstraintType constraintType) {
		for (Timewindow timewindow : flattenedAtomicEventPatterns2.get(ep)) {
			TimeConstraint timeConstraint = SM_FACTORY.createTimeConstraint();
			timeConstraint.setId(getIdForTimewindow(timewindow));
			timeConstraint.setType(constraintType);
			timeConstraint.setExpectedLength(timewindow.getLength());
			currentState.getTimeConstraints().add(timeConstraint);
		}
	}

	private String getIdForTimewindow(Timewindow timewindow) {
		for (Timewindow t : window2constraintMapping.keySet()) {
			if (timewindow.equals(t)) {
				return window2constraintMapping.get(t).toString();
			}
		}

		UUID uuid = UUID.randomUUID();
		window2constraintMapping.put(timewindow, uuid);
		return uuid.toString();
	}

	private AtomicEventPattern getLastElement(Set<AtomicEventPattern> atomicEventPatterns) {
		Iterator<AtomicEventPattern> i = atomicEventPatterns.iterator();
		AtomicEventPattern lastElement = i.next();
		while (i.hasNext()) {
			lastElement = i.next();
		}
		return lastElement;
	}

	private void buildAlternativeTraces() {
		State currentState = finalState;

		while (!(currentState.equals(initState) && getAvailableAtomicEventPatterns(currentState).isEmpty())) {
			if (currentState instanceof FinalState) {
				currentState = stepBack(currentState);
			}

			List<State> states = new ArrayList<State>();
			List<String> availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);

			while (availableAtomicEventPatterns.isEmpty()) {
				currentState = stepBack(currentState);
				availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);
				if (currentState.equals(initState)) {
					return;
				}
			}

			while (!availableAtomicEventPatterns.isEmpty()) {
				String nextEventType = getAvailableAtomicEventPatterns(currentState).get(0);
				AtomicEventPattern nextAtomicEventPattern = getAvailableAtomicEventPatterns(currentState).get(0);

				State foundState = findTrace(currentState, nextEventType);
				if (foundState == null) {
					State nextState = SM_FACTORY.createState();
					states.add(nextState);
					createTransition(currentState, nextState, createEventGuard(nextEventType));
					
					createTimeConstraints(currentState, ep, TimeConstraintType.START);
					
					currentState = nextState;
					availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);
				} else if (foundState != null) {
					State nextState = foundState;
					createTransition(currentState, nextState, createEventGuard(nextEventType));
					availableAtomicEventPatterns.remove(nextEventType);
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
			String usedEvent = currentState.getInTransitions().get(0).getGuard().getEventType();
			events.add(usedEvent);
			currentState = stepBack(currentState);
		}
		return events;
	}

	private List<String> getAvailableAtomicEventPatterns(State state) {
		List<String> events = new ArrayList<String>();

		for (AtomicEventPattern ep : flattenedAtomicEventPatterns2.keySet()) {
			if (isAvailable(ep, state)) {
				events.add(ep.getType());
			}
		}
		return events;
	}
	
	private List<String> getAvailableAtomicEvents(State state) {
		List<String> events = new ArrayList<String>();

		for (AtomicEventPattern ep : flattenedAtomicEventPatterns2.keySet()) {
			if (isAvailable(ep, state)) {
				events.add(ep.getType());
			}
		}
		return events;
	}

	private boolean isAvailable(AtomicEventPattern ep, State state) {
		if (appearsOnOutTransition(ep.getType(), state)) {
			return false;
		}

		List<String> usedAtomicEventPatterns = getUsedAtomicEventPatterns(state);
		int usedTimes = Collections.frequency(usedAtomicEventPatterns, ep.getType());

		int availableTimes = Collections.frequency(flattenedAtomicEventTypes, ep.getType());

		if (appearsOnOutTransition(ep.getType(), state)) {
			usedTimes++;
		}

		if (!(usedTimes < availableTimes)) {
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
			if (t.getGuard().getEventType().equalsIgnoreCase(eventType)) {
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
		g.setEventType(atomicEventPattern.getType());
		return g;
	}

	private Guard createEventGuard(String eventType) {
		Guard g = SM_FACTORY.createGuard();
		g.setEventType(eventType);
		return g;
	}

	private boolean isOrdered(ComplexEventPattern cePattern) {
		if (cePattern.getOperator().equals(ComplexOperator.ORDERED)
				|| cePattern.getOperator().equals(ComplexOperator.ORDERED_T)) {
			return true;
		}
		return false;
	}

	private boolean isUnordered(ComplexEventPattern cePattern) {
		if (cePattern.getOperator().equals(ComplexOperator.UNORDERED)
				|| cePattern.getOperator().equals(ComplexOperator.UNORDERED_T)) {
			return true;
		}
		return false;
	}
}