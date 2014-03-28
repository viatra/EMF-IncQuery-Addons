package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.api.evm.CepActivationStates;
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.logging.LoggerUtils;

import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;

public class CepJobs {
    private static Logger logger = LoggerUtils.getInstance().getLogger();

    public static Job<IObservableComplexEventPattern> getDefaultJob() {
        return new Job<IObservableComplexEventPattern>(CepActivationStates.ACTIVE) {

            protected void execute(Activation<? extends IObservableComplexEventPattern> activation, Context context) {
                logger.debug("CepJobs#DefaultJob: Complex event pattern appeared: "
                        + activation.getAtom().getObservableEventPattern().getId());
            }

            @Override
            protected void handleError(Activation<? extends IObservableComplexEventPattern> activation,
                    Exception exception, Context context) {
                // not gonna happen
            }
        };
    }

}
