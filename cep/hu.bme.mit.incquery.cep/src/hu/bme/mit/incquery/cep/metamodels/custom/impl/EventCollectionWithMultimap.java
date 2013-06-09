package hu.bme.mit.incquery.cep.metamodels.custom.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventCollectionImpl;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

public class EventCollectionWithMultimap extends EventCollectionImpl {
	
	private Multimap<String, Event> recordedEvents = LinkedListMultimap.create();
	
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
