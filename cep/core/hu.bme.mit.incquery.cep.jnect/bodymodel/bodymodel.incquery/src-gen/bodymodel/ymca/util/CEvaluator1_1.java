package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.C pattern.
 */
public class CEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float HX, final Float LHX) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("LHX");
    Float _LHX = LHX;
    MovingAverageCalculator _addValue = _calculator.addValue((_LHX).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("HX");
    Float _HX = HX;
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_HX).floatValue());
    float _movingAvg_1 = _addValue_1.getMovingAvg();
    boolean _greaterThan = (_movingAvg > _movingAvg_1);
    return Boolean.valueOf(_greaterThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int HXPosition = tupleNameMap.get("HX");
    java.lang.Float HX = (java.lang.Float) tuple.get(HXPosition);
    int LHXPosition = tupleNameMap.get("LHX");
    java.lang.Float LHX = (java.lang.Float) tuple.get(LHXPosition);
    return evaluateXExpressionGenerated(HX, LHX);
  }
}
