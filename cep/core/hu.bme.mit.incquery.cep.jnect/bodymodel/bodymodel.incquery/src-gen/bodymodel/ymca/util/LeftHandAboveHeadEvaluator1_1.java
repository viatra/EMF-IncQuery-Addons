package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.leftHandAboveHead pattern.
 */
public class LeftHandAboveHeadEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float LHy, final Float Hy) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("HY");
    Float _Hy = Hy;
    MovingAverageCalculator _addValue = _calculator.addValue((_Hy).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("LHY");
    Float _LHy = LHy;
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_LHy).floatValue());
    float _movingAvg_1 = _addValue_1.getMovingAvg();
    boolean _lessThan = (_movingAvg < _movingAvg_1);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int LHyPosition = tupleNameMap.get("LHy");
    java.lang.Float LHy = (java.lang.Float) tuple.get(LHyPosition);
    int HyPosition = tupleNameMap.get("Hy");
    java.lang.Float Hy = (java.lang.Float) tuple.get(HyPosition);
    return evaluateXExpressionGenerated(LHy, Hy);
  }
}
