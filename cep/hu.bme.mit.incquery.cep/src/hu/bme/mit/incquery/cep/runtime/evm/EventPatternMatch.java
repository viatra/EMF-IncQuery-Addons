package hu.bme.mit.incquery.cep.runtime.evm;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;

public class EventPatternMatch implements IPatternMatch {
	
	private EventPattern matchedPattern;
	
	public EventPatternMatch(EventPattern matchedPattern) {
		this.matchedPattern = matchedPattern;
	}
	
	@Override
	@Deprecated
	public Pattern pattern() {
		return null;
	}
	
	public EventPattern eventPattern() {
		return matchedPattern;
	}
	
	@Override
	public String patternName() {
		return matchedPattern.getId();
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
	public Object get(int position) {
		return null;
	}
	
	@Override
	@Deprecated
	public boolean set(String parameterName, Object newValue) {
		return false;
	}
	
	@Override
	@Deprecated
	public boolean set(int position, Object newValue) {
		return false;
	}
	
	@Override
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
	
	@Override
	public boolean isCompatibleWith(IPatternMatch other) {
		if (this.equals(other)) {
			return true;
		}
		return false;
	}
}