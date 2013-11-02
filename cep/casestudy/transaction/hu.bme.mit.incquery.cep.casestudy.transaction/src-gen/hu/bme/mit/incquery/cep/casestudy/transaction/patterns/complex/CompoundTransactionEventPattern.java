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
public class CompoundTransactionEventPattern extends ParameterizableComplexEventPattern {
  public CompoundTransactionEventPattern() {
    super();
    setOperator(ComplexOperator.ORDERED);
    
    // composition events
    List<EventPattern> atomicEventPatternsForCP = Lists.newArrayList();
    atomicEventPatternsForCP.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.ComponentAPattern());
    atomicEventPatternsForCP.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.ComponentBPattern());
    atomicEventPatternsForCP.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.ComponentCPattern());
    getCompositionEvents().addAll(atomicEventPatternsForCP);
    
    // timewindows
    GlobalTimewindow timewindow = CepFactory.eINSTANCE.createGlobalTimewindow();
    timewindow.setLength(5000l);
    setGlobalTimewindow(timewindow);
    
    setId("CompoundTransactionEventPattern");
  }
  
  @Override
  public boolean evaluateParameterBindigs(final Event event) {
    if(event instanceof hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA){
    Map<String,Object> params = Maps.newHashMap();
    	Object value0 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA) event).getParameter(0);
    	params.put("tId", value0);
    	Object value2 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentA) event).getParameter(2);
    	params.put("cId", value2);
    	return evaluateParamBinding(params);
    }
    if(event instanceof hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB){
    Map<String,Object> params = Maps.newHashMap();
    	Object value0 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentB) event).getParameter(0);
    	params.put("tId", value0);
    	return evaluateParamBinding(params);
    }
    if(event instanceof hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC){
    Map<String,Object> params = Maps.newHashMap();
    	Object value0 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC) event).getParameter(0);
    	params.put("tId", value0);
    	Object value2 = ((hu.bme.mit.incquery.cep.casestudy.transaction.events.ComponentC) event).getParameter(2);
    	params.put("sId", value2);
    	return evaluateParamBinding(params);
    }
    return true;
    
  }
}
