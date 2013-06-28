/**
 */
package hu.bme.mit.incquery.vedl.edl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.ComplexEvent#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.ComplexEvent#getParamlist <em>Paramlist</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getComplexEvent()
 * @model
 * @generated
 */
public interface ComplexEvent extends Event
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
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getComplexEvent_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotations> getAnnotations();

  /**
   * Returns the value of the '<em><b>Paramlist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Paramlist</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Paramlist</em>' containment reference.
   * @see #setParamlist(CEParamlist)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getComplexEvent_Paramlist()
   * @model containment="true"
   * @generated
   */
  CEParamlist getParamlist();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.ComplexEvent#getParamlist <em>Paramlist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Paramlist</em>' containment reference.
   * @see #getParamlist()
   * @generated
   */
  void setParamlist(CEParamlist value);

} // ComplexEvent
