/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getTimeConstraintSpecification <em>Time Constraint Specification</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeConstraintImpl extends EObjectImpl implements TimeConstraint {
	/**
	 * The cached value of the '{@link #getTimeConstraintSpecification() <em>Time Constraint Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeConstraintSpecification()
	 * @generated
	 * @ordered
	 */
	protected TimeConstraintSpecification timeConstraintSpecification;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TimeConstraintType TYPE_EDEFAULT = TimeConstraintType.START;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TimeConstraintType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.TIME_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConstraintType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TimeConstraintType newType) {
		TimeConstraintType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConstraintSpecification getTimeConstraintSpecification() {
		if (timeConstraintSpecification != null && timeConstraintSpecification.eIsProxy()) {
			InternalEObject oldTimeConstraintSpecification = (InternalEObject)timeConstraintSpecification;
			timeConstraintSpecification = (TimeConstraintSpecification)eResolveProxy(oldTimeConstraintSpecification);
			if (timeConstraintSpecification != oldTimeConstraintSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION, oldTimeConstraintSpecification, timeConstraintSpecification));
			}
		}
		return timeConstraintSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConstraintSpecification basicGetTimeConstraintSpecification() {
		return timeConstraintSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeConstraintSpecification(TimeConstraintSpecification newTimeConstraintSpecification) {
		TimeConstraintSpecification oldTimeConstraintSpecification = timeConstraintSpecification;
		timeConstraintSpecification = newTimeConstraintSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION, oldTimeConstraintSpecification, timeConstraintSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InternalsmPackage.TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION:
				if (resolve) return getTimeConstraintSpecification();
				return basicGetTimeConstraintSpecification();
			case InternalsmPackage.TIME_CONSTRAINT__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InternalsmPackage.TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION:
				setTimeConstraintSpecification((TimeConstraintSpecification)newValue);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__TYPE:
				setType((TimeConstraintType)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case InternalsmPackage.TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION:
				setTimeConstraintSpecification((TimeConstraintSpecification)null);
				return;
			case InternalsmPackage.TIME_CONSTRAINT__TYPE:
				setType(TYPE_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InternalsmPackage.TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION:
				return timeConstraintSpecification != null;
			case InternalsmPackage.TIME_CONSTRAINT__TYPE:
				return type != TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //TimeConstraintImpl
