/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl#getInState <em>In State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl#getOutState <em>Out State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends EObjectImpl implements Transition {
	/**
	 * The cached value of the '{@link #getInState() <em>In State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInState()
	 * @generated
	 * @ordered
	 */
	protected State inState;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected Guard guard;

	/**
	 * The cached value of the '{@link #getOutState() <em>Out State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutState()
	 * @generated
	 * @ordered
	 */
	protected State outState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getInState() {
		if (inState != null && inState.eIsProxy()) {
			InternalEObject oldInState = (InternalEObject)inState;
			inState = (State)eResolveProxy(oldInState);
			if (inState != oldInState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TRANSITION__IN_STATE, oldInState, inState));
			}
		}
		return inState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetInState() {
		return inState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInState(State newInState, NotificationChain msgs) {
		State oldInState = inState;
		inState = newInState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__IN_STATE, oldInState, newInState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInState(State newInState) {
		if (newInState != inState) {
			NotificationChain msgs = null;
			if (inState != null)
				msgs = ((InternalEObject)inState).eInverseRemove(this, InternalsmPackage.STATE__OUT_TRANSITIONS, State.class, msgs);
			if (newInState != null)
				msgs = ((InternalEObject)newInState).eInverseAdd(this, InternalsmPackage.STATE__OUT_TRANSITIONS, State.class, msgs);
			msgs = basicSetInState(newInState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__IN_STATE, newInState, newInState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guard getGuard() {
		if (guard != null && guard.eIsProxy()) {
			InternalEObject oldGuard = (InternalEObject)guard;
			guard = (Guard)eResolveProxy(oldGuard);
			if (guard != oldGuard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TRANSITION__GUARD, oldGuard, guard));
			}
		}
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guard basicGetGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(Guard newGuard) {
		Guard oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__GUARD, oldGuard, guard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getOutState() {
		if (outState != null && outState.eIsProxy()) {
			InternalEObject oldOutState = (InternalEObject)outState;
			outState = (State)eResolveProxy(oldOutState);
			if (outState != oldOutState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TRANSITION__OUT_STATE, oldOutState, outState));
			}
		}
		return outState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetOutState() {
		return outState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutState(State newOutState, NotificationChain msgs) {
		State oldOutState = outState;
		outState = newOutState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__OUT_STATE, oldOutState, newOutState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutState(State newOutState) {
		if (newOutState != outState) {
			NotificationChain msgs = null;
			if (outState != null)
				msgs = ((InternalEObject)outState).eInverseRemove(this, InternalsmPackage.STATE__IN_TRANSITIONS, State.class, msgs);
			if (newOutState != null)
				msgs = ((InternalEObject)newOutState).eInverseAdd(this, InternalsmPackage.STATE__IN_TRANSITIONS, State.class, msgs);
			msgs = basicSetOutState(newOutState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__OUT_STATE, newOutState, newOutState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.TRANSITION__IN_STATE:
				if (inState != null)
					msgs = ((InternalEObject)inState).eInverseRemove(this, InternalsmPackage.STATE__OUT_TRANSITIONS, State.class, msgs);
				return basicSetInState((State)otherEnd, msgs);
			case InternalsmPackage.TRANSITION__OUT_STATE:
				if (outState != null)
					msgs = ((InternalEObject)outState).eInverseRemove(this, InternalsmPackage.STATE__IN_TRANSITIONS, State.class, msgs);
				return basicSetOutState((State)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.TRANSITION__IN_STATE:
				return basicSetInState(null, msgs);
			case InternalsmPackage.TRANSITION__OUT_STATE:
				return basicSetOutState(null, msgs);
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
			case InternalsmPackage.TRANSITION__IN_STATE:
				if (resolve) return getInState();
				return basicGetInState();
			case InternalsmPackage.TRANSITION__GUARD:
				if (resolve) return getGuard();
				return basicGetGuard();
			case InternalsmPackage.TRANSITION__OUT_STATE:
				if (resolve) return getOutState();
				return basicGetOutState();
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
			case InternalsmPackage.TRANSITION__IN_STATE:
				setInState((State)newValue);
				return;
			case InternalsmPackage.TRANSITION__GUARD:
				setGuard((Guard)newValue);
				return;
			case InternalsmPackage.TRANSITION__OUT_STATE:
				setOutState((State)newValue);
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
			case InternalsmPackage.TRANSITION__IN_STATE:
				setInState((State)null);
				return;
			case InternalsmPackage.TRANSITION__GUARD:
				setGuard((Guard)null);
				return;
			case InternalsmPackage.TRANSITION__OUT_STATE:
				setOutState((State)null);
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
			case InternalsmPackage.TRANSITION__IN_STATE:
				return inState != null;
			case InternalsmPackage.TRANSITION__GUARD:
				return guard != null;
			case InternalsmPackage.TRANSITION__OUT_STATE:
				return outState != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
