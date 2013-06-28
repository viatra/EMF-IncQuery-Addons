/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint;
import hu.bme.mit.incquery.cep.metamodels.internalsm.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getOutTransitions <em>Out Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getInTransitions <em>In Transitions</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getEventTokens <em>Event Tokens</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getTimeConstraints <em>Time Constraints</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getLastProcessedEvent <em>Last Processed Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends EObjectImpl implements State {
	/**
	 * The cached value of the '{@link #getOutTransitions() <em>Out Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outTransitions;

	/**
	 * The cached value of the '{@link #getInTransitions() <em>In Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> inTransitions;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEventTokens() <em>Event Tokens</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<EventToken> eventTokens;

	/**
	 * The cached value of the '{@link #getTimeConstraints() <em>Time Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConstraint> timeConstraints;

	/**
	 * The cached value of the '{@link #getLastProcessedEvent() <em>Last Processed Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastProcessedEvent()
	 * @generated
	 * @ordered
	 */
	protected Event lastProcessedEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutTransitions() {
		if (outTransitions == null) {
			outTransitions = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, InternalsmPackage.STATE__OUT_TRANSITIONS, InternalsmPackage.TRANSITION__PRE_STATE);
		}
		return outTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getInTransitions() {
		if (inTransitions == null) {
			inTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, InternalsmPackage.STATE__IN_TRANSITIONS, InternalsmPackage.TRANSITION__POST_STATE);
		}
		return inTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventToken> getEventTokens() {
		if (eventTokens == null) {
			eventTokens = new EObjectWithInverseResolvingEList<EventToken>(EventToken.class, this, InternalsmPackage.STATE__EVENT_TOKENS, InternalsmPackage.EVENT_TOKEN__CURRENT_STATE);
		}
		return eventTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConstraint> getTimeConstraints() {
		if (timeConstraints == null) {
			timeConstraints = new EObjectContainmentEList<TimeConstraint>(TimeConstraint.class, this, InternalsmPackage.STATE__TIME_CONSTRAINTS);
		}
		return timeConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getLastProcessedEvent() {
		if (lastProcessedEvent != null && lastProcessedEvent.eIsProxy()) {
			InternalEObject oldLastProcessedEvent = (InternalEObject)lastProcessedEvent;
			lastProcessedEvent = (Event)eResolveProxy(oldLastProcessedEvent);
			if (lastProcessedEvent != oldLastProcessedEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.STATE__LAST_PROCESSED_EVENT, oldLastProcessedEvent, lastProcessedEvent));
			}
		}
		return lastProcessedEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetLastProcessedEvent() {
		return lastProcessedEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastProcessedEvent(Event newLastProcessedEvent) {
		Event oldLastProcessedEvent = lastProcessedEvent;
		lastProcessedEvent = newLastProcessedEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE__LAST_PROCESSED_EVENT, oldLastProcessedEvent, lastProcessedEvent));
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
			case InternalsmPackage.STATE__OUT_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutTransitions()).basicAdd(otherEnd, msgs);
			case InternalsmPackage.STATE__IN_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInTransitions()).basicAdd(otherEnd, msgs);
			case InternalsmPackage.STATE__EVENT_TOKENS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEventTokens()).basicAdd(otherEnd, msgs);
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
			case InternalsmPackage.STATE__OUT_TRANSITIONS:
				return ((InternalEList<?>)getOutTransitions()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.STATE__IN_TRANSITIONS:
				return ((InternalEList<?>)getInTransitions()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.STATE__EVENT_TOKENS:
				return ((InternalEList<?>)getEventTokens()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.STATE__TIME_CONSTRAINTS:
				return ((InternalEList<?>)getTimeConstraints()).basicRemove(otherEnd, msgs);
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
			case InternalsmPackage.STATE__OUT_TRANSITIONS:
				return getOutTransitions();
			case InternalsmPackage.STATE__IN_TRANSITIONS:
				return getInTransitions();
			case InternalsmPackage.STATE__LABEL:
				return getLabel();
			case InternalsmPackage.STATE__EVENT_TOKENS:
				return getEventTokens();
			case InternalsmPackage.STATE__TIME_CONSTRAINTS:
				return getTimeConstraints();
			case InternalsmPackage.STATE__LAST_PROCESSED_EVENT:
				if (resolve) return getLastProcessedEvent();
				return basicGetLastProcessedEvent();
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
			case InternalsmPackage.STATE__OUT_TRANSITIONS:
				getOutTransitions().clear();
				getOutTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case InternalsmPackage.STATE__IN_TRANSITIONS:
				getInTransitions().clear();
				getInTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case InternalsmPackage.STATE__LABEL:
				setLabel((String)newValue);
				return;
			case InternalsmPackage.STATE__EVENT_TOKENS:
				getEventTokens().clear();
				getEventTokens().addAll((Collection<? extends EventToken>)newValue);
				return;
			case InternalsmPackage.STATE__TIME_CONSTRAINTS:
				getTimeConstraints().clear();
				getTimeConstraints().addAll((Collection<? extends TimeConstraint>)newValue);
				return;
			case InternalsmPackage.STATE__LAST_PROCESSED_EVENT:
				setLastProcessedEvent((Event)newValue);
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
			case InternalsmPackage.STATE__OUT_TRANSITIONS:
				getOutTransitions().clear();
				return;
			case InternalsmPackage.STATE__IN_TRANSITIONS:
				getInTransitions().clear();
				return;
			case InternalsmPackage.STATE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case InternalsmPackage.STATE__EVENT_TOKENS:
				getEventTokens().clear();
				return;
			case InternalsmPackage.STATE__TIME_CONSTRAINTS:
				getTimeConstraints().clear();
				return;
			case InternalsmPackage.STATE__LAST_PROCESSED_EVENT:
				setLastProcessedEvent((Event)null);
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
			case InternalsmPackage.STATE__OUT_TRANSITIONS:
				return outTransitions != null && !outTransitions.isEmpty();
			case InternalsmPackage.STATE__IN_TRANSITIONS:
				return inTransitions != null && !inTransitions.isEmpty();
			case InternalsmPackage.STATE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case InternalsmPackage.STATE__EVENT_TOKENS:
				return eventTokens != null && !eventTokens.isEmpty();
			case InternalsmPackage.STATE__TIME_CONSTRAINTS:
				return timeConstraints != null && !timeConstraints.isEmpty();
			case InternalsmPackage.STATE__LAST_PROCESSED_EVENT:
				return lastProcessedEvent != null;
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
		result.append(" (label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //StateImpl
