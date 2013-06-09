package org.jnect.demo.incquery.viatra.cep.evmspecific;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;

import org.eclipse.incquery.runtime.evm.api.event.EventFilter;

public class JnectEventFilter implements EventFilter<ObservedComplexEventPattern> {
	
	@Override
	public boolean isProcessable(ObservedComplexEventPattern eventAtom) {
		return true;
	}
	
}
