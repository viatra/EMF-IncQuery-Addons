package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;

import org.eclipse.incquery.runtime.evm.api.Activation;

public interface IActionHandler {
    void handle(Activation<? extends IObservableComplexEventPattern> activation);
}
