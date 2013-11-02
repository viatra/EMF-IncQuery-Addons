package hu.bme.mit.incquery.cep.api.evm;


import org.eclipse.incquery.runtime.evm.api.event.EventFilter;

public class EmptyEventFilter implements EventFilter<IObservableComplexEventPattern> {
	@Override
	public boolean isProcessable(IObservableComplexEventPattern eventAtom) {
		return true;
	}
}