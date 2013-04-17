package hu.bme.mit.incquery.cep.tests.evm.integration.generated.a;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.runtime.api.EventPatternMatch;

import org.eclipse.incquery.runtime.exception.IncQueryException;

public class AEventPatternMatch extends EventPatternMatch {
	
	@Override
	public EventPattern getEventPattern() {
		try {
			return ((AEventPatternMatcherFactory) AEventPatternMatcher.factory()).getEventPattern();
		} catch (IncQueryException ex) {
			throw new IllegalStateException(ex);
		}
	}
	
	@Override
	public String patternName() {
		return "hu.bme.mit.incquery.cep.tests.evm.integration.patterns.APattern";
	}
	
}