package hu.bme.mit.incquery.cep.api.evm;

import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.event.AbstractRuleInstanceBuilder;
import org.eclipse.incquery.runtime.evm.api.event.EventFilter;
import org.eclipse.incquery.runtime.evm.api.event.EventRealm;
import org.eclipse.incquery.runtime.evm.api.event.EventSourceSpecification;

public class CepEventSourceSpecification implements EventSourceSpecification<IObservableComplexEventPattern> {

	private StateMachine stateMachine;

	public CepEventSourceSpecification(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	@Override
	public EventFilter<IObservableComplexEventPattern> createEmptyFilter() {
		return new EmptyEventFilter();
	}

	@Override
	public AbstractRuleInstanceBuilder<IObservableComplexEventPattern> getRuleInstanceBuilder(final EventRealm realm) {
		return new AbstractRuleInstanceBuilder<IObservableComplexEventPattern>() {
			@Override
			public void prepareRuleInstance(RuleInstance<IObservableComplexEventPattern> ruleInstance,
					EventFilter<? super IObservableComplexEventPattern> filter) {
				CepEventSource source = new CepEventSource(CepEventSourceSpecification.this, (CepRealm) realm);
				CepEventHandler handler = new CepEventHandler(source, ruleInstance);
				source.setStateMachine(stateMachine);
				source.addHandler(handler);
			}
		};
	}
}
