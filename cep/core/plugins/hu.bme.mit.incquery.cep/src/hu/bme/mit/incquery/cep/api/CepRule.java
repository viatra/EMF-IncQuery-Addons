package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import java.util.List;

import org.eclipse.incquery.runtime.evm.api.Job;

import com.google.common.collect.Lists;

public class CepRule implements ICepRule {
    private List<EventPattern> eventPatterns = Lists.newArrayList();
    private Job<ObservedComplexEventPattern> job;

    public CepRule(List<EventPattern> eventPatterns, Job<ObservedComplexEventPattern> job) {
        this.eventPatterns = eventPatterns;
        this.job = job;
    }

    public void addEventPattern(EventPattern eventPattern) {
        eventPatterns.add(eventPattern);
    }

    public void addEventPatterns(List<EventPattern> eventPatterns) {
        this.eventPatterns.addAll(eventPatterns);
    }

    @Override
    public List<EventPattern> getEventPatterns() {
        return eventPatterns;
    }

    @Override
    public Job<ObservedComplexEventPattern> getJob() {
        return job;
    }
}
