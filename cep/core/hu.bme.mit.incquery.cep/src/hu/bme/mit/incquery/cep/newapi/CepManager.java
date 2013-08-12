package hu.bme.mit.incquery.cep.newapi;

import java.util.List;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.metamodels.internalsm.NoiseFiltering;

/**
 * Wrapper facade for the real event processing manager.
 * 
 * @author idavid
 * 
 */
public class CepManager {
	private static CepManager instance;
	private EventModelManager eventModelManager;

	public static CepManager create() {
		if (instance == null) {
			instance = new CepManager();
		}
		return instance;
	}

	private CepManager() {
		this.eventModelManager = new EventModelManager();
	}

	// options
	public void setEventProcessingContext(EventProcessingContext context) {
		eventModelManager.setEventProcessingContext(context);
	}

	// business data
	public void addEventPattern(EventPattern eventPattern) {
		// The NoiseFiltering parameter will be obsolete
		eventModelManager.assignEventPattern(eventPattern, NoiseFiltering.OFF);
	}

	public void removeEventPattern(EventPattern eventPattern) {
		// TODO
	}

	public void addEventPatterns(List<EventPattern> eventPatterns) {
		eventModelManager.assignEventPatterns(eventPatterns);
	}

	public void removeEventPatterns(List<EventPattern> eventPatterns) {
		// TODO
	}

	public void emptyEventPatterns() {
		// TODO
	}
	
	public void assignJob(){
		// TODO
	}

	// runtime
	public void registerEventQueue() {

	}

	public void execute() {
	}

	public EventModelManager getEventModelManager() {
		return eventModelManager;
	}

	
	/**
	 * consider the following methods for later enhancements
	 * 		public void setLoggingLevel();
	 * 
	 */
	
}