/**
 */
package hu.bme.mit.incquery.srct.srct;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.srct.srct.Source#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.srct.srct.Source#getAdapter <em>Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.srct.srct.SrctPackage#getSource()
 * @model
 * @generated
 */
public interface Source extends EObject
{
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
   * @see hu.bme.mit.incquery.srct.srct.SrctPackage#getSource_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.srct.srct.Source#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Adapter</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.srct.srct.Adapter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adapter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adapter</em>' containment reference list.
   * @see hu.bme.mit.incquery.srct.srct.SrctPackage#getSource_Adapter()
   * @model containment="true"
   * @generated
   */
  EList<Adapter> getAdapter();

} // Source
