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
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.DABC_Pattern_MIXED_Timed;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventsWithTimewindows {
	DefaultRealm realm;
	EventQueue eventQueue;
	IEventSource source;
	DABC_Pattern_MIXED_Timed dabcPattern;
	EventModelManager manager;
	
	@Before
	public void setUp() {
		realm = new DefaultRealm();
		eventQueue = EventQueue.getInstance();
		dabcPattern = new DABC_Pattern_MIXED_Timed();
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
		
		manager = new EventModelManager(Strategy.getDefault());
		manager.assignEventPatterns(eventPatterns);
		
		System.err.println("DIAG: Test starting.\n");
		
		eventQueue.push(new D(source));
		eventQueue.push(new B(source));
		eventQueue.push(new C(source));
		Thread.sleep(1488l);
		eventQueue.push(new A(source));
		
		System.err.println("\nDIAG: Test finished.");
	}
}