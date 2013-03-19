package hu.bme.mit.incquery.cep.tests.testcaseEmf.main;

import hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern;
import hu.bme.mit.incquery.cep.model.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.tests.testcaseEmf.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseEmf.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseEmf.patterns.ABPattern;
import hu.bme.mit.incquery.cep.tests.testcaseEmf.patterns.APattern;
import hu.bme.mit.incquery.cep.tests.testcaseEmf.patterns.BPattern;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestcaseEMF {
	EventQueue eventQueue;
	EventModelManager modelManager;
	IEventSource source;
	
	@Before
	public void setUp() {
		eventQueue = EventQueue.getInstance();
		modelManager = EventModelManager.getInstance();
	}
	
	@After
	public void tearDown() {
		eventQueue = null;
		modelManager = null;
	}
	
	@Test
	public void test() {
		try {
			// this will be replaced by generating IncQuery patterns, from
			// here...
			List<AbstractEventPattern> eventPatterns = new ArrayList<AbstractEventPattern>();
			
			APattern ap = new APattern();
			BPattern bp = new BPattern();
			
			eventPatterns.add(ap);
			eventPatterns.add(bp);
			
			List<AbstractEventPattern> atomicEventPatternsForCP = new ArrayList<AbstractEventPattern>();
			atomicEventPatternsForCP.add(ap);
			atomicEventPatternsForCP.add(bp);
			atomicEventPatternsForCP.add(bp);
			ABPattern abp = new ABPattern(atomicEventPatternsForCP);
			
			eventPatterns.add(abp);
			
			modelManager.registerPatterns(eventPatterns);
			// ...to here
			
			System.out.println("starting test");
			
			A a1 = new A(source);
			Thread.sleep(250l);
			B b1 = new B(source);
			Thread.sleep(250l);
			A a2 = new A(source);
			Thread.sleep(250l);
			B b2 = new B(source);
			
			eventQueue.push(a1);
			eventQueue.push(b1);
			eventQueue.push(a2);
			eventQueue.push(b2);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
