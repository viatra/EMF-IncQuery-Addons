/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression;

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
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsExpressionImpl#getFollowerExpressions <em>Follower Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FollowsExpressionImpl extends ExpressionImpl implements FollowsExpression
{
  /**
   * The cached value of the '{@link #getFollowerExpressions() <em>Follower Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFollowerExpressions()
   * @generated
   * @ordered
   */
  protected EList<FollowerExpression> followerExpressions;

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
    return EventPatternLanguagePackage.Literals.FOLLOWS_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FollowerExpression> getFollowerExpressions()
  {
    if (followerExpressions == null)
    {
      followerExpressions = new EObjectContainmentEList<FollowerExpression>(FollowerExpression.class, this, EventPatternLanguagePackage.FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS);
    }
    return followerExpressions;
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
      case EventPatternLanguagePackage.FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS:
        return ((InternalEList<?>)getFollowerExpressions()).basicRemove(otherEnd, msgs);
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
      case EventPatternLanguagePackage.FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS:
        return getFollowerExpressions();
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
      case EventPatternLanguagePackage.FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS:
        getFollowerExpressions().clear();
        getFollowerExpressions().addAll((Collection<? extends FollowerExpression>)newValue);
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
      case EventPatternLanguagePackage.FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS:
        getFollowerExpressions().clear();
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
      case EventPatternLanguagePackage.FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS:
        return followerExpressions != null && !followerExpressions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FollowsExpressionImpl
