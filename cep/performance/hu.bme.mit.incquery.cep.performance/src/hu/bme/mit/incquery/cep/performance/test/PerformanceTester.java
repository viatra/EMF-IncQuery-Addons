package hu.bme.mit.incquery.cep.performance.test;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.cep.api.ICepAdapter;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.api.ViatraCepManager;
import hu.bme.mit.incquery.cep.casestudy.base.adapters.TransactionEventAdapter;
import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.performance.events.ComponentA_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentB_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentC_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentD_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentE_Event;

import java.util.List;

import com.google.common.collect.Lists;

public class PerformanceTester {
	private ICepAdapter adapter = new TransactionEventAdapter();

	private static PerformanceTester instance;

	private PerformanceTester() {
	}

	public static PerformanceTester getInstance() {
		if (instance == null) {
			instance = new PerformanceTester();
		}
		return instance;
	}

	public void setup(ICepRule rule) {
		checkArgument(rule != null);
		ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRule(rule);
	}

	public void simulate() {
		List<EventType> testSeries = Lists
				.newArrayList(EventType.A, EventType.B, EventType.C, EventType.D, EventType.E);

		for (int i = 0; i < 100000; i++) {
			for (EventType eventType : testSeries) {
				ParameterizableEventInstance event = generateEvent(eventType);

				System.out.println("Refreshing model with " + event);
				adapter.push(event);
			}
		}
	}

	private enum EventType {
		A, B, C, D, E
	}

	private ParameterizableEventInstance generateEvent(EventType type) {
		switch (type) {
		case A:
			ComponentA_Event componentA = new ComponentA_Event(null);
			return componentA;
		case B:
			ComponentB_Event componentB = new ComponentB_Event(null);
			return componentB;
		case C:
			ComponentC_Event componentC = new ComponentC_Event(null);
			return componentC;
		case D:
			ComponentD_Event componentD = new ComponentD_Event(null);
			return componentD;
		case E:
			ComponentE_Event componentE = new ComponentE_Event(null);
			return componentE;
		default:
			return null;
		}
	}

	public void dispose() {
		instance = null;
	}

}
