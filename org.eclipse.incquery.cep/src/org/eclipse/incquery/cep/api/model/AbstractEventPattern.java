package org.eclipse.incquery.cep.api.model;

import java.util.ArrayList;
import java.util.List;

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