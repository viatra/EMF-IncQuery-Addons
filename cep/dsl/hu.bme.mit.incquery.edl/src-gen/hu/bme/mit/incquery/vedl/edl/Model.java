/**
 */
package hu.bme.mit.incquery.vedl.edl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.Model#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.Model#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.Model#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.vedl.edl.Annotations}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getModel_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotations> getAnnotations();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.vedl.edl.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getModel_Events()
   * @model containment="true"
   * @generated
   */
  EList<Event> getEvents();

} // Model
