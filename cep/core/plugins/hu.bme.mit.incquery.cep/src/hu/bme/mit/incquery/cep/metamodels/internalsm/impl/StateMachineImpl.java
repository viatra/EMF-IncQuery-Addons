/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;
import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.State;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl#getStates <em>States</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl#getEventPattern <em>Event Pattern</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMachineImpl extends EObjectImpl implements StateMachine {
	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getEventPattern() <em>Event Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventPattern()
	 * @generated
	 * @ordered
	 */
	protected EventPattern eventPattern;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final EventProcessingContext CONTEXT_EDEFAULT = EventProcessingContext.CHRONICLE;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EventProcessingContext context = CONTEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InternalsmPackage.Literals.STATE_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, InternalsmPackage.STATE_MACHINE__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern getEventPattern() {
		if (eventPattern != null && eventPattern.eIsProxy()) {
			InternalEObject oldEventPattern = (InternalEObject)eventPattern;
			eventPattern = (EventPattern)eResolveProxy(oldEventPattern);
			if (eventPattern != oldEventPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, oldEventPattern, eventPattern));
			}
		}
		return eventPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPattern basicGetEventPattern() {
		return eventPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventPattern(EventPattern newEventPattern, NotificationChain msgs) {
		EventPattern oldEventPattern = eventPattern;
		eventPattern = newEventPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, oldEventPattern, newEventPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventPattern(EventPattern newEventPattern) {
		if (newEventPattern != eventPattern) {
			NotificationChain msgs = null;
			if (eventPattern != null)
				msgs = ((InternalEObject)eventPattern).eInverseRemove(this, CepPackage.EVENT_PATTERN__STATE_MACHINE, EventPattern.class, msgs);
			if (newEventPattern != null)
				msgs = ((InternalEObject)newEventPattern).eInverseAdd(this, CepPackage.EVENT_PATTERN__STATE_MACHINE, EventPattern.class, msgs);
			msgs = basicSetEventPattern(newEventPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN, newEventPattern, newEventPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE_MACHINE__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventProcessingContext getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(EventProcessingContext newContext) {
		EventProcessingContext oldContext = context;
		context = newContext == null ? CONTEXT_EDEFAULT : newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE_MACHINE__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				if (eventPattern != null)
					msgs = ((InternalEObject)eventPattern).eInverseRemove(this, CepPackage.EVENT_PATTERN__STATE_MACHINE, EventPattern.class, msgs);
				return basicSetEventPattern((EventPattern)otherEnd, msgs);
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				return basicSetEventPattern(null, msgs);
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				return getStates();
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				if (resolve) return getEventPattern();
				return basicGetEventPattern();
			case InternalsmPackage.STATE_MACHINE__PRIORITY:
				return getPriority();
			case InternalsmPackage.STATE_MACHINE__CONTEXT:
				return getContext();
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				setEventPattern((EventPattern)newValue);
				return;
			case InternalsmPackage.STATE_MACHINE__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case InternalsmPackage.STATE_MACHINE__CONTEXT:
				setContext((EventProcessingContext)newValue);
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				getStates().clear();
				return;
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				setEventPattern((EventPattern)null);
				return;
			case InternalsmPackage.STATE_MACHINE__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case InternalsmPackage.STATE_MACHINE__CONTEXT:
				setContext(CONTEXT_EDEFAULT);
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
			case InternalsmPackage.STATE_MACHINE__STATES:
				return states != null && !states.isEmpty();
			case InternalsmPackage.STATE_MACHINE__EVENT_PATTERN:
				return eventPattern != null;
			case InternalsmPackage.STATE_MACHINE__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case InternalsmPackage.STATE_MACHINE__CONTEXT:
				return context != CONTEXT_EDEFAULT;
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
		result.append(" (priority: ");
		result.append(priority);
		result.append(", context: ");
		result.append(context);
		result.append(')');
		return result.toString();
	}

} //StateMachineImpl
