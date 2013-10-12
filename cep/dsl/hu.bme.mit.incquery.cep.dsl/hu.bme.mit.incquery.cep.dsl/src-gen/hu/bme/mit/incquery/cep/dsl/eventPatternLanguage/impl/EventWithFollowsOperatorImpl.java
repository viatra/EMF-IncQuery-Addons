/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerEventStructure;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event With Follows Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithFollowsOperatorImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithFollowsOperatorImpl#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventWithFollowsOperatorImpl extends MinimalEObjectImpl.Container implements EventWithFollowsOperator
{
  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected FollowsOperator operator;

  /**
   * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent()
   * @generated
   * @ordered
   */
  protected FollowerEventStructure event;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventWithFollowsOperatorImpl()
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
    return EventPatternLanguagePackage.Literals.EVENT_WITH_FOLLOWS_OPERATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowsOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperator(FollowsOperator newOperator, NotificationChain msgs)
  {
    FollowsOperator oldOperator = operator;
    operator = newOperator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR, oldOperator, newOperator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(FollowsOperator newOperator)
  {
    if (newOperator != operator)
    {
      NotificationChain msgs = null;
      if (operator != null)
        msgs = ((InternalEObject)operator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR, null, msgs);
      if (newOperator != null)
        msgs = ((InternalEObject)newOperator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR, null, msgs);
      msgs = basicSetOperator(newOperator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR, newOperator, newOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowerEventStructure getEvent()
  {
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEvent(FollowerEventStructure newEvent, NotificationChain msgs)
  {
    FollowerEventStructure oldEvent = event;
    event = newEvent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT, oldEvent, newEvent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvent(FollowerEventStructure newEvent)
  {
    if (newEvent != event)
    {
      NotificationChain msgs = null;
      if (event != null)
        msgs = ((InternalEObject)event).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT, null, msgs);
      if (newEvent != null)
        msgs = ((InternalEObject)newEvent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT, null, msgs);
      msgs = basicSetEvent(newEvent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT, newEvent, newEvent));
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
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR:
        return basicSetOperator(null, msgs);
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT:
        return basicSetEvent(null, msgs);
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
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR:
        return getOperator();
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT:
        return getEvent();
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
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR:
        setOperator((FollowsOperator)newValue);
        return;
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT:
        setEvent((FollowerEventStructure)newValue);
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
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR:
        setOperator((FollowsOperator)null);
        return;
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT:
        setEvent((FollowerEventStructure)null);
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
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR:
        return operator != null;
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR__EVENT:
        return event != null;
    }
    return super.eIsSet(featureID);
  }

} //EventWithFollowsOperatorImpl
