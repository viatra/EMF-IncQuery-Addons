/**
 */
package hu.bme.mit.incquery.vedl.edl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CE Paramlist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.CEParamlist#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getCEParamlist()
 * @model
 * @generated
 */
public interface CEParamlist extends EObject
{
  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.vedl.edl.ParamWithType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getCEParamlist_Params()
   * @model containment="true"
   * @generated
   */
  EList<ParamWithType> getParams();

} // CEParamlist
