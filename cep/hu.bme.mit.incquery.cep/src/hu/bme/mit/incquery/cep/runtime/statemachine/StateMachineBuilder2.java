package hu.bme.mit.incquery.cep.runtime.statemachine;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Action;
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
import java.util.List;

public class StateMachineBuilder2 {
	
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	private InternalExecutionModel model;
	private List<AtomicEventPattern> flattenedAtomicEventPatterns;
	private InitState initState;
	private FinalState finalState;
	private Action action;
	private StateMachine sm;
	
	public StateMachineBuilder2(InternalExecutionModel model) {
		this.model = model;
	}
	
	public void buildStateMachine(EventPattern eventPattern) {
		sm = SM_FACTORY.createStateMachine();
		
		action = SM_FACTORY.createAction();
		action.setMsgToLog("\t\tCEP: Event pattern " + eventPattern.getId() + " recognized");
		
		flattenedAtomicEventPatterns = SMUtils.flattenComplexPatterns(eventPattern);
		
		buildInitialTrace();
		buildAlternativeTraces();
		
		sm.setEventPattern(eventPattern);
		model.getStateMachines().add(sm);
	}
	
	private void buildAlternativeTraces() {
		State currentState = finalState;
		
		while (!(currentState.equals(initState) && getAvailableAtomicEventPatterns(currentState).isEmpty())) {
			if (currentState instanceof FinalState) {
				currentState = stepBack(currentState);
				continue;
			}
			
			List<State> states = new ArrayList<State>();
			
			while (getAvailableAtomicEventPatterns(currentState).isEmpty()) {
				currentState = stepBack(currentState);
				if (currentState.equals(initState) && getAvailableAtomicEventPatterns(currentState).isEmpty()) {
					return;
				}
			}
			
			List<String> availableAtomicEventPatterns = new ArrayList<String>();
			availableAtomicEventPatterns.addAll(getAvailableAtomicEventPatterns(currentState));
			
			while (!availableAtomicEventPatterns.isEmpty()) {
				String nextEventType = getAvailableAtomicEventPatterns(currentState).get(0);
				
				State foundState = findTrace(currentState, nextEventType);
				if (foundState == null) {
					State nextState = SM_FACTORY.createState();
					states.add(nextState);
					createTransition(currentState, nextState, createEventGuard(nextEventType));
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
				finalState.getActions().add(action);
				states.add(finalState);
				
				createTransition(latestState, finalState, createEventGuard(ep));
			}
		}
		
		sm.getStates().addAll(states);
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
		
		for (AtomicEventPattern ep : flattenedAtomicEventPatterns) {
			if (!getUsedAtomicEventPatterns(state).contains(ep.getType())) {
				if (!appearsOnOutTransition(ep.getType(), state)) {
					events.add(ep.getType());
				}
			}
		}
		return events;
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
}