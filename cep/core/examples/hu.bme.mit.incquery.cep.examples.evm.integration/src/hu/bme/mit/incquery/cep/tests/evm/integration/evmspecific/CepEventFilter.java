package hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;

import org.eclipse.incquery.runtime.evm.api.event.EventFilter;

public class CepEventFilter implements EventFilter<ObservedComplexEventPattern> {
	
	@Override
	public boolean isProcessable(ObservedComplexEventPattern eventAtom) {
		return true;
	}
	
}
