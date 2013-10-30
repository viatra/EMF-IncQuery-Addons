/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametrized Inc Query Pattern Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParametrizedIncQueryPatternReferenceImpl#getIqpattern <em>Iqpattern</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParametrizedIncQueryPatternReferenceImpl#getParameterList <em>Parameter List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParametrizedIncQueryPatternReferenceImpl extends MinimalEObjectImpl.Container implements ParametrizedIncQueryPatternReference
{
  /**
   * The cached value of the '{@link #getIqpattern() <em>Iqpattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIqpattern()
   * @generated
   * @ordered
   */
  protected Pattern iqpattern;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParametrizedIncQueryPatternReferenceImpl()
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
    return EventPatternLanguagePackage.Literals.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern getIqpattern()
  {
    if (iqpattern != null && iqpattern.eIsProxy())
    {
      InternalEObject oldIqpattern = (InternalEObject)iqpattern;
      iqpattern = (Pattern)eResolveProxy(oldIqpattern);
      if (iqpattern != oldIqpattern)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN, oldIqpattern, iqpattern));
      }
    }
    return iqpattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern basicGetIqpattern()
  {
    return iqpattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIqpattern(Pattern newIqpattern)
  {
    Pattern oldIqpattern = iqpattern;
    iqpattern = newIqpattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN, oldIqpattern, iqpattern));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST, oldParameterList, newParameterList);
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
        msgs = ((InternalEObject)parameterList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST, null, msgs);
      if (newParameterList != null)
        msgs = ((InternalEObject)newParameterList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST, null, msgs);
      msgs = basicSetParameterList(newParameterList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST, newParameterList, newParameterList));
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
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST:
        return basicSetParameterList(null, msgs);
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
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN:
        if (resolve) return getIqpattern();
        return basicGetIqpattern();
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST:
        return getParameterList();
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
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN:
        setIqpattern((Pattern)newValue);
        return;
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST:
        setParameterList((PatternCallParameterList)newValue);
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
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN:
        setIqpattern((Pattern)null);
        return;
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST:
        setParameterList((PatternCallParameterList)null);
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
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN:
        return iqpattern != null;
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST:
        return parameterList != null;
    }
    return super.eIsSet(featureID);
  }

} //ParametrizedIncQueryPatternReferenceImpl
