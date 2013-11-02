package hu.bme.mit.incquery.cep.api.evm;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

public class InTrapComplexEventPattern implements IObservableComplexEventPattern {
	
	private EventPattern observablePattern;
	
	@Override
	public EventPattern getObservableEventPattern() {
		return observablePattern;
	}
	
	public InTrapComplexEventPattern(EventPattern observablePattern) {
		this.observablePattern = observablePattern;
	}
}
