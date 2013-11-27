/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Typed Parameter With Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterWithMultiplicityImpl#getEventPattern <em>Event Pattern</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterWithMultiplicityImpl#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterWithMultiplicityImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventTypedParameterWithMultiplicityImpl extends FollowerEventStructureImpl implements EventTypedParameterWithMultiplicity
{
  /**
   * The cached value of the '{@link #getEventPattern() <em>Event Pattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventPattern()
   * @generated
   * @ordered
   */
  protected EventPattern eventPattern;

  /**
   * The cached value of the '{@link #getParameterList() <em>Parameter List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterList()
   * @generated
   * @ordered
   */
  protected PatternCallParameterList parameterList;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventTypedParameterWithMultiplicityImpl()
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
    return EventPatternLanguagePackage.Literals.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventPattern getEventPattern()
  {
    if (eventPattern != null && eventPattern.eIsProxy())
    {
      InternalEObject oldEventPattern = (InternalEObject)eventPattern;
      eventPattern = (EventPattern)eResolveProxy(oldEventPattern);
      if (eventPattern != oldEventPattern)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN, oldEventPattern, eventPattern));
      }
    }
    return eventPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventPattern basicGetEventPattern()
  {
    return eventPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEventPattern(EventPattern newEventPattern)
  {
    EventPattern oldEventPattern = eventPattern;
    eventPattern = newEventPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN, oldEventPattern, eventPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternCallParameterList getParameterList()
  {
    return parameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParameterList(PatternCallParameterList newParameterList, NotificationChain msgs)
  {
    PatternCallParameterList oldParameterList = parameterList;
    parameterList = newParameterList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST, oldParameterList, newParameterList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterList(PatternCallParameterList newParameterList)
  {
    if (newParameterList != parameterList)
    {
      NotificationChain msgs = null;
      if (parameterList != null)
        msgs = ((InternalEObject)parameterList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST, null, msgs);
      if (newParameterList != null)
        msgs = ((InternalEObject)newParameterList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST, null, msgs);
      msgs = basicSetParameterList(newParameterList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST, newParameterList, newParameterList));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY, oldMultiplicity, newMultiplicity);
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
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY, newMultiplicity, newMultiplicity));
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
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST:
        return basicSetParameterList(null, msgs);
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
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
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN:
        if (resolve) return getEventPattern();
        return basicGetEventPattern();
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST:
        return getParameterList();
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY:
        return getMultiplicity();
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
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN:
        setEventPattern((EventPattern)newValue);
        return;
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST:
        setParameterList((PatternCallParameterList)newValue);
        return;
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY:
        setMultiplicity((Multiplicity)newValue);
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
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN:
        setEventPattern((EventPattern)null);
        return;
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST:
        setParameterList((PatternCallParameterList)null);
        return;
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY:
        setMultiplicity((Multiplicity)null);
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
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN:
        return eventPattern != null;
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST:
        return parameterList != null;
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY:
        return multiplicity != null;
    }
    return super.eIsSet(featureID);
  }

} //EventTypedParameterWithMultiplicityImpl
