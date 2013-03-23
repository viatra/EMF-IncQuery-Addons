package hu.bme.mit.incquery.cep.runtime;

import hu.bme.mit.incquery.metamodels.cep.AbstractEventPattern;
import hu.bme.mit.incquery.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.metamodels.cep.Event;
import hu.bme.mit.incquery.metamodels.cep.EventProcessingModel;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class EventModelManager {
	private static EventModelManager instance;
	private EventProcessingModel model;
	private static final CepFactory FACTORY = CepFactory.eINSTANCE;
	
	private EventModelManager() {
		this.model = FACTORY.createEventProcessingModel();
		
		Adapter adapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				Object newValue = notification.getNewValue();
				if (newValue instanceof Event) {
					Event event = (Event) newValue;
					findPotentialMatches(event);
				}
			}
		};
		EventQueue.getInstance().eAdapters().add(adapter);
	}
	
	public static EventModelManager getInstance() {
		if (instance == null) {
			instance = new EventModelManager();
		}
		return instance;
	}
	
	public EventProcessingModel getModel() {
		return model;
	}
	
	public void registerPatterns(List<AbstractEventPattern> eventPatterns) {
		// TODO generate the appropriate IncQuery patterns
	}
	
	private void findPotentialMatches(Event event) {
		// TODO invoke IncQuery: fire all rules
	}
}
