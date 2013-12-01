package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public abstract class ParameterizableComplexEventPattern extends
		ComplexEventPatternImpl {
	private Map<String, Object> paramValues = Maps.newHashMap();
	private List<ParameterizableEventInstance> observedEvents = Lists
			.newArrayList();

	protected boolean evaluateParamBinding(Map<String, Object> params) {
		if (params.isEmpty()) {
			return false;
		}
		for (Entry<String, Object> param : params.entrySet()) {
			if (!(evaluateParamBinding(param.getKey(), param.getValue()))) {
				return false;
			}
		}
		return true;
	}

	protected boolean evaluateParamBinding(Map<String, Object> params,
			ParameterizableEventInstance observedEvent) {
		if (evaluateParamBinding(params)) {
			observedEvents.add(observedEvent);
			return true;
		}
		return false;
	}

	protected boolean evaluateParamBinding(String paramName, Object paramValue) {
		if (Strings.isNullOrEmpty(paramName) || paramValue == null) {
			return false;
		}
		Object value = paramValues.get(paramName);
		if (value == null) {
			paramValues.put(paramName, paramValue);
			return true;
		}
		return value.equals(paramValue);
	}

	public Map<String, Object> getParamValues() {
		return paramValues;
	}

	public List<ParameterizableEventInstance> getObservedEvents() {
		return observedEvents;
	}
}
