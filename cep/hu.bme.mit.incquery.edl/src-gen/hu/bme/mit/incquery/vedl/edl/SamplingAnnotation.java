/**
 */
package hu.bme.mit.incquery.vedl.edl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sampling Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.SamplingAnnotation#getSampling <em>Sampling</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getSamplingAnnotation()
 * @model
 * @generated
 */
public interface SamplingAnnotation extends Annotations
{
  /**
   * Returns the value of the '<em><b>Sampling</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sampling</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sampling</em>' attribute.
   * @see #setSampling(int)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getSamplingAnnotation_Sampling()
   * @model
   * @generated
   */
  int getSampling();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.SamplingAnnotation#getSampling <em>Sampling</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sampling</em>' attribute.
   * @see #getSampling()
   * @generated
   */
  void setSampling(int value);

} // SamplingAnnotation
