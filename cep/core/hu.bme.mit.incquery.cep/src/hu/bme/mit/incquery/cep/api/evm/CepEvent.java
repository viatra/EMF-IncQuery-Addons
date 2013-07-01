package hu.bme.mit.incquery.cep.api.evm;


import org.eclipse.incquery.runtime.evm.api.event.Event;
import org.eclipse.incquery.runtime.evm.api.event.EventType;

public class CepEvent implements Event<ObservedComplexEventPattern> {
	
	private CepEventType type;
	private ObservedComplexEventPattern atom;
	
	public CepEvent(CepEventType type, ObservedComplexEventPattern atom) {
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
