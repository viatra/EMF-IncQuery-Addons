package hu.bme.mit.incquery.cep.api.eventprocessingstrategy;

import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

public interface IEventProcessingStrategy {
    EventProcessingContext getContext();
    
	void fireTransition(Transition t, EventToken et, Event e);
	
	void handleInitTokenCreation(InternalExecutionModel model, InternalsmFactory SM_FACTORY,
			IObservableComplexEventPattern observedComplexEventPattern);

	void handleSmResets(InternalExecutionModel model, InternalsmFactory SM_FACTORY);
}