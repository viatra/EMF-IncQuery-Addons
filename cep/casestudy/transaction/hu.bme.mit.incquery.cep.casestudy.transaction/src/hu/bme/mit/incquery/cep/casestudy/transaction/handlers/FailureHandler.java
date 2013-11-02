package hu.bme.mit.incquery.cep.casestudy.transaction.handlers;

import hu.bme.mit.incquery.cep.api.IActionHandler;
import hu.bme.mit.incquery.cep.api.evm.InTrapComplexEventPattern;
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.incquery.runtime.evm.api.Activation;

public class FailureHandler implements IActionHandler {

	@Override
	public void handle(
			Activation<? extends IObservableComplexEventPattern> activation) {
		IObservableComplexEventPattern atom = activation.getAtom();
		if (!(atom instanceof InTrapComplexEventPattern)) {
			return;
		}
		EventPattern observedEventPattern = atom.getObservableEventPattern();
		System.out.println("Failure: " + observedEventPattern.getId());

	}
}
