/**
 */
package hu.bme.mit.incquery.metamodels.internalsm.impl;

import hu.bme.mit.incquery.metamodels.internalsm.Guard;
import hu.bme.mit.incquery.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.metamodels.internalsm.State;
import hu.bme.mit.incquery.metamodels.internalsm.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.metamodels.internalsm.impl.TransitionImpl#getInStates <em>In States</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.metamodels.internalsm.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.metamodels.internalsm.impl.TransitionImpl#getOutStates <em>Out States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends EObjectImpl implements Transition {
	/**
	 * The cached value of the '{@link #getInStates() <em>In States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> inStates;

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
	 * The cached value of the '{@link #getOutStates() <em>Out States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> outStates;

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
	public EList<State> getInStates() {
		if (inStates == null) {
			inStates = new EObjectWithInverseResolvingEList.ManyInverse<State>(State.class, this, InternalsmPackage.TRANSITION__IN_STATES, InternalsmPackage.STATE__OUT_TRANSITIONS);
		}
		return inStates;
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
	public EList<State> getOutStates() {
		if (outStates == null) {
			outStates = new EObjectWithInverseResolvingEList.ManyInverse<State>(State.class, this, InternalsmPackage.TRANSITION__OUT_STATES, InternalsmPackage.STATE__IN_TRANSITIONS);
		}
		return outStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.TRANSITION__IN_STATES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInStates()).basicAdd(otherEnd, msgs);
			case InternalsmPackage.TRANSITION__OUT_STATES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutStates()).basicAdd(otherEnd, msgs);
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
			case InternalsmPackage.TRANSITION__IN_STATES:
				return ((InternalEList<?>)getInStates()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.TRANSITION__OUT_STATES:
				return ((InternalEList<?>)getOutStates()).basicRemove(otherEnd, msgs);
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
			case InternalsmPackage.TRANSITION__IN_STATES:
				return getInStates();
			case InternalsmPackage.TRANSITION__GUARD:
				if (resolve) return getGuard();
				return basicGetGuard();
			case InternalsmPackage.TRANSITION__OUT_STATES:
				return getOutStates();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InternalsmPackage.TRANSITION__IN_STATES:
				getInStates().clear();
				getInStates().addAll((Collection<? extends State>)newValue);
				return;
			case InternalsmPackage.TRANSITION__GUARD:
				setGuard((Guard)newValue);
				return;
			case InternalsmPackage.TRANSITION__OUT_STATES:
				getOutStates().clear();
				getOutStates().addAll((Collection<? extends State>)newValue);
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
			case InternalsmPackage.TRANSITION__IN_STATES:
				getInStates().clear();
				return;
			case InternalsmPackage.TRANSITION__GUARD:
				setGuard((Guard)null);
				return;
			case InternalsmPackage.TRANSITION__OUT_STATES:
				getOutStates().clear();
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
			case InternalsmPackage.TRANSITION__IN_STATES:
				return inStates != null && !inStates.isEmpty();
			case InternalsmPackage.TRANSITION__GUARD:
				return guard != null;
			case InternalsmPackage.TRANSITION__OUT_STATES:
				return outStates != null && !outStates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
