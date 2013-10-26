package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

public interface ICepAdapter {
    void push(Event event);
}
