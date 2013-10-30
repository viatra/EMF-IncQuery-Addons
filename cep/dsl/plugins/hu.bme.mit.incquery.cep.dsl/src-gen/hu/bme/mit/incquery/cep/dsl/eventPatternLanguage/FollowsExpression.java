/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Follows Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression#getFollowerExpressions <em>Follower Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getFollowsExpression()
 * @model
 * @generated
 */
public interface FollowsExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Follower Expressions</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Follower Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Follower Expressions</em>' containment reference list.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getFollowsExpression_FollowerExpressions()
   * @model containment="true"
   * @generated
   */
  EList<FollowerExpression> getFollowerExpressions();

} // FollowsExpression
