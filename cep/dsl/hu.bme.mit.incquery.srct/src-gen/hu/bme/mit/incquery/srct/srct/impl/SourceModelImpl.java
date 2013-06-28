/**
 */
package hu.bme.mit.incquery.srct.srct.impl;

import hu.bme.mit.incquery.srct.srct.Source;
import hu.bme.mit.incquery.srct.srct.SourceModel;
import hu.bme.mit.incquery.srct.srct.SrctPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.srct.srct.impl.SourceModelImpl#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceModelImpl extends MinimalEObjectImpl.Container implements SourceModel
{
  /**
   * The cached value of the '{@link #getSources() <em>Sources</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSources()
   * @generated
   * @ordered
   */
  protected EList<Source> sources;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SourceModelImpl()
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
    return SrctPackage.Literals.SOURCE_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Source> getSources()
  {
    if (sources == null)
    {
      sources = new EObjectContainmentEList<Source>(Source.class, this, SrctPackage.SOURCE_MODEL__SOURCES);
    }
    return sources;
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
      case SrctPackage.SOURCE_MODEL__SOURCES:
        return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
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
      case SrctPackage.SOURCE_MODEL__SOURCES:
        return getSources();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SrctPackage.SOURCE_MODEL__SOURCES:
        getSources().clear();
        getSources().addAll((Collection<? extends Source>)newValue);
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
      case SrctPackage.SOURCE_MODEL__SOURCES:
        getSources().clear();
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
      case SrctPackage.SOURCE_MODEL__SOURCES:
        return sources != null && !sources.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SourceModelImpl
