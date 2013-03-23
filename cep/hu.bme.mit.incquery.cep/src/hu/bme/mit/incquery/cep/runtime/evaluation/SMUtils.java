package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.AbstractEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

public final class SMUtils {
	public static boolean isEnabled(Transition transition, Event event) {
		if (transition.getGuard().getEventType().equals(event.getClass())) {
			return true;
		}
		return false;
	}
	public static void fireTransition(AbstractEventPattern ep, Transition t) {
		ep.getStateMachine().setCurrentState(t.getOutState());
	}
}
