package hu.bme.mit.incquery.cep.eventmodel;

import java.util.List;

import javax.naming.OperationNotSupportedException;

/**
 * Common interface for classes defining event patterns.
 * 
 * TODO
 * 	- remove OperationNotSupportedException from the signature by implementing
 * 		the state-machine based evaluation as discussed with Istvan
 * 
 * @author Istvan David
 * 
 */
public interface IEventPattern {
	/**
	 * Returns the {@link List} of {@link AtomicEventPattern}s composing the
	 * EventPattern.
	 */
	List<IEventPattern> getCompositionAtomicEvents();
	
	/**
	 * Attempts to match the currently observed {@link Event} against the
	 * EventPattern. It executes successfully if the first
	 * {@link AtomicEventPattern} in the list of composing patterns is of the
	 * type of the Event.
	 * 
	 * @throws OperationNotSupportedException
	 */
	boolean match(Event event) throws OperationNotSupportedException;
	
	/**
	 * Returns whether the EventPattern has been matched fully, i.e. recognized.
	 */
	boolean isRecognized();
}
