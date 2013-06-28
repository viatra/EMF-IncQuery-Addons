package hu.bme.mit.incquery.cep.specific.evm;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.event.EventRealm;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;
import org.eclipse.incquery.runtime.evm.api.event.EventSourceSpecification;

import com.google.common.collect.Sets;

public class CepEventSource implements EventSource<ObservedComplexEventPattern> {
	
	private CepRealm realm;
	private CepEventSourceSpecification specification;
	private StateMachine stateMachine;
	private Set<CepEventHandler> handlers = Sets.newHashSet();
	
	public CepEventSource(CepEventSourceSpecification specification, CepRealm realm) {
		this.specification = specification;
		this.realm = realm;
		realm.addSource(this);
	}
	
	@Override
	public EventSourceSpecification<ObservedComplexEventPattern> getSourceSpecification() {
		return specification;
	}
	
	@Override
	public EventRealm getRealm() {
		return realm;
	}
	
	public StateMachine getStateMachine() {
		return stateMachine;
	}
	
	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
	
	@Override
	public void dispose() {}
	
	public void addHandler(CepEventHandler handler) {
		handlers.add(handler);
	}
	
	public void pushEvent(CepEventType type, ObservedComplexEventPattern op) {
		CepEvent event = new CepEvent(type, op);
		for (CepEventHandler handler : handlers) {
			handler.handleEvent(event);
		}
	}
}