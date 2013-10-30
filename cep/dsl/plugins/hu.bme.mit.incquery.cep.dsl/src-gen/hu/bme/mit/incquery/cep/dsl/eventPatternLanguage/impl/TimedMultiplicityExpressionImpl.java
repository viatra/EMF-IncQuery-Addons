/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Multiplicity Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedMultiplicityExpressionImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedMultiplicityExpressionImpl#getTimewindow <em>Timewindow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimedMultiplicityExpressionImpl extends AugmentedExpressionImpl implements TimedMultiplicityExpression
{
  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected Multiplicity multiplicity;

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
  protected TimedMultiplicityExpressionImpl()
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
    return EventPatternLanguagePackage.Literals.TIMED_MULTIPLICITY_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiplicity getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicity(Multiplicity newMultiplicity, NotificationChain msgs)
  {
    Multiplicity oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY, oldMultiplicity, newMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(Multiplicity newMultiplicity)
  {
    if (newMultiplicity != multiplicity)
    {
      NotificationChain msgs = null;
      if (multiplicity != null)
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY, newMultiplicity, newMultiplicity));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW, oldTimewindow, newTimewindow);
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
        msgs = ((InternalEObject)timewindow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW, null, msgs);
      if (newTimewindow != null)
        msgs = ((InternalEObject)newTimewindow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW, null, msgs);
      msgs = basicSetTimewindow(newTimewindow, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW, newTimewindow, newTimewindow));
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
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW:
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
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY:
        return getMultiplicity();
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW:
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
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY:
        setMultiplicity((Multiplicity)newValue);
        return;
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW:
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
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY:
        setMultiplicity((Multiplicity)null);
        return;
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW:
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
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY:
        return multiplicity != null;
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW:
        return timewindow != null;
    }
    return super.eIsSet(featureID);
  }

} //TimedMultiplicityExpressionImpl
