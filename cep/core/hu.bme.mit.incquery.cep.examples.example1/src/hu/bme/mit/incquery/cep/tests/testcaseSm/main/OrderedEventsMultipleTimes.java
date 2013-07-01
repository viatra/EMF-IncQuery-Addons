package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.api.runtime.EventQueue;
import hu.bme.mit.incquery.cep.api.strategy.Strategy;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.ABC_Pattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderedEventsMultipleTimes {
	DefaultRealm realm;
	EventQueue eventQueue;
	IEventSource source;
	ABC_Pattern abcPattern;
	EventModelManager manager;

	@Before
	public void setUp() {
		realm = new DefaultRealm();
		eventQueue = EventQueue.getInstance();
		abcPattern = new ABC_Pattern();
	}

	@After
	public void tearDown() {
		realm.dispose();
		eventQueue = null;
		abcPattern = null;
		manager = null;
	}

	@Test
	public void test() throws InterruptedException, IncQueryException {

		List<EventPattern> eventPatterns = new ArrayList<EventPattern>();
		eventPatterns.add(abcPattern);

		manager = new EventModelManager(Strategy.getDefault());
		manager.assignEventPatterns(eventPatterns);

		System.err.println("DIAG: Test starting.\n");

		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new C(source));
		eventQueue.push(new C(source));
		eventQueue.push(new C(source));
		eventQueue.push(new C(source));
		eventQueue.push(new C(source));

		System.err.println("\nDIAG: Test finished.");
	}
}