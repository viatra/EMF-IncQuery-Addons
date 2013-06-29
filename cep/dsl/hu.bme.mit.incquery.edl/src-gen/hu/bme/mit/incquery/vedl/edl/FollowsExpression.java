/**
 */
package hu.bme.mit.incquery.vedl.edl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Follows Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.FollowsExpression#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.FollowsExpression#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getFollowsExpression()
 * @model
 * @generated
 */
public interface FollowsExpression extends ComplexEventExpression
{
  /**
   * Returns the value of the '<em><b>First Event</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.vedl.edl.EventWithMultiplicity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Event</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Event</em>' containment reference list.
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getFollowsExpression_FirstEvent()
   * @model containment="true"
   * @generated
   */
  EList<EventWithMultiplicity> getFirstEvent();

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.vedl.edl.EventWithFollowsOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getFollowsExpression_Events()
   * @model containment="true"
   * @generated
   */
  EList<EventWithFollowsOperator> getEvents();

} // FollowsExpression
