package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import java.util.Collection;
import java.util.Map;

import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.ABC_Pattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.APattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.BC_Pattern;
import hu.bme.mit.incquery.cep.tests.testcasesmqueries.event.EventMatch;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.MatcherFactoryRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

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
	
	// commented code is related to the generated queries
	@Test
	public void test() throws InterruptedException, IncQueryException {
		// Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		// Map<String, Object> m = reg.getExtensionToFactoryMap();
		// m.put("cep", new XMIResourceFactoryImpl());
		//
		// ResourceSet rs = new ResourceSetImpl();
		// Resource r = rs.createResource(URI.createURI("cep/sm.model"));
		//
		// if (r == null) {
		// System.out.println("null resource");
		// }
		// r.getContents().add(modelManager.getModel());
		//
		// IncQueryEngine engine =
		// EngineManager.getInstance().getIncQueryEngine(rs);
		// if (engine == null) {
		// System.out.println("null engine");
		// }
		//
		// IMatcherFactory mf = MatcherFactoryRegistry
		// .getMatcherFactory("hu.bme.mit.incquery.cep.tests.testcasesmqueries.event");
		//
		// if (mf == null) {
		// System.out.println("null matcher factory");
		// }
		// IncQueryMatcher matcher = mf.getMatcher(engine);
		
		System.err.println("DIAG: Test starting.\n");
		Thread.sleep(1000l);
		
		modelManager.buildStateMachine(aPattern);
		modelManager.buildStateMachine(bcPattern);
		
		eventQueue.push(new B(source));
		// check(matcher);
		Thread.sleep(1000l);
		eventQueue.push(new C(source));
		// check(matcher);
		Thread.sleep(1000l);
		eventQueue.push(new A(source));
		// check(matcher);
		Thread.sleep(1000l);
		
		System.err.println("\nDIAG: Test finished.");
	}
	private void check(IncQueryMatcher matcher) {
		Collection<IPatternMatch> matches = matcher.getAllMatches();
		for (IPatternMatch match : matches) {
			System.out.println("IQ: " + match.prettyPrint());
		}
	}
}