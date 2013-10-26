package hu.bme.mit.incquery.cep.casestudy.transaction.handlers;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.incquery.runtime.evm.api.Activation;

public class MyActionHandler  {
	public void handleAction(String msg) {
		System.out.println(msg);
	}

	public void handleAction(String msg, Activation<? extends ObservedComplexEventPattern> activation) {
		ObservedComplexEventPattern atom = activation.getAtom();
		EventPattern observedEventPattern = atom.getObservedEventPattern();
		System.out.println(msg + " -- " + observedEventPattern.getId());
	}
}
