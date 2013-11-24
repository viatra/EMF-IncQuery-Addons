package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentA;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentB;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionComponentC;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionFactory;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel;
import hu.bme.mit.incquery.cep.casestudy.transaction.adapters.TransactionEventAdapter;
import hu.bme.mit.incquery.cep.casestudy.transaction.test.mhr.Patterns2Events;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class IncQueryTester {
	private ICepAdapter adapter = new TransactionEventAdapter();
	private TransactionModel model;
	private Resource resource;
	private ResourceSet resourceSet;

	public void initializeEngine(ICepRule rule) {
		checkArgument(rule != null);
		ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRule(rule);
		prepareModel();
		initializeModelHandling();
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

	private void initializeModelHandling() {
		Patterns2Events mhr = new Patterns2Events(this);
		mhr.registerRules();
	}

	public void simulate() {
		System.out.println("Compound events in model: " + model.getLatestCompoundEvent());

		TransactionComponentA componentA = TransactionFactory.eINSTANCE.createTransactionComponentA();
		componentA.setCustomerId("c123");
		componentA.setTimestamp(0001l);
		componentA.setTransactionId("tr10");
		System.out.println("Refreshing model with " + componentA);
		model.setLatestComponentEvent(componentA);
		
		TransactionComponentB componentB = TransactionFactory.eINSTANCE.createTransactionComponentB();
		componentB.setTimestamp(0002l);
		componentB.setTransactionId("tr10");
		System.out.println("Refreshing model with " + componentB);
		model.setLatestComponentEvent(componentB);
		
		TransactionComponentC componentC = TransactionFactory.eINSTANCE.createTransactionComponentC();
		componentC.setSupplierId("s123");
		componentC.setTimestamp(5002l);
		componentC.setTransactionId("tr10");
		System.out.println("Refreshing model with " + componentC);
		model.setLatestComponentEvent(componentC);
	}

	public ICepAdapter getAdapter() {
		return adapter;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}
}