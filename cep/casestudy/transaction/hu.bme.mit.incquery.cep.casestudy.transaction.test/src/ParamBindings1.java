import hu.bme.mit.incquery.cep.api.IParameterBindings;

import java.util.Map;

import com.google.common.collect.Maps;

public class ParamBindings1 implements IParameterBindings {

	private Map<String, Object> paramValues = Maps.newHashMap();

	@Override
	public boolean evaluateBindings() {
		return true;
	}

	public boolean checkParam(String paramName, Object paramValue) {
		Object value = paramValues.get(paramName);
		if (value == null) {
			paramValues.put(paramName, paramValue);
			return true;
		}
		return value.equals(paramValue);
	}
}
