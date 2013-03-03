package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.eventmodel.Event;

public class FaultyState implements IState {
	
	@Override
	public void handleEvent(EventPatternMatcher matcher, Event event) {
		matcher.dispose();
	}
	
	@Override
	public boolean isTimedOut() {
		throw new UnsupportedOperationException();
	}
}