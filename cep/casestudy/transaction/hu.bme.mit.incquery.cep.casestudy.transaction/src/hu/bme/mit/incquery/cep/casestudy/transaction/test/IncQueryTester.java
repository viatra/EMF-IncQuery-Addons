package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.casestudy.base.adapters.TransactionEventAdapter;
import hu.bme.mit.incquery.cep.casestudy.transaction.Component;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentA;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentB;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionFactory;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel;
import hu.bme.mit.incquery.cep.casestudy.transaction.mapping.IncQuery2ViatraCep;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.Lists;

public class IncQueryTester {
	private ICepAdapter adapter = new TransactionEventAdapter();

	private static IncQueryTester instance;

	private IncQueryTester() {
	}

	public static IncQueryTester getInstance() {
		if (instance == null) {
			instance = new IncQueryTester();
		}
		return instance;
	}

	private TransactionModel model;
	private Resource resource;
	private ResourceSet resourceSet;

	public void setup(ICepRule rule) {
		initializeEngine(rule);
		prepareModel();
		new IncQuery2ViatraCep(resourceSet, adapter).registerRules();
	}

	private void initializeEngine(ICepRule rule) {
		checkArgument(rule != null);
		ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRule(rule);
		prepareModel();
	}

	private void prepareModel() {
		model = TransactionFactory.eINSTANCE.createTransactionModel();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("transaction", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(URI.createURI("transaction/model.tr"));
		resource.getContents().add(model);
	}

	public void simulate() {
		System.out.println("Compound events in model: " + model.getLatestCompoundEvent());

		List<EventType> testSeries = Lists.newArrayList(EventType.A, EventType.B, EventType.C);

		for (int i = 0; i < 100000; i++) {
			for (EventType eventType : testSeries) {
				Component event = generateEvent(eventType);

				System.out.println("Refreshing model with " + event);
				model.setLatestComponentEvent(event);
			}
		}
	}

	private enum EventType {
		A, B, C
	}

	private Component generateEvent(EventType type) {
		String tId = "tr10";
		String cId = "c123";
		String sId = "s123";

		switch (type) {
		case A:
			TransactionComponentA componentA = TransactionFactory.eINSTANCE.createTransactionComponentA();
			componentA.setCustomerId(cId);
			componentA.setTransactionId(tId);
			return componentA;
		case B:
			TransactionComponentB componentB = TransactionFactory.eINSTANCE.createTransactionComponentB();
			componentB.setTransactionId(tId);
			return componentB;
		case C:
			TransactionComponentC componentC = TransactionFactory.eINSTANCE.createTransactionComponentC();
			componentC.setSupplierId(sId);
			componentC.setTransactionId(tId);
			return componentC;
		default:
			return null;
		}
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public TransactionModel getModel() {
		return model;
	}

	public void dispose() {
		instance = null;
	}
}