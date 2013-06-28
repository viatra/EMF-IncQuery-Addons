/**
 */
package hu.bme.mit.incquery.srct.srct;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.srct.srct.SrctPackage
 * @generated
 */
public interface SrctFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SrctFactory eINSTANCE = hu.bme.mit.incquery.srct.srct.impl.SrctFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Declaration</em>'.
   * @generated
   */
  PackageDeclaration createPackageDeclaration();

  /**
   * Returns a new object of class '<em>Source Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Source Model</em>'.
   * @generated
   */
  SourceModel createSourceModel();

  /**
   * Returns a new object of class '<em>Source</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Source</em>'.
   * @generated
   */
  Source createSource();

  /**
   * Returns a new object of class '<em>Adapter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Adapter</em>'.
   * @generated
   */
  Adapter createAdapter();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SrctPackage getSrctPackage();

} //SrctFactory
