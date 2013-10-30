package hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.util;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns.sample.newTransactionEvent pattern.
 */
@SuppressWarnings("all")
public class NewTransactionEventEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Long ts) {
    boolean _greaterThan = ((ts).longValue() > 0l);
    return Boolean.valueOf(_greaterThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int tsPosition = tupleNameMap.get("ts");
    java.lang.Long ts = (java.lang.Long) tuple.get(tsPosition);
    return evaluateXExpressionGenerated(ts);
  }
}
