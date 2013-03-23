/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep.impl;

import hu.bme.mit.incquery.cep.metamodels.cep.AbstractEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.cep.metamodels.cep.Event;

import hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmPackage;
import hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.AbstractEventPatternImpl#getCompositionEvents <em>Composition Events</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.AbstractEventPatternImpl#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractEventPatternImpl extends EObjectImpl implements AbstractEventPattern {
	/**
	 * The cached value of the '{@link #getCompositionEvents() <em>Composition Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractEventPattern> compositionEvents;

	/**
	 * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine> stateMachine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractEventPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CepPackage.Literals.ABSTRACT_EVENT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractEventPattern> getCompositionEvents() {
		if (compositionEvents == null) {
			compositionEvents = new EObjectContainmentEList<AbstractEventPattern>(AbstractEventPattern.class, this, CepPackage.ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS);
		}
		return compositionEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine> getStateMachine() {
		if (stateMachine == null) {
			stateMachine = new EObjectWithInverseResolvingEList<StateMachine>(StateMachine.class, this, CepPackage.ABSTRACT_EVENT_PATTERN__STATE_MACHINE, InternalsmPackage.STATE_MACHINE__EVENT_PATTERN);
		}
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean match(Event event) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRecognized() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case CepPackage.ABSTRACT_EVENT_PATTERN__STATE_MACHINE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStateMachine()).basicAdd(otherEnd, msgs);
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
			case CepPackage.ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS:
				return ((InternalEList<?>)getCompositionEvents()).basicRemove(otherEnd, msgs);
			case CepPackage.ABSTRACT_EVENT_PATTERN__STATE_MACHINE:
				return ((InternalEList<?>)getStateMachine()).basicRemove(otherEnd, msgs);
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
			case CepPackage.ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS:
				return getCompositionEvents();
			case CepPackage.ABSTRACT_EVENT_PATTERN__STATE_MACHINE:
				return getStateMachine();
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
			case CepPackage.ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS:
				getCompositionEvents().clear();
				getCompositionEvents().addAll((Collection<? extends AbstractEventPattern>)newValue);
				return;
			case CepPackage.ABSTRACT_EVENT_PATTERN__STATE_MACHINE:
				getStateMachine().clear();
				getStateMachine().addAll((Collection<? extends StateMachine>)newValue);
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
			case CepPackage.ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS:
				getCompositionEvents().clear();
				return;
			case CepPackage.ABSTRACT_EVENT_PATTERN__STATE_MACHINE:
				getStateMachine().clear();
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
			case CepPackage.ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS:
				return compositionEvents != null && !compositionEvents.isEmpty();
			case CepPackage.ABSTRACT_EVENT_PATTERN__STATE_MACHINE:
				return stateMachine != null && !stateMachine.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractEventPatternImpl
