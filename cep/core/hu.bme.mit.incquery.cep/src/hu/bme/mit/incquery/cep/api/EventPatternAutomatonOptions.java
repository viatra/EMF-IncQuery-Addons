package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.api.strategy.Strategy;
import hu.bme.mit.incquery.cep.metamodels.internalsm.NoiseFiltering;

public class EventPatternAutomatonOptions {
	NoiseFiltering noiseFiltering;
	Strategy strategy;
	int priority;

	public static EventPatternAutomatonOptions getDefault() {
		return new EventPatternAutomatonOptions(NoiseFiltering.OFF, Strategy.CHRONICLE, 0);
	}

	public EventPatternAutomatonOptions(NoiseFiltering noiseFiltering, Strategy strategy, int priority) {
		this.noiseFiltering = noiseFiltering;
		this.strategy = strategy;
		this.priority = priority;
	}

	public NoiseFiltering getNoiseFiltering() {
		return noiseFiltering;
	}

	public void setNoiseFiltering(NoiseFiltering noiseFiltering) {
		this.noiseFiltering = noiseFiltering;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}