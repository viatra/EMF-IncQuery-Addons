/**
 */
package hu.bme.mit.incquery.srct.srct;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.srct.srct.PackageDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.srct.srct.PackageDeclaration#getSourceModel <em>Source Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.srct.srct.SrctPackage#getPackageDeclaration()
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
   * @see hu.bme.mit.incquery.srct.srct.SrctPackage#getPackageDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.srct.srct.PackageDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Source Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Model</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Model</em>' containment reference.
   * @see #setSourceModel(SourceModel)
   * @see hu.bme.mit.incquery.srct.srct.SrctPackage#getPackageDeclaration_SourceModel()
   * @model containment="true"
   * @generated
   */
  SourceModel getSourceModel();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.srct.srct.PackageDeclaration#getSourceModel <em>Source Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Model</em>' containment reference.
   * @see #getSourceModel()
   * @generated
   */
  void setSourceModel(SourceModel value);

} // PackageDeclaration
