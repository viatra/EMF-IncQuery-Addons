package hu.bme.mit.incquery.cep.casestudy.transaction.handlers;

import hu.bme.mit.incquery.cep.api.IActionHandler;
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.incquery.runtime.evm.api.Activation;

public class MySimpleActionHandler implements IActionHandler {

	@Override
	public void handle(
			Activation<? extends ObservedComplexEventPattern> activation) {
		ObservedComplexEventPattern atom = activation.getAtom();
		EventPattern observedEventPattern = atom.getObservedEventPattern();
		System.out.println("Event pattern appeared: "
				+ observedEventPattern.getId());

	}
}
