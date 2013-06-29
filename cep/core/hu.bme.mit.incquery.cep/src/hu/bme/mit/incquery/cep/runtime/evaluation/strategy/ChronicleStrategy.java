package hu.bme.mit.incquery.cep.runtime.evaluation.strategy;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;

public class ChronicleStrategy extends AbstractEventProcessingStrategy {

	private EventModelManager eventModelManager;

	public ChronicleStrategy(EventModelManager eventModelManager) {
		this.eventModelManager = eventModelManager;
	}

	@Override
	public void fireTransition(Transition t, EventToken eventTokenToMove) {
		State preState = t.getPreState();
		if (preState instanceof FinalState) {
			return;
		}

		InternalExecutionModel model = eventModelManager.getModel();
		State nextState = t.getPostState();

		if (!handleTimeConstraints(eventTokenToMove, nextState)) {
			return;
		}
		eventTokenToMove.getRecordedEvents().add(model.getLatestEvent());
		preState.setLastProcessedEvent(model.getLatestEvent());
		eventTokenToMove.setCurrentState(nextState);
	}

	@Override
	public void handleVisitorCreation(InternalExecutionModel model, InternalsmFactory SM_FACTORY) {
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
}