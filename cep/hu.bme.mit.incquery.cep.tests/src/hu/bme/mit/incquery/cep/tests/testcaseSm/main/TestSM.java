package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.ABC_Pattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.APattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSM {
	EventQueue eventQueue;
	EventModelManager modelManager;
	IEventSource source;
	ABC_Pattern abcPattern;
	APattern aPattern;
	
	@Before
	public void setUp() {
		eventQueue = EventQueue.getInstance();
		modelManager = EventModelManager.getInstance();
		abcPattern = new ABC_Pattern();
		aPattern = new APattern();
	}
	
	@After
	public void tearDown() {
		eventQueue = null;
		modelManager = null;
		abcPattern = null;
		aPattern = null;
	}
	
	@Test
	public void test() throws InterruptedException {
		System.err.println("DIAG: Test starting.\n");
		Thread.sleep(1000l);
		
		modelManager.buildStateMachine(aPattern);
		
		// eventQueue.push(new A(source));
		// Thread.sleep(1000l);
		eventQueue.push(new B(source));
		Thread.sleep(1000l);
		// eventQueue.push(new A(source));
		// Thread.sleep(1000l);
		eventQueue.push(new C(source));
		Thread.sleep(1000l);
		eventQueue.push(new A(source));
		Thread.sleep(1000l);
		
		System.err.println("\nDIAG: Test finished.");
	}
	
}