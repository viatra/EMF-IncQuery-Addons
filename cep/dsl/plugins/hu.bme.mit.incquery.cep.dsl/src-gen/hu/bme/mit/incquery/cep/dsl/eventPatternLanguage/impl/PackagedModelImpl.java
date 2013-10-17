/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Packaged Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PackagedModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PackagedModelImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PackagedModelImpl#getModelElements <em>Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackagedModelImpl extends MinimalEObjectImpl.Container implements PackagedModel
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getUsages() <em>Usages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsages()
   * @generated
   * @ordered
   */
  protected EList<Usage> usages;

  /**
   * The cached value of the '{@link #getModelElements() <em>Model Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelElements()
   * @generated
   * @ordered
   */
  protected EList<ModelElement> modelElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackagedModelImpl()
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
    return EventPatternLanguagePackage.Literals.PACKAGED_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EventPatternLanguagePackage.PACKAGED_MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Usage> getUsages()
  {
    if (usages == null)
    {
      usages = new EObjectContainmentEList<Usage>(Usage.class, this, EventPatternLanguagePackage.PACKAGED_MODEL__USAGES);
    }
    return usages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModelElement> getModelElements()
  {
    if (modelElements == null)
    {
      modelElements = new EObjectContainmentEList<ModelElement>(ModelElement.class, this, EventPatternLanguagePackage.PACKAGED_MODEL__MODEL_ELEMENTS);
    }
    return modelElements;
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
      case EventPatternLanguagePackage.PACKAGED_MODEL__USAGES:
        return ((InternalEList<?>)getUsages()).basicRemove(otherEnd, msgs);
      case EventPatternLanguagePackage.PACKAGED_MODEL__MODEL_ELEMENTS:
        return ((InternalEList<?>)getModelElements()).basicRemove(otherEnd, msgs);
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
      case EventPatternLanguagePackage.PACKAGED_MODEL__NAME:
        return getName();
      case EventPatternLanguagePackage.PACKAGED_MODEL__USAGES:
        return getUsages();
      case EventPatternLanguagePackage.PACKAGED_MODEL__MODEL_ELEMENTS:
        return getModelElements();
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
      case EventPatternLanguagePackage.PACKAGED_MODEL__NAME:
        setName((String)newValue);
        return;
      case EventPatternLanguagePackage.PACKAGED_MODEL__USAGES:
        getUsages().clear();
        getUsages().addAll((Collection<? extends Usage>)newValue);
        return;
      case EventPatternLanguagePackage.PACKAGED_MODEL__MODEL_ELEMENTS:
        getModelElements().clear();
        getModelElements().addAll((Collection<? extends ModelElement>)newValue);
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
      case EventPatternLanguagePackage.PACKAGED_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EventPatternLanguagePackage.PACKAGED_MODEL__USAGES:
        getUsages().clear();
        return;
      case EventPatternLanguagePackage.PACKAGED_MODEL__MODEL_ELEMENTS:
        getModelElements().clear();
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
      case EventPatternLanguagePackage.PACKAGED_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EventPatternLanguagePackage.PACKAGED_MODEL__USAGES:
        return usages != null && !usages.isEmpty();
      case EventPatternLanguagePackage.PACKAGED_MODEL__MODEL_ELEMENTS:
        return modelElements != null && !modelElements.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PackagedModelImpl
