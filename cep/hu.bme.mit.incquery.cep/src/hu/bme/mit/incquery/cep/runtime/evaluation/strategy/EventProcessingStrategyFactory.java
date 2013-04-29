package hu.bme.mit.incquery.cep.runtime.evaluation.strategy;

public class EventProcessingStrategyFactory {
	public static IEventProcessingStrategy getStrategy(Strategy strategy) {
		switch (strategy) {
			case CHRONICLE :
				return new ChronicleStrategy();
			case RECENT :
				return null; // return new RecentStrategy();
			case UNRESTRICTED :
				return null; // return new UnrestrictedStrategy();
			default :
				return null; // shall not happen
		}
	}
}