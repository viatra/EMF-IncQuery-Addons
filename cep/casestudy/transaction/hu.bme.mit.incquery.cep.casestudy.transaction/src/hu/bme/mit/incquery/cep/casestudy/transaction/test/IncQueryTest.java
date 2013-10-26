package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.casestudy.transaction.adapters.TransactionEventAdapter;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

import java.util.List;

public class IncQueryTest {
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
		// TODO
		// TransactionManager manager = TransactionManager.getInstance();
		// EList<ModelElement> modelElements = manager.getModelElements();
		// System.out.println("Elements in model: " + modelElements.size());
		//
		// ComponentA componentA =
		// TransactionFactory.eINSTANCE.createComponentA();
		// componentA.setCustomerId("asd");
		// componentA.setTimestamp(123l);
		// componentA.setTransactionId("qwerty");
		// manager.addComponent(componentA);
		// System.out.println("Elements in model: " + modelElements.size());
	}
}
