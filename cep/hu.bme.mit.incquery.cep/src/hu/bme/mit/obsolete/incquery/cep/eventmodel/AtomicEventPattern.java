package hu.bme.mit.obsolete.incquery.cep.eventmodel;

/**
 * The most basic event pattern. It contains a type reference to exactly one
 * {@link Event}. If this Event is observed on the event stream, the
 * AtomicEventPattern is matched.
 * 
 * @author Istvan David
 * 
 */
public class AtomicEventPattern extends AbstractEventPattern {
	private Class<? extends Event> type;
	
	public AtomicEventPattern(Class<? extends Event> type) {
		super();
		this.type = type;
		compositionEvents.add(this);
	}
	
	@Override
	public boolean match(Event event) {
		if (event.getClass().equals(type)) {
			return true;
		}
		return false;
	}
	
	public Class<? extends Event> getType() {
		return type;
	}
}