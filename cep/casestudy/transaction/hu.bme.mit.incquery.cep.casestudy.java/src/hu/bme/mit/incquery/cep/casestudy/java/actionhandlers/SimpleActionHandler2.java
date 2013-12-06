package hu.bme.mit.incquery.cep.casestudy.java.actionhandlers;

import hu.bme.mit.incquery.cep.api.IActionHandler;
import hu.bme.mit.incquery.cep.api.ParameterizableComplexEventPattern;
import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA_Event;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB_Event;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC_Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import java.util.List;

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

		if (observedEventPattern instanceof ParameterizableComplexEventPattern) {
			List<ParameterizableEventInstance> observedEvents = ((ParameterizableComplexEventPattern) observedEventPattern)
					.getObservedEvents();
			ComponentA_Event componentA = (ComponentA_Event) observedEvents.get(0);
			ComponentB_Event componentB = (ComponentB_Event) observedEvents.get(1);
			ComponentC_Event componentC = (ComponentC_Event) observedEvents.get(2);

			System.out.println("New compound event with params:");
			System.out.println("---TransactionId: " + componentA.getTransactionId());
			System.out.println("---CustomerId: " + componentA.getCustomerId());
			System.out.println("---Timestamp A: " + componentA.getTimestamp());
			System.out.println("---Timestamp B: " + componentB.getTimestamp());
			System.out.println("---Timestamp C: " + componentC.getTimestamp());
		}
	}
}
