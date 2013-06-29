/**
 */
package hu.bme.mit.incquery.vedl.edl.impl;

import hu.bme.mit.incquery.vedl.edl.EdlPackage;
import hu.bme.mit.incquery.vedl.edl.EventWithFollowsOperator;
import hu.bme.mit.incquery.vedl.edl.EventWithMultiplicity;
import hu.bme.mit.incquery.vedl.edl.FollowsExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Follows Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.FollowsExpressionImpl#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.FollowsExpressionImpl#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FollowsExpressionImpl extends ComplexEventExpressionImpl implements FollowsExpression
{
  /**
   * The cached value of the '{@link #getFirstEvent() <em>First Event</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstEvent()
   * @generated
   * @ordered
   */
  protected EList<EventWithMultiplicity> firstEvent;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<EventWithFollowsOperator> events;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FollowsExpressionImpl()
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
    return EdlPackage.Literals.FOLLOWS_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EventWithMultiplicity> getFirstEvent()
  {
    if (firstEvent == null)
    {
      firstEvent = new EObjectContainmentEList<EventWithMultiplicity>(EventWithMultiplicity.class, this, EdlPackage.FOLLOWS_EXPRESSION__FIRST_EVENT);
    }
    return firstEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EventWithFollowsOperator> getEvents()
  {
    if (events == null)
    {
      events = new EObjectContainmentEList<EventWithFollowsOperator>(EventWithFollowsOperator.class, this, EdlPackage.FOLLOWS_EXPRESSION__EVENTS);
    }
    return events;
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
      case EdlPackage.FOLLOWS_EXPRESSION__FIRST_EVENT:
        return ((InternalEList<?>)getFirstEvent()).basicRemove(otherEnd, msgs);
      case EdlPackage.FOLLOWS_EXPRESSION__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
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
      case EdlPackage.FOLLOWS_EXPRESSION__FIRST_EVENT:
        return getFirstEvent();
      case EdlPackage.FOLLOWS_EXPRESSION__EVENTS:
        return getEvents();
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
      case EdlPackage.FOLLOWS_EXPRESSION__FIRST_EVENT:
        getFirstEvent().clear();
        getFirstEvent().addAll((Collection<? extends EventWithMultiplicity>)newValue);
        return;
      case EdlPackage.FOLLOWS_EXPRESSION__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends EventWithFollowsOperator>)newValue);
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
      case EdlPackage.FOLLOWS_EXPRESSION__FIRST_EVENT:
        getFirstEvent().clear();
        return;
      case EdlPackage.FOLLOWS_EXPRESSION__EVENTS:
        getEvents().clear();
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
      case EdlPackage.FOLLOWS_EXPRESSION__FIRST_EVENT:
        return firstEvent != null && !firstEvent.isEmpty();
      case EdlPackage.FOLLOWS_EXPRESSION__EVENTS:
        return events != null && !events.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FollowsExpressionImpl
