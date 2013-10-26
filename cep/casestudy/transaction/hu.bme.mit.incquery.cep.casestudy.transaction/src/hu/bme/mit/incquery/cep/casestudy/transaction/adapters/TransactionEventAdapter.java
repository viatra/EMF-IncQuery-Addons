package hu.bme.mit.incquery.cep.casestudy.transaction.adapters;

import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.runtime.EventQueue;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;

public class TransactionEventAdapter implements ICepAdapter {

	private EventQueue eventQueue;

	public TransactionEventAdapter() {
		this.eventQueue = EventQueue.getInstance();
	}

	@Override
	public void push(Event event) {
		eventQueue.push(event);
	}
}
