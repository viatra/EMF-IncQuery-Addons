/**
 */
package hu.bme.mit.incquery.vedl.edl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Priority Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.PriorityAnnotation#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getPriorityAnnotation()
 * @model
 * @generated
 */
public interface PriorityAnnotation extends Annotations
{
  /**
   * Returns the value of the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' attribute.
   * @see #setPriority(int)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getPriorityAnnotation_Priority()
   * @model
   * @generated
   */
  int getPriority();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.PriorityAnnotation#getPriority <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' attribute.
   * @see #getPriority()
   * @generated
   */
  void setPriority(int value);

} // PriorityAnnotation
