package hu.bme.mit.incquery.cep.casestudy.transaction.patterns;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

@SuppressWarnings("all")
public class CompoundTransactionEvent_Pattern extends ComplexEventPatternImpl {
  public CompoundTransactionEvent_Pattern() {
    super();
    // TODO register ordering
    // TODO register events
    // TODO register timewindow
    setId("compoundTransactionEventPattern");
  }
}
