package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import hu.bme.mit.incquery.cep.api.CepJobs;
import hu.bme.mit.incquery.cep.api.CepRule;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.api.runtime.EventQueue;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.D;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.ABC_Pattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.BCD_Pattern;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.BC_Pattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class MultipleComplexEventsInRules3 {
    DefaultRealm realm;
    EventQueue eventQueue;
    IEventSource source;
    ABC_Pattern pattern1;
    BCD_Pattern pattern2;
    BC_Pattern pattern3;
    ViatraCepManager manager;

    @Before
    public void setUp() {
        realm = new DefaultRealm();
        eventQueue = EventQueue.getInstance();
        pattern1 = new ABC_Pattern();
        pattern2 = new BCD_Pattern();
        pattern3 = new BC_Pattern();
    }

    @After
    public void tearDown() {
        realm.dispose();
        eventQueue = null;
        pattern1 = null;
        pattern2 = null;
        pattern3 = null;
        manager = null;
    }

    @Test
    public void test() throws InterruptedException, IncQueryException {
        List<ICepRule> rules = Lists.newArrayList();

        List<EventPattern> eventPatterns1 = new ArrayList<EventPattern>();
        eventPatterns1.add(pattern1);
        eventPatterns1.add(pattern2);
        CepRule rule1 = new CepRule(eventPatterns1, CepJobs.getDefaultJob());
        rules.add(rule1);
        
        List<EventPattern> eventPatterns3 = new ArrayList<EventPattern>();
        eventPatterns3.add(pattern3);
        CepRule rule3 = new CepRule(eventPatterns3, CepJobs.getDefaultJob());
        rules.add(rule3);

        manager = ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRules(rules);

        System.err.println("DIAG: Test starting.\n");

        eventQueue.push(new A(source));
        Thread.sleep(1500l);
        eventQueue.push(new B(source));
        Thread.sleep(1500l);
        eventQueue.push(new C(source));
        Thread.sleep(1500l);
        eventQueue.push(new D(source));
        Thread.sleep(1500l);

        System.err.println("\nDIAG: Test finished.");
    }
}