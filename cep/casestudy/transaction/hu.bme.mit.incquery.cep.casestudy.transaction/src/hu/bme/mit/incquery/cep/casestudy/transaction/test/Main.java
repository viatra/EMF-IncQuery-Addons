package hu.bme.mit.incquery.cep.casestudy.transaction.test;

import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.api.runtime.EventQueue;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC;
import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Main {
	DefaultRealm realm;
	EventQueue eventQueue;
	IEventSource source;
	ViatraCepManager manager;

	@Before
	public void setUp() {
		realm = new DefaultRealm();
		eventQueue = EventQueue.getInstance();
	}

	@After
	public void tearDown() {
		realm.dispose();
		eventQueue = null;
		manager = null;
	}

	@Test
	public void test() {
		manager = ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRule(new R1());

        System.err.println("DIAG: Test starting.\n");

        eventQueue.push(new ComponentA(source));
        eventQueue.push(new ComponentB(source));
        eventQueue.push(new ComponentA(source));
        eventQueue.push(new ComponentB(source));
        eventQueue.push(new ComponentC(source));

        System.err.println("\nDIAG: Test finished.");
	}
}
