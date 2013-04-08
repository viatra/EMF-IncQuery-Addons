package hu.bme.mit.incquery.cep.model.custom.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventCollectionImpl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class EventCollectionWithMultimap extends EventCollectionImpl {
	
	private Multimap<String, Event> recordedEvents = ArrayListMultimap.create();
	
	@Override
	public Multimap<String, Event> getRecordedEvents() {
		return recordedEvents;
	}
	
	@Override
	public void addEvent(Event event) {
		String id = event.getTypeId();
		recordedEvents.put(id, event);
	}
}
