/**
 */
package hu.bme.mit.incquery.vedl.edl.impl;

import hu.bme.mit.incquery.vedl.edl.EdlPackage;
import hu.bme.mit.incquery.vedl.edl.IQPattern;
import hu.bme.mit.incquery.vedl.edl.IQPatternChangeType;
import hu.bme.mit.incquery.vedl.edl.IQPatternEvent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IQ Pattern Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.IQPatternEventImpl#getIqpattern <em>Iqpattern</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.IQPatternEventImpl#getChangeType <em>Change Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IQPatternEventImpl extends AbstractAtomicEventImpl implements IQPatternEvent
{
  /**
   * The cached value of the '{@link #getIqpattern() <em>Iqpattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIqpattern()
   * @generated
   * @ordered
   */
  protected IQPattern iqpattern;

  /**
   * The default value of the '{@link #getChangeType() <em>Change Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeType()
   * @generated
   * @ordered
   */
  protected static final IQPatternChangeType CHANGE_TYPE_EDEFAULT = IQPatternChangeType.FOUND;

  /**
   * The cached value of the '{@link #getChangeType() <em>Change Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeType()
   * @generated
   * @ordered
   */
  protected IQPatternChangeType changeType = CHANGE_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IQPatternEventImpl()
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
    return EdlPackage.Literals.IQ_PATTERN_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IQPattern getIqpattern()
  {
    return iqpattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIqpattern(IQPattern newIqpattern, NotificationChain msgs)
  {
    IQPattern oldIqpattern = iqpattern;
    iqpattern = newIqpattern;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdlPackage.IQ_PATTERN_EVENT__IQPATTERN, oldIqpattern, newIqpattern);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIqpattern(IQPattern newIqpattern)
  {
    if (newIqpattern != iqpattern)
    {
      NotificationChain msgs = null;
      if (iqpattern != null)
        msgs = ((InternalEObject)iqpattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdlPackage.IQ_PATTERN_EVENT__IQPATTERN, null, msgs);
      if (newIqpattern != null)
        msgs = ((InternalEObject)newIqpattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdlPackage.IQ_PATTERN_EVENT__IQPATTERN, null, msgs);
      msgs = basicSetIqpattern(newIqpattern, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.IQ_PATTERN_EVENT__IQPATTERN, newIqpattern, newIqpattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IQPatternChangeType getChangeType()
  {
    return changeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangeType(IQPatternChangeType newChangeType)
  {
    IQPatternChangeType oldChangeType = changeType;
    changeType = newChangeType == null ? CHANGE_TYPE_EDEFAULT : newChangeType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.IQ_PATTERN_EVENT__CHANGE_TYPE, oldChangeType, changeType));
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
      case EdlPackage.IQ_PATTERN_EVENT__IQPATTERN:
        return basicSetIqpattern(null, msgs);
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
      case EdlPackage.IQ_PATTERN_EVENT__IQPATTERN:
        return getIqpattern();
      case EdlPackage.IQ_PATTERN_EVENT__CHANGE_TYPE:
        return getChangeType();
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
      case EdlPackage.IQ_PATTERN_EVENT__IQPATTERN:
        setIqpattern((IQPattern)newValue);
        return;
      case EdlPackage.IQ_PATTERN_EVENT__CHANGE_TYPE:
        setChangeType((IQPatternChangeType)newValue);
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
      case EdlPackage.IQ_PATTERN_EVENT__IQPATTERN:
        setIqpattern((IQPattern)null);
        return;
      case EdlPackage.IQ_PATTERN_EVENT__CHANGE_TYPE:
        setChangeType(CHANGE_TYPE_EDEFAULT);
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
      case EdlPackage.IQ_PATTERN_EVENT__IQPATTERN:
        return iqpattern != null;
      case EdlPackage.IQ_PATTERN_EVENT__CHANGE_TYPE:
        return changeType != CHANGE_TYPE_EDEFAULT;
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
    result.append(" (changeType: ");
    result.append(changeType);
    result.append(')');
    return result.toString();
  }

} //IQPatternEventImpl
