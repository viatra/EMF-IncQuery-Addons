package hu.bme.mit.incquery.cep.tests.evm.integration2.main;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific.CepActivationStates;
import hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific.CepEventFilter;
import hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific.CepEventSourceSpecification;
import hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific.CepEventType;
import hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific.CepRealm;

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

public class EvmIntegration2 {
	
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
						+ activation.getAtom().getObservedEventPattern().getId());
			}
			@Override
			protected void handleError(Activation<? extends ObservedComplexEventPattern> activation,
					Exception exception, Context context) {
				// not gonna happen
			}
		};
		
		Job<ObservedComplexEventPattern> job2 = new Job<ObservedComplexEventPattern>(CepActivationStates.IS_NOT) {
			@Override
			protected void execute(Activation<? extends ObservedComplexEventPattern> activation, Context context) {
				System.out.println("Complex event pattern disappeared:"
						+ activation.getAtom().getObservedEventPattern().getId());
			}
			@Override
			protected void handleError(Activation<? extends ObservedComplexEventPattern> activation,
					Exception exception, Context context) {
				// not gonna happen
			}
		};
		
		CepEventSourceSpecification sourceSpec = new CepEventSourceSpecification();
		
		Set<Job<ObservedComplexEventPattern>> jobs = Sets.newHashSet(job, job2);
		
		RuleSpecification<ObservedComplexEventPattern> ruleSpec = new RuleSpecification<ObservedComplexEventPattern>(
				sourceSpec, lifeCycle, jobs);
		
		CepEventFilter filter = new CepEventFilter();
		engine.addRule(ruleSpec, false, filter);
		
		cepRealm.generateEvent(CepEventType.APPEARED);
		
		engine.getNextActivation().fire(Context.create());
		
	}
	
}
