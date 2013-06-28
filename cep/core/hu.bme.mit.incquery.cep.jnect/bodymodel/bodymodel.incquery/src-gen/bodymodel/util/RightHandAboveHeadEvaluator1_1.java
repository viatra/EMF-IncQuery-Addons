package bodymodel.util;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.RightHandAboveHead pattern.
 */
public class RightHandAboveHeadEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float Hy, final Float RHy) {
    Float _Hy = Hy;
    Float _RHy = RHy;
    boolean _lessThan = (_Hy.compareTo(_RHy) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int HyPosition = tupleNameMap.get("Hy");
    java.lang.Float Hy = (java.lang.Float) tuple.get(HyPosition);
    int RHyPosition = tupleNameMap.get("RHy");
    java.lang.Float RHy = (java.lang.Float) tuple.get(RHyPosition);
    return evaluateXExpressionGenerated(Hy, RHy);
  }
}
