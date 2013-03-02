package org.eclipse.incquery.cep.api.model;

import java.util.List;

import javax.naming.OperationNotSupportedException;

/**
 * Complex pattern consisting of many {@link AtomicEventPattern}s. It is
 * recognized, i.e. fully matched if every AtomicEventPattern has been matched.
 * 
 * TODO
 * 	- remove OperationNotSupportedException from the signature by implementing 
 * 		the state-machine based evaluation as discussed with Istvan
 * 
 * @author Istvan David
 * 
 */
public class ComplexEventPattern extends AbstractEventPattern {
	
	public ComplexEventPattern(List<IEventPattern> compositionEventPatterns) {
		super();
		compositionEvents = compositionEventPatterns;
	}
	
	public void addCompositionEventPattern(IEventPattern compositionEventPattern) {
		compositionEvents.add(compositionEventPattern);
	}
	
	@Override
	public boolean match(Event event) throws OperationNotSupportedException {
		if (!(compositionEvents.get(0) instanceof AtomicEventPattern)) {
			throw new OperationNotSupportedException();
		}
		AtomicEventPattern firstAtomicComponent = (AtomicEventPattern) compositionEvents.get(0);
		if (event.getClass().equals(firstAtomicComponent.getType())) {
			return true;
		}
		return false;
	}
}
