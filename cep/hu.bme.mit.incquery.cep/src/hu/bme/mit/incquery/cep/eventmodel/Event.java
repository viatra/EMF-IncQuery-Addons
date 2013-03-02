package hu.bme.mit.incquery.cep.eventmodel;

import java.util.Date;

/**
 * A conventional Java bean representing a single event on the event stream.
 * 
 * @author Istvan David
 * 
 */
public class Event {
	private String id;
	private Long timestamp;
	private IEventSource eventSource;
	
	public Event(IEventSource eventSource) {
		timestamp = new Date().getTime();
		id = this.getClass().getName() + timestamp;
		this.eventSource = eventSource;
	}
	
	public String getId() {
		return id;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public IEventSource getEventSource() {
		return eventSource;
	}
}
