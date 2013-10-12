/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression#getBranches <em>Branches</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getBranchExpression()
 * @model
 * @generated
 */
public interface BranchExpression extends FollowerEventStructure
{
  /**
   * Returns the value of the '<em><b>Branches</b></em>' reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Branches</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Branches</em>' reference list.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getBranchExpression_Branches()
   * @model
   * @generated
   */
  EList<EventParamWithType> getBranches();

} // BranchExpression
