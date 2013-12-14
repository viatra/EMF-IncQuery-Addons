package hu.bme.mit.incquery.cep.performance.md.test;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.casestudy.base.adapters.TransactionEventAdapter;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.performance.mapping.IncQuery2ViatraCep;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.Component;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentA;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentB;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentC;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentD;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentE;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentF;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentG;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentH;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentI;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionComponentJ;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionFactory;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.Lists;

public class MDPerformanceTester {
	private ICepAdapter adapter = new TransactionEventAdapter();
	private File log;
	private int observedComplexPatterns = 0;
	private BufferedWriter bw;
	private TransactionModel model;
	private ResourceSet resourceSet;

	private static MDPerformanceTester instance;

	private MDPerformanceTester() {
		model = TransactionFactory.eINSTANCE.createTransactionModel();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("transaction", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI("transaction/model.tr"));
		resource.getContents().add(model);
	}

	public static MDPerformanceTester getInstance() {
		if (instance == null) {
			instance = new MDPerformanceTester();
		}
		return instance;
	}

	public void setup(ICepRule rule) throws IOException {
		checkArgument(rule != null);
		new IncQuery2ViatraCep(resourceSet, adapter).registerRules();

		log = new File("log.txt");
		log.createNewFile();
		FileWriter fw = new FileWriter(log.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		bw.write("Compilation started: " + new Date().getTime() + "\n");
		ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRule(rule);
		bw.write("Compilation ended: " + new Date().getTime() + "\n\n");
	}

	public void simulate() throws IOException {
		int inputEvents = 0;
		bw.write("Simulation started: " + new Date().getTime() + "\n");

		List<EventType> testSeries = Lists.newArrayList(EventType.A, EventType.B, EventType.C, EventType.D,
				EventType.E, EventType.F, EventType.G);

		for (int i = 0; i < 100; i++) {
			System.out.println("+++Turnaround: " + i);
			for (EventType eventType : testSeries) {
				Component event = generateEvent(eventType);

				System.out.println("Refreshing model with " + event);
				inputEvents++;
				model.setLatestComponentEvent(event);
			}
		}
		bw.write("Simulation ended: " + new Date().getTime() + "\n\n");
		bw.write("Input events: " + inputEvents + "\n");
		bw.write("Observed complex patterns: " + observedComplexPatterns + "\n");
		bw.close();
	}

	private enum EventType {
		A, B, C, D, E, F, G, H, I, J, K, L, M, N
	}

	private Component generateEvent(EventType type) {
		switch (type) {
		case A:
			TransactionComponentA componentA = TransactionFactory.eINSTANCE.createTransactionComponentA();
			return componentA;
		case B:
			TransactionComponentB componentB = TransactionFactory.eINSTANCE.createTransactionComponentB();
			return componentB;
		case C:
			TransactionComponentC componentC = TransactionFactory.eINSTANCE.createTransactionComponentC();
			return componentC;
		case D:
			TransactionComponentD componentD = TransactionFactory.eINSTANCE.createTransactionComponentD();
			return componentD;
		case E:
			TransactionComponentE componentE = TransactionFactory.eINSTANCE.createTransactionComponentE();
			return componentE;
		case F:
			TransactionComponentF componentF = TransactionFactory.eINSTANCE.createTransactionComponentF();
			return componentF;
		case G:
			TransactionComponentG componentG = TransactionFactory.eINSTANCE.createTransactionComponentG();
			return componentG;
		case H:
			TransactionComponentH componentH = TransactionFactory.eINSTANCE.createTransactionComponentH();
			return componentH;
		case I:
			TransactionComponentI componentI = TransactionFactory.eINSTANCE.createTransactionComponentI();
			return componentI;
		case J:
			TransactionComponentJ componentJ = TransactionFactory.eINSTANCE.createTransactionComponentJ();
			return componentJ;
		default:
			return null;
		}
	}

	public void dispose() {
		instance = null;
	}

	public File getLog() {
		return log;
	}

	public int getObservedComplexPatterns() {
		return observedComplexPatterns;
	}

	public void increaseObservedPatternCount() {
		observedComplexPatterns++;
	}
}
