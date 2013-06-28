package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.VectorMaths;
import bodymodel.ymca.YMCAConstants;
import java.util.Map;
import java.util.Vector;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.handsAreApart pattern.
 */
public class HandsAreApartEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float RHX, final Float RHY, final Float RHZ, final Float LHX, final Float LHZ, final Float LHY) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("LHX");
    Float _LHX = LHX;
    MovingAverageCalculator _addValue = _calculator.addValue((_LHX).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("LHY");
    Float _LHY = LHY;
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_LHY).floatValue());
    float _movingAvg_1 = _addValue_1.getMovingAvg();
    MovingAverageCalculator _calculator_2 = MovingAverageCalculator.getCalculator("LHZ");
    Float _LHZ = LHZ;
    MovingAverageCalculator _addValue_2 = _calculator_2.addValue((_LHZ).floatValue());
    float _movingAvg_2 = _addValue_2.getMovingAvg();
    MovingAverageCalculator _calculator_3 = MovingAverageCalculator.getCalculator("RHX");
    Float _RHX = RHX;
    MovingAverageCalculator _addValue_3 = _calculator_3.addValue((_RHX).floatValue());
    float _movingAvg_3 = _addValue_3.getMovingAvg();
    MovingAverageCalculator _calculator_4 = MovingAverageCalculator.getCalculator("RHY");
    Float _RHY = RHY;
    MovingAverageCalculator _addValue_4 = _calculator_4.addValue((_RHY).floatValue());
    float _movingAvg_4 = _addValue_4.getMovingAvg();
    MovingAverageCalculator _calculator_5 = MovingAverageCalculator.getCalculator("RHZ");
    Float _RHZ = RHZ;
    MovingAverageCalculator _addValue_5 = _calculator_5.addValue((_RHZ).floatValue());
    float _movingAvg_5 = _addValue_5.getMovingAvg();
    Vector<Float> _createVector = VectorMaths.createVector(_movingAvg, _movingAvg_1, _movingAvg_2, _movingAvg_3, _movingAvg_4, _movingAvg_5);
    float _lengthOf = VectorMaths.lengthOf(_createVector);
    boolean _greaterThan = (_lengthOf > YMCAConstants.apartDistance);
    return Boolean.valueOf(_greaterThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int RHXPosition = tupleNameMap.get("RHX");
    java.lang.Float RHX = (java.lang.Float) tuple.get(RHXPosition);
    int RHYPosition = tupleNameMap.get("RHY");
    java.lang.Float RHY = (java.lang.Float) tuple.get(RHYPosition);
    int RHZPosition = tupleNameMap.get("RHZ");
    java.lang.Float RHZ = (java.lang.Float) tuple.get(RHZPosition);
    int LHXPosition = tupleNameMap.get("LHX");
    java.lang.Float LHX = (java.lang.Float) tuple.get(LHXPosition);
    int LHZPosition = tupleNameMap.get("LHZ");
    java.lang.Float LHZ = (java.lang.Float) tuple.get(LHZPosition);
    int LHYPosition = tupleNameMap.get("LHY");
    java.lang.Float LHY = (java.lang.Float) tuple.get(LHYPosition);
    return evaluateXExpressionGenerated(RHX, RHY, RHZ, LHX, LHZ, LHY);
  }
}
