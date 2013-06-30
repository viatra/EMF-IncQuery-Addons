package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.YMCAConstants;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.SE pattern.
 */
public class SEEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float RHy, final Float Hy) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("RHY");
    Float _RHy = RHy;
    MovingAverageCalculator _addValue = _calculator.addValue((_RHy).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("HY");
    Float _Hy = Hy;
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_Hy).floatValue());
    float _movingAvg_1 = _addValue_1.getMovingAvg();
    float _minus = (_movingAvg - _movingAvg_1);
    boolean _greaterThan = (_minus > YMCAConstants.veryCloseDistance);
    return Boolean.valueOf(_greaterThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int RHyPosition = tupleNameMap.get("RHy");
    java.lang.Float RHy = (java.lang.Float) tuple.get(RHyPosition);
    int HyPosition = tupleNameMap.get("Hy");
    java.lang.Float Hy = (java.lang.Float) tuple.get(HyPosition);
    return evaluateXExpressionGenerated(RHy, Hy);
  }
}
