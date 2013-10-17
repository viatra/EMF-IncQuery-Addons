package hu.bme.mit.incquery.examples.apidemo;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.newapi.CepManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApiExample {
	DefaultRealm realm;

	@Before
	public void setUp() {
		realm = new DefaultRealm();
	}

	@After
	public void tearDown() {
		realm.dispose();
	}

	@Test
	public void test() {
		CepManager cepManager = CepManager.create();
		
		//Setting the Event Processing Context. If omitted, the default is applied.
		cepManager.setEventProcessingContext(EventProcessingContext.CHRONICLE);
		
		EventPattern dummyPattern = new EventPatternImpl() {};
		
		cepManager.addEventPattern(dummyPattern);
	}
}