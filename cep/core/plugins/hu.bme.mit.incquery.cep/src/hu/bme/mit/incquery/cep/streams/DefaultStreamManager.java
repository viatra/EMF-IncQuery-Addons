package hu.bme.mit.incquery.cep.streams;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;

import java.util.List;

import com.google.common.collect.Lists;

public class DefaultStreamManager implements IStreamManager {
    private static IStreamManager instance;
    private EventModelManager listener;

    private static final int MAX_STREAMS = 1;
    private List<EventStream> eventStreams = Lists.newArrayList();

    public static IStreamManager getInstance(EventModelManager eventModelManager) {
        if (instance == null) {
            instance = new DefaultStreamManager(eventModelManager);
        }
        return instance;
    }

    private DefaultStreamManager(EventModelManager eventModelManager) {
        this.listener = eventModelManager;
    }

    @Override
    public EventStream newEventStream() {
        if (eventStreams.isEmpty() || eventStreams.size() < MAX_STREAMS) {
            EventStream newEventStream = new EventStream();
            eventStreams.add(newEventStream);
            listener.registerNewEventStream(newEventStream);
            return newEventStream;
        }

        // here some intelligence should be included to select the appropriate stream
        return eventStreams.get(0);
    }

    @Override
    public List<EventStream> getEventStreams() {
        return eventStreams;
    }
}
