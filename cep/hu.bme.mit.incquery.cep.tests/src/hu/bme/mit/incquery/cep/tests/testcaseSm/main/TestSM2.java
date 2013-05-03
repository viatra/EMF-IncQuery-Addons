package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.Strategy;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.D;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.DABC_Pattern_MIXED;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSM2 {
	DefaultRealm realm;
	EventQueue eventQueue;
	IEventSource source;
	DABC_Pattern_MIXED dabcPattern;
	EventModelManager manager;
	
	@Before
	public void setUp() {
		realm = new DefaultRealm();
		eventQueue = EventQueue.getInstance();
		dabcPattern = new DABC_Pattern_MIXED();
	}
	
	@After
	public void tearDown() {
		realm.dispose();
		eventQueue = null;
		dabcPattern = null;
		manager = null;
	}
	
	@Test
	public void test() throws InterruptedException, IncQueryException {
		
		List<EventPattern> eventPatterns = new ArrayList<EventPattern>();
		eventPatterns.add(dabcPattern);
		
		manager = EventModelManager.getInstance(eventPatterns, Strategy.getDefault());
		
		System.err.println("DIAG: Test starting.\n");
		// Thread.sleep(1000l);
		
		eventQueue.push(new D(source));
		// Thread.sleep(1000l);
		
		eventQueue.push(new B(source));
		// Thread.sleep(1000l);
		
		eventQueue.push(new C(source));
		// Thread.sleep(1000l);
		
		eventQueue.push(new A(source));
		// Thread.sleep(1000l);
		
		System.err.println("\nDIAG: Test finished.");
	}
}