package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.YMCAConstants;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.M pattern.
 */
public class MEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float LEY, final Float LSY) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("LEY");
    Float _LEY = LEY;
    MovingAverageCalculator _addValue = _calculator.addValue((_LEY).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("LSY");
    Float _LSY = LSY;
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_LSY).floatValue());
    float _movingAvg_1 = _addValue_1.getMovingAvg();
    float _minus = (_movingAvg - _movingAvg_1);
    float _abs = Math.abs(_minus);
    boolean _lessThan = (_abs < YMCAConstants.veryCloseDistance);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int LEYPosition = tupleNameMap.get("LEY");
    java.lang.Float LEY = (java.lang.Float) tuple.get(LEYPosition);
    int LSYPosition = tupleNameMap.get("LSY");
    java.lang.Float LSY = (java.lang.Float) tuple.get(LSYPosition);
    return evaluateXExpressionGenerated(LEY, LSY);
  }
}
