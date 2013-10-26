import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow;
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@SuppressWarnings("all")
public class CompoundTransactionEventPattern extends ComplexEventPatternImpl {

	// private IParameterBindings parameterBindings;
	private Map<String, Object> paramValues = Maps.newHashMap();

	public CompoundTransactionEventPattern() {
		super();
		setOperator(ComplexOperator.ORDERED);

		// composition events
		List<EventPattern> atomicEventPatternsForCP = Lists.newArrayList();
		atomicEventPatternsForCP
				.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.ComponentAPattern());
		atomicEventPatternsForCP
				.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.ComponentBPattern());
		atomicEventPatternsForCP
				.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.ComponentCPattern());
		getCompositionEvents().addAll(atomicEventPatternsForCP);

		// timewindows
		GlobalTimewindow timewindow = CepFactory.eINSTANCE
				.createGlobalTimewindow();
		timewindow.setLength(1100l);
		setGlobalTimewindow(timewindow);

		setId("CompoundTransactionEventPattern");
	}

	@Override
	public boolean evaluateParameterBindigs(Event event) {
		if (event instanceof ComponentA) {
			Object value1 = ((ComponentA) event).getParameter(0);
			Object value2 = ((ComponentA) event).getParameter(2);
			Map<String, Object> params = Maps.newHashMap();
			params.put("tId", value1);
			params.put("cId", value2);
			return evaluateParamBinding(params);
		}
		// ...

		return true;
	};

	private boolean evaluateParamBinding(Map<String, Object> params) {
		for (Entry<String, Object> param : params.entrySet()) {
			if (!(evaluateParamBinding(param.getKey(), param.getValue()))) {
				return false;
			}
		}
		return true;
	}

	private boolean evaluateParamBinding(String paramName, Object paramValue) {
		Object value = paramValues.get(paramName);
		if (value == null) {
			paramValues.put(paramName, paramValue);
			return true;
		}
		return value.equals(paramValue);
	}
}
