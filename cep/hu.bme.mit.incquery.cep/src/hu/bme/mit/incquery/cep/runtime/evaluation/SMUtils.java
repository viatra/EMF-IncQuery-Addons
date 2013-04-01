package hu.bme.mit.incquery.cep.runtime.evaluation;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

public final class SMUtils {
	
	public static boolean isEnabled(Transition transition, Event event) {
		// if (transition.getGuard().getEventType().equals(event.getClass())) {
		if (transition.getGuard().getEventType().getCanonicalName().equalsIgnoreCase(event.getId())) {
			return true;
		}
		return false;
	}
	public static boolean timedout(Transition transition, Long recordedTime) {
		Timewindow timewindow = transition.getGuard().getTimewindow();
		if (timewindow == null) {
			return false;
		}
		if (timewindow.getLength() <= recordedTime) {
			return false;
		}
		return true;
	}
	
	public static boolean isFinal(State state) {
		if (state instanceof FinalState) {
			return true;
		}
		return false;
	}
	
	public static void fireTransition(StateMachine sm, Transition t) {
		sm.setCurrentState(t.getPostState());
	}
	
	// only for patterns using the ORDERED operator without time window
	public static List<AtomicEventPattern> flattenComplexPatterns(ComplexEventPattern cePattern) {
		List<AtomicEventPattern> flattenedList = new ArrayList<AtomicEventPattern>();
		
		for (EventPattern ep : cePattern.getCompositionEvents()) {
			if (ep instanceof AtomicEventPattern) {
				flattenedList.add((AtomicEventPattern) ep);
			} else {
				ComplexOperator op = ((ComplexEventPattern) ep).getOperator();
				if (op == null) {
					continue;
				}
				if (op.equals(ComplexOperator.ORDERED)) {
					flattenedList.addAll(flattenComplexPatterns((ComplexEventPattern) ep));
				}
			}
		}
		
		return flattenedList;
	}
}
