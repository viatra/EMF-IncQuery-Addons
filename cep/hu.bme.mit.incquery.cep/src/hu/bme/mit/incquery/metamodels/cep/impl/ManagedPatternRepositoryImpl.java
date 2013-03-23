/**
 */
package hu.bme.mit.incquery.metamodels.cep.impl;

import hu.bme.mit.incquery.metamodels.cep.AbstractEventPattern;
import hu.bme.mit.incquery.metamodels.cep.CepPackage;
import hu.bme.mit.incquery.metamodels.cep.ManagedPatternRepository;

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
 * An implementation of the model object '<em><b>Managed Pattern Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.metamodels.cep.impl.ManagedPatternRepositoryImpl#getEventPatterns <em>Event Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManagedPatternRepositoryImpl extends EObjectImpl implements ManagedPatternRepository {
	/**
	 * The cached value of the '{@link #getEventPatterns() <em>Event Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractEventPattern> eventPatterns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagedPatternRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CepPackage.Literals.MANAGED_PATTERN_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractEventPattern> getEventPatterns() {
		if (eventPatterns == null) {
			eventPatterns = new EObjectContainmentEList<AbstractEventPattern>(AbstractEventPattern.class, this, CepPackage.MANAGED_PATTERN_REPOSITORY__EVENT_PATTERNS);
		}
		return eventPatterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CepPackage.MANAGED_PATTERN_REPOSITORY__EVENT_PATTERNS:
				return ((InternalEList<?>)getEventPatterns()).basicRemove(otherEnd, msgs);
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
			case CepPackage.MANAGED_PATTERN_REPOSITORY__EVENT_PATTERNS:
				return getEventPatterns();
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
			case CepPackage.MANAGED_PATTERN_REPOSITORY__EVENT_PATTERNS:
				getEventPatterns().clear();
				getEventPatterns().addAll((Collection<? extends AbstractEventPattern>)newValue);
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
			case CepPackage.MANAGED_PATTERN_REPOSITORY__EVENT_PATTERNS:
				getEventPatterns().clear();
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
			case CepPackage.MANAGED_PATTERN_REPOSITORY__EVENT_PATTERNS:
				return eventPatterns != null && !eventPatterns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ManagedPatternRepositoryImpl