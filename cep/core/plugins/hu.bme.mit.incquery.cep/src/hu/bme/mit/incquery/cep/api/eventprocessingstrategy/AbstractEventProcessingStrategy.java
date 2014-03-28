package hu.bme.mit.incquery.cep.api.eventprocessingstrategy;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState;
import hu.bme.mit.incquery.cep.runtime.evaluation.SMUtils;

import java.util.Calendar;

import org.eclipse.emf.common.util.EList;

import com.google.common.base.Preconditions;

public abstract class AbstractEventProcessingStrategy implements IEventProcessingStrategy {

	private EventModelManager eventModelManager;

	public AbstractEventProcessingStrategy(EventModelManager eventModelManager) {
		this.eventModelManager = eventModelManager;
	}

	protected EventModelManager getEventModelManager() {
		return this.eventModelManager;
	}

	protected long getCurrentTimeStamp() {
		Calendar c = Calendar.getInstance();
		return c.getTimeInMillis();
	}

	protected boolean handleTimeConstraints(EventToken eventToken, State nextState) {
		EList<TimeConstraint> timeConstraints = nextState.getTimeConstraints();
		if (timeConstraints.isEmpty())
			return true;
		for (TimeConstraint timeConstraint : timeConstraints) {
			TimeConstraintSpecification timeConstraintSpecification = timeConstraint.getTimeConstraintSpecification();
			Preconditions.checkArgument(timeConstraintSpecification != null);

			switch (timeConstraint.getType()) {
			case START:
				timeConstraint.getTimeConstraintSpecification().setStartTimestamp(getCurrentTimeStamp());
				continue;
			case STOP:
				timeConstraint.getTimeConstraintSpecification().setStopTimestamp(getCurrentTimeStamp());
				if (!isTimeConstraintSatisfied(timeConstraint)) {
					moveToTrapState(eventToken);
					return false;
				}
				continue;
			case CHECK:
				tryStart(timeConstraintSpecification);
				if (!isTimeConstraintSatisfied(timeConstraint)) {
					moveToTrapState(eventToken);
					return false;
				}
				continue;
			}
		}
		return true;
	}

	private void tryStart(TimeConstraintSpecification timeConstraintSpecification) {
		if (timeConstraintSpecification.getStartTimestamp() == 0l) {
			timeConstraintSpecification.setStartTimestamp(getCurrentTimeStamp());
		}
	}

	protected void moveToTrapState(EventToken eventToken) {
		Preconditions.checkArgument(eventToken.getCurrentState().eContainer() instanceof StateMachine);

		StateMachine sm = (StateMachine) eventToken.getCurrentState().eContainer();
		TrapState trapState = SMUtils.getTrapState(sm);
		Preconditions.checkNotNull(trapState);

		eventToken.setCurrentState(trapState);
	}

	protected boolean isTimeConstraintSatisfied(TimeConstraint constraint) {
		long start = constraint.getTimeConstraintSpecification().getStartTimestamp();
		long stop = constraint.getTimeConstraintSpecification().getStopTimestamp();
		long expected = constraint.getTimeConstraintSpecification().getExpectedLength();

		if (start == 0l || expected == 0l) {
			return true;
		}

		if (stop != 0l) {
			if (stop - start < expected) {
				return true;
			}
		}
		if (stop == 0l) {
			if (getCurrentTimeStamp() - start < expected) {
				return true;
			}
		}

		return false;
	}
}