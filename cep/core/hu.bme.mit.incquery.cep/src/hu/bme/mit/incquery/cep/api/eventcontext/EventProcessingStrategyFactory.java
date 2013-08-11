package hu.bme.mit.incquery.cep.api.eventcontext;

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
		case RECENT:
			return null; // return new RecentStrategy();
		case UNRESTRICTED:
			return null; // return new UnrestrictedStrategy();
		default:
			return null; // shall not happen
		}
	}
}