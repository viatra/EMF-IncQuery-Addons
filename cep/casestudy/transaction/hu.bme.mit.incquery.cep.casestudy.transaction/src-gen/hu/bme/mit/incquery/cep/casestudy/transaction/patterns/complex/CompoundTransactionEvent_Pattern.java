package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.complex;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import hu.bme.mit.incquery.cep.api.ParameterizableComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class CompoundTransactionEvent_Pattern extends ParameterizableComplexEventPattern {
  public CompoundTransactionEvent_Pattern() {
    super();
    setOperator(ComplexOperator.ORDERED);
    
    // composition events
    List<EventPattern> atomicEventPatternsForCP = Lists.newArrayList();
    atomicEventPatternsForCP.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.incquery.ComponentA_IQPattern());
    atomicEventPatternsForCP.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.incquery.ComponentB_IQPattern());
    atomicEventPatternsForCP.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.incquery.ComponentC_IQPattern());
    getCompositionEvents().addAll(atomicEventPatternsForCP);
    
    // timewindows
    GlobalTimewindow timewindow = CepFactory.eINSTANCE.createGlobalTimewindow();
    timewindow.setLength(500l);
    setGlobalTimewindow(timewindow);
    
    setId("CompoundTransactionEvent_Pattern");
  }
  
  @Override
  public boolean evaluateParameterBindigs(final Event event) {
    if(event instanceof hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_IQEvent){
    Map<String,Object> params = Maps.newHashMap();
    	Object value0 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_IQEvent) event).getParameter(0);
    	params.put("tId", value0);
    	Object value1 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentA_IQEvent) event).getParameter(1);
    	params.put("cId", value1);
    	return evaluateParamBinding(params);
    }
    if(event instanceof hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_IQEvent){
    Map<String,Object> params = Maps.newHashMap();
    	Object value0 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentB_IQEvent) event).getParameter(0);
    	params.put("tId", value0);
    	return evaluateParamBinding(params);
    }
    if(event instanceof hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_IQEvent){
    Map<String,Object> params = Maps.newHashMap();
    	Object value0 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_IQEvent) event).getParameter(0);
    	params.put("tId", value0);
    	Object value1 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.incquery.ComponentC_IQEvent) event).getParameter(1);
    	params.put("sId", value1);
    	return evaluateParamBinding(params);
    }
    return true;
    
  }
}
