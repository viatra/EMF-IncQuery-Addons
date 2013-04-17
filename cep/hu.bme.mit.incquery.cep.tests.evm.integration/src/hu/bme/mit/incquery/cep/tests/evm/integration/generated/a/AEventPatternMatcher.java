package hu.bme.mit.incquery.cep.tests.evm.integration.generated.a;

import hu.bme.mit.incquery.cep.runtime.api.EventPatternMatcher;

import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class AEventPatternMatcher extends EventPatternMatcher<AEventPatternMatch> {
	
	public AEventPatternMatcher(IncQueryEngine engine,
			IMatcherFactory<? extends BaseGeneratedMatcher<AEventPatternMatch>> factory) throws IncQueryException {
		super(engine, factory);
	}
	
	public AEventPatternMatcher(final IncQueryEngine engine) throws IncQueryException {
		super(engine, factory());
	}
	
	public static IMatcherFactory<AEventPatternMatcher> factory() throws IncQueryException {
		return AEventPatternMatcherFactory.instance();
	}
}
