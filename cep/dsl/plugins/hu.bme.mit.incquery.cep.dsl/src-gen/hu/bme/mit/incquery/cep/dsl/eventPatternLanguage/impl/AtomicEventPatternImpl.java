/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventPatternImpl#getSource <em>Source</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventPatternImpl#getStaticBindings <em>Static Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomicEventPatternImpl extends AbstractAtomicEventPatternImpl implements AtomicEventPattern
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
   * The cached value of the '{@link #getStaticBindings() <em>Static Bindings</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStaticBindings()
   * @generated
   * @ordered
   */
  protected XExpression staticBindings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AtomicEventPatternImpl()
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
    return EventPatternLanguagePackage.Literals.ATOMIC_EVENT_PATTERN;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__SOURCE, oldSource, source));
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
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getStaticBindings()
  {
    return staticBindings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStaticBindings(XExpression newStaticBindings, NotificationChain msgs)
  {
    XExpression oldStaticBindings = staticBindings;
    staticBindings = newStaticBindings;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS, oldStaticBindings, newStaticBindings);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStaticBindings(XExpression newStaticBindings)
  {
    if (newStaticBindings != staticBindings)
    {
      NotificationChain msgs = null;
      if (staticBindings != null)
        msgs = ((InternalEObject)staticBindings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS, null, msgs);
      if (newStaticBindings != null)
        msgs = ((InternalEObject)newStaticBindings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS, null, msgs);
      msgs = basicSetStaticBindings(newStaticBindings, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS, newStaticBindings, newStaticBindings));
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
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS:
        return basicSetStaticBindings(null, msgs);
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
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS:
        return getStaticBindings();
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
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__SOURCE:
        setSource((Source)newValue);
        return;
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS:
        setStaticBindings((XExpression)newValue);
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
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__SOURCE:
        setSource((Source)null);
        return;
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS:
        setStaticBindings((XExpression)null);
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
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__SOURCE:
        return source != null;
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN__STATIC_BINDINGS:
        return staticBindings != null;
    }
    return super.eIsSet(featureID);
  }

} //AtomicEventPatternImpl
