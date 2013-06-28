/**
 */
package hu.bme.mit.incquery.vedl.edl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getUsages <em>Usages</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getPackageDeclaration()
 * @model
 * @generated
 */
public interface PackageDeclaration extends EObject
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
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getPackageDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Usages</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.vedl.edl.Usage}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Usages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Usages</em>' containment reference list.
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getPackageDeclaration_Usages()
   * @model containment="true"
   * @generated
   */
  EList<Usage> getUsages();

  /**
   * Returns the value of the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' containment reference.
   * @see #setModel(Model)
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#getPackageDeclaration_Model()
   * @model containment="true"
   * @generated
   */
  Model getModel();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getModel <em>Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' containment reference.
   * @see #getModel()
   * @generated
   */
  void setModel(Model value);

} // PackageDeclaration
