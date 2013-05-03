package hu.bme.mit.incquery.cep.runtime.evaluation.strategy;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InitState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.model.custom.impl.EventCollectionWithMultimap;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;

public class ChronicleStrategy extends AbstractEventProcessingStrategy {
	
	@Override
	public void fireTransition(Transition t) {
		State preState = t.getPreState();
		if (preState instanceof FinalState) {
			return;
		}
		
		InternalExecutionModel model = EventModelManager.getInstance().getModel();
		State nextState = t.getPostState();
		
		CurrentStateVisitor cvToMove = t.getPreState().getCurrentVisitors().get(0);
		cvToMove.getEventCollection().addEvent(model.getLatestEvent());
		cvToMove.setCurrentState(nextState);
		handleTimeConstraints(cvToMove);
	}
	
	@Override
	public void handleVisitorCreation(InternalExecutionModel model, InternalsmFactory SM_FACTORY) {
		for (StateMachine sm : model.getStateMachines()) {
			for (State s : sm.getStates()) {
				if (s instanceof InitState) {
					if (s.getCurrentVisitors().isEmpty()) {
						CurrentStateVisitor cv = SM_FACTORY.createCurrentStateVisitor();
						cv.setCurrentState(s);
						cv.setEventCollection(new EventCollectionWithMultimap());
						model.getCurrentStateVisitors().add(cv);
					}
				}
			}
		}
	}
}