package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.VectorMaths;
import bodymodel.ymca.YMCAConstants;
import java.util.Map;
import java.util.Vector;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.bentRightArm pattern.
 */
public class BentRightArmEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float REZ, final Float RHY, final Float RSX, final Float REY, final Float RSZ, final Float RHX, final Float RHZ, final Float RSY, final Float REX) {
    boolean _xblockexpression = false;
    {
      MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("RHX");
      Float _RHX = RHX;
      MovingAverageCalculator _addValue = _calculator.addValue((_RHX).floatValue());
      float _movingAvg = _addValue.getMovingAvg();
      MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("RHY");
      Float _RHY = RHY;
      MovingAverageCalculator _addValue_1 = _calculator_1.addValue((_RHY).floatValue());
      float _movingAvg_1 = _addValue_1.getMovingAvg();
      MovingAverageCalculator _calculator_2 = MovingAverageCalculator.getCalculator("RHZ");
      Float _RHZ = RHZ;
      MovingAverageCalculator _addValue_2 = _calculator_2.addValue((_RHZ).floatValue());
      float _movingAvg_2 = _addValue_2.getMovingAvg();
      MovingAverageCalculator _calculator_3 = MovingAverageCalculator.getCalculator("REX");
      Float _REX = REX;
      MovingAverageCalculator _addValue_3 = _calculator_3.addValue((_REX).floatValue());
      float _movingAvg_3 = _addValue_3.getMovingAvg();
      MovingAverageCalculator _calculator_4 = MovingAverageCalculator.getCalculator("REY");
      Float _REY = REY;
      MovingAverageCalculator _addValue_4 = _calculator_4.addValue((_REY).floatValue());
      float _movingAvg_4 = _addValue_4.getMovingAvg();
      MovingAverageCalculator _calculator_5 = MovingAverageCalculator.getCalculator("REZ");
      Float _REZ = REZ;
      MovingAverageCalculator _addValue_5 = _calculator_5.addValue((_REZ).floatValue());
      float _movingAvg_5 = _addValue_5.getMovingAvg();
      Vector<Float> _createVector = VectorMaths.createVector(_movingAvg, _movingAvg_1, _movingAvg_2, _movingAvg_3, _movingAvg_4, _movingAvg_5);
      MovingAverageCalculator _calculator_6 = MovingAverageCalculator.getCalculator("RSX");
      Float _RSX = RSX;
      MovingAverageCalculator _addValue_6 = _calculator_6.addValue((_RSX).floatValue());
      float _movingAvg_6 = _addValue_6.getMovingAvg();
      MovingAverageCalculator _calculator_7 = MovingAverageCalculator.getCalculator("RSY");
      Float _RSY = RSY;
      MovingAverageCalculator _addValue_7 = _calculator_7.addValue((_RSY).floatValue());
      float _movingAvg_7 = _addValue_7.getMovingAvg();
      MovingAverageCalculator _calculator_8 = MovingAverageCalculator.getCalculator("RSZ");
      Float _RSZ = RSZ;
      MovingAverageCalculator _addValue_8 = _calculator_8.addValue((_RSZ).floatValue());
      float _movingAvg_8 = _addValue_8.getMovingAvg();
      MovingAverageCalculator _calculator_9 = MovingAverageCalculator.getCalculator("REX");
      Float _REX_1 = REX;
      MovingAverageCalculator _addValue_9 = _calculator_9.addValue((_REX_1).floatValue());
      float _movingAvg_9 = _addValue_9.getMovingAvg();
      MovingAverageCalculator _calculator_10 = MovingAverageCalculator.getCalculator("REY");
      Float _REY_1 = REY;
      MovingAverageCalculator _addValue_10 = _calculator_10.addValue((_REY_1).floatValue());
      float _movingAvg_10 = _addValue_10.getMovingAvg();
      MovingAverageCalculator _calculator_11 = MovingAverageCalculator.getCalculator("REZ");
      Float _REZ_1 = REZ;
      MovingAverageCalculator _addValue_11 = _calculator_11.addValue((_REZ_1).floatValue());
      float _movingAvg_11 = _addValue_11.getMovingAvg();
      Vector<Float> _createVector_1 = VectorMaths.createVector(_movingAvg_6, _movingAvg_7, _movingAvg_8, _movingAvg_9, _movingAvg_10, _movingAvg_11);
      float angleBetween = VectorMaths.angleBetween(_createVector, _createVector_1);
      double _divide = (Math.PI / 2);
      double _minus = (_divide - angleBetween);
      double _abs = Math.abs(_minus);
      boolean _lessThan = (_abs < YMCAConstants.angleTolerance);
      _xblockexpression = (_lessThan);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int REZPosition = tupleNameMap.get("REZ");
    java.lang.Float REZ = (java.lang.Float) tuple.get(REZPosition);
    int RHYPosition = tupleNameMap.get("RHY");
    java.lang.Float RHY = (java.lang.Float) tuple.get(RHYPosition);
    int RSXPosition = tupleNameMap.get("RSX");
    java.lang.Float RSX = (java.lang.Float) tuple.get(RSXPosition);
    int REYPosition = tupleNameMap.get("REY");
    java.lang.Float REY = (java.lang.Float) tuple.get(REYPosition);
    int RSZPosition = tupleNameMap.get("RSZ");
    java.lang.Float RSZ = (java.lang.Float) tuple.get(RSZPosition);
    int RHXPosition = tupleNameMap.get("RHX");
    java.lang.Float RHX = (java.lang.Float) tuple.get(RHXPosition);
    int RHZPosition = tupleNameMap.get("RHZ");
    java.lang.Float RHZ = (java.lang.Float) tuple.get(RHZPosition);
    int RSYPosition = tupleNameMap.get("RSY");
    java.lang.Float RSY = (java.lang.Float) tuple.get(RSYPosition);
    int REXPosition = tupleNameMap.get("REX");
    java.lang.Float REX = (java.lang.Float) tuple.get(REXPosition);
    return evaluateXExpressionGenerated(REZ, RHY, RSX, REY, RSZ, RHX, RHZ, RSY, REX);
  }
}
