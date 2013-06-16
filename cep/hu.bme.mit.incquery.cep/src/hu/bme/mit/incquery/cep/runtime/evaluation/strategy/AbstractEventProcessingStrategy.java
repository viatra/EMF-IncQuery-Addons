package hu.bme.mit.incquery.cep.runtime.evaluation.strategy;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;

import java.util.Calendar;

import org.eclipse.emf.common.util.EList;

import com.google.common.base.Preconditions;

public abstract class AbstractEventProcessingStrategy implements IEventProcessingStrategy {
	
	protected long getCurrentTimeStamp() {
		Calendar c = Calendar.getInstance();
		return c.getTimeInMillis();
	}
	
	protected void handleTimeConstraints(EventToken eventToken) {
		EList<TimeConstraint> startConstraints = eventToken.getCurrentState().getStartConstraints();
		EList<TimeConstraint> stopConstraints = eventToken.getCurrentState().getStopConstraints();
		
		if (!startConstraints.isEmpty()) {
			for (TimeConstraint c : startConstraints) {
				c.setStartTimeStamp(getCurrentTimeStamp());
			}
		}
		
		if (!stopConstraints.isEmpty()) {
			for (TimeConstraint c : stopConstraints) {
				c.setStopTimeStamp(getCurrentTimeStamp());
				if (!isTimeConstraintSatisfied(c)) {
					moveToTrapState(eventToken);
				}
			}
		}
	}
	
	protected void moveToTrapState(EventToken eventToken) {
		StateMachine sm = (StateMachine) eventToken.getCurrentState().eContainer();
		TrapState trapState = SMUtils.getTrapState(sm);
		Preconditions.checkNotNull(trapState);
		eventToken.setCurrentState(trapState);
	}
	
	protected boolean isTimeConstraintSatisfied(TimeConstraint constraint) {
		long start = constraint.getStartTimeStamp();
		long stop = constraint.getStopTimeStamp();
		long expected = constraint.getExpectedLength();
		
		Preconditions.checkNotNull(start);
		Preconditions.checkNotNull(stop);
		Preconditions.checkNotNull(expected);
		
		if (stop - start < expected) {
			return true;
		}
		
		return false;
	}
}