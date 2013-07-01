package hu.bme.mit.incquery.cep.utils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author Istvan David
 * 
 */
public final class SMUtils {

	/**
	 * Returns whether a {@link Transition} is enabled for a given {@link Event}
	 * based on its type, or not.
	 * 
	 * @param transition
	 * @param event
	 * @return
	 */
	public static boolean isEnabled(Transition transition, Event event) {
		checkArgument(transition != null);
		checkArgument(event != null);

		Guard guard = checkNotNull(transition.getGuard(), "The Guard must not be null.");
		String guardEventType = checkNotNull(guard.getEventType().getType(),
				"The Event Type of the Guard must not be null.");

		String eventTypeId = checkNotNull(event.getType(), "The Event Type of the Event must not be null.");

		if (guardEventType.equalsIgnoreCase(eventTypeId)) {
			return true;
		}
		return false;
	}

	public static boolean isFinal(State state) {
		checkArgument(state != null);

		if (state instanceof FinalState) {
			return true;
		}
		return false;
	}

	public static TrapState getTrapState(StateMachine stateMachine) {
		checkArgument(stateMachine != null);

		for (State s : stateMachine.getStates()) {
			if (s instanceof TrapState) {
				return (TrapState) s;
			}
		}
		return null;
	}

	/**
	 * Flattens hierarchically nested {@link AtomicEventPattern}s. It is
	 * deterministic for fully ordered case. In mixed or unordered case, it is
	 * used for building an initial flattened equivalent to initialize the
	 * back-step trace building algorithm. (See
	 * {@link StateMachineBuilder#buildStateMachine()}.)
	 * 
	 * @param eventPattern
	 * @return
	 */
	public static List<AtomicEventPattern> flattenEventPatterns(EventPattern eventPattern) {
		checkArgument(eventPattern != null);

		List<AtomicEventPattern> flattenedList = new ArrayList<AtomicEventPattern>();

		if (eventPattern instanceof AtomicEventPattern) {
			flattenedList.add((AtomicEventPattern) eventPattern);
			return flattenedList;
		}

		for (EventPattern ep : ((ComplexEventPattern) eventPattern).getCompositionEvents()) {
			if (ep instanceof AtomicEventPattern) {
				flattenedList.add((AtomicEventPattern) ep);
			} else if (ep instanceof ComplexEventPattern) {
				ComplexOperator op = ((ComplexEventPattern) ep).getOperator();
				if (op == null) {
					continue;
				}
				flattenedList.addAll(flattenEventPatterns(ep));
			}
		}

		return flattenedList;
	}

	public static Map<AtomicEventPattern, List<Timewindow>> flattenEventPatternsWithTimewindows(
			EventPattern eventPattern) {
		checkArgument(eventPattern != null);

		Map<AtomicEventPattern, List<Timewindow>> flattenedList = new LinkedHashMap<AtomicEventPattern, List<Timewindow>>();
		if (eventPattern instanceof AtomicEventPattern) {
			addElement(flattenedList, (AtomicEventPattern) eventPattern);
			return flattenedList;
		}

		for (EventPattern ep : ((ComplexEventPattern) eventPattern).getCompositionEvents()) {
			if (ep instanceof AtomicEventPattern) {
				addElement(flattenedList, (AtomicEventPattern) ep);
			} else if (ep instanceof ComplexEventPattern) {
				ComplexEventPattern cep = (ComplexEventPattern) ep;
				ComplexOperator op = (cep).getOperator();
				if (op == null) {
					continue;
				}
				flattenedList.putAll(flattenEventPatternsWithTimewindows(ep));
			}
		}

		return flattenedList;
	}

	private static void addElement(Map<AtomicEventPattern, List<Timewindow>> map, AtomicEventPattern patternToAdd) {
		for (AtomicEventPattern aep : map.keySet()) {
			if (aep.equals(patternToAdd)) {
				return;
			}
		}

		map.put((AtomicEventPattern) patternToAdd, collectTimewindows(patternToAdd));
	}

	private static List<Timewindow> collectTimewindows(EventPattern eventPattern) {
		List<Timewindow> timewindows = new ArrayList<Timewindow>();

		while (eventPattern.eContainer() instanceof EventPattern) {
			EObject parent = eventPattern.eContainer();
			if (parent instanceof AtomicEventPattern) {
				eventPattern = (AtomicEventPattern) parent;
				continue;
			} else if (parent instanceof ComplexEventPattern) {
				ComplexEventPattern ep = (ComplexEventPattern) eventPattern.eContainer();
				Timewindow timewindow = ep.getTimewindow();
				if (timewindow != null) {
					timewindows.add(timewindow);
				}
				eventPattern = (ComplexEventPattern) parent;
				continue;
			}
		}
		return timewindows;
	}

}