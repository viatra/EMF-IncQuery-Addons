package hu.bme.mit.incquery.cep.tests.testcase1.main;

import hu.bme.mit.incquery.cep.tests.testcase1.events.A;
import hu.bme.mit.incquery.cep.tests.testcase1.events.B;
import hu.bme.mit.incquery.cep.tests.testcase1.patterns.ABPattern;
import hu.bme.mit.incquery.cep.tests.testcase1.patterns.APattern;
import hu.bme.mit.incquery.cep.tests.testcase1.patterns.BPattern;
import hu.bme.mit.obsolete.incquery.cep.eventmodel.IEventPattern;
import hu.bme.mit.obsolete.incquery.cep.eventmodel.IEventSource;
import hu.bme.mit.obsolete.incquery.cep.runtime.EventPatternRegistry;
import hu.bme.mit.obsolete.incquery.cep.runtime.EventQueue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCase1 {
	EventQueue eventQueue;
	EventPatternRegistry eventPatternRegistry;
	IEventSource source;
	
	@Before
	public void setUp() {
		eventQueue = EventQueue.getInstance();
		eventPatternRegistry = EventPatternRegistry.getInstance();
	}
	
	@After
	public void tearDown() {
		eventQueue = null;
		eventPatternRegistry = null;
	}
	
	@Test
	public void test() {
		try {
			List<IEventPattern> eventPatterns = new ArrayList<IEventPattern>();
			APattern ap = new APattern(A.class);
			BPattern bp = new BPattern(B.class);
			
			eventPatterns.add(ap);
			eventPatterns.add(bp);
			
			List<IEventPattern> atomicEventPatternsForCP = new ArrayList<IEventPattern>();
			atomicEventPatternsForCP.add(ap);
			atomicEventPatternsForCP.add(bp);
			atomicEventPatternsForCP.add(bp);
			ABPattern abp = new ABPattern(atomicEventPatternsForCP);
			
			eventPatterns.add(abp);
			
			eventPatternRegistry.registerPatterns(eventPatterns);
			
			A a1 = new A(source);
			Thread.sleep(1000l);
			B b1 = new B(source);
			Thread.sleep(1000l);
			A a2 = new A(source);
			Thread.sleep(1000l);
			B b2 = new B(source);
			
			eventQueue.push(a1);
			eventQueue.push(b1);
			eventQueue.push(a2);
			eventQueue.push(b2);
			
			// matcher.execute();
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
