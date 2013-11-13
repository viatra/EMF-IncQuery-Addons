package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.complex;

import com.google.common.collect.Lists;
import hu.bme.mit.incquery.cep.api.ParameterizableComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory;
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow;
import java.util.List;

@SuppressWarnings("all")
public class CompoundTransactionTestEvent1Pattern extends ParameterizableComplexEventPattern {
  public CompoundTransactionTestEvent1Pattern() {
    super();
    setOperator(ComplexOperator.ORDERED);
    
    // composition events
    List<EventPattern> atomicEventPatternsForCP = Lists.newArrayList();
    atomicEventPatternsForCP.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.ComponentAPattern());
    atomicEventPatternsForCP.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.atomic.ComponentBPattern());
    getCompositionEvents().addAll(atomicEventPatternsForCP);
    
    // timewindows
    GlobalTimewindow timewindow = CepFactory.eINSTANCE.createGlobalTimewindow();
    timewindow.setLength(1500l);
    setGlobalTimewindow(timewindow);
    
    setId("CompoundTransactionTestEvent1Pattern");
  }
  
  @Override
  public boolean evaluateParameterBindigs(final Event event) {
    return true;
    
  }
}
