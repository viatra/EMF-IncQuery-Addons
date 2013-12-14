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
import hu.bme.mit.incquery.cep.performance.events.ComponentF_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentG_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentH_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentI_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentJ_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentK_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentL_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentM_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentN_Event;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class PerformanceTester {
	private ICepAdapter adapter = new TransactionEventAdapter();
	private File log;
	private int observedComplexPatterns = 0;
	private BufferedWriter bw;

	private static PerformanceTester instance;

	private PerformanceTester() {
	}

	public static PerformanceTester getInstance() {
		if (instance == null) {
			instance = new PerformanceTester();
		}
		return instance;
	}

	public void setup(ICepRule rule) throws IOException {
		checkArgument(rule != null);

		log = new File("log.txt");
		log.createNewFile();
		FileWriter fw = new FileWriter(log.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		bw.write("Compilation started: " + new Date().getTime() + "\n");
		ViatraCepManager.withContext(EventProcessingContext.CHRONICLE).addRule(rule);
		bw.write("Compilation ended: " + new Date().getTime() + "\n\n");
	}

	public void simulate() throws IOException {
		int inputEvents = 0;
		bw.write("Simulation started: " + new Date().getTime() + "\n");

		List<EventType> testSeries = Lists.newArrayList(EventType.C);
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("+++Turnaround: " + i);
			for (EventType eventType : testSeries) {
				ParameterizableEventInstance event = generateEvent(eventType);

				System.out.println("Refreshing model with " + event);
				inputEvents++;
				adapter.push(event);
			}
		}
		bw.write("Simulation ended: " + new Date().getTime() + "\n\n");
		bw.write("Input events: " + inputEvents + "\n");
		bw.write("Observed complex patterns: " + observedComplexPatterns + "\n");
		bw.close();
	}

	private enum EventType {
		A, B, C, D, E, F, G, H, I, J, K, L, M, N
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
		case F:
			ComponentF_Event componentF = new ComponentF_Event(null);
			return componentF;
		case G:
			ComponentG_Event componentG = new ComponentG_Event(null);
			return componentG;
		case H:
			ComponentH_Event componentH = new ComponentH_Event(null);
			return componentH;
		case I:
			ComponentI_Event componentI = new ComponentI_Event(null);
			return componentI;
		case J:
			ComponentJ_Event componentJ = new ComponentJ_Event(null);
			return componentJ;
		case K:
			ComponentK_Event componentK = new ComponentK_Event(null);
			return componentK;
		case L:
			ComponentL_Event componentL = new ComponentL_Event(null);
			return componentL;
		case M:
			ComponentM_Event componentM = new ComponentM_Event(null);
			return componentM;
		case N:
			ComponentN_Event componentN = new ComponentN_Event(null);
			return componentN;
		default:
			return null;
		}
	}

	public void dispose() {
		instance = null;
	}

	public File getLog() {
		return log;
	}

	public int getObservedComplexPatterns() {
		return observedComplexPatterns;
	}


	public void increaseObservedPatternCount() {
		observedComplexPatterns++;
	}
}
