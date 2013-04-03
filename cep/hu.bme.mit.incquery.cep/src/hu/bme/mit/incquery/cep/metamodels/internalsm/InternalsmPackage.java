/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalsmFactory
 * @model kind="package"
 * @generated
 */
public interface InternalsmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "internalsm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "sm.meta";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.bme.mit.incquery.metamodels";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InternalsmPackage eINSTANCE = hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getState()
	 * @generated
	 */
	int STATE = 0;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUT_TRANSITIONS = 0;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IN_TRANSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LABEL = 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 1;

	/**
	 * The feature id for the '<em><b>Pre State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PRE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = 1;

	/**
	 * The feature id for the '<em><b>Post State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__POST_STATE = 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.GuardImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 2;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__EVENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Timewindow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__TIMEWINDOW = 1;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.FinalStateImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 3;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__OUT_TRANSITIONS = STATE__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__IN_TRANSITIONS = STATE__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__LABEL = STATE__LABEL;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__ACTIONS = STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InitStateImpl <em>Init State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InitStateImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getInitState()
	 * @generated
	 */
	int INIT_STATE = 4;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_STATE__OUT_TRANSITIONS = STATE__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_STATE__IN_TRANSITIONS = STATE__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_STATE__LABEL = STATE__LABEL;

	/**
	 * The number of structural features of the '<em>Init State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TrapStateImpl <em>Trap State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TrapStateImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTrapState()
	 * @generated
	 */
	int TRAP_STATE = 5;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAP_STATE__OUT_TRANSITIONS = STATE__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAP_STATE__IN_TRANSITIONS = STATE__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAP_STATE__LABEL = STATE__LABEL;

	/**
	 * The number of structural features of the '<em>Trap State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAP_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getStateMachine()
	 * @generated
	 */
	int STATE_MACHINE = 6;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__STATES = 0;

	/**
	 * The feature id for the '<em><b>Current State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__CURRENT_STATE = 1;

	/**
	 * The feature id for the '<em><b>Event Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__EVENT_PATTERN = 2;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalExecutionModelImpl <em>Internal Execution Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalExecutionModelImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getInternalExecutionModel()
	 * @generated
	 */
	int INTERNAL_EXECUTION_MODEL = 7;

	/**
	 * The feature id for the '<em><b>State Machines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EXECUTION_MODEL__STATE_MACHINES = 0;

	/**
	 * The feature id for the '<em><b>Latest Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EXECUTION_MODEL__LATEST_EVENT = 1;

	/**
	 * The number of structural features of the '<em>Internal Execution Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EXECUTION_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.ActionImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 8;

	/**
	 * The feature id for the '<em><b>Msg To Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__MSG_TO_LOG = 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Transitions</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getOutTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutTransitions();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getInTransitions <em>In Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Transitions</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getInTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InTransitions();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getLabel()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Label();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPreState <em>Pre State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pre State</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPreState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_PreState();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Guard();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPostState <em>Post State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Post State</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPostState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_PostState();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Type</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getEventType()
	 * @see #getGuard()
	 * @generated
	 */
	EAttribute getGuard_EventType();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getTimewindow <em>Timewindow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Timewindow</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getTimewindow()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_Timewindow();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.FinalState#getActions()
	 * @see #getFinalState()
	 * @generated
	 */
	EReference getFinalState_Actions();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.InitState <em>Init State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Init State</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InitState
	 * @generated
	 */
	EClass getInitState();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState <em>Trap State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trap State</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TrapState
	 * @generated
	 */
	EClass getTrapState();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getStates()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_States();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Current State</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getCurrentState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_CurrentState();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getEventPattern <em>Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Pattern</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.StateMachine#getEventPattern()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_EventPattern();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel <em>Internal Execution Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Execution Model</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel
	 * @generated
	 */
	EClass getInternalExecutionModel();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel#getStateMachines <em>State Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Machines</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel#getStateMachines()
	 * @see #getInternalExecutionModel()
	 * @generated
	 */
	EReference getInternalExecutionModel_StateMachines();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel#getLatestEvent <em>Latest Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Latest Event</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel#getLatestEvent()
	 * @see #getInternalExecutionModel()
	 * @generated
	 */
	EReference getInternalExecutionModel_LatestEvent();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Action#getMsgToLog <em>Msg To Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msg To Log</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Action#getMsgToLog()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_MsgToLog();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InternalsmFactory getInternalsmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Out Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUT_TRANSITIONS = eINSTANCE.getState_OutTransitions();

		/**
		 * The meta object literal for the '<em><b>In Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__IN_TRANSITIONS = eINSTANCE.getState_InTransitions();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__LABEL = eINSTANCE.getState_Label();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TransitionImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Pre State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__PRE_STATE = eINSTANCE.getTransition_PreState();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Post State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__POST_STATE = eINSTANCE.getTransition_PostState();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.GuardImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARD__EVENT_TYPE = eINSTANCE.getGuard_EventType();

		/**
		 * The meta object literal for the '<em><b>Timewindow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__TIMEWINDOW = eINSTANCE.getGuard_Timewindow();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.FinalStateImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINAL_STATE__ACTIONS = eINSTANCE.getFinalState_Actions();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InitStateImpl <em>Init State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InitStateImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getInitState()
		 * @generated
		 */
		EClass INIT_STATE = eINSTANCE.getInitState();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TrapStateImpl <em>Trap State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TrapStateImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTrapState()
		 * @generated
		 */
		EClass TRAP_STATE = eINSTANCE.getTrapState();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.StateMachineImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__STATES = eINSTANCE.getStateMachine_States();

		/**
		 * The meta object literal for the '<em><b>Current State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__CURRENT_STATE = eINSTANCE.getStateMachine_CurrentState();

		/**
		 * The meta object literal for the '<em><b>Event Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__EVENT_PATTERN = eINSTANCE.getStateMachine_EventPattern();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalExecutionModelImpl <em>Internal Execution Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalExecutionModelImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getInternalExecutionModel()
		 * @generated
		 */
		EClass INTERNAL_EXECUTION_MODEL = eINSTANCE.getInternalExecutionModel();

		/**
		 * The meta object literal for the '<em><b>State Machines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_EXECUTION_MODEL__STATE_MACHINES = eINSTANCE.getInternalExecutionModel_StateMachines();

		/**
		 * The meta object literal for the '<em><b>Latest Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_EXECUTION_MODEL__LATEST_EVENT = eINSTANCE.getInternalExecutionModel_LatestEvent();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.ActionImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Msg To Log</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__MSG_TO_LOG = eINSTANCE.getAction_MsgToLog();

	}

} //InternalsmPackage
