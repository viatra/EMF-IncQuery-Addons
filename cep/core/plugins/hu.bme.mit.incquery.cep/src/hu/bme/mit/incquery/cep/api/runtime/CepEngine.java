package hu.bme.mit.incquery.cep.api.runtime;


/**
 * Initial implementation
 * @author idavid
 *
 */
public class CepEngine {
    private EventModelManager eventModelManager;

    public CepEngine() {
        eventModelManager = new EventModelManager();
    }

    public EventModelManager getEventModelManager() {
        return eventModelManager;
    }
}
