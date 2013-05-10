package hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific;
import hu.bme.mit.incquery.cep.api.SimpleObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

public class ABCPatternMatchObservation extends SimpleObservedComplexEventPattern {
	
	public ABCPatternMatchObservation(EventPattern observerdPattern) {
		super(observerdPattern);
	}
}
