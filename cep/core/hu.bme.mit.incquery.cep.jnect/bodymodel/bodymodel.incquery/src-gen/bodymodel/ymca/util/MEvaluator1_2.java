package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.YMCAConstants;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.M pattern.
 */
public class MEvaluator1_2 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float REY, final Float RSY) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("REY");
    Float _REY = REY;
    MovingAverageCalculator _addValue = _calculator.addValue((_REY).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("RSY");
    Float _RSY = RSY;
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_RSY).floatValue());
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
    int REYPosition = tupleNameMap.get("REY");
    java.lang.Float REY = (java.lang.Float) tuple.get(REYPosition);
    int RSYPosition = tupleNameMap.get("RSY");
    java.lang.Float RSY = (java.lang.Float) tuple.get(RSYPosition);
    return evaluateXExpressionGenerated(REY, RSY);
  }
}
