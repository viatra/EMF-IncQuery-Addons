package hu.bme.mit.incquery.cep.specific.evm;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;

import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.event.AbstractRuleInstanceBuilder;
import org.eclipse.incquery.runtime.evm.api.event.EventFilter;
import org.eclipse.incquery.runtime.evm.api.event.EventRealm;
import org.eclipse.incquery.runtime.evm.api.event.EventSourceSpecification;

public class CepEventSourceSpecification implements EventSourceSpecification<ObservedComplexEventPattern> {
	
	private EventPattern eventPattern;
	private EventModelManager eventModelManager;
	
	public CepEventSourceSpecification(EventPattern eventPattern, EventModelManager eventModelManager) {
		this.eventPattern = eventPattern;
		this.eventModelManager = eventModelManager;
	}
	
	@Override
	public EventFilter<ObservedComplexEventPattern> createEmptyFilter() {
		return new EmptyEventFilter();
	}
	
	@Override
	public AbstractRuleInstanceBuilder<ObservedComplexEventPattern> getRuleInstanceBuilder(final EventRealm realm) {
		return new AbstractRuleInstanceBuilder<ObservedComplexEventPattern>() {
			@Override
			public void prepareRuleInstance(RuleInstance<ObservedComplexEventPattern> ruleInstance,
					EventFilter<ObservedComplexEventPattern> filter) {
				CepEventSource source = new CepEventSource(CepEventSourceSpecification.this, (CepRealm) realm);
				CepEventHandler handler = new CepEventHandler(source, ruleInstance);
				StateMachine stateMachine = eventModelManager.getStateMachine(eventPattern);
				source.setStateMachine(stateMachine);
				source.addHandler(handler);
			}
		};
	}
}
