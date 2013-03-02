package org.eclipse.incquery.cep.tests.testcase1.main;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.cep.api.EventQueue;
import org.eclipse.incquery.cep.api.model.IEventPattern;
import org.eclipse.incquery.cep.api.model.IEventSource;
import org.eclipse.incquery.cep.runtime.EventPatternRegistry;
import org.eclipse.incquery.cep.runtime.PartiallyMatchedEventPatternRegistry;
import org.eclipse.incquery.cep.tests.testcase1.events.A;
import org.eclipse.incquery.cep.tests.testcase1.events.B;
import org.eclipse.incquery.cep.tests.testcase1.patterns.ABPattern;
import org.eclipse.incquery.cep.tests.testcase1.patterns.APattern;
import org.eclipse.incquery.cep.tests.testcase1.patterns.BPattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCase1 {
	EventQueue eventQueue;
	EventPatternRegistry eventPatternRegistry;
	PartiallyMatchedEventPatternRegistry partiallyMatchedEventRegistry;
	IEventSource source;
	
	@Before
	public void setUp() {
		eventQueue = EventQueue.getInstance();
		eventPatternRegistry = EventPatternRegistry.getInstance();
		partiallyMatchedEventRegistry = PartiallyMatchedEventPatternRegistry.getInstance();
	}
	
	@After
	public void tearDown() {
		eventQueue = null;
		eventPatternRegistry = null;
		partiallyMatchedEventRegistry = null;
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
			
			// matcher.execute();
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
