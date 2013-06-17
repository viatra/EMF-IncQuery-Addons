package hu.bme.mit.incquery.cep.runtime.statemachine;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.Timewindow;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import java.util.LinkedHashMap;

public class TimingBuilder {
	private StateMachine stateMachine;
	private EventPattern rootPattern;
	private LinkedHashMap<EventPattern, Timewindow> timewindows;

	public TimingBuilder(StateMachine stateMachine, EventPattern rootPattern) {
		this.stateMachine = stateMachine;
		this.rootPattern = rootPattern;
		this.timewindows = new LinkedHashMap<EventPattern, Timewindow>();
	}

	private void getTimewindows(EventPattern eventPattern) {
		checkArgument(eventPattern != null);

		if (eventPattern instanceof AtomicEventPattern) {
			return;
		}
		
		Timewindow timewindow = ((ComplexEventPattern) eventPattern).getTimewindow();
		if (timewindow != null) {
			timewindows.put(eventPattern, timewindow);
		}
		
		
		for (EventPattern ep : eventPattern.getCompositionEvents()) {
			if (ep instanceof AtomicEventPattern) {
				continue;
			} else if (ep instanceof ComplexEventPattern) {
				Timewindow tw = ((ComplexEventPattern) ep).getTimewindow();
				if (tw != null) {
					getTimewindows(ep);
				}
			}
		}
	}
}
