package hu.bme.mit.incquery.cep.performance.patterns.complex;

import com.google.common.collect.Lists;
import hu.bme.mit.incquery.cep.api.ParameterizableComplexEventPattern;
import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import java.util.List;

@SuppressWarnings("all")
public class CompoundTransactionEvent30_Pattern extends ParameterizableComplexEventPattern {
  public CompoundTransactionEvent30_Pattern() {
    super();
    setOperator(ComplexOperator.ORDERED);
    
    // composition events
    List<EventPattern> compositionEventPatternsForCP = Lists.newArrayList();
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery.ComponentC_IQPattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery.ComponentA_IQPattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery.ComponentD_IQPattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery.ComponentE_IQPattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery.ComponentF_IQPattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery.ComponentB_IQPattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.incquery.ComponentG_IQPattern());
    getCompositionEvents().addAll(compositionEventPatternsForCP);
    setId("CompoundTransactionEvent30_Pattern");
  }
  
  @Override
  public boolean evaluateParameterBindigs(final Event event) {
    if(event instanceof ParameterizableEventInstance){
    	return evaluateParameterBindigs((ParameterizableEventInstance) event);
    }
    return true;
  }
  
  public boolean evaluateParameterBindigs(final ParameterizableEventInstance event) {
    return true;
  }
}
