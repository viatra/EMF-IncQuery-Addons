/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern;

import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.GuardImpl#getTimeConstraint <em>Time Constraint</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.GuardImpl#getEventType <em>Event Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardImpl extends EObjectImpl implements Guard {
	/**
	 * The cached value of the '{@link #getTimeConstraint() <em>Time Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeConstraint()
	 * @generated
	 * @ordered
	 */
	protected TimeConstraint timeConstraint;

	/**
	 * The cached value of the '{@link #getEventType() <em>Event Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected AtomicEventPattern eventType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.GUARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConstraint getTimeConstraint() {
		return timeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeConstraint(TimeConstraint newTimeConstraint, NotificationChain msgs) {
		TimeConstraint oldTimeConstraint = timeConstraint;
		timeConstraint = newTimeConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.GUARD__TIME_CONSTRAINT, oldTimeConstraint, newTimeConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeConstraint(TimeConstraint newTimeConstraint) {
		if (newTimeConstraint != timeConstraint) {
			NotificationChain msgs = null;
			if (timeConstraint != null)
				msgs = ((InternalEObject)timeConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InternalsmPackage.GUARD__TIME_CONSTRAINT, null, msgs);
			if (newTimeConstraint != null)
				msgs = ((InternalEObject)newTimeConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InternalsmPackage.GUARD__TIME_CONSTRAINT, null, msgs);
			msgs = basicSetTimeConstraint(newTimeConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.GUARD__TIME_CONSTRAINT, newTimeConstraint, newTimeConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicEventPattern getEventType() {
		if (eventType != null && eventType.eIsProxy()) {
			InternalEObject oldEventType = (InternalEObject)eventType;
			eventType = (AtomicEventPattern)eResolveProxy(oldEventType);
			if (eventType != oldEventType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.GUARD__EVENT_TYPE, oldEventType, eventType));
			}
		}
		return eventType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicEventPattern basicGetEventType() {
		return eventType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventType(AtomicEventPattern newEventType) {
		AtomicEventPattern oldEventType = eventType;
		eventType = newEventType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.GUARD__EVENT_TYPE, oldEventType, eventType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.GUARD__TIME_CONSTRAINT:
				return basicSetTimeConstraint(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InternalsmPackage.GUARD__TIME_CONSTRAINT:
				return getTimeConstraint();
			case InternalsmPackage.GUARD__EVENT_TYPE:
				if (resolve) return getEventType();
				return basicGetEventType();
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
			case InternalsmPackage.GUARD__TIME_CONSTRAINT:
				setTimeConstraint((TimeConstraint)newValue);
				return;
			case InternalsmPackage.GUARD__EVENT_TYPE:
				setEventType((AtomicEventPattern)newValue);
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
			case InternalsmPackage.GUARD__TIME_CONSTRAINT:
				setTimeConstraint((TimeConstraint)null);
				return;
			case InternalsmPackage.GUARD__EVENT_TYPE:
				setEventType((AtomicEventPattern)null);
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
			case InternalsmPackage.GUARD__TIME_CONSTRAINT:
				return timeConstraint != null;
			case InternalsmPackage.GUARD__EVENT_TYPE:
				return eventType != null;
		}
		return super.eIsSet(featureID);
	}

} //GuardImpl
