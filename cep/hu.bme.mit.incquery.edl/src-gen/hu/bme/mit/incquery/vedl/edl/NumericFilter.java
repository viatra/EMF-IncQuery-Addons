/**
 */
package hu.bme.mit.incquery.vedl.edl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.NumericFilter#getOperator <em>Operator</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.NumericFilter#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getNumericFilter()
 * @model
 * @generated
 */
public interface NumericFilter extends ParameterFilterRule
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see #setOperator(String)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getNumericFilter_Operator()
   * @model
   * @generated
   */
  String getOperator();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.NumericFilter#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see #getOperator()
   * @generated
   */
  void setOperator(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getNumericFilter_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.NumericFilter#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // NumericFilter
