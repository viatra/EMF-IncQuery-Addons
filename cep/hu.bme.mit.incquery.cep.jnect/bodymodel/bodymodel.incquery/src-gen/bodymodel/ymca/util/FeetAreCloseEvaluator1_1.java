package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.VectorMaths;
import bodymodel.ymca.YMCAConstants;
import java.util.Map;
import java.util.Vector;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.feetAreClose pattern.
 */
public class FeetAreCloseEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float LFY, final Float RFY, final Float RFZ, final Float LFZ, final Float RFX, final Float LFX) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("LFX");
    Float _LFX = LFX;
    MovingAverageCalculator _addValue = _calculator.addValue((_LFX).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("LFY");
    Float _LFY = LFY;
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_LFY).floatValue());
    float _movingAvg_1 = _addValue_1.getMovingAvg();
    MovingAverageCalculator _calculator_2 = MovingAverageCalculator.getCalculator("LFZ");
    Float _LFZ = LFZ;
    MovingAverageCalculator _addValue_2 = _calculator_2.addValue((_LFZ).floatValue());
    float _movingAvg_2 = _addValue_2.getMovingAvg();
    MovingAverageCalculator _calculator_3 = MovingAverageCalculator.getCalculator("RFX");
    Float _RFX = RFX;
    MovingAverageCalculator _addValue_3 = _calculator_3.addValue((_RFX).floatValue());
    float _movingAvg_3 = _addValue_3.getMovingAvg();
    MovingAverageCalculator _calculator_4 = MovingAverageCalculator.getCalculator("RFY");
    Float _RFY = RFY;
    MovingAverageCalculator _addValue_4 = _calculator_4.addValue((_RFY).floatValue());
    float _movingAvg_4 = _addValue_4.getMovingAvg();
    MovingAverageCalculator _calculator_5 = MovingAverageCalculator.getCalculator("RFZ");
    Float _RFZ = RFZ;
    MovingAverageCalculator _addValue_5 = _calculator_5.addValue((_RFZ).floatValue());
    float _movingAvg_5 = _addValue_5.getMovingAvg();
    Vector<Float> _createVector = VectorMaths.createVector(_movingAvg, _movingAvg_1, _movingAvg_2, _movingAvg_3, _movingAvg_4, _movingAvg_5);
    float _lengthOf = VectorMaths.lengthOf(_createVector);
    boolean _lessThan = (_lengthOf < YMCAConstants.closeDistance);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int LFYPosition = tupleNameMap.get("LFY");
    java.lang.Float LFY = (java.lang.Float) tuple.get(LFYPosition);
    int RFYPosition = tupleNameMap.get("RFY");
    java.lang.Float RFY = (java.lang.Float) tuple.get(RFYPosition);
    int RFZPosition = tupleNameMap.get("RFZ");
    java.lang.Float RFZ = (java.lang.Float) tuple.get(RFZPosition);
    int LFZPosition = tupleNameMap.get("LFZ");
    java.lang.Float LFZ = (java.lang.Float) tuple.get(LFZPosition);
    int RFXPosition = tupleNameMap.get("RFX");
    java.lang.Float RFX = (java.lang.Float) tuple.get(RFXPosition);
    int LFXPosition = tupleNameMap.get("LFX");
    java.lang.Float LFX = (java.lang.Float) tuple.get(LFXPosition);
    return evaluateXExpressionGenerated(LFY, RFY, RFZ, LFZ, RFX, LFX);
  }
}
