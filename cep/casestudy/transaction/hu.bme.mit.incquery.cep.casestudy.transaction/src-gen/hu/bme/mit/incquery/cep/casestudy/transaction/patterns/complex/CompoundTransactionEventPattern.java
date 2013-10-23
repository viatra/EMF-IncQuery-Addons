package hu.bme.mit.incquery.cep.casestudy.transaction.patterns.complex;

import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl;

@SuppressWarnings("all")
public class CompoundTransactionEventPattern extends ComplexEventPatternImpl {
  public CompoundTransactionEventPattern() {
    super();
    // TODO register ordering
    // TODO register events
    // TODO register timewindow
    setId("compoundTransactionEventPattern");
  }
}
