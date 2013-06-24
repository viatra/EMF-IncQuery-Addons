package hu.bme.mit.incquery.cep.runtime.evaluation.strategy;

import hu.bme.mit.incquery.cep.metamodels.custom.impl.EventCollectionWithMultimap;
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
	public void fireTransition(Transition t) {
		State preState = t.getPreState();
		if (preState instanceof FinalState) {
			return;
		}
		
		InternalExecutionModel model = eventModelManager.getModel();
		State nextState = t.getPostState();
		
		EventToken cvToMove = t.getPreState().getEventTokens().get(0);
		if(!handleTimeConstraints(cvToMove, nextState)){
			return;
		}
		cvToMove.getEventCollection().addEvent(model.getLatestEvent());
		cvToMove.setCurrentState(nextState);
	}
	
	@Override
	public void handleVisitorCreation(InternalExecutionModel model, InternalsmFactory SM_FACTORY) {
		for (StateMachine sm : model.getStateMachines()) {
			for (State s : sm.getStates()) {
				if (s instanceof InitState) {
					if (s.getEventTokens().isEmpty()) {
						EventToken cv = SM_FACTORY.createEventToken();
						cv.setCurrentState(s);
						cv.setEventCollection(new EventCollectionWithMultimap());
						model.getEventTokens().add(cv);
					}
					break;
				}
			}
		}
	}
}