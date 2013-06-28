/**
 */
package hu.bme.mit.incquery.vedl.edl.impl;

import hu.bme.mit.incquery.vedl.edl.EdlPackage;
import hu.bme.mit.incquery.vedl.edl.LiteralFilter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.LiteralFilterImpl#getNeg <em>Neg</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.LiteralFilterImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.vedl.edl.impl.LiteralFilterImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiteralFilterImpl extends ParameterFilterRuleImpl implements LiteralFilter
{
  /**
   * The default value of the '{@link #getNeg() <em>Neg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNeg()
   * @generated
   * @ordered
   */
  protected static final String NEG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNeg() <em>Neg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNeg()
   * @generated
   * @ordered
   */
  protected String neg = NEG_EDEFAULT;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final String OPERATOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected String operator = OPERATOR_EDEFAULT;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LiteralFilterImpl()
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
    return EdlPackage.Literals.LITERAL_FILTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNeg()
  {
    return neg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNeg(String newNeg)
  {
    String oldNeg = neg;
    neg = newNeg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.LITERAL_FILTER__NEG, oldNeg, neg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(String newOperator)
  {
    String oldOperator = operator;
    operator = newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.LITERAL_FILTER__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EdlPackage.LITERAL_FILTER__VALUE, oldValue, value));
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
      case EdlPackage.LITERAL_FILTER__NEG:
        return getNeg();
      case EdlPackage.LITERAL_FILTER__OPERATOR:
        return getOperator();
      case EdlPackage.LITERAL_FILTER__VALUE:
        return getValue();
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
      case EdlPackage.LITERAL_FILTER__NEG:
        setNeg((String)newValue);
        return;
      case EdlPackage.LITERAL_FILTER__OPERATOR:
        setOperator((String)newValue);
        return;
      case EdlPackage.LITERAL_FILTER__VALUE:
        setValue((String)newValue);
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
      case EdlPackage.LITERAL_FILTER__NEG:
        setNeg(NEG_EDEFAULT);
        return;
      case EdlPackage.LITERAL_FILTER__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case EdlPackage.LITERAL_FILTER__VALUE:
        setValue(VALUE_EDEFAULT);
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
      case EdlPackage.LITERAL_FILTER__NEG:
        return NEG_EDEFAULT == null ? neg != null : !NEG_EDEFAULT.equals(neg);
      case EdlPackage.LITERAL_FILTER__OPERATOR:
        return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
      case EdlPackage.LITERAL_FILTER__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
    result.append(" (neg: ");
    result.append(neg);
    result.append(", operator: ");
    result.append(operator);
    result.append(", value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //LiteralFilterImpl
