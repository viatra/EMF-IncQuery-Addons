/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerEventStructure;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Follower Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerExpressionImpl#getFollowsOperator <em>Follows Operator</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerExpressionImpl#getEventPattern <em>Event Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FollowerExpressionImpl extends MinimalEObjectImpl.Container implements FollowerExpression
{
  /**
   * The cached value of the '{@link #getFollowsOperator() <em>Follows Operator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFollowsOperator()
   * @generated
   * @ordered
   */
  protected FollowsOperator followsOperator;

  /**
   * The cached value of the '{@link #getEventPattern() <em>Event Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventPattern()
   * @generated
   * @ordered
   */
  protected FollowerEventStructure eventPattern;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FollowerExpressionImpl()
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
    return EventPatternLanguagePackage.Literals.FOLLOWER_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowsOperator getFollowsOperator()
  {
    return followsOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFollowsOperator(FollowsOperator newFollowsOperator, NotificationChain msgs)
  {
    FollowsOperator oldFollowsOperator = followsOperator;
    followsOperator = newFollowsOperator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR, oldFollowsOperator, newFollowsOperator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFollowsOperator(FollowsOperator newFollowsOperator)
  {
    if (newFollowsOperator != followsOperator)
    {
      NotificationChain msgs = null;
      if (followsOperator != null)
        msgs = ((InternalEObject)followsOperator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR, null, msgs);
      if (newFollowsOperator != null)
        msgs = ((InternalEObject)newFollowsOperator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR, null, msgs);
      msgs = basicSetFollowsOperator(newFollowsOperator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR, newFollowsOperator, newFollowsOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowerEventStructure getEventPattern()
  {
    return eventPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEventPattern(FollowerEventStructure newEventPattern, NotificationChain msgs)
  {
    FollowerEventStructure oldEventPattern = eventPattern;
    eventPattern = newEventPattern;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN, oldEventPattern, newEventPattern);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEventPattern(FollowerEventStructure newEventPattern)
  {
    if (newEventPattern != eventPattern)
    {
      NotificationChain msgs = null;
      if (eventPattern != null)
        msgs = ((InternalEObject)eventPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN, null, msgs);
      if (newEventPattern != null)
        msgs = ((InternalEObject)newEventPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN, null, msgs);
      msgs = basicSetEventPattern(newEventPattern, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN, newEventPattern, newEventPattern));
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
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR:
        return basicSetFollowsOperator(null, msgs);
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN:
        return basicSetEventPattern(null, msgs);
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
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR:
        return getFollowsOperator();
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN:
        return getEventPattern();
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
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR:
        setFollowsOperator((FollowsOperator)newValue);
        return;
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN:
        setEventPattern((FollowerEventStructure)newValue);
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
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR:
        setFollowsOperator((FollowsOperator)null);
        return;
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN:
        setEventPattern((FollowerEventStructure)null);
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
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR:
        return followsOperator != null;
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION__EVENT_PATTERN:
        return eventPattern != null;
    }
    return super.eIsSet(featureID);
  }

} //FollowerExpressionImpl
