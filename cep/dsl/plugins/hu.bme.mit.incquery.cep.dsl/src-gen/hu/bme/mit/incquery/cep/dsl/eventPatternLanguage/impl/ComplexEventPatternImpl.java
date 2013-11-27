/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventPatternImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventPatternImpl#getComplexEventExpression <em>Complex Event Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexEventPatternImpl extends EventPatternImpl implements ComplexEventPattern
{
  /**
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final int PRIORITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected int priority = PRIORITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getComplexEventExpression() <em>Complex Event Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComplexEventExpression()
   * @generated
   * @ordered
   */
  protected ComplexEventExpression complexEventExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComplexEventPatternImpl()
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
    return EventPatternLanguagePackage.Literals.COMPLEX_EVENT_PATTERN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPriority()
  {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(int newPriority)
  {
    int oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__PRIORITY, oldPriority, priority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexEventExpression getComplexEventExpression()
  {
    return complexEventExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComplexEventExpression(ComplexEventExpression newComplexEventExpression, NotificationChain msgs)
  {
    ComplexEventExpression oldComplexEventExpression = complexEventExpression;
    complexEventExpression = newComplexEventExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION, oldComplexEventExpression, newComplexEventExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComplexEventExpression(ComplexEventExpression newComplexEventExpression)
  {
    if (newComplexEventExpression != complexEventExpression)
    {
      NotificationChain msgs = null;
      if (complexEventExpression != null)
        msgs = ((InternalEObject)complexEventExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION, null, msgs);
      if (newComplexEventExpression != null)
        msgs = ((InternalEObject)newComplexEventExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION, null, msgs);
      msgs = basicSetComplexEventExpression(newComplexEventExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION, newComplexEventExpression, newComplexEventExpression));
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
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION:
        return basicSetComplexEventExpression(null, msgs);
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
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__PRIORITY:
        return getPriority();
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION:
        return getComplexEventExpression();
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
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__PRIORITY:
        setPriority((Integer)newValue);
        return;
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION:
        setComplexEventExpression((ComplexEventExpression)newValue);
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
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
        return;
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION:
        setComplexEventExpression((ComplexEventExpression)null);
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
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSION:
        return complexEventExpression != null;
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
    result.append(" (priority: ");
    result.append(priority);
    result.append(')');
    return result.toString();
  }

} //ComplexEventPatternImpl
