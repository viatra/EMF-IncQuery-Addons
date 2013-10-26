package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import hu.bme.mit.incquery.cep.api.CepJobs;
import hu.bme.mit.incquery.cep.api.CepRule;
import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.api.runtime.EventQueue;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.D;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.E;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.F;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.G;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.H;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.I;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.J;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.LargeComplexEventPattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LargeComplexEvent {
	DefaultRealm realm;
	EventQueue eventQueue;
	IEventSource source;
	LargeComplexEventPattern pattern;
	EventModelManager manager;

	@Before
	public void setUp() {
		realm = new DefaultRealm();
		eventQueue = EventQueue.getInstance();
		pattern = new LargeComplexEventPattern();
	}

	@After
	public void tearDown() {
		realm.dispose();
		eventQueue = null;
		pattern = null;
		manager = null;
	}

	@Test
	public void test() throws InterruptedException, IncQueryException {

		List<EventPattern> eventPatterns = new ArrayList<EventPattern>();
		eventPatterns.add(pattern);

		manager = new EventModelManager();
		//manager.assignEventPatterns(eventPatterns);
        CepRule rule = new CepRule(eventPatterns, CepJobs.getDefaultJob()); 
        manager.addRule(rule);

		System.err.println("DIAG: Test starting.\n");
		
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new C(source));
		eventQueue.push(new D(source));
		eventQueue.push(new E(source));
		eventQueue.push(new F(source));
		eventQueue.push(new G(source));
		eventQueue.push(new H(source));
		eventQueue.push(new I(source));
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new C(source));
		eventQueue.push(new D(source));
		eventQueue.push(new E(source));
		eventQueue.push(new F(source));
		eventQueue.push(new G(source));
		eventQueue.push(new H(source));
		eventQueue.push(new I(source));
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new C(source));
		eventQueue.push(new D(source));
		eventQueue.push(new E(source));
		eventQueue.push(new F(source));
		eventQueue.push(new G(source));
		eventQueue.push(new H(source));
		eventQueue.push(new I(source));
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new C(source));
		eventQueue.push(new D(source));
		eventQueue.push(new E(source));
		eventQueue.push(new F(source));
		eventQueue.push(new G(source));
		eventQueue.push(new H(source));
		eventQueue.push(new I(source));
		//Thread.sleep(990l);
		eventQueue.push(new J(source));
	
		System.err.println("\nDIAG: Test finished.");
	}
}