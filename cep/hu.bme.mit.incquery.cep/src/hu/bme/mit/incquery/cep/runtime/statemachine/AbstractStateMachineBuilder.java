package hu.bme.mit.incquery.cep.runtime.statemachine;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;

public abstract class AbstractStateMachineBuilder<T extends EventPattern> {
	protected final InternalsmFactory SM_FACTORY = InternalsmFactory.eINSTANCE;
	protected InternalExecutionModel model;
	
	public AbstractStateMachineBuilder(InternalExecutionModel model) {
		this.model = model;
	}
	
	public abstract void buildStateMachine(T eventPattern);
}