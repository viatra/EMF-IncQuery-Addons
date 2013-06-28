package bodymodel.util;

import bodymodel.MovingAverageCalculator;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the bodymodel.RightHandAboveHead_MovingAverage pattern.
 */
public class RightHandAboveHead_MovingAverageEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Float Hy, final Float RHy) {
    boolean _xblockexpression = false;
    {
      MovingAverageCalculator rhy_mac = MovingAverageCalculator.getCalculator("RH_Y");
      Float _RHy = RHy;
      rhy_mac.addValue((_RHy).floatValue());
      MovingAverageCalculator hy_mac = MovingAverageCalculator.getCalculator("H_Y");
      Float _Hy = Hy;
      hy_mac.addValue((_Hy).floatValue());
      float _movingAvg = hy_mac.getMovingAvg();
      float _movingAvg_1 = rhy_mac.getMovingAvg();
      boolean _lessThan = (_movingAvg < _movingAvg_1);
      _xblockexpression = (_lessThan);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int HyPosition = tupleNameMap.get("Hy");
    java.lang.Float Hy = (java.lang.Float) tuple.get(HyPosition);
    int RHyPosition = tupleNameMap.get("RHy");
    java.lang.Float RHy = (java.lang.Float) tuple.get(RHyPosition);
    return evaluateXExpressionGenerated(Hy, RHy);
  }
}
