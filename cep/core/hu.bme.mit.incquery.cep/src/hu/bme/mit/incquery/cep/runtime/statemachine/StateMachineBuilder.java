package hu.bme.mit.incquery.cep.runtime.statemachine;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventPatternAutomatonOptions;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.google.common.base.Strings;

public class StateMachineBuilder {

	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	private InternalExecutionModel model;
	private Map<AtomicEventPattern, List<Timewindow>> flattenedAtomicEventPatterns;
	private InitState initState;
	private FinalState finalState;
	private StateMachine sm;
	private EventPattern rootPattern;
	private Map<Timewindow, TimeConstraintSpecification> window2constraintSpecMapping;
	private EventPatternAutomatonOptions options;

	public StateMachineBuilder(InternalExecutionModel model, EventPattern rootPattern,
			EventPatternAutomatonOptions options) {
		this.model = model;
		this.rootPattern = rootPattern;
		model.eResource().getContents().add(rootPattern);
		window2constraintSpecMapping = new LinkedHashMap<Timewindow, TimeConstraintSpecification>();
		this.options = options;
	}

	public StateMachine buildStateMachine() {
		sm = SM_FACTORY.createStateMachine();

		flattenedAtomicEventPatterns = SMUtils.flattenEventPatternsWithTimewindows(rootPattern);

		buildInitialTrace();
		if (flattenedAtomicEventPatterns.size() > 1) {
			buildAlternativeTraces();
		}

		sm.getStates().add(SM_FACTORY.createTrapState());
		sm.setEventPattern(rootPattern);

		if (options != null) {
			sm.setNoiseFiltering(options.getNoiseFiltering());
			sm.setPriority(options.getPriority());
		}

		model.eResource().getContents().addAll(window2constraintSpecMapping.values());

		model.getStateMachines().add(sm);

		return sm;
	}

	private void buildInitialTrace() {
		initState = SM_FACTORY.createInitState();
		sm.getStates().add(initState);

		List<State> states = new ArrayList<State>();
		State latestState = initState;

		for (AtomicEventPattern ep : flattenedAtomicEventPatterns.keySet()) {
			if (!ep.equals(getLastElement(flattenedAtomicEventPatterns.keySet()))) {
				State currentState = SM_FACTORY.createState();
				states.add(currentState);

				createTransition(latestState, currentState, createEventGuard(ep));
				if (latestState.equals(initState)) {
					assignTimeConstraints(currentState, ep, TimeConstraintType.START);
				} else {
					assignTimeConstraints(currentState, ep);
				}

				latestState = currentState;
			}

			else {
				finalState = createFinalState(ep);
				assignTimeConstraints(finalState, ep, TimeConstraintType.STOP);
				states.add(finalState);

				createTransition(latestState, finalState, createEventGuard(ep));
			}
		}

		sm.getStates().addAll(states);
	}

	private void assignTimeConstraints(State currentState, AtomicEventPattern ep) {
		if (SMUtils.isFinal(currentState)) {
			assignTimeConstraints(currentState, ep, TimeConstraintType.STOP);
			return;
		} else
			assignTimeConstraints(currentState, ep, TimeConstraintType.CHECK);
	}

	private TimeConstraint createTimeConstraintForSpec(TimeConstraintSpecification tcs, TimeConstraintType type) {
		TimeConstraint timeConstraint = SM_FACTORY.createTimeConstraint();
		timeConstraint.setTimeConstraintSpecification(tcs);
		timeConstraint.setType(type);
		return timeConstraint;
	}

	private void assignTimeConstraints(State currentState, AtomicEventPattern ep, TimeConstraintType constraintType) {
		for (Timewindow timewindow : flattenedAtomicEventPatterns.get(ep)) {
			TimeConstraintSpecification timeConstraintSpecification = getRegisteredConstraintSpecForTimewindow(timewindow);

			if (timeConstraintSpecification == null) {
				timeConstraintSpecification = SM_FACTORY.createTimeConstraintSpecification();
				String id = registerWindow2ConstraintSpecMapping(timewindow, timeConstraintSpecification);
				timeConstraintSpecification.setId(id);
				timeConstraintSpecification.setExpectedLength(timewindow.getLength());
			}

			if (stateEquippedWithTheGivenTimeconstraintSpec(currentState, timeConstraintSpecification)) {
				continue;
			}

			TimeConstraint timeConstraint = createTimeConstraintForSpec(timeConstraintSpecification, constraintType);
			currentState.getTimeConstraints().add(timeConstraint);
			continue;
		}
	}

	private String registerWindow2ConstraintSpecMapping(Timewindow timewindow,
			TimeConstraintSpecification timeConstraintSpecification) {
		UUID uuid = UUID.randomUUID();
		window2constraintSpecMapping.put(timewindow, timeConstraintSpecification);
		return uuid.toString();
	}

	private boolean stateEquippedWithTheGivenTimeconstraintSpec(State currentState,
			TimeConstraintSpecification timeConstraintSpecification) {
		for (TimeConstraint tc : currentState.getTimeConstraints()) {
			if (tc.getTimeConstraintSpecification() == null) {
				continue;
			}
			if (tc.getTimeConstraintSpecification().getId().equalsIgnoreCase(timeConstraintSpecification.getId())) {
				return true;
			}
		}
		return false;
	}

	private TimeConstraintSpecification getRegisteredConstraintSpecForTimewindow(Timewindow timewindow) {
		for (Timewindow t : window2constraintSpecMapping.keySet()) {
			if (timewindow.equals(t)) {
				return window2constraintSpecMapping.get(t);
			}
		}

		return null;
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
			List<AtomicEventPattern> availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);

