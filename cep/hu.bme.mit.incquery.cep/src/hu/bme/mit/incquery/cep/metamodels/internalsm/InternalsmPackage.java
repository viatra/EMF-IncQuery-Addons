/**
 */
package hu.bme.mit.incquery.cep.metamodels.internalsm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Event Tokens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EVENT_TOKENS = 3;

	/**
	 * The feature id for the '<em><b>Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TIME_CONSTRAINTS = 4;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 5;

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
	 * The feature id for the '<em><b>Pre State</b></em>' container reference.
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
	 * The feature id for the '<em><b>Time Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__TIME_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__EVENT_TYPE = 1;

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
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Event Tokens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__EVENT_TOKENS = STATE__EVENT_TOKENS;

	/**
	 * The feature id for the '<em><b>Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__TIME_CONSTRAINTS = STATE__TIME_CONSTRAINTS;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Event Tokens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_STATE__EVENT_TOKENS = STATE__EVENT_TOKENS;

	/**
	 * The feature id for the '<em><b>Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_STATE__TIME_CONSTRAINTS = STATE__TIME_CONSTRAINTS;

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
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Event Tokens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAP_STATE__EVENT_TOKENS = STATE__EVENT_TOKENS;

	/**
	 * The feature id for the '<em><b>Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAP_STATE__TIME_CONSTRAINTS = STATE__TIME_CONSTRAINTS;

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
	 * The feature id for the '<em><b>Event Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__EVENT_PATTERN = 1;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Current State Visitors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EXECUTION_MODEL__CURRENT_STATE_VISITORS = 2;

	/**
	 * The number of structural features of the '<em>Internal Execution Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EXECUTION_MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventTokenImpl <em>Event Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventTokenImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getEventToken()
	 * @generated
	 */
	int EVENT_TOKEN = 8;

	/**
	 * The feature id for the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TOKEN__CURRENT_STATE = 0;

	/**
	 * The feature id for the '<em><b>Event Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TOKEN__EVENT_COLLECTION = 1;

	/**
	 * The number of structural features of the '<em>Event Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TOKEN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventCollectionImpl <em>Event Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventCollectionImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getEventCollection()
	 * @generated
	 */
	int EVENT_COLLECTION = 9;

	/**
	 * The feature id for the '<em><b>Current State Visitor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COLLECTION__CURRENT_STATE_VISITOR = 0;

	/**
	 * The number of structural features of the '<em>Event Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintSpecificationImpl <em>Time Constraint Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintSpecificationImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTimeConstraintSpecification()
	 * @generated
	 */
	int TIME_CONSTRAINT_SPECIFICATION = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT_SPECIFICATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Expected Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT_SPECIFICATION__EXPECTED_LENGTH = 1;

	/**
	 * The feature id for the '<em><b>Start Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT_SPECIFICATION__START_TIMESTAMP = 2;

	/**
	 * The feature id for the '<em><b>Stop Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT_SPECIFICATION__STOP_TIMESTAMP = 3;

	/**
	 * The number of structural features of the '<em>Time Constraint Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT_SPECIFICATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl <em>Time Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTimeConstraint()
	 * @generated
	 */
	int TIME_CONSTRAINT = 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Time Constraint Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION = 1;

	/**
	 * The number of structural features of the '<em>Time Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.NumericCompareOperator <em>Numeric Compare Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.NumericCompareOperator
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getNumericCompareOperator()
	 * @generated
	 */
	int NUMERIC_COMPARE_OPERATOR = 12;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType <em>Time Constraint Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTimeConstraintType()
	 * @generated
	 */
	int TIME_CONSTRAINT_TYPE = 13;


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
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Out Transitions</em>'.
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
	 * Returns the meta object for the reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getEventTokens <em>Event Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event Tokens</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getEventTokens()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_EventTokens();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.State#getTimeConstraints <em>Time Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Time Constraints</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.State#getTimeConstraints()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_TimeConstraints();

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
	 * Returns the meta object for the container reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Transition#getPreState <em>Pre State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Pre State</em>'.
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
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getTimeConstraint <em>Time Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Constraint</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getTimeConstraint()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_TimeConstraint();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Type</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.Guard#getEventType()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_EventType();

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
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel#getCurrentStateVisitors <em>Current State Visitors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Current State Visitors</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.InternalExecutionModel#getCurrentStateVisitors()
	 * @see #getInternalExecutionModel()
	 * @generated
	 */
	EReference getInternalExecutionModel_CurrentStateVisitors();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken <em>Event Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Token</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken
	 * @generated
	 */
	EClass getEventToken();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current State</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getCurrentState()
	 * @see #getEventToken()
	 * @generated
	 */
	EReference getEventToken_CurrentState();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getEventCollection <em>Event Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Collection</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventToken#getEventCollection()
	 * @see #getEventToken()
	 * @generated
	 */
	EReference getEventToken_EventCollection();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection <em>Event Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Collection</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection
	 * @generated
	 */
	EClass getEventCollection();

	/**
	 * Returns the meta object for the container reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getCurrentStateVisitor <em>Current State Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Current State Visitor</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.EventCollection#getCurrentStateVisitor()
	 * @see #getEventCollection()
	 * @generated
	 */
	EReference getEventCollection_CurrentStateVisitor();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification <em>Time Constraint Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Constraint Specification</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification
	 * @generated
	 */
	EClass getTimeConstraintSpecification();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getId()
	 * @see #getTimeConstraintSpecification()
	 * @generated
	 */
	EAttribute getTimeConstraintSpecification_Id();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getExpectedLength <em>Expected Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected Length</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getExpectedLength()
	 * @see #getTimeConstraintSpecification()
	 * @generated
	 */
	EAttribute getTimeConstraintSpecification_ExpectedLength();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getStartTimestamp <em>Start Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Timestamp</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getStartTimestamp()
	 * @see #getTimeConstraintSpecification()
	 * @generated
	 */
	EAttribute getTimeConstraintSpecification_StartTimestamp();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getStopTimestamp <em>Stop Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Timestamp</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintSpecification#getStopTimestamp()
	 * @see #getTimeConstraintSpecification()
	 * @generated
	 */
	EAttribute getTimeConstraintSpecification_StopTimestamp();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint <em>Time Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Constraint</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint
	 * @generated
	 */
	EClass getTimeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getType()
	 * @see #getTimeConstraint()
	 * @generated
	 */
	EAttribute getTimeConstraint_Type();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getTimeConstraintSpecification <em>Time Constraint Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time Constraint Specification</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraint#getTimeConstraintSpecification()
	 * @see #getTimeConstraint()
	 * @generated
	 */
	EReference getTimeConstraint_TimeConstraintSpecification();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.NumericCompareOperator <em>Numeric Compare Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Numeric Compare Operator</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.NumericCompareOperator
	 * @generated
	 */
	EEnum getNumericCompareOperator();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType <em>Time Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Constraint Type</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType
	 * @generated
	 */
	EEnum getTimeConstraintType();

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
		 * The meta object literal for the '<em><b>Out Transitions</b></em>' containment reference list feature.
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
		 * The meta object literal for the '<em><b>Event Tokens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__EVENT_TOKENS = eINSTANCE.getState_EventTokens();

		/**
		 * The meta object literal for the '<em><b>Time Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__TIME_CONSTRAINTS = eINSTANCE.getState_TimeConstraints();

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
		 * The meta object literal for the '<em><b>Pre State</b></em>' container reference feature.
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
		 * The meta object literal for the '<em><b>Time Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__TIME_CONSTRAINT = eINSTANCE.getGuard_TimeConstraint();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__EVENT_TYPE = eINSTANCE.getGuard_EventType();

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
		 * The meta object literal for the '<em><b>Current State Visitors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_EXECUTION_MODEL__CURRENT_STATE_VISITORS = eINSTANCE.getInternalExecutionModel_CurrentStateVisitors();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventTokenImpl <em>Event Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventTokenImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getEventToken()
		 * @generated
		 */
		EClass EVENT_TOKEN = eINSTANCE.getEventToken();

		/**
		 * The meta object literal for the '<em><b>Current State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_TOKEN__CURRENT_STATE = eINSTANCE.getEventToken_CurrentState();

		/**
		 * The meta object literal for the '<em><b>Event Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_TOKEN__EVENT_COLLECTION = eINSTANCE.getEventToken_EventCollection();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventCollectionImpl <em>Event Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.EventCollectionImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getEventCollection()
		 * @generated
		 */
		EClass EVENT_COLLECTION = eINSTANCE.getEventCollection();

		/**
		 * The meta object literal for the '<em><b>Current State Visitor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_COLLECTION__CURRENT_STATE_VISITOR = eINSTANCE.getEventCollection_CurrentStateVisitor();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintSpecificationImpl <em>Time Constraint Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintSpecificationImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTimeConstraintSpecification()
		 * @generated
		 */
		EClass TIME_CONSTRAINT_SPECIFICATION = eINSTANCE.getTimeConstraintSpecification();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONSTRAINT_SPECIFICATION__ID = eINSTANCE.getTimeConstraintSpecification_Id();

		/**
		 * The meta object literal for the '<em><b>Expected Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONSTRAINT_SPECIFICATION__EXPECTED_LENGTH = eINSTANCE.getTimeConstraintSpecification_ExpectedLength();

		/**
		 * The meta object literal for the '<em><b>Start Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONSTRAINT_SPECIFICATION__START_TIMESTAMP = eINSTANCE.getTimeConstraintSpecification_StartTimestamp();

		/**
		 * The meta object literal for the '<em><b>Stop Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONSTRAINT_SPECIFICATION__STOP_TIMESTAMP = eINSTANCE.getTimeConstraintSpecification_StopTimestamp();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl <em>Time Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.TimeConstraintImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTimeConstraint()
		 * @generated
		 */
		EClass TIME_CONSTRAINT = eINSTANCE.getTimeConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONSTRAINT__TYPE = eINSTANCE.getTimeConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Time Constraint Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_CONSTRAINT__TIME_CONSTRAINT_SPECIFICATION = eINSTANCE.getTimeConstraint_TimeConstraintSpecification();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.NumericCompareOperator <em>Numeric Compare Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.NumericCompareOperator
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getNumericCompareOperator()
		 * @generated
		 */
		EEnum NUMERIC_COMPARE_OPERATOR = eINSTANCE.getNumericCompareOperator();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType <em>Time Constraint Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.TimeConstraintType
		 * @see hu.bme.mit.incquery.cep.metamodels.internalsm.impl.InternalsmPackageImpl#getTimeConstraintType()
		 * @generated
		 */
		EEnum TIME_CONSTRAINT_TYPE = eINSTANCE.getTimeConstraintType();

	}

} //InternalsmPackage
