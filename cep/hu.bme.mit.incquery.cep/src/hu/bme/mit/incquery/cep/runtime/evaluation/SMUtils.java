package hu.bme.mit.incquery.cep.runtime.evaluation;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;
import hu.bme.mit.incquery.cep.runtime.statemachine.StateMachineBuilder;

import java.util.ArrayList;
import java.util.List;

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
		String guardEventType = checkNotNull(guard.getEventType(), "The Event Type of the Guard must not be null.");

		String eventTypeId = checkNotNull(event.getTypeId(), "The Event Type of the Event must not be null.");

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
	 * back-step trace building algorithm. (See {@link StateMachineBuilder#buildStateMachine()}.)
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

		for (EventPattern ep : eventPattern.getCompositionEvents()) {
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
}
