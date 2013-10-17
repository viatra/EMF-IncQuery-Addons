/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedExpressionImpl#getTimewindow <em>Timewindow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimedExpressionImpl extends AugmentedExpressionImpl implements TimedExpression
{
  /**
   * The cached value of the '{@link #getTimewindow() <em>Timewindow</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimewindow()
   * @generated
   * @ordered
   */
  protected Timewindow timewindow;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimedExpressionImpl()
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
    return EventPatternLanguagePackage.Literals.TIMED_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Timewindow getTimewindow()
  {
    return timewindow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTimewindow(Timewindow newTimewindow, NotificationChain msgs)
  {
    Timewindow oldTimewindow = timewindow;
    timewindow = newTimewindow;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW, oldTimewindow, newTimewindow);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimewindow(Timewindow newTimewindow)
  {
    if (newTimewindow != timewindow)
    {
      NotificationChain msgs = null;
      if (timewindow != null)
        msgs = ((InternalEObject)timewindow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW, null, msgs);
      if (newTimewindow != null)
        msgs = ((InternalEObject)newTimewindow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW, null, msgs);
      msgs = basicSetTimewindow(newTimewindow, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW, newTimewindow, newTimewindow));
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
      case EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW:
        return basicSetTimewindow(null, msgs);
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
      case EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW:
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
      case EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW:
        setTimewindow((Timewindow)newValue);
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
      case EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW:
        setTimewindow((Timewindow)null);
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
      case EventPatternLanguagePackage.TIMED_EXPRESSION__TIMEWINDOW:
        return timewindow != null;
    }
    return super.eIsSet(featureID);
  }

} //TimedExpressionImpl
