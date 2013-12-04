package hu.bme.mit.incquery.cep.casestudy.transaction.handlers;

import hu.bme.mit.incquery.cep.api.IActionHandler;
import hu.bme.mit.incquery.cep.api.ParameterizableComplexEventPattern;
import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionFactory;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_IQEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_IQEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_IQEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.test.IncQueryTester;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import java.util.List;

import org.eclipse.incquery.runtime.evm.api.Activation;

public class SimpleActionHandler implements IActionHandler {

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
			ComponentA_IQEvent componentA = (ComponentA_IQEvent) observedEvents.get(0);
			ComponentB_IQEvent componentB = (ComponentB_IQEvent) observedEvents.get(1);
			ComponentC_IQEvent componentC = (ComponentC_IQEvent) observedEvents.get(2);

			System.out.println("New compound event with params:");
			System.out.println("---TransactionId: " + componentA.getTransactionId());
			System.out.println("---CustomerId: " + componentA.getCustomerId());
			System.out.println("---Timestamp A: " + componentA.getTimestamp());
			System.out.println("---Timestamp B: " + componentB.getTimestamp());
			System.out.println("---Timestamp C: " + componentC.getTimestamp());

			createCompoundTransactionEvent(componentA, componentB, componentC);
		}
	}

	private void createCompoundTransactionEvent(ComponentA_IQEvent componentA, ComponentB_IQEvent componentB,
			ComponentC_IQEvent componentC) {
		CompoundTransactionEvent compoundTransactionEvent = TransactionFactory.eINSTANCE
				.createCompoundTransactionEvent();
		compoundTransactionEvent.setTransactionId(componentA.getTransactionId());
		compoundTransactionEvent.setCustomerId(componentA.getCustomerId());
		compoundTransactionEvent.setTimestampA(componentA.getTimestamp());
		compoundTransactionEvent.setTimestampB(componentB.getTimestamp());
		compoundTransactionEvent.setTimestampC(componentC.getTimestamp());
		
		
		TransactionModel model = IncQueryTester.getInstance().getModel();
		
		System.out.println("Compound events in model: " + model.getLatestCompoundEvent());
		
		model.setLatestCompoundEvent(compoundTransactionEvent);
		
		System.out.println("Compound events in model: " + model.getLatestCompoundEvent());
	}
}
