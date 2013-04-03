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
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl#getPreState <em>Pre State</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl#getPostState <em>Post State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends EObjectImpl implements Transition {
	/**
	 * The cached value of the '{@link #getPreState() <em>Pre State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreState()
	 * @generated
	 * @ordered
	 */
	protected State preState;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected Guard guard;

	/**
	 * The cached value of the '{@link #getPostState() <em>Post State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostState()
	 * @generated
	 * @ordered
	 */
	protected State postState;

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
	public State getPreState() {
		if (preState != null && preState.eIsProxy()) {
			InternalEObject oldPreState = (InternalEObject)preState;
			preState = (State)eResolveProxy(oldPreState);
			if (preState != oldPreState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TRANSITION__PRE_STATE, oldPreState, preState));
			}
		}
		return preState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetPreState() {
		return preState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreState(State newPreState, NotificationChain msgs) {
		State oldPreState = preState;
		preState = newPreState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__PRE_STATE, oldPreState, newPreState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreState(State newPreState) {
		if (newPreState != preState) {
			NotificationChain msgs = null;
			if (preState != null)
				msgs = ((InternalEObject)preState).eInverseRemove(this, InternalsmPackage.STATE__OUT_TRANSITIONS, State.class, msgs);
			if (newPreState != null)
				msgs = ((InternalEObject)newPreState).eInverseAdd(this, InternalsmPackage.STATE__OUT_TRANSITIONS, State.class, msgs);
			msgs = basicSetPreState(newPreState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__PRE_STATE, newPreState, newPreState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guard getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuard(Guard newGuard, NotificationChain msgs) {
		Guard oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__GUARD, oldGuard, newGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(Guard newGuard) {
		if (newGuard != guard) {
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InternalsmPackage.TRANSITION__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InternalsmPackage.TRANSITION__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getPostState() {
		if (postState != null && postState.eIsProxy()) {
			InternalEObject oldPostState = (InternalEObject)postState;
			postState = (State)eResolveProxy(oldPostState);
			if (postState != oldPostState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.TRANSITION__POST_STATE, oldPostState, postState));
			}
		}
		return postState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetPostState() {
		return postState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostState(State newPostState, NotificationChain msgs) {
		State oldPostState = postState;
		postState = newPostState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__POST_STATE, oldPostState, newPostState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostState(State newPostState) {
		if (newPostState != postState) {
			NotificationChain msgs = null;
			if (postState != null)
				msgs = ((InternalEObject)postState).eInverseRemove(this, InternalsmPackage.STATE__IN_TRANSITIONS, State.class, msgs);
			if (newPostState != null)
				msgs = ((InternalEObject)newPostState).eInverseAdd(this, InternalsmPackage.STATE__IN_TRANSITIONS, State.class, msgs);
			msgs = basicSetPostState(newPostState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.TRANSITION__POST_STATE, newPostState, newPostState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.TRANSITION__PRE_STATE:
				if (preState != null)
					msgs = ((InternalEObject)preState).eInverseRemove(this, InternalsmPackage.STATE__OUT_TRANSITIONS, State.class, msgs);
				return basicSetPreState((State)otherEnd, msgs);
			case InternalsmPackage.TRANSITION__POST_STATE:
				if (postState != null)
					msgs = ((InternalEObject)postState).eInverseRemove(this, InternalsmPackage.STATE__IN_TRANSITIONS, State.class, msgs);
				return basicSetPostState((State)otherEnd, msgs);
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
			case InternalsmPackage.TRANSITION__PRE_STATE:
				return basicSetPreState(null, msgs);
			case InternalsmPackage.TRANSITION__GUARD:
				return basicSetGuard(null, msgs);
			case InternalsmPackage.TRANSITION__POST_STATE:
				return basicSetPostState(null, msgs);
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
			case InternalsmPackage.TRANSITION__PRE_STATE:
				if (resolve) return getPreState();
				return basicGetPreState();
			case InternalsmPackage.TRANSITION__GUARD:
				return getGuard();
			case InternalsmPackage.TRANSITION__POST_STATE:
				if (resolve) return getPostState();
				return basicGetPostState();
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
			case InternalsmPackage.TRANSITION__PRE_STATE:
				setPreState((State)newValue);
				return;
			case InternalsmPackage.TRANSITION__GUARD:
				setGuard((Guard)newValue);
				return;
			case InternalsmPackage.TRANSITION__POST_STATE:
				setPostState((State)newValue);
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
			case InternalsmPackage.TRANSITION__PRE_STATE:
				setPreState((State)null);
				return;
			case InternalsmPackage.TRANSITION__GUARD:
				setGuard((Guard)null);
				return;
			case InternalsmPackage.TRANSITION__POST_STATE:
				setPostState((State)null);
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
			case InternalsmPackage.TRANSITION__PRE_STATE:
				return preState != null;
			case InternalsmPackage.TRANSITION__GUARD:
				return guard != null;
			case InternalsmPackage.TRANSITION__POST_STATE:
				return postState != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
