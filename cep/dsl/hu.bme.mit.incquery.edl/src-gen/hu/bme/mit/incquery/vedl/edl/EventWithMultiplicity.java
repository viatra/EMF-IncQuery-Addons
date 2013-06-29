/**
 */
package hu.bme.mit.incquery.vedl.edl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event With Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.EventWithMultiplicity#getEvent <em>Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.EventWithMultiplicity#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getEventWithMultiplicity()
 * @model
 * @generated
 */
public interface EventWithMultiplicity extends EObject
{
  /**
   * Returns the value of the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' reference.
   * @see #setEvent(EventParamWithType)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getEventWithMultiplicity_Event()
   * @model
   * @generated
   */
  EventParamWithType getEvent();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.EventWithMultiplicity#getEvent <em>Event</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' reference.
   * @see #getEvent()
   * @generated
   */
  void setEvent(EventParamWithType value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' attribute.
   * @see #setMultiplicity(int)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getEventWithMultiplicity_Multiplicity()
   * @model
   * @generated
   */
  int getMultiplicity();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.EventWithMultiplicity#getMultiplicity <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' attribute.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(int value);

} // EventWithMultiplicity
