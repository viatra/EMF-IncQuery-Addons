package hu.bme.mit.incquery.cep.runtime.api;

import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

public class EventPatternMatcher<Match extends EventPatternMatch> extends BaseGeneratedMatcher<Match> {
	
	public EventPatternMatcher(IncQueryEngine engine, IMatcherFactory<? extends BaseGeneratedMatcher<Match>> factory)
			throws IncQueryException {
		super(engine, factory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Match arrayToMatch(Object[] parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected Match arrayToMatchMutable(Object[] parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected Match tupleToMatch(Tuple t) {
		// TODO Auto-generated method stub
		return null;
	}
}
