package hu.bme.mit.incquery.cep.tests.evm.integration.main;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.Strategy;
import hu.bme.mit.incquery.cep.tests.evm.integration.events.A;
import hu.bme.mit.incquery.cep.tests.evm.integration.events.B;
import hu.bme.mit.incquery.cep.tests.evm.integration.events.C;
import hu.bme.mit.incquery.cep.tests.evm.integration.patterns.ABCPattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntegrationTest {
	DefaultRealm realm;
	EventQueue eventQueue;
	IEventSource source;
	ABCPattern abcPattern;
	EventModelManager manager;
	
	@Before
	public void setUp() {
		realm = new DefaultRealm();
		eventQueue = EventQueue.getInstance();
		abcPattern = new ABCPattern();
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
		
		manager = EventModelManager.getInstance(eventPatterns, Strategy.getDefault(), RuleDefinitions.getEventRules());
		
		System.err.println("DIAG: Test starting.\n");
		eventQueue.push(new A(source));
		eventQueue.push(new B(source));
		eventQueue.push(new C(source));
		
		System.err.println("\nDIAG: Test finished.");
	}
	
}
