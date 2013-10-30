/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timewindow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimewindowImpl#getLength <em>Length</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimewindowImpl extends MinimalEObjectImpl.Container implements Timewindow
{
  /**
   * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected static final int LENGTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected int length = LENGTH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimewindowImpl()
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
    return EventPatternLanguagePackage.Literals.TIMEWINDOW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLength()
  {
    return length;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLength(int newLength)
  {
    int oldLength = length;
    length = newLength;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.TIMEWINDOW__LENGTH, oldLength, length));
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
      case EventPatternLanguagePackage.TIMEWINDOW__LENGTH:
        return getLength();
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
      case EventPatternLanguagePackage.TIMEWINDOW__LENGTH:
        setLength((Integer)newValue);
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
      case EventPatternLanguagePackage.TIMEWINDOW__LENGTH:
        setLength(LENGTH_EDEFAULT);
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
      case EventPatternLanguagePackage.TIMEWINDOW__LENGTH:
        return length != LENGTH_EDEFAULT;
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
    result.append(" (length: ");
    result.append(length);
    result.append(')');
    return result.toString();
  }

} //TimewindowImpl
