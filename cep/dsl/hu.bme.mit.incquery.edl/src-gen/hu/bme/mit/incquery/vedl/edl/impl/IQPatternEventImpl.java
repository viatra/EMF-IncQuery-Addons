/**
 */
package hu.bme.mit.incquery.vedl.edl.impl;

import hu.bme.mit.incquery.vedl.edl.EdlPackage;
import hu.bme.mit.incquery.vedl.edl.IQPatternChangeType;
import hu.bme.mit.incquery.vedl.edl.IQPatternEvent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

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
   * The default value of the '{@link #getIqpattern() <em>Iqpattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIqpattern()
   * @generated
   * @ordered
   */
  protected static final String IQPATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIqpattern() <em>Iqpattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIqpattern()
   * @generated
   * @ordered
   */
  protected String iqpattern = IQPATTERN_EDEFAULT;

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
  public String getIqpattern()
  {
    return iqpattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIqpattern(String newIqpattern)
  {
    String oldIqpattern = iqpattern;
    iqpattern = newIqpattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.IQ_PATTERN_EVENT__IQPATTERN, oldIqpattern, iqpattern));
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
        setIqpattern((String)newValue);
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
        setIqpattern(IQPATTERN_EDEFAULT);
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
        return IQPATTERN_EDEFAULT == null ? iqpattern != null : !IQPATTERN_EDEFAULT.equals(iqpattern);
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
    result.append(" (iqpattern: ");
    result.append(iqpattern);
    result.append(", changeType: ");
    result.append(changeType);
    result.append(')');
    return result.toString();
  }

} //IQPatternEventImpl
