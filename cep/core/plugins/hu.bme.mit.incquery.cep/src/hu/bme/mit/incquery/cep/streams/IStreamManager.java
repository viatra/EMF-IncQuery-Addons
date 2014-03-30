package hu.bme.mit.incquery.cep.streams;

import java.util.List;

public interface IStreamManager {
    EventStream newEventStream();
    List<EventStream> getEventStreams();
}