			while (availableAtomicEventPatterns.isEmpty()) {
				currentState = stepBack(currentState);
				availableAtomicEventPatterns = getAvailableAtomicEventPatterns(currentState);
				if (currentState.equals(initState) && availableAtomicEventPatterns.isEmpty()) {
					return;
				}
			}

			while (!availableAtomicEventPatterns.isEmpty()) {
				AtomicEventPattern nextEventType = getAvailableAtomicEventPatterns(currentState).get(0);

				State foundState = findTrace(currentState, nextEventType);
				if (foundState == null) {
					State nextState = SM_FACTORY.createState();
					states.add(nextState);
					createTransition(currentState, nextState, createEventGuard(nextEventType));

					assignTimeConstraints(nextState, nextEventType);

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

	private State findTrace(State state, AtomicEventPattern nextEventType) {
		List<AtomicEventPattern> eventsToLookFor = getUsedAtomicEventPatterns(state);
		eventsToLookFor.add(nextEventType);

		for (State s : sm.getStates()) {
			List<AtomicEventPattern> usedEventPatterns = getUsedAtomicEventPatterns(s);
			if (!(usedEventPatterns.size() == eventsToLookFor.size())) {
				continue;
			}

			for (AtomicEventPattern e1 : eventsToLookFor) {
				removeByType(usedEventPatterns, e1);
			}

			if (usedEventPatterns.isEmpty()) {
				return s;
			}
		}

		return null;
	}

	private void removeByType(List<AtomicEventPattern> collection, AtomicEventPattern element) {
		for (AtomicEventPattern ap : collection) {
			if (ap.getType().equalsIgnoreCase(element.getType())) {
				collection.remove(ap);
				return;
			}
		}
	}

	private List<AtomicEventPattern> getUsedAtomicEventPatterns(State state) {
		List<AtomicEventPattern> events = new ArrayList<AtomicEventPattern>();
		State currentState = state;
		while (!(currentState instanceof InitState)) {
			AtomicEventPattern usedEvent = currentState.getInTransitions().get(0).getGuard().getEventType();
			events.add(usedEvent);
			currentState = stepBack(currentState);
		}
		return events;
	}

	private List<AtomicEventPattern> getAvailableAtomicEventPatterns(State state) {
		List<AtomicEventPattern> events = new ArrayList<AtomicEventPattern>();

		for (AtomicEventPattern ep : flattenedAtomicEventPatterns.keySet()) {
			if (isAvailable(ep, state)) {
				if (getUsedTimes(events, ep) == 0) {
					events.add(ep);
				}
			}
		}
		return events;
	}

	private boolean isAvailable(AtomicEventPattern atomicEventPattern, State state) {
		if (appearsOnOutTransition(atomicEventPattern, state)) {
			return false;
		}

		List<AtomicEventPattern> usedAtomicEventPatterns = getUsedAtomicEventPatterns(state);
		int usedTimes = getUsedTimes(usedAtomicEventPatterns, atomicEventPattern);

		int availableTimes = getUsedTimes(flattenedAtomicEventPatterns.keySet(), atomicEventPattern);

		if (!(usedTimes < availableTimes)) {
			return false;
		}

		if (checkPrerequisites(atomicEventPattern, state)) {
			return true;
		}

		return false;
	}

	private int getUsedTimes(Collection<AtomicEventPattern> usedAtomicEventPatterns,
			AtomicEventPattern atomicEventPattern) {
		if (usedAtomicEventPatterns.isEmpty()) {
			return 0;
		}

		int count = 0;
		for (AtomicEventPattern ap : usedAtomicEventPatterns) {
			if (ap.getType().equalsIgnoreCase(atomicEventPattern.getType())) {
				count++;
			}
		}
		return count;
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
						if (!getUsedAtomicEventPatterns(state).contains(((AtomicEventPattern) patternToCheck))) {
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

	private boolean appearsOnOutTransition(AtomicEventPattern atomicEventPattern, State state) {
		if (state.getOutTransitions().isEmpty()) {
			return false;
		}

		for (Transition t : state.getOutTransitions()) {
			if (t.getGuard().getEventType().getType().equals(atomicEventPattern.getType())) {
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

		if ((postState instanceof FinalState) || (postState instanceof TrapState)) {
			return t;
		}

		String[] split = guard.getEventType().getType().split("\\.");
		String additionalEventType = split[split.length - 1];
		String postLabel = postState.getLabel();

		if (Strings.isNullOrEmpty(postLabel) || postLabel.equalsIgnoreCase("null")) {
			postState.setLabel("");
			postLabel = postState.getLabel();
		}

		String newLabel = "";

		// adding prestate label
		if (!(preState instanceof InitState)) {
			String preLabel = preState.getLabel();
			if (!Strings.isNullOrEmpty(preLabel)) {
				for (String s : Arrays.asList(preLabel.split(""))) {
					if (!postLabel.contains(s)) {
						newLabel += s;
					}
				}
			}
		}

		// adding transition
		if (!postLabel.contains(additionalEventType)) {
			newLabel += additionalEventType;
		}

		postState.setLabel(postLabel + newLabel);

		return t;
	}

	private Guard createEventGuard(AtomicEventPattern atomicEventPattern) {
		Guard g = SM_FACTORY.createGuard();
		g.setEventType(atomicEventPattern);
		return g;
	}

	private boolean isOrdered(ComplexEventPattern cePattern) {
		if (cePattern.getOperator().equals(ComplexOperator.ORDERED)
				|| cePattern.getOperator().equals(ComplexOperator.ORDERED_T)) {
			return true;
		}
		return false;
	}
}