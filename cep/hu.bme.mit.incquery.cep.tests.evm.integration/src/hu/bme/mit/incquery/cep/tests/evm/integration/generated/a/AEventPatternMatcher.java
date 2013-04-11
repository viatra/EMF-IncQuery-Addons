package hu.bme.mit.incquery.cep.tests.evm.integration.generated.a;

import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatcher;
import hu.bme.mit.incquery.cep.runtime.evaluation.queries.finishedstatemachine.FinishedStateMachineMatcherFactory;

import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

public class AEventPatternMatcher extends BaseGeneratedMatcher<AEventPatternMatch> {
	
	public AEventPatternMatcher(IncQueryEngine engine,
			IMatcherFactory<? extends BaseGeneratedMatcher<AEventPatternMatch>> factory) throws IncQueryException {
		super(engine, factory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected AEventPatternMatch arrayToMatch(Object[] parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected AEventPatternMatch arrayToMatchMutable(Object[] parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected AEventPatternMatch tupleToMatch(Tuple t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static IMatcherFactory<AEventPatternMatcher> factory() throws IncQueryException {
		return AEventPatternMatcherFactory.instance();
	}
	
}
