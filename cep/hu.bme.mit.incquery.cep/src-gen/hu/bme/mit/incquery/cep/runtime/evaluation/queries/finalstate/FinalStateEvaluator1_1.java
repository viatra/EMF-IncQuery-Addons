package hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalstate;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.incquery.cep.runtime.evaluation.queries.finalState pattern.
 */
public class FinalStateEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final String label) {
    String _label = label;
    boolean _equalsIgnoreCase = _label.equalsIgnoreCase("final");
    return Boolean.valueOf(_equalsIgnoreCase);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int labelPosition = tupleNameMap.get("label");
    java.lang.String label = (java.lang.String) tuple.get(labelPosition);
    return evaluateXExpressionGenerated(label);
  }
}
