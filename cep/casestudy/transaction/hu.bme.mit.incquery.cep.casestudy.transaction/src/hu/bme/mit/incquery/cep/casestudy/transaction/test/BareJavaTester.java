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
	private ViatraCepManager manager;

	public void initializeEngine(List<ICepRule> rules) {
		checkArgument(!rules.isEmpty());
		manager = ViatraCepManager
				.withContext(EventProcessingContext.CHRONICLE).addRules(rules);
	}

	public void initializeEngine(ICepRule rule) {
		checkArgument(rule != null);
		manager = ViatraCepManager
				.withContext(EventProcessingContext.CHRONICLE).addRule(rule);
	}

	public void acquireAdapter() {
		adapter = new TransactionEventAdapter();
	}

	public void simulate() {
//		// pushing events into the adapter
//
//		String transactionId = "t-10";
//		String customerId = "c-200";
//		String supplierId = "s-300";
//
//		ComponentA componentA = new hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA(
//				source);
//		componentA.setTransactionId(transactionId);
//		componentA.setCustomerId(customerId);
//
//		ComponentB componentB = new hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB(
//				source);
//		componentB.setTransactionId(transactionId);
//
//		ComponentC componentC = new hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC(
//				source);
//		componentC.setTransactionId(transactionId);
//		componentC.setSupplierId(supplierId);
//		
//		adapter.push(componentA);
//		adapter.push(componentB);
//		adapter.push(componentC);
	}
}
