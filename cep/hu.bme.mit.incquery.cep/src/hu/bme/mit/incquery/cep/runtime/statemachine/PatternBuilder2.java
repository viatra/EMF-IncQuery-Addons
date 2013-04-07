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
	
	protected final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	protected InternalExecutionModel model;
	
	public PatternBuilder2(InternalExecutionModel model) {
		this.model = model;
	}
	
	public void buildStateMachine(ComplexEventPattern eventPattern) {
		StateMachine sm = SM_FACTORY.createStateMachine();
		InitState initState = SM_FACTORY.createInitState();
		
		Action action = SM_FACTORY.createAction();
		action.setMsgToLog("\t\tCEP: Event pattern " + eventPattern.getId() + " recognized");
		
		sm.getStates().add(initState);
		
		List<AtomicEventPattern> flattenedAtomicEventPatterns = SMUtils.flattenComplexPatterns(eventPattern);
		List<State> states = new ArrayList<State>();
		
		State latestState = initState;
		
		for (AtomicEventPattern ep : flattenedAtomicEventPatterns) {
			if (!ep.equals(flattenedAtomicEventPatterns.get(flattenedAtomicEventPatterns.size() - 1))) {
				State currentState = createState(ep);
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
		model.getStateMachines().add(sm);
	}
	
	private FinalState createFinalState(AtomicEventPattern ep) {
		FinalState finalState = SM_FACTORY.createFinalState();
		finalState.setLabel("final");
		return finalState;
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
	
	private State createState(AtomicEventPattern atomicEventPattern) {
		State s = SM_FACTORY.createState();
		return s;
	}
	
	private Guard createEventGuard(AtomicEventPattern atomicEventPattern) {
		Guard g = SM_FACTORY.createGuard();
		g.setEventType(atomicEventPattern.getType());
		return g;
	}
	
	private boolean navigateTo(List<AtomicEventPattern> pathElements) {
		return false;
	}
}