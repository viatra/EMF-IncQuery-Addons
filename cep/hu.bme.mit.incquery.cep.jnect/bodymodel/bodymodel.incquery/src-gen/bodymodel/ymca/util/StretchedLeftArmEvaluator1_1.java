package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.VectorMaths;
import bodymodel.ymca.YMCAConstants;
import java.util.Map;
import java.util.Vector;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.ymca.stretchedLeftArm pattern.
 */
public class StretchedLeftArmEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float LHY, final Float LHZ, final Float LSZ, final Float LSX, final Float LSY, final Float LHX, final Float LEY, final Float LEZ, final Float LEX) {
    boolean _xblockexpression = false;
    {
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
      MovingAverageCalculator _calculator_3 = MovingAverageCalculator.getCalculator("LEX");
      Float _LEX = LEX;
      MovingAverageCalculator _addValue_3 = _calculator_3.addValue((_LEX).floatValue());
      float _movingAvg_3 = _addValue_3.getMovingAvg();
      MovingAverageCalculator _calculator_4 = MovingAverageCalculator.getCalculator("LEY");
      Float _LEY = LEY;
      MovingAverageCalculator _addValue_4 = _calculator_4.addValue((_LEY).floatValue());
      float _movingAvg_4 = _addValue_4.getMovingAvg();
      MovingAverageCalculator _calculator_5 = MovingAverageCalculator.getCalculator("LEZ");
      Float _LEZ = LEZ;
      MovingAverageCalculator _addValue_5 = _calculator_5.addValue((_LEZ).floatValue());
      float _movingAvg_5 = _addValue_5.getMovingAvg();
      Vector<Float> _createVector = VectorMaths.createVector(_movingAvg, _movingAvg_1, _movingAvg_2, _movingAvg_3, _movingAvg_4, _movingAvg_5);
      MovingAverageCalculator _calculator_6 = MovingAverageCalculator.getCalculator("LSX");
      Float _LSX = LSX;
      MovingAverageCalculator _addValue_6 = _calculator_6.addValue((_LSX).floatValue());
      float _movingAvg_6 = _addValue_6.getMovingAvg();
      MovingAverageCalculator _calculator_7 = MovingAverageCalculator.getCalculator("LSY");
      Float _LSY = LSY;
      MovingAverageCalculator _addValue_7 = _calculator_7.addValue((_LSY).floatValue());
      float _movingAvg_7 = _addValue_7.getMovingAvg();
      MovingAverageCalculator _calculator_8 = MovingAverageCalculator.getCalculator("LSZ");
      Float _LSZ = LSZ;
      MovingAverageCalculator _addValue_8 = _calculator_8.addValue((_LSZ).floatValue());
      float _movingAvg_8 = _addValue_8.getMovingAvg();
      MovingAverageCalculator _calculator_9 = MovingAverageCalculator.getCalculator("LEX");
      Float _LEX_1 = LEX;
      MovingAverageCalculator _addValue_9 = _calculator_9.addValue((_LEX_1).floatValue());
      float _movingAvg_9 = _addValue_9.getMovingAvg();
      MovingAverageCalculator _calculator_10 = MovingAverageCalculator.getCalculator("LEY");
      Float _LEY_1 = LEY;
      MovingAverageCalculator _addValue_10 = _calculator_10.addValue((_LEY_1).floatValue());
      float _movingAvg_10 = _addValue_10.getMovingAvg();
      MovingAverageCalculator _calculator_11 = MovingAverageCalculator.getCalculator("LEZ");
      Float _LEZ_1 = LEZ;
      MovingAverageCalculator _addValue_11 = _calculator_11.addValue((_LEZ_1).floatValue());
      float _movingAvg_11 = _addValue_11.getMovingAvg();
      Vector<Float> _createVector_1 = VectorMaths.createVector(_movingAvg_6, _movingAvg_7, _movingAvg_8, _movingAvg_9, _movingAvg_10, _movingAvg_11);
      float angleBetween = VectorMaths.angleBetween(_createVector, _createVector_1);
      double _minus = (Math.PI - angleBetween);
      boolean _lessThan = (_minus < YMCAConstants.angleTolerance);
      _xblockexpression = (_lessThan);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int LHYPosition = tupleNameMap.get("LHY");
    java.lang.Float LHY = (java.lang.Float) tuple.get(LHYPosition);
    int LHZPosition = tupleNameMap.get("LHZ");
    java.lang.Float LHZ = (java.lang.Float) tuple.get(LHZPosition);
    int LSZPosition = tupleNameMap.get("LSZ");
    java.lang.Float LSZ = (java.lang.Float) tuple.get(LSZPosition);
    int LSXPosition = tupleNameMap.get("LSX");
    java.lang.Float LSX = (java.lang.Float) tuple.get(LSXPosition);
    int LSYPosition = tupleNameMap.get("LSY");
    java.lang.Float LSY = (java.lang.Float) tuple.get(LSYPosition);
    int LHXPosition = tupleNameMap.get("LHX");
    java.lang.Float LHX = (java.lang.Float) tuple.get(LHXPosition);
    int LEYPosition = tupleNameMap.get("LEY");
    java.lang.Float LEY = (java.lang.Float) tuple.get(LEYPosition);
    int LEZPosition = tupleNameMap.get("LEZ");
    java.lang.Float LEZ = (java.lang.Float) tuple.get(LEZPosition);
    int LEXPosition = tupleNameMap.get("LEX");
    java.lang.Float LEX = (java.lang.Float) tuple.get(LEXPosition);
    return evaluateXExpressionGenerated(LHY, LHZ, LSZ, LSX, LSY, LHX, LEY, LEZ, LEX);
  }
}
