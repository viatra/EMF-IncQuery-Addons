package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import java.util.List;

import org.eclipse.incquery.runtime.evm.api.Job;

public interface ICepRule {
    List<EventPattern> getEventPatterns();

    Job<IObservableComplexEventPattern> getJob();
}
