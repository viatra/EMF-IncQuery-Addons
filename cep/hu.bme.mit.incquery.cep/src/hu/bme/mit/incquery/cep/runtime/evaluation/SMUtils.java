package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Timewindow;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.runtime.statemachine.EventWithPrerequisite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class SMUtils {
	
	public static boolean isEnabled(Transition transition, Event event) {
		if (transition.getGuard().getEventType().equalsIgnoreCase(event.getTypeId())) {
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
	
	// only for patterns using the ORDERED operator without time window
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
	
	public static List<EventWithPrerequisite> flattenComplexPatterns2(EventPattern pattern) {
		List<EventWithPrerequisite> events = new ArrayList<EventWithPrerequisite>();
		
		if (pattern instanceof AtomicEventPattern) {
			events.add(new EventWithPrerequisite((AtomicEventPattern) pattern));
			return events;
		}
		
		ComplexEventPattern cePattern = (ComplexEventPattern) pattern;
		
		for (int i = 0; i < cePattern.getCompositionEvents().size(); i++) {
			EventPattern ep = cePattern.getCompositionEvents().get(i);
			
			if (ep instanceof AtomicEventPattern) {
				if (cePattern.getOperator().equals(ComplexOperator.ORDERED)
						|| cePattern.getOperator().equals(ComplexOperator.ORDERED_T)) {
					events.add(new EventWithPrerequisite((AtomicEventPattern) ep));
				} else if (cePattern.getOperator().equals(ComplexOperator.UNORDERED)
						|| cePattern.getOperator().equals(ComplexOperator.UNORDERED_T)) {
					if (i == 0) {
						events.add(new EventWithPrerequisite((AtomicEventPattern) ep));
					} else if (i > 0) {
						EventPattern req = cePattern.getCompositionEvents().get(i - 1);
						if (req instanceof AtomicEventPattern) {
							events.add(new EventWithPrerequisite((AtomicEventPattern) ep, (AtomicEventPattern) req));
						} else if (req instanceof ComplexEventPattern) {
							List<EventWithPrerequisite> flatReq = flattenComplexPatterns2(req);
							events.add(new EventWithPrerequisite((AtomicEventPattern) ep, flatReq.get(
									flatReq.size() - 1).getEventPattern()));
						}
					}
				}
			} else {
				ComplexOperator op = ((ComplexEventPattern) ep).getOperator();
				if (op == null) {
					continue;
				}
				events.addAll(flattenComplexPatterns2(ep));
			}
		}
		
		return events;
	}
	public static Map<AtomicEventPattern, List<AtomicEventPattern>> getPrecedenceRules() {
		return Collections.emptyMap();
	}
}
