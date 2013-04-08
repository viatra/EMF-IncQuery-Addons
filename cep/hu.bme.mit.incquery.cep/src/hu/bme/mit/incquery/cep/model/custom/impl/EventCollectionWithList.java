package hu.bme.mit.incquery.cep.model.custom.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventCollectionImpl;

import java.util.ArrayList;
import java.util.List;

public class EventCollectionWithList extends EventCollectionImpl {
	
	private List<Event> recordedEvents = new ArrayList<Event>();
	
	@Override
	public List<Event> getRecordedEvents() {
		return recordedEvents;
	}
	
	@Override
	public void addEvent(Event event) {
		recordedEvents.add(event);
	}
}
