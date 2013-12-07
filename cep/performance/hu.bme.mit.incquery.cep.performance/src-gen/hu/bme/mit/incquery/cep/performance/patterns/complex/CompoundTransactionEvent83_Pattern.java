package hu.bme.mit.incquery.cep.performance.patterns.complex;

import com.google.common.collect.Lists;
import hu.bme.mit.incquery.cep.api.ParameterizableComplexEventPattern;
import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import java.util.List;

@SuppressWarnings("all")
public class CompoundTransactionEvent83_Pattern extends ParameterizableComplexEventPattern {
  public CompoundTransactionEvent83_Pattern() {
    super();
    setOperator(ComplexOperator.ORDERED);
    
    // composition events
    List<EventPattern> compositionEventPatternsForCP = Lists.newArrayList();
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.ComponentB_Pattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.ComponentE_Pattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.ComponentA_Pattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.ComponentC_Pattern());
    compositionEventPatternsForCP.add(new hu.bme.mit.incquery.cep.performance.patterns.atomic.ComponentD_Pattern());
    getCompositionEvents().addAll(compositionEventPatternsForCP);
    setId("CompoundTransactionEvent83_Pattern");
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
