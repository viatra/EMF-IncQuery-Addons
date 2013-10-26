package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.casestudy.transaction.adapters.TransactionEventAdapter;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

import java.util.List;

public class BareJavaTester {
	private IEventSource source;
	private ICepAdapter adapter;

	public void initializeEngine(List<ICepRule> rules) {
		checkArgument(!rules.isEmpty());
		ViatraCepManager.withContext(EventProcessingContext.CHRONICLE)
				.addRules(rules);
	}

	public void initializeEngine(ICepRule rule) {
		checkArgument(rule != null);
		ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRule(
				rule);
	}

	public void acquireAdapter() {
		adapter = new TransactionEventAdapter();
	}

	public void simulate() {
		// pushing events into the adapter
		adapter.push(new hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA(
				source));
		adapter.push(new hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB(
				source));
		adapter.push(new hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC(
				source));
	}
}
