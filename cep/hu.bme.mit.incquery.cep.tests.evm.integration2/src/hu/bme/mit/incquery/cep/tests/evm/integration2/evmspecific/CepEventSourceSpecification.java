package hu.bme.mit.incquery.cep.tests.evm.integration2.evmspecific;

import hu.bme.mit.incquery.cep.api.ObservedComplexEventPattern;

import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.event.AbstractRuleInstanceBuilder;
import org.eclipse.incquery.runtime.evm.api.event.EventFilter;
import org.eclipse.incquery.runtime.evm.api.event.EventRealm;
import org.eclipse.incquery.runtime.evm.api.event.EventSourceSpecification;

public class CepEventSourceSpecification implements EventSourceSpecification<ObservedComplexEventPattern> {
	
	@Override
	public EventFilter<ObservedComplexEventPattern> createEmptyFilter() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AbstractRuleInstanceBuilder<ObservedComplexEventPattern> getRuleInstanceBuilder(final EventRealm realm) {
		return new AbstractRuleInstanceBuilder<ObservedComplexEventPattern>() {
			@Override
			public void prepareRuleInstance(RuleInstance<ObservedComplexEventPattern> ruleInstance,
					EventFilter<ObservedComplexEventPattern> filter) {
				CepEventSource source = new CepEventSource(CepEventSourceSpecification.this, (CepRealm) realm);
				CepEventHandler handler = new CepEventHandler(source, (CepEventFilter) filter, ruleInstance);
				source.addHandler(handler);
			}
		};
	}
}
