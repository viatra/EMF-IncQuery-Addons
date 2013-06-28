/**
 */
package hu.bme.mit.incquery.vedl.edl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.ParameterFilter#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.ParameterFilter#getParamFilterRule <em>Param Filter Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getParameterFilter()
 * @model
 * @generated
 */
public interface ParameterFilter extends EObject
{
  /**
   * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Name</em>' attribute.
   * @see #setAttributeName(String)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getParameterFilter_AttributeName()
   * @model
   * @generated
   */
  String getAttributeName();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.ParameterFilter#getAttributeName <em>Attribute Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Name</em>' attribute.
   * @see #getAttributeName()
   * @generated
   */
  void setAttributeName(String value);

  /**
   * Returns the value of the '<em><b>Param Filter Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Filter Rule</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Filter Rule</em>' containment reference.
   * @see #setParamFilterRule(ParameterFilterRule)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getParameterFilter_ParamFilterRule()
   * @model containment="true"
   * @generated
   */
  ParameterFilterRule getParamFilterRule();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.ParameterFilter#getParamFilterRule <em>Param Filter Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param Filter Rule</em>' containment reference.
   * @see #getParamFilterRule()
   * @generated
   */
  void setParamFilterRule(ParameterFilterRule value);

} // ParameterFilter
