/**
 */
package hu.bme.mit.incquery.vedl.edl.impl;

import hu.bme.mit.incquery.vedl.edl.EdlPackage;
import hu.bme.mit.incquery.vedl.edl.FollowsOperatorViaTW;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Follows Operator Via TW</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.FollowsOperatorViaTWImpl#getTimewindow <em>Timewindow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FollowsOperatorViaTWImpl extends FollowsOperatorImpl implements FollowsOperatorViaTW
{
  /**
   * The default value of the '{@link #getTimewindow() <em>Timewindow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimewindow()
   * @generated
   * @ordered
   */
  protected static final int TIMEWINDOW_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTimewindow() <em>Timewindow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimewindow()
   * @generated
   * @ordered
   */
  protected int timewindow = TIMEWINDOW_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FollowsOperatorViaTWImpl()
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
    return EdlPackage.Literals.FOLLOWS_OPERATOR_VIA_TW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTimewindow()
  {
    return timewindow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimewindow(int newTimewindow)
  {
    int oldTimewindow = timewindow;
    timewindow = newTimewindow;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW, oldTimewindow, timewindow));
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
      case EdlPackage.FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW:
        return getTimewindow();
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
      case EdlPackage.FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW:
        setTimewindow((Integer)newValue);
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
      case EdlPackage.FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW:
        setTimewindow(TIMEWINDOW_EDEFAULT);
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
      case EdlPackage.FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW:
        return timewindow != TIMEWINDOW_EDEFAULT;
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
    result.append(" (timewindow: ");
    result.append(timewindow);
    result.append(')');
    return result.toString();
  }

} //FollowsOperatorViaTWImpl
