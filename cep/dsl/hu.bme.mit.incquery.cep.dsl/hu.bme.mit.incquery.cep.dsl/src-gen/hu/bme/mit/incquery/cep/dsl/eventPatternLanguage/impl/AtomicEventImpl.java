/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source;

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
 * An implementation of the model object '<em><b>Atomic Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventImpl#getSource <em>Source</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventImpl#getParameterFilters <em>Parameter Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomicEventImpl extends AbstractAtomicEventImpl implements AtomicEvent
{
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected Source source;

  /**
   * The cached value of the '{@link #getParameterFilters() <em>Parameter Filters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterFilters()
   * @generated
   * @ordered
   */
  protected EList<ParameterFilter> parameterFilters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AtomicEventImpl()
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
    return EventPatternLanguagePackage.Literals.ATOMIC_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Source getSource()
  {
    if (source != null && source.eIsProxy())
    {
      InternalEObject oldSource = (InternalEObject)source;
      source = (Source)eResolveProxy(oldSource);
      if (source != oldSource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventPatternLanguagePackage.ATOMIC_EVENT__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Source basicGetSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(Source newSource)
  {
    Source oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.ATOMIC_EVENT__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterFilter> getParameterFilters()
  {
    if (parameterFilters == null)
    {
      parameterFilters = new EObjectContainmentEList<ParameterFilter>(ParameterFilter.class, this, EventPatternLanguagePackage.ATOMIC_EVENT__PARAMETER_FILTERS);
    }
    return parameterFilters;
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
      case EventPatternLanguagePackage.ATOMIC_EVENT__PARAMETER_FILTERS:
        return ((InternalEList<?>)getParameterFilters()).basicRemove(otherEnd, msgs);
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
      case EventPatternLanguagePackage.ATOMIC_EVENT__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case EventPatternLanguagePackage.ATOMIC_EVENT__PARAMETER_FILTERS:
        return getParameterFilters();
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
      case EventPatternLanguagePackage.ATOMIC_EVENT__SOURCE:
        setSource((Source)newValue);
        return;
      case EventPatternLanguagePackage.ATOMIC_EVENT__PARAMETER_FILTERS:
        getParameterFilters().clear();
        getParameterFilters().addAll((Collection<? extends ParameterFilter>)newValue);
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
      case EventPatternLanguagePackage.ATOMIC_EVENT__SOURCE:
        setSource((Source)null);
        return;
      case EventPatternLanguagePackage.ATOMIC_EVENT__PARAMETER_FILTERS:
        getParameterFilters().clear();
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
      case EventPatternLanguagePackage.ATOMIC_EVENT__SOURCE:
        return source != null;
      case EventPatternLanguagePackage.ATOMIC_EVENT__PARAMETER_FILTERS:
        return parameterFilters != null && !parameterFilters.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AtomicEventImpl
