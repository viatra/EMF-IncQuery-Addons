/**
 */
package hu.bme.mit.incquery.cep.model.cep.impl;

import hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern;
import hu.bme.mit.incquery.cep.model.cep.CepPackage;
import hu.bme.mit.incquery.cep.model.cep.Event;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.model.cep.impl.AbstractEventPatternImpl#getCompositionEvents <em>Composition Events</em>}</li>
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CepPackage.ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS:
				return ((InternalEList<?>)getCompositionEvents()).basicRemove(otherEnd, msgs);
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
		}
		return super.eIsSet(featureID);
	}

} //AbstractEventPatternImpl
