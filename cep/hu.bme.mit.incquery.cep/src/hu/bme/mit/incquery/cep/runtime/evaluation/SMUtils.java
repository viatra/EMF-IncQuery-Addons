package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

public final class SMUtils {
	public static boolean isEnabled(Transition transition, Event event) {
		if (transition.getGuard().getEventType().equals(event.getClass())) {
			return true;
		}
		return false;
	}
	public static void fireTransition(StateMachine sm, Transition t) {
		sm.setCurrentState(t.getOutState());
	}
}
