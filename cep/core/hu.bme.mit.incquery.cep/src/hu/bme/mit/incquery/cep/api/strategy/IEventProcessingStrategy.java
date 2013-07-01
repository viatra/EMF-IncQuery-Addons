package hu.bme.mit.incquery.cep.api.strategy;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

public interface IEventProcessingStrategy {
	void fireTransition(Transition t, EventToken et);

	void handleInitTokenCreation(InternalExecutionModel model, InternalsmFactory SM_FACTORY,
			ObservedComplexEventPattern observedComplexEventPattern);
}