/**
 */
package hu.bme.mit.incquery.srct.srct;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.srct.srct.SourceModel#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.srct.srct.SrctPackage#getSourceModel()
 * @model
 * @generated
 */
public interface SourceModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Sources</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.srct.srct.Source}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sources</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sources</em>' containment reference list.
   * @see hu.bme.mit.incquery.srct.srct.SrctPackage#getSourceModel_Sources()
   * @model containment="true"
   * @generated
   */
  EList<Source> getSources();

} // SourceModel
