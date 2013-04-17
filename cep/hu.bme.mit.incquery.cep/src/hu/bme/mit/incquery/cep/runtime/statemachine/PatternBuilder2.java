package hu.bme.mit.incquery.cep.runtime.statemachine;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
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

public class PatternBuilder2 {
	
	private final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	private InternalExecutionModel model;
	private List<AtomicEventPattern> flattenedAtomicEventPatterns;
	private StateMachine sm;
	
	public PatternBuilder2(InternalExecutionModel model) {
		this.model = model;
	}
	
	public void buildStateMachine(ComplexEventPattern eventPattern) {
		sm = SM_FACTORY.createStateMachine();
		InitState initState = SM_FACTORY.createInitState();
		
		Action action = SM_FACTORY.createAction();
		action.setMsgToLog("\t\tCEP: Event pattern " + eventPattern.getId() + " recognized");
		
		sm.getStates().add(initState);
		
		flattenedAtomicEventPatterns = SMUtils.flattenComplexPatterns(eventPattern);
		List<State> states = new ArrayList<State>();
		
		// build initial trace
		State latestState = initState;
		
		for (AtomicEventPattern ep : flattenedAtomicEventPatterns) {
			if (!ep.equals(flattenedAtomicEventPatterns.get(flattenedAtomicEventPatterns.size() - 1))) {
				State currentState = createState();
				states.add(currentState);
				
				createTransition(latestState, currentState, createEventGuard(ep));
				
				latestState = currentState;
			}
			
			else {
				FinalState finalState = createFinalState(ep);
				finalState.getActions().add(action);
				states.add(finalState);
				
				createTransition(latestState, finalState, createEventGuard(ep));
			}
		}
		
		sm.getStates().addAll(states);
		
		State currentState = getFinalState();
		while (currentState != initState && !getAvailableAtomicEventPatterns(currentState).isEmpty()) {
			while (getAvailableAtomicEventPatterns(currentState).isEmpty()) {
				currentState = stepBack(currentState);
			}
			
			for (String nextEventType : getAvailableAtomicEventPatterns(currentState)) {
				State nextState = findOrCreateState(currentState, nextEventType);
				createTransition(currentState, nextState, createEventGuard(nextEventType));
				currentState = nextState;
			}
		}
		
		model.getStateMachines().add(sm);
	}
	private State findOrCreateState(State state, String nextEventType) {
		State foundState = findTrace(state, nextEventType);
		if (foundState != null) {
			return foundState;
		}
		
		return createState();
	}
	
	private FinalState createFinalState(AtomicEventPattern ep) {
		FinalState finalState = SM_FACTORY.createFinalState();
		finalState.setLabel("final");
		return finalState;
	}
	
	private FinalState getFinalState() {
		for (State state : sm.getStates()) {
			if (state instanceof FinalState) {
				return (FinalState) state;
			}
		}
		return null;
	}
	
	private State findTrace(State state, String nextEventType) {
		List<String> events = getUsedAtomicEventPatterns(state);
		events.add(nextEventType);
		
		return null;
	}
	
	private List<String> getUsedAtomicEventPatterns(State state) {
		List<String> events = new ArrayList<String>();
		State currentState = state;
		while (!(currentState instanceof InitState)) {
			String usedEvent = state.getInTransitions().get(0).getGuard().getEventType();
			events.add(usedEvent);
			currentState = state.getInTransitions().get(0).getPreState();
		}
		return events;
	}
	
	private List<String> getAvailableAtomicEventPatterns(State state) {
		List<String> events = new ArrayList<String>();
		for (AtomicEventPattern ep : flattenedAtomicEventPatterns) {
			if (!getUsedAtomicEventPatterns(state).contains(ep.getType())) {
				for (Transition t : state.getOutTransitions()) {
					if (!t.getGuard().getEventType().equalsIgnoreCase(ep.getType())) {
						events.add(ep.getType());
					}
				}
			}
		}
		return events;
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
	
	private State createState() {
		State s = SM_FACTORY.createState();
		return s;
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