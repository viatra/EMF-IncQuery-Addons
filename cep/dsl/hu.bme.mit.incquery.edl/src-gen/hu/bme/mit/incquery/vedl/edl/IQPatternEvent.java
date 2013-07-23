/**
 */
package hu.bme.mit.incquery.vedl.edl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IQ Pattern Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.IQPatternEvent#getIqpattern <em>Iqpattern</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.IQPatternEvent#getChangeType <em>Change Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getIQPatternEvent()
 * @model
 * @generated
 */
public interface IQPatternEvent extends AbstractAtomicEvent
{
  /**
   * Returns the value of the '<em><b>Iqpattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iqpattern</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iqpattern</em>' attribute.
   * @see #setIqpattern(String)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getIQPatternEvent_Iqpattern()
   * @model
   * @generated
   */
  String getIqpattern();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.IQPatternEvent#getIqpattern <em>Iqpattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Iqpattern</em>' attribute.
   * @see #getIqpattern()
   * @generated
   */
  void setIqpattern(String value);

  /**
   * Returns the value of the '<em><b>Change Type</b></em>' attribute.
   * The literals are from the enumeration {@link hu.bme.mit.incquery.vedl.edl.IQPatternChangeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Change Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Change Type</em>' attribute.
   * @see hu.bme.mit.incquery.vedl.edl.IQPatternChangeType
   * @see #setChangeType(IQPatternChangeType)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getIQPatternEvent_ChangeType()
   * @model
   * @generated
   */
  IQPatternChangeType getChangeType();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.IQPatternEvent#getChangeType <em>Change Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Change Type</em>' attribute.
   * @see hu.bme.mit.incquery.vedl.edl.IQPatternChangeType
   * @see #getChangeType()
   * @generated
   */
  void setChangeType(IQPatternChangeType value);

} // IQPatternEvent
