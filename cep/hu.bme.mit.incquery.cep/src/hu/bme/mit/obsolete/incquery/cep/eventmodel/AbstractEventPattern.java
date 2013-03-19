package hu.bme.mit.obsolete.incquery.cep.eventmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for the common behavior implementations of
 * {@link AtomicEventPattern}s and {@link ComplexEventPattern}s.
 * 
 * @author Istvan David
 *
 */
public abstract class AbstractEventPattern implements IEventPattern {
	protected List<IEventPattern> compositionEvents;
	
	protected AbstractEventPattern() {
		compositionEvents = new ArrayList<IEventPattern>();
	}
	
	@Override
	public List<IEventPattern> getCompositionAtomicEvents() {
		return compositionEvents;
	}
	
	@Override
	public boolean isRecognized() {
		if (this.compositionEvents.isEmpty()) {
			return true;
		}
		return false;
	}
}