package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;

import java.util.ArrayList;
import java.util.List;

public final class SMUtils {
	
	public static boolean isEnabled(Transition transition, Event event) {
		if (transition.getGuard().getEventType().equalsIgnoreCase(event.getTypeId())) {
			return true;
		}
		return false;
	}
	
	public static boolean isFinal(State state) {
		if (state instanceof FinalState) {
			return true;
		}
		return false;
	}
	
	public static TrapState getTrapState(StateMachine sm) {
		for (State s : sm.getStates()) {
			if (s instanceof TrapState) {
				return (TrapState) s;
			}
		}
		return null;
	}
	
	public static List<AtomicEventPattern> flattenComplexPatterns(EventPattern cePattern) {
		List<AtomicEventPattern> flattenedList = new ArrayList<AtomicEventPattern>();
		
		if (cePattern instanceof AtomicEventPattern) {
			flattenedList.add((AtomicEventPattern) cePattern);
			return flattenedList;
		}
		
		for (EventPattern ep : cePattern.getCompositionEvents()) {
			if (ep instanceof AtomicEventPattern) {
				flattenedList.add((AtomicEventPattern) ep);
			} else {
				ComplexOperator op = ((ComplexEventPattern) ep).getOperator();
				if (op == null) {
					continue;
				}
				flattenedList.addAll(flattenComplexPatterns(ep));
			}
		}
		
		return flattenedList;
	}
}
