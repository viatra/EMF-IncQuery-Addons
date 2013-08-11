package hu.bme.mit.incquery.cep.api.eventcontext;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.NoiseFiltering;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

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
		eventModelManager.callbackOnFiredToken(t, eventTokenToMove);
	}

	@Override
	public void handleInitTokenCreation(InternalExecutionModel model, InternalsmFactory SM_FACTORY,
			ObservedComplexEventPattern observedComplexEventPattern) {
		NoiseFiltering nf = eventModelManager.getNoiseFiltering();

		if ((nf != null) && nf.equals(NoiseFiltering.STRICT) && observedComplexEventPattern == null) {
			return;
		}
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