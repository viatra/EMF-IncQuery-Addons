package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.eventmodel.Event;

public interface IState {
	void handleEvent(EventPatternMatcher matcher, Event event);
	boolean isTimedOut();
}