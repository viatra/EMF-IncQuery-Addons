package hu.bme.mit.incquery.cep.api.evm;


import org.eclipse.incquery.runtime.evm.api.event.EventFilter;

public class EmptyEventFilter implements EventFilter<ObservedComplexEventPattern> {
	@Override
	public boolean isProcessable(ObservedComplexEventPattern eventAtom) {
		return true;
	}
}