package org.jnect.demo.incquery.viatra.cep.evmspecific;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;

import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.event.Event;
import org.eclipse.incquery.runtime.evm.api.event.EventFilter;
import org.eclipse.incquery.runtime.evm.api.event.EventHandler;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;

public class JnectEventHandler implements EventHandler<ObservedComplexEventPattern> {
	
	private JnectEventFilter filter;
	private JnectEventSource source;
	private RuleInstance<ObservedComplexEventPattern> instance;
	
	@Override
	public void handleEvent(Event<ObservedComplexEventPattern> event) {
		JnectEventType type = (JnectEventType) event.getEventType();
		ObservedComplexEventPattern eventAtom = event.getEventAtom();
		switch (type) {
			case APPEARED :
				instance.activationStateTransition(instance.createActivation(eventAtom), type);
				break;
			default :
				System.err.println("Never happens!");
				break;
		}
	}
	
	@Override
	public EventSource<ObservedComplexEventPattern> getSource() {
		return source;
	}
	
	@Override
	public EventFilter<ObservedComplexEventPattern> getEventFilter() {
		return filter;
	}
	
	@Override
	public void dispose() {}
	
	public JnectEventHandler(JnectEventSource source, JnectEventFilter filter,
			RuleInstance<ObservedComplexEventPattern> instance) {
		this.source = source;
		this.filter = filter;
		this.instance = instance;
	}
	
}