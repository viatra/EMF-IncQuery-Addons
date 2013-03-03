package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.eventmodel.Event;

public class MatchedState implements IState {
	
	@Override
	public void handleEvent(EventPatternMatcher matcher, Event event) {
		// TODO instantiate RuleInstance in EVM based on the action
		// defined in the pattern and terminate current thread
	}
	
	@Override
	public boolean isTimedOut() {
		return false;
	}
}
