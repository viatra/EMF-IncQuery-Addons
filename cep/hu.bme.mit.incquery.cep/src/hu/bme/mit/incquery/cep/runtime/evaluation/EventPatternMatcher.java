package hu.bme.mit.incquery.cep.runtime.evaluation;

import hu.bme.mit.incquery.cep.eventmodel.Event;
import hu.bme.mit.incquery.cep.runtime.EventQueue;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class EventPatternMatcher implements Runnable {
	private IState state;
	private Adapter eventQueueAdapter;
	
	public EventPatternMatcher(IState startingState) {
		state = startingState;
		eventQueueAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				System.out.println("Notification received: " + notification);
				Object newValue = notification.getNewValue();
				if (newValue instanceof Event) {
					Event event = (Event) newValue;
					state.handleEvent(EventPatternMatcher.this, event);
				}
			}
		};
		
		EventQueue.getInstance().eAdapters().add(eventQueueAdapter);
	}
	public IState getState() {
		return state;
	}
	
	public void setState(IState state) {
		this.state = state;
	}
	
	public void dispose() {
		EventQueue.getInstance().eAdapters().remove(eventQueueAdapter);
		// TODO interrupt current thread
	}
	
	@Override
	public void run() {
		while (true) {
			// NOP - wait for events
		}
	}
}