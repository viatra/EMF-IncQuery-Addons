/**
 */
package hu.bme.mit.incquery.vedl.edl.impl;

import hu.bme.mit.incquery.srct.srct.Source;

import hu.bme.mit.incquery.vedl.edl.Annotations;
import hu.bme.mit.incquery.vedl.edl.AtomicEvent;
import hu.bme.mit.incquery.vedl.edl.EdlPackage;
import hu.bme.mit.incquery.vedl.edl.ParameterFilter;

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
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.AtomicEventImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.AtomicEventImpl#getSource <em>Source</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.AtomicEventImpl#getId <em>Id</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.AtomicEventImpl#getParameterFilters <em>Parameter Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomicEventImpl extends AbstractAtomicEventImpl implements AtomicEvent
{
  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotations> annotations;

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
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

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
    return EdlPackage.Literals.ATOMIC_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotations> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotations>(Annotations.class, this, EdlPackage.ATOMIC_EVENT__ANNOTATIONS);
    }
    return annotations;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdlPackage.ATOMIC_EVENT__SOURCE, oldSource, source));
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
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.ATOMIC_EVENT__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.ATOMIC_EVENT__ID, oldId, id));
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
      parameterFilters = new EObjectContainmentEList<ParameterFilter>(ParameterFilter.class, this, EdlPackage.ATOMIC_EVENT__PARAMETER_FILTERS);
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
      case EdlPackage.ATOMIC_EVENT__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case EdlPackage.ATOMIC_EVENT__PARAMETER_FILTERS:
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
      case EdlPackage.ATOMIC_EVENT__ANNOTATIONS:
        return getAnnotations();
      case EdlPackage.ATOMIC_EVENT__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case EdlPackage.ATOMIC_EVENT__ID:
        return getId();
      case EdlPackage.ATOMIC_EVENT__PARAMETER_FILTERS:
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
      case EdlPackage.ATOMIC_EVENT__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotations>)newValue);
        return;
      case EdlPackage.ATOMIC_EVENT__SOURCE:
        setSource((Source)newValue);
        return;
      case EdlPackage.ATOMIC_EVENT__ID:
        setId((String)newValue);
        return;
      case EdlPackage.ATOMIC_EVENT__PARAMETER_FILTERS:
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
      case EdlPackage.ATOMIC_EVENT__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case EdlPackage.ATOMIC_EVENT__SOURCE:
        setSource((Source)null);
        return;
      case EdlPackage.ATOMIC_EVENT__ID:
        setId(ID_EDEFAULT);
        return;
      case EdlPackage.ATOMIC_EVENT__PARAMETER_FILTERS:
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
      case EdlPackage.ATOMIC_EVENT__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case EdlPackage.ATOMIC_EVENT__SOURCE:
        return source != null;
      case EdlPackage.ATOMIC_EVENT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case EdlPackage.ATOMIC_EVENT__PARAMETER_FILTERS:
        return parameterFilters != null && !parameterFilters.isEmpty();
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
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //AtomicEventImpl
