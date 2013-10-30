/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Follower Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression#getFollowsOperator <em>Follows Operator</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression#getEventPattern <em>Event Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getFollowerExpression()
 * @model
 * @generated
 */
public interface FollowerExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Follows Operator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Follows Operator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Follows Operator</em>' containment reference.
   * @see #setFollowsOperator(FollowsOperator)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getFollowerExpression_FollowsOperator()
   * @model containment="true"
   * @generated
   */
  FollowsOperator getFollowsOperator();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression#getFollowsOperator <em>Follows Operator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Follows Operator</em>' containment reference.
   * @see #getFollowsOperator()
   * @generated
   */
  void setFollowsOperator(FollowsOperator value);

  /**
   * Returns the value of the '<em><b>Event Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event Pattern</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event Pattern</em>' containment reference.
   * @see #setEventPattern(FollowerEventStructure)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getFollowerExpression_EventPattern()
   * @model containment="true"
   * @generated
   */
  FollowerEventStructure getEventPattern();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression#getEventPattern <em>Event Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event Pattern</em>' containment reference.
   * @see #getEventPattern()
   * @generated
   */
  void setEventPattern(FollowerEventStructure value);

} // FollowerExpression
