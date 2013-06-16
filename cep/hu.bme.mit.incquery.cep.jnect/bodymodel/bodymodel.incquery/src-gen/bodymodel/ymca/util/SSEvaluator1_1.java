package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.YMCAConstants;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.SS pattern.
 */
public class SSEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float CHy, final Float RHy) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("CHY");
    Float _CHy = CHy;
    MovingAverageCalculator _addValue = _calculator.addValue((_CHy).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("RHY");
    Float _RHy = RHy;
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_RHy).floatValue());
    float _movingAvg_1 = _addValue_1.getMovingAvg();
    float _minus = (_movingAvg - _movingAvg_1);
    float _abs = Math.abs(_minus);
    boolean _lessThan = (_abs < YMCAConstants.closeDistance);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int CHyPosition = tupleNameMap.get("CHy");
    java.lang.Float CHy = (java.lang.Float) tuple.get(CHyPosition);
    int RHyPosition = tupleNameMap.get("RHy");
    java.lang.Float RHy = (java.lang.Float) tuple.get(RHyPosition);
    return evaluateXExpressionGenerated(CHy, RHy);
  }
}
