package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.logging.LoggerUtils;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ViatraCepManager {
    private EventModelManager eventModelManager;

    public static ViatraCepManager withContext(EventProcessingContext context) {
        return new ViatraCepManager(context);
    }

    private ViatraCepManager(EventProcessingContext context) {
        this.eventModelManager = new EventModelManager();
        eventModelManager.setEventProcessingContext(context);
    }

    public ViatraCepManager addRule(ICepRule rule) {
        eventModelManager.addRule(rule);
        return this;
    }

    public ViatraCepManager addRules(List<ICepRule> rules) {
        eventModelManager.addRules(rules);
        return this;
    }

    public void removeEventPattern(EventPattern eventPattern) {
        // TODO
    }

    public void removeEventPatterns(List<EventPattern> eventPatterns) {
        // TODO
    }

    public void emptyEventPatterns() {
        // TODO
    }

    public void assignJob() {
        // TODO
    }

    public EventModelManager getEventModelManager() {
        return eventModelManager;
    }

    public void setTopLevelExecutionSchemaDebugLevel(Level level) {
        eventModelManager.setDebuggingLevel(level);
    }

    public void setCepDebugLevel(Level level) {
        LoggerUtils.getInstance().getLogger().setLevel(level);
    }
}