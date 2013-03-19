package hu.bme.mit.obsolete.incquery.cep.runtime.evaluation;

import hu.bme.mit.obsolete.incquery.cep.eventmodel.Event;
import hu.bme.mit.obsolete.incquery.cep.eventmodel.IEventPattern;
import hu.bme.mit.obsolete.incquery.cep.runtime.EventQueue;

import java.util.Date;

import javax.naming.OperationNotSupportedException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class EventPatternMatcher {
	private long timestamp;
	protected IEventPattern eventPattern;
	protected Adapter eventQueueAdapter;
	
	public EventPatternMatcher(IEventPattern eventPattern, Event startingEvent) {
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
	
	public IEventPattern getEventPattern() {
		return eventPattern;
	}
	
	public void matchAndFire(Event event) {
		try {
			if (!eventPattern.isRecognized() && eventPattern.match(event)) {
				eventPattern.getCompositionAtomicEvents().remove(0);
			}
			if (eventPattern.isRecognized()) {
				removeListener();
				// TODO instantiate RuleInstance in EVM based on the action
				// defined in the pattern
				String patternName = eventPattern.getClass().getSimpleName();
				System.out.printf("Pattern \"%s\" has been fully matched. -- %s \n", patternName, timestamp);
			}
		} catch (OperationNotSupportedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void removeListener() {
		EventQueue.getInstance().eAdapters().remove(eventQueueAdapter);
	}
}