package hu.bme.mit.incquery.cep.newapi.wrappers;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

public class EventProcessingManager {

	private static EventProcessingManager instance;
	private EventModelManager eventModelManager;
	private EventProcessingContext context;
	
	public static EventProcessingManager getEventProcessingManager(){
		if(instance==null){
			instance = new EventProcessingManager();
		}
		return instance;
	}
	
	public EventProcessingManager setEventProcessingContext(EventProcessingContext context){
		this.context = context;
		return instance;
	}
	
	public void setLoggingLevel(){}
	public void registerEventAdapter(){}
}
