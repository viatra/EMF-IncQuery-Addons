package org.jnect.demo.incquery.viatra.cep.evmspecific;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;

import org.eclipse.incquery.runtime.evm.api.event.Event;
import org.eclipse.incquery.runtime.evm.api.event.EventType;

public class JnectEvent implements Event<ObservedComplexEventPattern> {
	
	private JnectEventType type;
	private ObservedComplexEventPattern atom;
	
	public JnectEvent(JnectEventType type, ObservedComplexEventPattern atom) {
		this.type = type;
		this.atom = atom;
	}
	
	@Override
	public EventType getEventType() {
		return type;
	}
	
	@Override
	public ObservedComplexEventPattern getEventAtom() {
		return atom;
	}
	
}
