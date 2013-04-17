package hu.bme.mit.incquery.cep.runtime.api;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;

public abstract class EventPatternMatch extends BasePatternMatch {
	
	public abstract EventPattern getEventPattern();
	
	@Override
	@Deprecated
	public Pattern pattern() {
		return null;
	}
	
	@Override
	@Deprecated
	public String[] parameterNames() {
		return null;
	}
	
	@Override
	@Deprecated
	public Object get(String parameterName) {
		return null;
	}
	
	@Override
	@Deprecated
	public boolean set(String parameterName, Object newValue) {
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isMutable() {
		return false;
	}
	
	@Override
	@Deprecated
	public Object[] toArray() {
		return null;
	}
	
	@Override
	@Deprecated
	public String prettyPrint() {
		return null;
	}
	
}
