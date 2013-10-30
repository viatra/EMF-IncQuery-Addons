/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBindingRule;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingImpl#getBindingRule <em>Binding Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StaticBindingImpl extends MinimalEObjectImpl.Container implements StaticBinding
{
  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected TypedParameter parameter;

  /**
   * The cached value of the '{@link #getBindingRule() <em>Binding Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBindingRule()
   * @generated
   * @ordered
   */
  protected StaticBindingRule bindingRule;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StaticBindingImpl()
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
    return EventPatternLanguagePackage.Literals.STATIC_BINDING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedParameter getParameter()
  {
    if (parameter != null && parameter.eIsProxy())
    {
      InternalEObject oldParameter = (InternalEObject)parameter;
      parameter = (TypedParameter)eResolveProxy(oldParameter);
      if (parameter != oldParameter)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventPatternLanguagePackage.STATIC_BINDING__PARAMETER, oldParameter, parameter));
      }
    }
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedParameter basicGetParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameter(TypedParameter newParameter)
  {
    TypedParameter oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.STATIC_BINDING__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StaticBindingRule getBindingRule()
  {
    return bindingRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBindingRule(StaticBindingRule newBindingRule, NotificationChain msgs)
  {
    StaticBindingRule oldBindingRule = bindingRule;
    bindingRule = newBindingRule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE, oldBindingRule, newBindingRule);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBindingRule(StaticBindingRule newBindingRule)
  {
    if (newBindingRule != bindingRule)
    {
      NotificationChain msgs = null;
      if (bindingRule != null)
        msgs = ((InternalEObject)bindingRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE, null, msgs);
      if (newBindingRule != null)
        msgs = ((InternalEObject)newBindingRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE, null, msgs);
      msgs = basicSetBindingRule(newBindingRule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE, newBindingRule, newBindingRule));
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
      case EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE:
        return basicSetBindingRule(null, msgs);
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
      case EventPatternLanguagePackage.STATIC_BINDING__PARAMETER:
        if (resolve) return getParameter();
        return basicGetParameter();
      case EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE:
        return getBindingRule();
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
      case EventPatternLanguagePackage.STATIC_BINDING__PARAMETER:
        setParameter((TypedParameter)newValue);
        return;
      case EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE:
        setBindingRule((StaticBindingRule)newValue);
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
      case EventPatternLanguagePackage.STATIC_BINDING__PARAMETER:
        setParameter((TypedParameter)null);
        return;
      case EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE:
        setBindingRule((StaticBindingRule)null);
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
      case EventPatternLanguagePackage.STATIC_BINDING__PARAMETER:
        return parameter != null;
      case EventPatternLanguagePackage.STATIC_BINDING__BINDING_RULE:
        return bindingRule != null;
    }
    return super.eIsSet(featureID);
  }

} //StaticBindingImpl
