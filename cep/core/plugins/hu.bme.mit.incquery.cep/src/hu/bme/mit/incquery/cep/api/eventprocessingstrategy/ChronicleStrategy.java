package hu.bme.mit.incquery.cep.api.eventprocessingstrategy;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

public class ChronicleStrategy extends AbstractEventProcessingStrategy {

    @Override
    public EventProcessingContext getContext() {
        return EventProcessingContext.CHRONICLE;
    }
    
	public ChronicleStrategy(EventModelManager eventModelManager) {
		super(eventModelManager);
	}

	@Override
	public void fireTransition(Transition t, EventToken eventTokenToMove) {
		State preState = t.getPreState();
		if (preState instanceof FinalState) {
			return;
		}

		InternalExecutionModel model = getEventModelManager().getModel();
		State nextState = t.getPostState();

		if (!handleTimeConstraints(eventTokenToMove, nextState)) {
			return;
		}
		eventTokenToMove.getRecordedEvents().add(model.getLatestEvent());
		preState.setLastProcessedEvent(model.getLatestEvent());
		eventTokenToMove.setCurrentState(nextState);
		getEventModelManager().callbackOnFiredToken(t, eventTokenToMove);
	}

	@Override
	public void handleInitTokenCreation(InternalExecutionModel model, InternalsmFactory SM_FACTORY,
			ObservedComplexEventPattern observedComplexEventPattern) {
		for (StateMachine sm : model.getStateMachines()) {
			for (State s : sm.getStates()) {
				if (s instanceof InitState) {
					if (s.getEventTokens().isEmpty()) {
						EventToken cv = SM_FACTORY.createEventToken();
						cv.setCurrentState(s);
						model.getEventTokens().add(cv);
					}
					break;
				}
			}
		}
	}

	@Override
	public void handleSmResets(InternalExecutionModel model, InternalsmFactory SM_FACTORY) {
		return;
	}

}