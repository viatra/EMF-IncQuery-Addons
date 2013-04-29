package hu.bme.mit.incquery.cep.runtime.statemachine;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;

public class EventWithPrerequisite {
	private AtomicEventPattern eventPattern;
	private AtomicEventPattern prerequisiteEventPattern;
	
	public EventWithPrerequisite(AtomicEventPattern eventPattern, AtomicEventPattern prerequisiteEventPattern) {
		this.eventPattern = eventPattern;
		this.prerequisiteEventPattern = prerequisiteEventPattern;
	}
	
	public EventWithPrerequisite(AtomicEventPattern eventPattern) {
		this.eventPattern = eventPattern;
		this.prerequisiteEventPattern = null;
	}
	
	public AtomicEventPattern getEventPattern() {
		return eventPattern;
	}
	
	public AtomicEventPattern getPrerequisiteEventPattern() {
		return prerequisiteEventPattern;
	}
}