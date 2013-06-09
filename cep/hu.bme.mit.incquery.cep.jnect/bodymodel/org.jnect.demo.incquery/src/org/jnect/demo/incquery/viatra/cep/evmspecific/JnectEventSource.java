package org.jnect.demo.incquery.viatra.cep.evmspecific;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;

import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.event.EventRealm;
import org.eclipse.incquery.runtime.evm.api.event.EventSource;
import org.eclipse.incquery.runtime.evm.api.event.EventSourceSpecification;

import com.google.common.collect.Sets;

public class JnectEventSource implements EventSource<ObservedComplexEventPattern> {
	
	private JnectRealm realm;
	private JnectEventSourceSpecification specification;
	private Set<JnectEventHandler> handlers = Sets.newHashSet();
	
	@Override
	public EventSourceSpecification<ObservedComplexEventPattern> getSourceSpecification() {
		return specification;
	}
	
	public JnectEventSource(JnectEventSourceSpecification specification, JnectRealm realm) {
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
	
	public void addHandler(JnectEventHandler handler) {
		handlers.add(handler);
	}
	
	public void pushEvent(JnectEventType type, ObservedComplexEventPattern op) {
		JnectEvent event = new JnectEvent(type, op);
		for (JnectEventHandler handler : handlers) {
			handler.handleEvent(event);
		}
	}
}
