/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm.impl;

import hu.bme.mit.incquery.cep.metamodels.internalsm.CurrentStateVisitor;
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
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getCurrentVisitors <em>Current Visitors</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getStartConstraints <em>Start Constraints</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getStopConstraints <em>Stop Constraints</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl#getIntermediateConstraints <em>Intermediate Constraints</em>}</li>
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
	 * The cached value of the '{@link #getCurrentVisitors() <em>Current Visitors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentVisitors()
	 * @generated
	 * @ordered
	 */
	protected EList<CurrentStateVisitor> currentVisitors;

	/**
	 * The cached value of the '{@link #getStartConstraints() <em>Start Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConstraint> startConstraints;

	/**
	 * The cached value of the '{@link #getStopConstraints() <em>Stop Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConstraint> stopConstraints;

	/**
	 * The cached value of the '{@link #getIntermediateConstraints() <em>Intermediate Constraints</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateConstraints()
	 * @generated
	 * @ordered
	 */
	protected TimeConstraint intermediateConstraints;

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
	public EList<CurrentStateVisitor> getCurrentVisitors() {
		if (currentVisitors == null) {
			currentVisitors = new EObjectWithInverseResolvingEList<CurrentStateVisitor>(CurrentStateVisitor.class, this, InternalsmPackage.STATE__CURRENT_VISITORS, InternalsmPackage.CURRENT_STATE_VISITOR__CURRENT_STATE);
		}
		return currentVisitors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConstraint> getStartConstraints() {
		if (startConstraints == null) {
			startConstraints = new EObjectWithInverseResolvingEList<TimeConstraint>(TimeConstraint.class, this, InternalsmPackage.STATE__START_CONSTRAINTS, InternalsmPackage.TIME_CONSTRAINT__START_STATE);
		}
		return startConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConstraint> getStopConstraints() {
		if (stopConstraints == null) {
			stopConstraints = new EObjectWithInverseResolvingEList<TimeConstraint>(TimeConstraint.class, this, InternalsmPackage.STATE__STOP_CONSTRAINTS, InternalsmPackage.TIME_CONSTRAINT__STOP_STATE);
		}
		return stopConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConstraint getIntermediateConstraints() {
		if (intermediateConstraints != null && intermediateConstraints.eIsProxy()) {
			InternalEObject oldIntermediateConstraints = (InternalEObject)intermediateConstraints;
			intermediateConstraints = (TimeConstraint)eResolveProxy(oldIntermediateConstraints);
			if (intermediateConstraints != oldIntermediateConstraints) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS, oldIntermediateConstraints, intermediateConstraints));
			}
		}
		return intermediateConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConstraint basicGetIntermediateConstraints() {
		return intermediateConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateConstraints(TimeConstraint newIntermediateConstraints, NotificationChain msgs) {
		TimeConstraint oldIntermediateConstraints = intermediateConstraints;
		intermediateConstraints = newIntermediateConstraints;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS, oldIntermediateConstraints, newIntermediateConstraints);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateConstraints(TimeConstraint newIntermediateConstraints) {
		if (newIntermediateConstraints != intermediateConstraints) {
			NotificationChain msgs = null;
			if (intermediateConstraints != null)
				msgs = ((InternalEObject)intermediateConstraints).eInverseRemove(this, InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE, TimeConstraint.class, msgs);
			if (newIntermediateConstraints != null)
				msgs = ((InternalEObject)newIntermediateConstraints).eInverseAdd(this, InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE, TimeConstraint.class, msgs);
			msgs = basicSetIntermediateConstraints(newIntermediateConstraints, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS, newIntermediateConstraints, newIntermediateConstraints));
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
			case InternalsmPackage.STATE__CURRENT_VISITORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCurrentVisitors()).basicAdd(otherEnd, msgs);
			case InternalsmPackage.STATE__START_CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStartConstraints()).basicAdd(otherEnd, msgs);
			case InternalsmPackage.STATE__STOP_CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStopConstraints()).basicAdd(otherEnd, msgs);
			case InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS:
				if (intermediateConstraints != null)
					msgs = ((InternalEObject)intermediateConstraints).eInverseRemove(this, InternalsmPackage.TIME_CONSTRAINT__INTERMEDIATE_STATE, TimeConstraint.class, msgs);
				return basicSetIntermediateConstraints((TimeConstraint)otherEnd, msgs);
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
			case InternalsmPackage.STATE__CURRENT_VISITORS:
				return ((InternalEList<?>)getCurrentVisitors()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.STATE__START_CONSTRAINTS:
				return ((InternalEList<?>)getStartConstraints()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.STATE__STOP_CONSTRAINTS:
				return ((InternalEList<?>)getStopConstraints()).basicRemove(otherEnd, msgs);
			case InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS:
				return basicSetIntermediateConstraints(null, msgs);
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
			case InternalsmPackage.STATE__CURRENT_VISITORS:
				return getCurrentVisitors();
			case InternalsmPackage.STATE__START_CONSTRAINTS:
				return getStartConstraints();
			case InternalsmPackage.STATE__STOP_CONSTRAINTS:
				return getStopConstraints();
			case InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS:
				if (resolve) return getIntermediateConstraints();
				return basicGetIntermediateConstraints();
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
			case InternalsmPackage.STATE__CURRENT_VISITORS:
				getCurrentVisitors().clear();
				getCurrentVisitors().addAll((Collection<? extends CurrentStateVisitor>)newValue);
				return;
			case InternalsmPackage.STATE__START_CONSTRAINTS:
				getStartConstraints().clear();
				getStartConstraints().addAll((Collection<? extends TimeConstraint>)newValue);
				return;
			case InternalsmPackage.STATE__STOP_CONSTRAINTS:
				getStopConstraints().clear();
				getStopConstraints().addAll((Collection<? extends TimeConstraint>)newValue);
				return;
			case InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS:
				setIntermediateConstraints((TimeConstraint)newValue);
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
			case InternalsmPackage.STATE__CURRENT_VISITORS:
				getCurrentVisitors().clear();
				return;
			case InternalsmPackage.STATE__START_CONSTRAINTS:
				getStartConstraints().clear();
				return;
			case InternalsmPackage.STATE__STOP_CONSTRAINTS:
				getStopConstraints().clear();
				return;
			case InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS:
				setIntermediateConstraints((TimeConstraint)null);
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
			case InternalsmPackage.STATE__CURRENT_VISITORS:
				return currentVisitors != null && !currentVisitors.isEmpty();
			case InternalsmPackage.STATE__START_CONSTRAINTS:
				return startConstraints != null && !startConstraints.isEmpty();
			case InternalsmPackage.STATE__STOP_CONSTRAINTS:
				return stopConstraints != null && !stopConstraints.isEmpty();
			case InternalsmPackage.STATE__INTERMEDIATE_CONSTRAINTS:
				return intermediateConstraints != null;
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
