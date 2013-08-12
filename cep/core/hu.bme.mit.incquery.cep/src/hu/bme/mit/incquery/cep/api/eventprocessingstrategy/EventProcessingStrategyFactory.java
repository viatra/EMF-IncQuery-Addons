package hu.bme.mit.incquery.cep.api.eventprocessingstrategy;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

public class EventProcessingStrategyFactory {
	public static IEventProcessingStrategy getStrategy(EventProcessingContext context,
			EventModelManager eventModelManager) {
		if (context == null) { // return default
			return new ChronicleStrategy(eventModelManager);
		}
		switch (context) {
		case CHRONICLE:
			return new ChronicleStrategy(eventModelManager);
		case STRICT_IMMEDIATE:
			return new StrictImmediateStrategy(eventModelManager);
		case IMMEDIATE:
			return new NormalImmediateStrategy(eventModelManager);
		case RECENT:
			throw new IllegalArgumentException();	// NOT IMPLEMENTED YET
		case UNRESTRICTED:
			throw new IllegalArgumentException();	// NOT IMPLEMENTED YET
		default:
			throw new IllegalArgumentException();	// SHALL NOT HAPPEN
		}
	}
}