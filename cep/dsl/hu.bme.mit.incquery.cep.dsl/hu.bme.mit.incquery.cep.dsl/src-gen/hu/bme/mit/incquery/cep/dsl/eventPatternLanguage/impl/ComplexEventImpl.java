/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.CEParamlist;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventImpl#getParamlist <em>Paramlist</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventImpl#getComplexEventExpressions <em>Complex Event Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexEventImpl extends EventImpl implements ComplexEvent
{
  /**
   * The cached value of the '{@link #getParamlist() <em>Paramlist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamlist()
   * @generated
   * @ordered
   */
  protected CEParamlist paramlist;

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
   * The cached value of the '{@link #getComplexEventExpressions() <em>Complex Event Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComplexEventExpressions()
   * @generated
   * @ordered
   */
  protected EList<ComplexEventExpression> complexEventExpressions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComplexEventImpl()
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
    return EventPatternLanguagePackage.Literals.COMPLEX_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CEParamlist getParamlist()
  {
    return paramlist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParamlist(CEParamlist newParamlist, NotificationChain msgs)
  {
    CEParamlist oldParamlist = paramlist;
    paramlist = newParamlist;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST, oldParamlist, newParamlist);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParamlist(CEParamlist newParamlist)
  {
    if (newParamlist != paramlist)
    {
      NotificationChain msgs = null;
      if (paramlist != null)
        msgs = ((InternalEObject)paramlist).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST, null, msgs);
      if (newParamlist != null)
        msgs = ((InternalEObject)newParamlist).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST, null, msgs);
      msgs = basicSetParamlist(newParamlist, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST, newParamlist, newParamlist));
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
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.COMPLEX_EVENT__PRIORITY, oldPriority, priority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComplexEventExpression> getComplexEventExpressions()
  {
    if (complexEventExpressions == null)
    {
      complexEventExpressions = new EObjectContainmentEList<ComplexEventExpression>(ComplexEventExpression.class, this, EventPatternLanguagePackage.COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS);
    }
    return complexEventExpressions;
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
      case EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST:
        return basicSetParamlist(null, msgs);
      case EventPatternLanguagePackage.COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS:
        return ((InternalEList<?>)getComplexEventExpressions()).basicRemove(otherEnd, msgs);
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
      case EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST:
        return getParamlist();
      case EventPatternLanguagePackage.COMPLEX_EVENT__PRIORITY:
        return getPriority();
      case EventPatternLanguagePackage.COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS:
        return getComplexEventExpressions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST:
        setParamlist((CEParamlist)newValue);
        return;
      case EventPatternLanguagePackage.COMPLEX_EVENT__PRIORITY:
        setPriority((Integer)newValue);
        return;
      case EventPatternLanguagePackage.COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS:
        getComplexEventExpressions().clear();
        getComplexEventExpressions().addAll((Collection<? extends ComplexEventExpression>)newValue);
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
      case EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST:
        setParamlist((CEParamlist)null);
        return;
      case EventPatternLanguagePackage.COMPLEX_EVENT__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
        return;
      case EventPatternLanguagePackage.COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS:
        getComplexEventExpressions().clear();
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
      case EventPatternLanguagePackage.COMPLEX_EVENT__PARAMLIST:
        return paramlist != null;
      case EventPatternLanguagePackage.COMPLEX_EVENT__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
      case EventPatternLanguagePackage.COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS:
        return complexEventExpressions != null && !complexEventExpressions.isEmpty();
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

} //ComplexEventImpl
