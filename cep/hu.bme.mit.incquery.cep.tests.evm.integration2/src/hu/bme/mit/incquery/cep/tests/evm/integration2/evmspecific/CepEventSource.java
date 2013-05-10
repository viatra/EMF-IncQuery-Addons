package hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;

import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.event.EventRealm;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;
import org.eclipse.incquery.runtime.evm.api.event.EventSourceSpecification;

import com.google.common.collect.Sets;

public class CepEventSource implements EventSource<ObservedComplexEventPattern> {
	
	private CepRealm realm;
	private CepEventSourceSpecification specification;
	private Set<CepEventHandler> handlers = Sets.newHashSet();
	
	@Override
	public EventSourceSpecification<ObservedComplexEventPattern> getSourceSpecification() {
		return specification;
	}
	
	public CepEventSource(CepEventSourceSpecification specification, CepRealm realm) {
		this.specification = specification;
		this.realm = realm;
		realm.addSource(this);
	}
	
	@Override
	public EventRealm getRealm() {
		return realm;
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
