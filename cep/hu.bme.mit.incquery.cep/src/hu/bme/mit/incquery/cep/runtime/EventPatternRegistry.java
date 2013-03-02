package hu.bme.mit.incquery.cep.runtime;

import hu.bme.mit.incquery.cep.eventmodel.Event;
import hu.bme.mit.incquery.cep.eventmodel.IEventPattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import com.rits.cloning.Cloner;

/**
 * Singleton class for storing the original {@link IEventPattern}s defined by
 * the user which the {@link Event}s of the event stream are matched against.
 * 
 * @author Istvan David
 * 
 */
public final class EventPatternRegistry {
	private List<IEventPattern> patternRegistry;
	private static EventPatternRegistry instance;
	
	private EventPatternRegistry() {
		patternRegistry = new LinkedList<IEventPattern>();
		
		Adapter adapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				Object newValue = notification.getNewValue();
				if (newValue instanceof Event) {
					Event event = (Event) newValue;
					List<IEventPattern> partialMatches = findPartialMatches(event);
					PartiallyMatchedEventPatternRegistry.getInstance().registerPartialMatches(partialMatches);
					PartiallyMatchedEventPatternRegistry.getInstance().matchAndFireRecognizedPatterns(event);
				}
			}
		};
		EventQueue.getInstance().eAdapters().add(adapter);
	}
	
	public static EventPatternRegistry getInstance() {
		if (instance == null) {
			instance = new EventPatternRegistry();
		}
		return instance;
	}
	
	/**
	 * Initializes the registry with the user-defined {@link IEventPattern}s.
	 * 
	 * @param eventPatterns
	 *            a {@link List} of {@link IEventPattern}s to initialize the
	 *            registry with
	 */
	public void initialize(List<IEventPattern> eventPatterns) {
		patternRegistry = eventPatterns;
	}
	
	/**
	 * Registers single {@link IEventPattern} into the registry. The usage of
	 * this method should be avoided since the registry of the user-defined
	 * {@link IEventPattern}s should be considered final.
	 * 
	 * @param eventPattern
	 *            an {@link IEventPattern} to register
	 */
	public void registerPattern(IEventPattern eventPattern) {
		patternRegistry.add(eventPattern);
	}
	
	/**
	 * Registers multiple {@link IEventPattern}s into the registry. The usage of
	 * this method should be avoided since the registry of the user-defined
	 * {@link IEventPattern}s should be considered final.
	 * 
	 * @param eventPatterns
	 *            a {@link List} of {@link IEventPattern}s to register
	 */
	public void registerPatterns(List<IEventPattern> eventPatterns) {
		patternRegistry.addAll(eventPatterns);
	}
	
	/**
	 * Finds potentially matchable {@link IEventPattern}s in the registry.
	 * 
	 * @param event
	 *            the currently processed {@link Event} on the stream
	 * @return {@link List} of suitable {@link IEventPattern}s
	 */
	public List<IEventPattern> findPartialMatches(Event event) {
		List<IEventPattern> partialMatches = new ArrayList<IEventPattern>();
		
		for (IEventPattern registeredPattern : patternRegistry) {
			try {
				if (registeredPattern.match(event)) {
					Cloner cloner = new Cloner();
					partialMatches.add(cloner.deepClone(registeredPattern));
				}
			} catch (OperationNotSupportedException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return partialMatches;
	}
	public List<IEventPattern> getPatternRegistry() {
		return patternRegistry;
	}
}