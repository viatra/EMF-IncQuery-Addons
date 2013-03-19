package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern;
import hu.bme.mit.incquery.cep.model.cep.Event;
import hu.bme.mit.incquery.cep.runtime.EventQueue;

import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class EventPatternMatcher {
	private long timestamp;
	protected AbstractEventPattern eventPattern;
	protected Adapter eventQueueAdapter;
	
	public EventPatternMatcher(AbstractEventPattern eventPattern, Event startingEvent) {
		this.timestamp = new Date().getTime();
		this.eventPattern = eventPattern;
		
		this.eventQueueAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				Object newValue = notification.getNewValue();
				if (newValue instanceof Event) {
					Event event = (Event) newValue;
					matchAndFire(event);
				}
			}
		};
		
		EventQueue.getInstance().eAdapters().add(eventQueueAdapter);
		
		// begin the evaluation with the first event
		matchAndFire(startingEvent);
	}
	
	public AbstractEventPattern getEventPattern() {
		return eventPattern;
	}
	
	public void matchAndFire(Event event) {
		if (!eventPattern.isRecognized() && eventPattern.match(event)) {
			eventPattern.getCompositionEvents().remove(0);
		}
		if (eventPattern.isRecognized()) {
			removeListener();
			// TODO instantiate RuleInstance in EVM based on the action
			// defined in the pattern
			String patternName = eventPattern.getClass().getSimpleName();
			System.out.printf("Pattern \"%s\" has been fully matched. -- %s \n", patternName, timestamp);
		}
	}
	
	public void removeListener() {
		EventQueue.getInstance().eAdapters().remove(eventQueueAdapter);
	}
}