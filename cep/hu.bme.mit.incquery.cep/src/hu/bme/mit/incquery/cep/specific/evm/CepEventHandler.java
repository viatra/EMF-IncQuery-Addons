package hu.bme.mit.incquery.cep.specific.evm;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;

import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.event.Event;
import org.eclipse.incquery.runtime.evm.api.event.EventFilter;
import org.eclipse.incquery.runtime.evm.api.event.EventHandler;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;

public class CepEventHandler implements EventHandler<ObservedComplexEventPattern> {
	
	private EmptyEventFilter emptyFilter;
	private CepEventSource source;
	private RuleInstance<ObservedComplexEventPattern> instance;
	
	@Override
	public void handleEvent(Event<ObservedComplexEventPattern> event) {
		ObservedComplexEventPattern eventAtom = event.getEventAtom();
		instance.activationStateTransition(instance.createActivation(eventAtom), CepEventType.APPEARED);
	}
	
	@Override
	public EventSource<ObservedComplexEventPattern> getSource() {
		return source;
	}
	
	@Override
	public EventFilter<ObservedComplexEventPattern> getEventFilter() {
		return emptyFilter;
	}
	
	@Override
	public void dispose() {}
	
	public CepEventHandler(CepEventSource source, RuleInstance<ObservedComplexEventPattern> instance) {
		this.source = source;
		this.emptyFilter = new EmptyEventFilter();
		this.instance = instance;
	}
}