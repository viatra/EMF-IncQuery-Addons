/**
 */
package hu.bme.mit.incquery.srct.srct.impl;

import hu.bme.mit.incquery.srct.srct.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SrctFactoryImpl extends EFactoryImpl implements SrctFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SrctFactory init()
  {
    try
    {
      SrctFactory theSrctFactory = (SrctFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.bme.hu/mit/incquery/srct/Srct"); 
      if (theSrctFactory != null)
      {
        return theSrctFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SrctFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SrctFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SrctPackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case SrctPackage.SOURCE_MODEL: return createSourceModel();
      case SrctPackage.SOURCE: return createSource();
      case SrctPackage.ADAPTER: return createAdapter();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SourceModel createSourceModel()
  {
    SourceModelImpl sourceModel = new SourceModelImpl();
    return sourceModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Source createSource()
  {
    SourceImpl source = new SourceImpl();
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Adapter createAdapter()
  {
    AdapterImpl adapter = new AdapterImpl();
    return adapter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SrctPackage getSrctPackage()
  {
    return (SrctPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SrctPackage getPackage()
  {
    return SrctPackage.eINSTANCE;
  }

} //SrctFactoryImpl
