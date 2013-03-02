package org.eclipse.incquery.cep.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.eclipse.incquery.cep.api.EventQueue;
import org.eclipse.incquery.cep.api.model.AtomicEventPattern;
import org.eclipse.incquery.cep.api.model.Event;
import org.eclipse.incquery.cep.api.model.IEventPattern;

/**
 * Singleton class for storing the {@link IEventPattern}s which already have
 * been matched partially, i.e. at least one of the composing
 * {@link AtomicEventPattern}s was loaded into the {@link EventQueue}.
 * 
 * TODO
 *  - replace this whole class by a state machine
 *  - tailor the CEP layer to the EVM via RuleInstance(s)
 * 
 * @author Istvan David
 * 
 */
public final class PartiallyMatchedEventPatternRegistry {
	private List<IEventPattern> partialPatternRegistry;
	private static PartiallyMatchedEventPatternRegistry instance;
	
	private PartiallyMatchedEventPatternRegistry() {
		partialPatternRegistry = new LinkedList<IEventPattern>();
	}
	
	public static PartiallyMatchedEventPatternRegistry getInstance() {
		if (instance == null) {
			instance = new PartiallyMatchedEventPatternRegistry();
		}
		return instance;
	}
	
	/**
	 * Registers a partially matched {@link IEventPattern} into the registry.
	 * 
	 * @param eventPattern
	 *            the {@link IEventPattern} to register
	 */
	public void registerPartialMatch(IEventPattern eventPattern) {
		IEventPattern partialPattern = eventPattern.getCompositionAtomicEvents().remove(0);
		partialPatternRegistry.add(partialPattern);
	}
	
	/**
	 * Registers multiple partially matched {@link IEventPattern}s into the
	 * registry.
	 * 
	 * @param eventPatterns
	 *            the {@link List} of {@link IEventPattern}s to register
	 */
	public void registerPartialMatches(List<IEventPattern> eventPatterns) {
		List<IEventPattern> partialEventPatterns = new ArrayList<IEventPattern>();
		
		for (IEventPattern eventPattern : eventPatterns) {
			eventPattern.getCompositionAtomicEvents().remove(0);
			partialEventPatterns.add(eventPattern);
		}
		
		partialPatternRegistry.addAll(partialEventPatterns);
	}
	
	/**
	 * Matches the partially matched patterns against the current {@link Event}
	 * and fires the recognized (fully matched) {@link IEventPattern}s.
	 */
	public void matchAndFireRecognizedPatterns(Event event) {
		Iterator<IEventPattern> iterator = partialPatternRegistry.iterator();
		while (iterator.hasNext()) {
			try {
				IEventPattern partialPattern = iterator.next();
				if (!partialPattern.isRecognized() && partialPattern.match(event)) {
					partialPattern.getCompositionAtomicEvents().remove(0);
				}
				if (partialPattern.isRecognized()) {
					// TODO instantiate RuleInstance in EVM based on the action
					// defined in the pattern
					String patternName = partialPattern.getClass().getSimpleName();
					iterator.remove();
					System.out.printf("Pattern \"%s\" has been fully matched.\n", patternName);
				}
			} catch (OperationNotSupportedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
