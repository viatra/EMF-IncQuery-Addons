package hu.bme.mit.incquery.cep.runtime.statemachine;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Action;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

public class AtomicPatternBuilder extends AbstractStateMachineBuilder<AtomicEventPattern> {
	
	public AtomicPatternBuilder(InternalExecutionModel model) {
		super(model);
	}
	
	@Override
	public void buildStateMachine(AtomicEventPattern eventPattern) {
		StateMachine sm = SM_FACTORY.createStateMachine();
		InitState initState = SM_FACTORY.createInitState();
		FinalState finalState = SM_FACTORY.createFinalState();
		finalState.setLabel("final");
		
		sm.getStates().add(initState);
		sm.getStates().add(finalState);
		
		Action action = SM_FACTORY.createAction();
		action.setMsgToLog("\t\tCEP: Event pattern " + eventPattern.getId() + " recognized");
		finalState.getActions().add(action);
		
		Transition t1 = SM_FACTORY.createTransition();
		Guard g1 = SM_FACTORY.createGuard();
		g1.setEventType(eventPattern.getType());
		t1.setGuard(g1);
		
		t1.setPostState(finalState);
		
		initState.getOutTransitions().add(t1);
		
		sm.setCurrentState(initState);
		
		sm.setEventPattern(eventPattern);
		
		model.getStateMachines().add(sm);
	}
}
