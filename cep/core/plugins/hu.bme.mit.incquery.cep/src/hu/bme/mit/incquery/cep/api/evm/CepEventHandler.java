package hu.bme.mit.incquery.cep.api.evm;


import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.event.Event;
import org.eclipse.incquery.runtime.evm.api.event.EventFilter;
import org.eclipse.incquery.runtime.evm.api.event.EventHandler;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;

public class CepEventHandler implements EventHandler<IObservableComplexEventPattern> {
	
	private EmptyEventFilter emptyFilter;
	private CepEventSource source;
	private RuleInstance<IObservableComplexEventPattern> instance;
	
	@Override
	public void handleEvent(Event<IObservableComplexEventPattern> event) {
		IObservableComplexEventPattern eventAtom = event.getEventAtom();
		instance.activationStateTransition(instance.createActivation(eventAtom), CepEventType.APPEARED);
	}
	
	@Override
	public EventSource<IObservableComplexEventPattern> getSource() {
		return source;
	}
	
	@Override
	public EventFilter<IObservableComplexEventPattern> getEventFilter() {
		return emptyFilter;
	}
	
	@Override
	public void dispose() {}
	
	public CepEventHandler(CepEventSource source, RuleInstance<IObservableComplexEventPattern> instance) {
		this.source = source;
		this.emptyFilter = new EmptyEventFilter();
		this.instance = instance;
	}
}