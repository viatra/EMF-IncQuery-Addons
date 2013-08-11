package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.metamodels.internalsm.NoiseFiltering;

public class EventPatternAutomatonOptions {
	private NoiseFiltering noiseFiltering;
	private EventProcessingContext context;
	private int priority;

	public static EventPatternAutomatonOptions getDefault() {
		return new EventPatternAutomatonOptions(NoiseFiltering.OFF, EventProcessingContext.CHRONICLE, 0);
	}

	public EventPatternAutomatonOptions(NoiseFiltering noiseFiltering, EventProcessingContext context, int priority) {
		this.noiseFiltering = noiseFiltering;
		this.context = context;
		this.priority = priority;
	}

	public NoiseFiltering getNoiseFiltering() {
		return noiseFiltering;
	}

	public void setNoiseFiltering(NoiseFiltering noiseFiltering) {
		this.noiseFiltering = noiseFiltering;
	}

	public EventProcessingContext getContext() {
		return context;
	}

	public void setContext(EventProcessingContext context) {
		this.context = context;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}