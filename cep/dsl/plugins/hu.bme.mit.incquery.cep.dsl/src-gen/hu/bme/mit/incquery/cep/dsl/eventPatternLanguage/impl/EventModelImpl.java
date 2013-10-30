/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelImpl#getPackagedModel <em>Packaged Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventModelImpl extends MinimalEObjectImpl.Container implements EventModel
{
  /**
   * The cached value of the '{@link #getPackagedModel() <em>Packaged Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackagedModel()
   * @generated
   * @ordered
   */
  protected PackagedModel packagedModel;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventModelImpl()
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
    return EventPatternLanguagePackage.Literals.EVENT_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackagedModel getPackagedModel()
  {
    return packagedModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackagedModel(PackagedModel newPackagedModel, NotificationChain msgs)
  {
    PackagedModel oldPackagedModel = packagedModel;
    packagedModel = newPackagedModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL, oldPackagedModel, newPackagedModel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackagedModel(PackagedModel newPackagedModel)
  {
    if (newPackagedModel != packagedModel)
    {
      NotificationChain msgs = null;
      if (packagedModel != null)
        msgs = ((InternalEObject)packagedModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL, null, msgs);
      if (newPackagedModel != null)
        msgs = ((InternalEObject)newPackagedModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL, null, msgs);
      msgs = basicSetPackagedModel(newPackagedModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL, newPackagedModel, newPackagedModel));
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
      case EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL:
        return basicSetPackagedModel(null, msgs);
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
      case EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL:
        return getPackagedModel();
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
      case EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL:
        setPackagedModel((PackagedModel)newValue);
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
      case EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL:
        setPackagedModel((PackagedModel)null);
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
      case EventPatternLanguagePackage.EVENT_MODEL__PACKAGED_MODEL:
        return packagedModel != null;
    }
    return super.eIsSet(featureID);
  }

} //EventModelImpl
