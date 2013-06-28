package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

public class SimpleObservedComplexEventPattern implements ObservedComplexEventPattern {
	
	private EventPattern observerdPattern;
	
	@Override
	public EventPattern getObservedEventPattern() {
		return observerdPattern;
	}
	
	public SimpleObservedComplexEventPattern(EventPattern observerdPattern) {
		this.observerdPattern = observerdPattern;
	}
}
