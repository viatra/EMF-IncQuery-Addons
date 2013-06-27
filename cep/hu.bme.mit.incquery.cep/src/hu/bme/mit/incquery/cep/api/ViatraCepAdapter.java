package hu.bme.mit.incquery.cep.api;

import java.util.Calendar;

import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;

/**
 * Adapters delegating events from a given realm must extend this class.
 * 
 * @author idavid
 *
 */
public abstract class ViatraCepAdapter {
	protected EventModelManager eventModelManager;
	protected EventQueue eventQueue = EventQueue.getInstance();
	
	public abstract void registerAdapter();

	protected long getCurrentTimeStamp() {
		Calendar c = Calendar.getInstance();
		return c.getTimeInMillis();
	}
	
	public EventModelManager getEventModelManager() {
		return eventModelManager;
	}

	public EventQueue getEventQueue() {
		return eventQueue;
	}
}
