package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;
import hu.bme.mit.incquery.cep.tests.jobs.RulesAndJobs;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.ABC_Pattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.APattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.BC_Pattern;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.cevent.CEventMatch;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.enabledtransition.EnabledTransitionMatch;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.finishedstatemachine.FinishedStateMachineMatch;

import java.util.Map;

import org.apache.log4j.Level;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.RuleEngine;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSM {
	EventQueue eventQueue;
	EventModelManager modelManager;
	IEventSource source;
	ABC_Pattern abcPattern;
	APattern aPattern;
	BC_Pattern bcPattern;
	
	@Before
	public void setUp() {
		eventQueue = EventQueue.getInstance();
		modelManager = EventModelManager.getInstance();
		aPattern = new APattern();
		bcPattern = new BC_Pattern();
	}
	
	@After
	public void tearDown() {
		eventQueue = null;
		modelManager = null;
		aPattern = null;
		bcPattern = null;
	}
	
	@Test
	public void test() throws InterruptedException, IncQueryException {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("cep", new XMIResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource smModelResource = resourceSet.createResource(URI.createURI("cep/sm.cep"));
		
		if (smModelResource == null) {
			System.err.println("null resource");
		}
		smModelResource.getContents().add(modelManager.getModel());
		
		IncQueryEngine engine = EngineManager.getInstance().getIncQueryEngine(resourceSet);
		RuleEngine ruleEngine = EventDrivenVM.createRuleEngine(engine);
		engine.getLogger().setLevel(Level.DEBUG);
		
		RuleSpecification<FinishedStateMachineMatch> spec = RulesAndJobs.getIntance().getFinishedStateMachineRule();
		
		ruleEngine.addRule(spec);
		
		Context ctx = Context.create();
		
		System.err.println("DIAG: Test starting.\n");
		Thread.sleep(1000l);
		
		modelManager.buildStateMachine(aPattern);
		modelManager.buildStateMachine(bcPattern);
		
		eventQueue.push(new B(source));
		for (Activation<FinishedStateMachineMatch> activation : ruleEngine.getActivations(spec)) {
			activation.fire(ctx);
		}
		Thread.sleep(1000l);
		
		eventQueue.push(new C(source));
		for (Activation<FinishedStateMachineMatch> activation : ruleEngine.getActivations(spec)) {
			activation.fire(ctx);
		}
		Thread.sleep(1000l);
		
		eventQueue.push(new A(source));
		for (Activation<FinishedStateMachineMatch> activation : ruleEngine.getActivations(spec)) {
			activation.fire(ctx);
		}
		Thread.sleep(1000l);
		
		System.err.println("\nDIAG: Test finished.");
	}
}