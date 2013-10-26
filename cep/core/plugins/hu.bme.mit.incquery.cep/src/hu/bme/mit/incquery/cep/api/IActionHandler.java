package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;

import org.eclipse.incquery.runtime.evm.api.Activation;

public interface IActionHandler {
    void handle(Activation<? extends ObservedComplexEventPattern> activation);
}
