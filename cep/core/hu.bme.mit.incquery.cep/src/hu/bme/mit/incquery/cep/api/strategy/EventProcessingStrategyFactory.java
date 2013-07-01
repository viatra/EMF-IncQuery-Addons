package hu.bme.mit.incquery.cep.api.strategy;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;

public class EventProcessingStrategyFactory {
	public static IEventProcessingStrategy getStrategy(Strategy strategy, EventModelManager eventModelManager) {
		switch (strategy) {
			case CHRONICLE :
				return new ChronicleStrategy(eventModelManager);
			case RECENT :
				return null; // return new RecentStrategy();
			case UNRESTRICTED :
				return null; // return new UnrestrictedStrategy();
			default :
				return null; // shall not happen
		}
	}
}