package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.Strategy;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.ABC_Pattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.ABC_Pattern_UNORDERED;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.APattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.BC_Pattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSM {
	DefaultRealm realm;
	EventQueue eventQueue;
	IEventSource source;
	ABC_Pattern_UNORDERED abcPattern;
	APattern aPattern;
	BC_Pattern bcPattern;
	EventModelManager manager;
	
	@Before
	public void setUp() {
		realm = new DefaultRealm();
		eventQueue = EventQueue.getInstance();
		aPattern = new APattern();
		bcPattern = new BC_Pattern();
		abcPattern = new ABC_Pattern_UNORDERED();
	}
	
	@After
	public void tearDown() {
		realm.dispose();
		eventQueue = null;
		aPattern = null;
		bcPattern = null;
		abcPattern = null;
		manager = null;
	}
	
	@Test
	public void test() throws InterruptedException, IncQueryException {
		
		List<EventPattern> eventPatterns = new ArrayList<EventPattern>();
		eventPatterns.add(bcPattern);
		eventPatterns.add(aPattern);
		eventPatterns.add(abcPattern);
		
		manager = new EventModelManager(Strategy.getDefault());
		manager.assignEventPatterns(eventPatterns);
		
		System.err.println("DIAG: Test starting.\n");
		Thread.sleep(1000l);
		
		eventQueue.push(new A(source));
		Thread.sleep(1000l);
		
		eventQueue.push(new B(source));
		Thread.sleep(1000l);
		
		eventQueue.push(new C(source));
		Thread.sleep(1000l);
		
		eventQueue.push(new A(source));
		Thread.sleep(1000l);
		
		eventQueue.push(new B(source));
		Thread.sleep(1000l);
		
		eventQueue.push(new C(source));
		Thread.sleep(1000l);
		
		System.err.println("\nDIAG: Test finished.");
	}
}