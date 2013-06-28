/**
 */
package hu.bme.mit.incquery.srct.srct;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.srct.srct.SrctFactory
 * @model kind="package"
 * @generated
 */
public interface SrctPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "srct";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.bme.hu/mit/incquery/srct/Srct";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "srct";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SrctPackage eINSTANCE = hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl.init();

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.srct.srct.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.srct.srct.impl.PackageDeclarationImpl
   * @see hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl#getPackageDeclaration()
   * @generated
   */
  int PACKAGE_DECLARATION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Source Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__SOURCE_MODEL = 1;

  /**
   * The number of structural features of the '<em>Package Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.srct.srct.impl.SourceModelImpl <em>Source Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.srct.srct.impl.SourceModelImpl
   * @see hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl#getSourceModel()
   * @generated
   */
  int SOURCE_MODEL = 1;

  /**
   * The feature id for the '<em><b>Sources</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_MODEL__SOURCES = 0;

  /**
   * The number of structural features of the '<em>Source Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.srct.srct.impl.SourceImpl <em>Source</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.srct.srct.impl.SourceImpl
   * @see hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl#getSource()
   * @generated
   */
  int SOURCE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__NAME = 0;

  /**
   * The feature id for the '<em><b>Adapter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__ADAPTER = 1;

  /**
   * The number of structural features of the '<em>Source</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.srct.srct.impl.AdapterImpl <em>Adapter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.srct.srct.impl.AdapterImpl
   * @see hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl#getAdapter()
   * @generated
   */
  int ADAPTER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADAPTER__NAME = 0;

  /**
   * The number of structural features of the '<em>Adapter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADAPTER_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.srct.srct.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Declaration</em>'.
   * @see hu.bme.mit.incquery.srct.srct.PackageDeclaration
   * @generated
   */
  EClass getPackageDeclaration();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.srct.srct.PackageDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.srct.srct.PackageDeclaration#getName()
   * @see #getPackageDeclaration()
   * @generated
   */
  EAttribute getPackageDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.srct.srct.PackageDeclaration#getSourceModel <em>Source Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source Model</em>'.
   * @see hu.bme.mit.incquery.srct.srct.PackageDeclaration#getSourceModel()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_SourceModel();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.srct.srct.SourceModel <em>Source Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Model</em>'.
   * @see hu.bme.mit.incquery.srct.srct.SourceModel
   * @generated
   */
  EClass getSourceModel();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.srct.srct.SourceModel#getSources <em>Sources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sources</em>'.
   * @see hu.bme.mit.incquery.srct.srct.SourceModel#getSources()
   * @see #getSourceModel()
   * @generated
   */
  EReference getSourceModel_Sources();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.srct.srct.Source <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source</em>'.
   * @see hu.bme.mit.incquery.srct.srct.Source
   * @generated
   */
  EClass getSource();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.srct.srct.Source#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.srct.srct.Source#getName()
   * @see #getSource()
   * @generated
   */
  EAttribute getSource_Name();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.srct.srct.Source#getAdapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Adapter</em>'.
   * @see hu.bme.mit.incquery.srct.srct.Source#getAdapter()
   * @see #getSource()
   * @generated
   */
  EReference getSource_Adapter();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.srct.srct.Adapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Adapter</em>'.
   * @see hu.bme.mit.incquery.srct.srct.Adapter
   * @generated
   */
  EClass getAdapter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.srct.srct.Adapter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.srct.srct.Adapter#getName()
   * @see #getAdapter()
   * @generated
   */
  EAttribute getAdapter_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SrctFactory getSrctFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.srct.srct.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.srct.srct.impl.PackageDeclarationImpl
     * @see hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl#getPackageDeclaration()
     * @generated
     */
    EClass PACKAGE_DECLARATION = eINSTANCE.getPackageDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_DECLARATION__NAME = eINSTANCE.getPackageDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Source Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__SOURCE_MODEL = eINSTANCE.getPackageDeclaration_SourceModel();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.srct.srct.impl.SourceModelImpl <em>Source Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.srct.srct.impl.SourceModelImpl
     * @see hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl#getSourceModel()
     * @generated
     */
    EClass SOURCE_MODEL = eINSTANCE.getSourceModel();

    /**
     * The meta object literal for the '<em><b>Sources</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOURCE_MODEL__SOURCES = eINSTANCE.getSourceModel_Sources();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.srct.srct.impl.SourceImpl <em>Source</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.srct.srct.impl.SourceImpl
     * @see hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl#getSource()
     * @generated
     */
    EClass SOURCE = eINSTANCE.getSource();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOURCE__NAME = eINSTANCE.getSource_Name();

    /**
     * The meta object literal for the '<em><b>Adapter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOURCE__ADAPTER = eINSTANCE.getSource_Adapter();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.srct.srct.impl.AdapterImpl <em>Adapter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.srct.srct.impl.AdapterImpl
     * @see hu.bme.mit.incquery.srct.srct.impl.SrctPackageImpl#getAdapter()
     * @generated
     */
    EClass ADAPTER = eINSTANCE.getAdapter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADAPTER__NAME = eINSTANCE.getAdapter_Name();

  }

} //SrctPackage
