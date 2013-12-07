package hu.bme.mit.incquery.cep.performance.actionhandlers;

import hu.bme.mit.incquery.cep.api.IActionHandler;
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.incquery.runtime.evm.api.Activation;

public class SimpleActionHandler2 implements IActionHandler {

	@Override
	public void handle(Activation<? extends IObservableComplexEventPattern> activation) {
		IObservableComplexEventPattern atom = activation.getAtom();
		if (!(atom instanceof ObservedComplexEventPattern)) {
			return;
		}
		EventPattern observedEventPattern = atom.getObservableEventPattern();
		System.out.println("Event pattern appeared: " + observedEventPattern.getId());
	}
}
