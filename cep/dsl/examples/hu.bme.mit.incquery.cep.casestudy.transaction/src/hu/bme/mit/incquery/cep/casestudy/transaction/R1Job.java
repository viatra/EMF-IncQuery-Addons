package hu.bme.mit.incquery.cep.casestudy.transaction;

import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.event.ActivationState;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;

public class R1Job<ObservedComplexEventPattern> extends Job<ObservedComplexEventPattern> {

	protected R1Job(ActivationState activationState) {
		super(activationState);
	}

	@Override
	protected void execute(
			Activation<? extends ObservedComplexEventPattern> activation,
			Context context) {
		//insert: appRule.action
		
	}

	@Override
	protected void handleError(
			Activation<? extends ObservedComplexEventPattern> activation,
			Exception exception, Context context) {
		// not gonna happen
		
	}

}
