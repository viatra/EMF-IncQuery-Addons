package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;
import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
import hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.naming.OperationNotSupportedException;

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
	
	public static void fireTransition(Transition t, boolean firedFromInitialState) {
		State nextState = t.getPostState();
		
		CopyOnWriteArrayList<CurrentStateVisitor> currentVisitors = new CopyOnWriteArrayList<CurrentStateVisitor>();
		currentVisitors.addAll(t.getPreState().getCurrentVisitors());
		
		for (CurrentStateVisitor c : currentVisitors) {
			c.setCurrentState(nextState);
		}
		
		if (!firedFromInitialState) {
			return;
		}
		
		// create new current state visitor
		try {
			State initState = t.getPreState();
			
			InternalExecutionModel model = EventModelManager.getInstance().getModel();
			
			CurrentStateVisitor currentStateVisitor = InternalsmFactory.eINSTANCE.createCurrentStateVisitor();
			currentStateVisitor.setCurrentState(initState);
			model.getCurrentStateVisitors().add(currentStateVisitor);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				if (op.equals(ComplexOperator.ORDERED)) {
					flattenedList.addAll(flattenComplexPatterns(ep));
				}
			}
		}
		
		return flattenedList;
	}
	
	public static Map<AtomicEventPattern, List<AtomicEventPattern>> getPrecedenceRules() {
		return Collections.emptyMap();
	}
}
