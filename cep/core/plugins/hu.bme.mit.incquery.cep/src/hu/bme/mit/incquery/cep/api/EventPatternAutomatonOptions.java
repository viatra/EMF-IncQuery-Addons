package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

public class EventPatternAutomatonOptions {
	private EventProcessingContext context;
	private int priority;

	public static EventPatternAutomatonOptions getDefault() {
		return new EventPatternAutomatonOptions(EventProcessingContext.CHRONICLE, 0);
	}

	public EventPatternAutomatonOptions(EventProcessingContext context, int priority) {
		this.context = context;
		this.priority = priority;
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