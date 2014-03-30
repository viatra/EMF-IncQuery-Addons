package hu.bme.mit.incquery.cep.tests.testcaseSm.main;

import hu.bme.mit.incquery.cep.api.CepJobs;
import hu.bme.mit.incquery.cep.api.CepRule;
import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.streams.EventStream;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.A;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.B;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.C;
import hu.bme.mit.incquery.cep.tests.testcaseSm.events.D;
import hu.bme.mit.incquery.cep.tests.testcaseSm.patterns.APattern;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtomicEvents {
    DefaultRealm realm;
    EventStream eventStream1;
    EventStream eventStream2;
    IEventSource source;
    APattern aPattern;
    EventModelManager manager;

    @Before
    public void setUp() {
        realm = new DefaultRealm();
        manager = new EventModelManager();
        eventStream1 = manager.getStreamManager().newEventStream();
        eventStream2 = manager.getStreamManager().newEventStream();
        aPattern = new APattern();
    }

    @After
    public void tearDown() {
        realm.dispose();
        eventStream1 = null;
        eventStream2 = null;
        aPattern = null;
        manager = null;
    }

    @Test
    public void test() throws InterruptedException, IncQueryException {

        List<EventPattern> eventPatterns = new ArrayList<EventPattern>();
        eventPatterns.add(aPattern);

        manager.setEventProcessingContext(EventProcessingContext.CHRONICLE);

        CepRule rule = new CepRule(eventPatterns, CepJobs.getDefaultJob());
        manager.addRule(rule);

        manager.setCepDebugLevel(Level.DEBUG);

        System.out.println("DIAG: Test starting.\n");

        eventStream2.push(new D(source));
        eventStream1.push(new B(source));
        eventStream2.push(new C(source));
        eventStream1.push(new A(source));

        System.out.println("\nDIAG: Test finished.");
    }
}