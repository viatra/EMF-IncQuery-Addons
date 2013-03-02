package hu.bme.mit.incquery.cep.runtime;

import hu.bme.mit.incquery.cep.eventmodel.Event;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * Singleton class for storing the event stream.
 * 
 * TODO:
 *  - make this class thread-safe
 *  - replace {@link LinkedBlockingQueue} with some kind of a memory-limited FIFO-queue
 * 
 * @author Istvan David
 */
public final class EventQueue extends EObjectImpl {
	private static EventQueue instance;
	private Queue<Event> queue = new LinkedBlockingQueue<Event>();
	
	private EventQueue() {
		super();
	}
	
	public static EventQueue getInstance() {
		if (instance == null) {
			instance = new EventQueue();
		}
		return instance;
	}
	
	/**
	 * Adds an {@link Event} to the {@link EventQueue}. Every new Event is published
	 * to the interested adapters via EMF's notification mechanism. For example
	 * see {@link EventPatternRegistry}.
	 * 
	 * @param event
	 *            the {@link Event} to be added
	 */
	public void push(Event event) {
		if (event == null) {
			return;
		}
		Queue<Event> oldQueue = this.queue;
		this.queue.add(event);
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.ADD, null, oldQueue, event));
		}
	}
	
	/**
	 * Returns the whole queue of {@link Event}s.
	 * 
	 * @return the queue containing yet unprocessed {@link Event}s
	 */
	public Queue<Event> getQueue() {
		return this.queue;
	}
}