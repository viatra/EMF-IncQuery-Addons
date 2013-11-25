package hu.bme.mit.incquery.cep.api;

import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;

import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

public class ParameterizableIncQueryPatternEventInstance extends ParameterizableEventInstance {
    private BasePatternMatch incQueryPattern;
    
    public ParameterizableIncQueryPatternEventInstance(IEventSource eventSource) {
        super(eventSource);
    }
    
    public BasePatternMatch getIncQueryPattern() {
        return incQueryPattern;
    }
    
    public void setIncQueryPattern(BasePatternMatch incQueryPattern) {
        this.incQueryPattern = incQueryPattern;
    }
}