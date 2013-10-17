/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IQ Pattern Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventPatternImpl#getIqPatternRef <em>Iq Pattern Ref</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventPatternImpl#getIqChangeType <em>Iq Change Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IQPatternEventPatternImpl extends AbstractAtomicEventPatternImpl implements IQPatternEventPattern
{
  /**
   * The cached value of the '{@link #getIqPatternRef() <em>Iq Pattern Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIqPatternRef()
   * @generated
   * @ordered
   */
  protected ParametrizedIncQueryPatternReference iqPatternRef;

  /**
   * The default value of the '{@link #getIqChangeType() <em>Iq Change Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIqChangeType()
   * @generated
   * @ordered
   */
  protected static final IQPatternChangeType IQ_CHANGE_TYPE_EDEFAULT = IQPatternChangeType.NEW_MATCH_FOUND;

  /**
   * The cached value of the '{@link #getIqChangeType() <em>Iq Change Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIqChangeType()
   * @generated
   * @ordered
   */
  protected IQPatternChangeType iqChangeType = IQ_CHANGE_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IQPatternEventPatternImpl()
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
    return EventPatternLanguagePackage.Literals.IQ_PATTERN_EVENT_PATTERN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParametrizedIncQueryPatternReference getIqPatternRef()
  {
    return iqPatternRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIqPatternRef(ParametrizedIncQueryPatternReference newIqPatternRef, NotificationChain msgs)
  {
    ParametrizedIncQueryPatternReference oldIqPatternRef = iqPatternRef;
    iqPatternRef = newIqPatternRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF, oldIqPatternRef, newIqPatternRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIqPatternRef(ParametrizedIncQueryPatternReference newIqPatternRef)
  {
    if (newIqPatternRef != iqPatternRef)
    {
      NotificationChain msgs = null;
      if (iqPatternRef != null)
        msgs = ((InternalEObject)iqPatternRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF, null, msgs);
      if (newIqPatternRef != null)
        msgs = ((InternalEObject)newIqPatternRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF, null, msgs);
      msgs = basicSetIqPatternRef(newIqPatternRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF, newIqPatternRef, newIqPatternRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IQPatternChangeType getIqChangeType()
  {
    return iqChangeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIqChangeType(IQPatternChangeType newIqChangeType)
  {
    IQPatternChangeType oldIqChangeType = iqChangeType;
    iqChangeType = newIqChangeType == null ? IQ_CHANGE_TYPE_EDEFAULT : newIqChangeType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_CHANGE_TYPE, oldIqChangeType, iqChangeType));
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
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF:
        return basicSetIqPatternRef(null, msgs);
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
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF:
        return getIqPatternRef();
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_CHANGE_TYPE:
        return getIqChangeType();
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
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF:
        setIqPatternRef((ParametrizedIncQueryPatternReference)newValue);
        return;
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_CHANGE_TYPE:
        setIqChangeType((IQPatternChangeType)newValue);
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
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF:
        setIqPatternRef((ParametrizedIncQueryPatternReference)null);
        return;
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_CHANGE_TYPE:
        setIqChangeType(IQ_CHANGE_TYPE_EDEFAULT);
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
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF:
        return iqPatternRef != null;
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN__IQ_CHANGE_TYPE:
        return iqChangeType != IQ_CHANGE_TYPE_EDEFAULT;
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
    result.append(" (iqChangeType: ");
    result.append(iqChangeType);
    result.append(')');
    return result.toString();
  }

} //IQPatternEventPatternImpl
