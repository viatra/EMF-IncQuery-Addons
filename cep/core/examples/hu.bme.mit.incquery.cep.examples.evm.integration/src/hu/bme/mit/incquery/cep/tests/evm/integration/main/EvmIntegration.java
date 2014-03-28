package hu.bme.mit.incquery.cep.tests.evm.integration.main;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific.CepActivationStates;
import hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific.CepEventFilter;
import hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific.CepEventSourceSpecification;
import hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific.CepEventType;
import hu.bme.mit.incquery.cep.tests.evm.integration.evmspecific.CepRealm;

import java.util.Set;

import org.apache.log4j.Level;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.ActivationLifeCycle;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.RuleEngine;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.event.EventType.RuleEngineEventType;
import org.junit.Test;

import com.google.common.collect.Sets;

public class EvmIntegration {

    @Test
    public void testEvmIntegration2() {
        CepRealm cepRealm = new CepRealm();
        RuleEngine engine = EventDrivenVM.createRuleEngine(cepRealm);
        engine.getLogger().setLevel(Level.DEBUG);

        ActivationLifeCycle lifeCycle = ActivationLifeCycle.create(CepActivationStates.IS_NOT);
        lifeCycle.addStateTransition(CepActivationStates.IS_NOT, CepEventType.APPEARED, CepActivationStates.IS);
        lifeCycle.addStateTransition(CepActivationStates.IS, RuleEngineEventType.FIRE, CepActivationStates.IS_NOT);

        Job<ObservedComplexEventPattern> job = new Job<ObservedComplexEventPattern>(CepActivationStates.IS) {
            @Override
            protected void execute(Activation<? extends ObservedComplexEventPattern> activation, Context context) {
                System.out.println("Complex event pattern observed:"
                        + activation.getAtom().getObservableEventPattern().getId());
            }

            @Override
            protected void handleError(Activation<? extends ObservedComplexEventPattern> activation,
                    Exception exception, Context context) {
                // not gonna happen
            }
        };

        CepEventSourceSpecification sourceSpec = new CepEventSourceSpecification();

        @SuppressWarnings("unchecked")
        Set<Job<ObservedComplexEventPattern>> jobs = Sets.newHashSet(job);

        RuleSpecification<ObservedComplexEventPattern> ruleSpec = new RuleSpecification<ObservedComplexEventPattern>(
                sourceSpec, lifeCycle, jobs);

        CepEventFilter filter = new CepEventFilter();
        engine.addRule(ruleSpec, filter);

        cepRealm.generateEvent(CepEventType.APPEARED);

        engine.getNextActivation().fire(Context.create());

    }

}
