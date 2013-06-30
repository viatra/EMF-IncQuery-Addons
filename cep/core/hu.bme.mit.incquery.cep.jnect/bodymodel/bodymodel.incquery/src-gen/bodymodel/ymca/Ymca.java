package bodymodel.ymca;

import bodymodel.ymca.AMatcher;
import bodymodel.ymca.BEMatcher;
import bodymodel.ymca.BSMatcher;
import bodymodel.ymca.BentLeftArmMatcher;
import bodymodel.ymca.BentRightArmMatcher;
import bodymodel.ymca.CMatcher;
import bodymodel.ymca.FEMatcher;
import bodymodel.ymca.FSMatcher;
import bodymodel.ymca.FeetAreApartMatcher;
import bodymodel.ymca.FeetAreCloseMatcher;
import bodymodel.ymca.HandsAreApartMatcher;
import bodymodel.ymca.HandsAreCloseMatcher;
import bodymodel.ymca.IMatcher;
import bodymodel.ymca.LeftHandAboveHeadMatcher;
import bodymodel.ymca.MMatcher;
import bodymodel.ymca.QMatcher;
import bodymodel.ymca.RightHandAboveHeadMatcher;
import bodymodel.ymca.SEMatcher;
import bodymodel.ymca.SMMatcher;
import bodymodel.ymca.SSMatcher;
import bodymodel.ymca.StretchedLeftArmMatcher;
import bodymodel.ymca.StretchedRightArmMatcher;
import bodymodel.ymca.UpperArmsInYMatcher;
import bodymodel.ymca.YMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in ymca.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare 
 * an EMF-IncQuery engine for matching all patterns originally defined in file ymca.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package bodymodel.ymca, the group contains the definition of the following patterns: <ul>
 * <li>rightHandAboveHead</li>
 * <li>leftHandAboveHead</li>
 * <li>handsAreClose</li>
 * <li>handsAreApart</li>
 * <li>feetAreClose</li>
 * <li>feetAreApart</li>
 * <li>stretchedRightArm</li>
 * <li>bentRightArm</li>
 * <li>stretchedLeftArm</li>
 * <li>bentLeftArm</li>
 * <li>upperArmsInY</li>
 * <li>Y</li>
 * <li>I</li>
 * <li>A</li>
 * <li>M</li>
 * <li>Q</li>
 * <li>C</li>
 * <li>FS</li>
 * <li>FE</li>
 * <li>BS</li>
 * <li>BE</li>
 * <li>SS</li>
 * <li>SM</li>
 * <li>SE</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
public final class Ymca extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Ymca instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Ymca();
    }
    return INSTANCE;
    
  }
  
  private static Ymca INSTANCE;
  
  private Ymca() throws IncQueryException {
    querySpecifications.add(FSMatcher.querySpecification());
    querySpecifications.add(BentLeftArmMatcher.querySpecification());
    querySpecifications.add(SMMatcher.querySpecification());
    querySpecifications.add(UpperArmsInYMatcher.querySpecification());
    querySpecifications.add(YMatcher.querySpecification());
    querySpecifications.add(BEMatcher.querySpecification());
    querySpecifications.add(StretchedLeftArmMatcher.querySpecification());
    querySpecifications.add(SEMatcher.querySpecification());
    querySpecifications.add(BentRightArmMatcher.querySpecification());
    querySpecifications.add(HandsAreApartMatcher.querySpecification());
    querySpecifications.add(FeetAreApartMatcher.querySpecification());
    querySpecifications.add(AMatcher.querySpecification());
    querySpecifications.add(RightHandAboveHeadMatcher.querySpecification());
    querySpecifications.add(SSMatcher.querySpecification());
    querySpecifications.add(LeftHandAboveHeadMatcher.querySpecification());
    querySpecifications.add(CMatcher.querySpecification());
    querySpecifications.add(IMatcher.querySpecification());
    querySpecifications.add(HandsAreCloseMatcher.querySpecification());
    querySpecifications.add(MMatcher.querySpecification());
    querySpecifications.add(FeetAreCloseMatcher.querySpecification());
    querySpecifications.add(FEMatcher.querySpecification());
    querySpecifications.add(QMatcher.querySpecification());
    querySpecifications.add(BSMatcher.querySpecification());
    querySpecifications.add(StretchedRightArmMatcher.querySpecification());
    
  }
}
