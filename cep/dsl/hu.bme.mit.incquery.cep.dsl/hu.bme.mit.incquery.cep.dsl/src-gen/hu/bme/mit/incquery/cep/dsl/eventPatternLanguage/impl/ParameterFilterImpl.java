/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilterRule;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterImpl#getParamFilterRule <em>Param Filter Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterFilterImpl extends MinimalEObjectImpl.Container implements ParameterFilter
{
  /**
   * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeName()
   * @generated
   * @ordered
   */
  protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeName()
   * @generated
   * @ordered
   */
  protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getParamFilterRule() <em>Param Filter Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamFilterRule()
   * @generated
   * @ordered
   */
  protected ParameterFilterRule paramFilterRule;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterFilterImpl()
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
    return EventPatternLanguagePackage.Literals.PARAMETER_FILTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAttributeName()
  {
    return attributeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttributeName(String newAttributeName)
  {
    String oldAttributeName = attributeName;
    attributeName = newAttributeName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.PARAMETER_FILTER__ATTRIBUTE_NAME, oldAttributeName, attributeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterFilterRule getParamFilterRule()
  {
    return paramFilterRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParamFilterRule(ParameterFilterRule newParamFilterRule, NotificationChain msgs)
  {
    ParameterFilterRule oldParamFilterRule = paramFilterRule;
    paramFilterRule = newParamFilterRule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE, oldParamFilterRule, newParamFilterRule);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParamFilterRule(ParameterFilterRule newParamFilterRule)
  {
    if (newParamFilterRule != paramFilterRule)
    {
      NotificationChain msgs = null;
      if (paramFilterRule != null)
        msgs = ((InternalEObject)paramFilterRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE, null, msgs);
      if (newParamFilterRule != null)
        msgs = ((InternalEObject)newParamFilterRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE, null, msgs);
      msgs = basicSetParamFilterRule(newParamFilterRule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE, newParamFilterRule, newParamFilterRule));
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
      case EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE:
        return basicSetParamFilterRule(null, msgs);
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
      case EventPatternLanguagePackage.PARAMETER_FILTER__ATTRIBUTE_NAME:
        return getAttributeName();
      case EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE:
        return getParamFilterRule();
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
      case EventPatternLanguagePackage.PARAMETER_FILTER__ATTRIBUTE_NAME:
        setAttributeName((String)newValue);
        return;
      case EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE:
        setParamFilterRule((ParameterFilterRule)newValue);
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
      case EventPatternLanguagePackage.PARAMETER_FILTER__ATTRIBUTE_NAME:
        setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
        return;
      case EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE:
        setParamFilterRule((ParameterFilterRule)null);
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
      case EventPatternLanguagePackage.PARAMETER_FILTER__ATTRIBUTE_NAME:
        return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
      case EventPatternLanguagePackage.PARAMETER_FILTER__PARAM_FILTER_RULE:
        return paramFilterRule != null;
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
    result.append(" (attributeName: ");
    result.append(attributeName);
    result.append(')');
    return result.toString();
  }

} //ParameterFilterImpl
