package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.api.evm.CepActivationStates;
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.utils.Logger;

import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;

public class CepJobs {
    public static Job<ObservedComplexEventPattern> getDefaultJob() {
        return new Job<ObservedComplexEventPattern>(CepActivationStates.ACTIVE) {

            protected void execute(Activation<? extends ObservedComplexEventPattern> activation, Context context) {
                Logger.log(">>>>>>>>>>>>>>>CEP: Complex event pattern appeared: "
                        + activation.getAtom().getObservedEventPattern().getId());
            }

            @Override
            protected void handleError(Activation<? extends ObservedComplexEventPattern> activation,
                    Exception exception, Context context) {
                // not gonna happen
            }
        };
    }

}
