/**
 */
package hu.bme.mit.incquery.srct.srct.impl;

import hu.bme.mit.incquery.srct.srct.PackageDeclaration;
import hu.bme.mit.incquery.srct.srct.SourceModel;
import hu.bme.mit.incquery.srct.srct.SrctPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.srct.srct.impl.PackageDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.srct.srct.impl.PackageDeclarationImpl#getSourceModel <em>Source Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageDeclarationImpl extends MinimalEObjectImpl.Container implements PackageDeclaration
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getSourceModel() <em>Source Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceModel()
   * @generated
   * @ordered
   */
  protected SourceModel sourceModel;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageDeclarationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SrctPackage.Literals.PACKAGE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SrctPackage.PACKAGE_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SourceModel getSourceModel()
  {
    return sourceModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSourceModel(SourceModel newSourceModel, NotificationChain msgs)
  {
    SourceModel oldSourceModel = sourceModel;
    sourceModel = newSourceModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL, oldSourceModel, newSourceModel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceModel(SourceModel newSourceModel)
  {
    if (newSourceModel != sourceModel)
    {
      NotificationChain msgs = null;
      if (sourceModel != null)
        msgs = ((InternalEObject)sourceModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL, null, msgs);
      if (newSourceModel != null)
        msgs = ((InternalEObject)newSourceModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL, null, msgs);
      msgs = basicSetSourceModel(newSourceModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL, newSourceModel, newSourceModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL:
        return basicSetSourceModel(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SrctPackage.PACKAGE_DECLARATION__NAME:
        return getName();
      case SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL:
        return getSourceModel();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SrctPackage.PACKAGE_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL:
        setSourceModel((SourceModel)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SrctPackage.PACKAGE_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL:
        setSourceModel((SourceModel)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SrctPackage.PACKAGE_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SrctPackage.PACKAGE_DECLARATION__SOURCE_MODEL:
        return sourceModel != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PackageDeclarationImpl
