package hu.bme.mit.incquery.cep.casestudy.java.test;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.casestudy.base.adapters.TransactionEventAdapter;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA_Event;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB_Event;
import hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC_Event;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

import java.util.List;

import com.google.common.collect.Lists;

public class JavaTester {
	private ICepAdapter adapter = new TransactionEventAdapter();

	private static JavaTester instance;

	private JavaTester() {
	}

	public static JavaTester getInstance() {
		if (instance == null) {
			instance = new JavaTester();
		}
		return instance;
	}

	public void setup(ICepRule rule) {
		checkArgument(rule != null);
		ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRule(rule);
	}

	public void simulate() {
		List<EventType> testSeries = Lists.newArrayList(EventType.A, EventType.B, EventType.C, EventType.A);

		//for (int i = 0; i < 100000; i++) {
			for (EventType eventType : testSeries) {
				ParameterizableEventInstance event = generateEvent(eventType);

				System.out.println("Refreshing model with " + event);
				adapter.push(event);
			}
		//}
	}

	private enum EventType {
		A, B, C
	}

	private ParameterizableEventInstance generateEvent(EventType type) {
		String tId = "tr10";
		String cId = "c123";
		String sId = "s123";

		switch (type) {
		case A:
			ComponentA_Event componentA = new ComponentA_Event(null);
			componentA.setTransactionId(tId);
			componentA.setCustomerId(cId);
			return componentA;
		case B:
			ComponentB_Event componentB = new ComponentB_Event(null);
			componentB.setTransactionId(tId);
			return componentB;
		case C:
			ComponentC_Event componentC = new ComponentC_Event(null);
			componentC.setTransactionId(tId);
			componentC.setSupplierId(sId);
			return componentC;
		default:
			return null;
		}
	}

	public void dispose() {
		instance = null;
	}

}
