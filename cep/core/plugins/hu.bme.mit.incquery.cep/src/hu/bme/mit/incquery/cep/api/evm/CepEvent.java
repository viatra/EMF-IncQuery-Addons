package hu.bme.mit.incquery.cep.api.evm;


import org.eclipse.incquery.runtime.evm.api.event.Event;
import org.eclipse.incquery.runtime.evm.api.event.EventType;

public class CepEvent implements Event<IObservableComplexEventPattern> {
	
	private CepEventType type;
	private IObservableComplexEventPattern atom;
	
	public CepEvent(CepEventType type, IObservableComplexEventPattern atom) {
		this.type = type;
		this.atom = atom;
	}
	
	@Override
	public EventType getEventType() {
		return type;
	}
	
	@Override
	public IObservableComplexEventPattern getEventAtom() {
		return atom;
	}
	
}
