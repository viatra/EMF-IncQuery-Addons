package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;

import java.util.List;

import com.google.common.collect.Lists;

public abstract class ParameterizableEventInstance extends AbstractEventInstance {
    protected List<Object> parameters = Lists.newArrayList();

    public ParameterizableEventInstance(IEventSource eventSource) {
        super(eventSource);
    }

    public Object getParameter(int i) {
        return parameters.get(i);
    }

    public List<Object> getParameters() {
        return parameters;
    }
}
