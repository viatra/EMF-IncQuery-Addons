/**
 */
package hu.bme.mit.incquery.cep.metamodels.automaton;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.metamodels.automaton.AutomatonFactory
 * @model kind="package"
 * @generated
 */
public interface AutomatonPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "automaton";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "automaton.meta";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "hu.bme.mit.incquery.cep.metamodels";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    AutomatonPackage eINSTANCE = hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl.init();

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.InternalModelImpl <em>Internal Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.InternalModelImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getInternalModel()
     * @generated
     */
    int INTERNAL_MODEL = 0;

    /**
     * The feature id for the '<em><b>Automata</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERNAL_MODEL__AUTOMATA = 0;

    /**
     * The feature id for the '<em><b>Latest Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERNAL_MODEL__LATEST_EVENT = 1;

    /**
     * The feature id for the '<em><b>Event Tokens</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERNAL_MODEL__EVENT_TOKENS = 2;

    /**
     * The number of structural features of the '<em>Internal Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERNAL_MODEL_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Internal Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERNAL_MODEL_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonImpl <em>Automaton</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getAutomaton()
     * @generated
     */
    int AUTOMATON = 1;

    /**
     * The feature id for the '<em><b>States</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTOMATON__STATES = 0;

    /**
     * The feature id for the '<em><b>Event Pattern</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTOMATON__EVENT_PATTERN = 1;

    /**
     * The number of structural features of the '<em>Automaton</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTOMATON_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Automaton</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTOMATON_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.EventTokenImpl <em>Event Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.EventTokenImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getEventToken()
     * @generated
     */
    int EVENT_TOKEN = 2;

    /**
     * The feature id for the '<em><b>Current State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_TOKEN__CURRENT_STATE = 0;

    /**
     * The feature id for the '<em><b>Recorded Events</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_TOKEN__RECORDED_EVENTS = 1;

    /**
     * The number of structural features of the '<em>Event Token</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_TOKEN_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Event Token</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_TOKEN_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.StateImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getState()
     * @generated
     */
    int STATE = 3;

    /**
     * The feature id for the '<em><b>In Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE__IN_TRANSITIONS = 0;

    /**
     * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE__OUT_TRANSITIONS = 1;

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
     * The feature id for the '<em><b>Last Processed Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE__LAST_PROCESSED_EVENT = 4;

    /**
     * The number of structural features of the '<em>State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.InitStateImpl <em>Init State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.InitStateImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getInitState()
     * @generated
     */
    int INIT_STATE = 4;

    /**
     * The feature id for the '<em><b>In Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INIT_STATE__IN_TRANSITIONS = STATE__IN_TRANSITIONS;

    /**
     * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INIT_STATE__OUT_TRANSITIONS = STATE__OUT_TRANSITIONS;

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
     * The feature id for the '<em><b>Last Processed Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INIT_STATE__LAST_PROCESSED_EVENT = STATE__LAST_PROCESSED_EVENT;

    /**
     * The number of structural features of the '<em>Init State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INIT_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Init State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INIT_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.FinalStateImpl <em>Final State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.FinalStateImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getFinalState()
     * @generated
     */
    int FINAL_STATE = 5;

    /**
     * The feature id for the '<em><b>In Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FINAL_STATE__IN_TRANSITIONS = STATE__IN_TRANSITIONS;

    /**
     * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FINAL_STATE__OUT_TRANSITIONS = STATE__OUT_TRANSITIONS;

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
     * The feature id for the '<em><b>Last Processed Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FINAL_STATE__LAST_PROCESSED_EVENT = STATE__LAST_PROCESSED_EVENT;

    /**
     * The number of structural features of the '<em>Final State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FINAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Final State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FINAL_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.TrapStateImpl <em>Trap State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.TrapStateImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getTrapState()
     * @generated
     */
    int TRAP_STATE = 6;

    /**
     * The feature id for the '<em><b>In Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRAP_STATE__IN_TRANSITIONS = STATE__IN_TRANSITIONS;

    /**
     * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRAP_STATE__OUT_TRANSITIONS = STATE__OUT_TRANSITIONS;

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
     * The feature id for the '<em><b>Last Processed Event</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRAP_STATE__LAST_PROCESSED_EVENT = STATE__LAST_PROCESSED_EVENT;

    /**
     * The number of structural features of the '<em>Trap State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRAP_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Trap State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRAP_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.TransitionImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getTransition()
     * @generated
     */
    int TRANSITION = 7;

    /**
     * The feature id for the '<em><b>Pre State</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__PRE_STATE = 0;

    /**
     * The feature id for the '<em><b>Post State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__POST_STATE = 1;

    /**
     * The feature id for the '<em><b>Guard</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__GUARD = 2;

    /**
     * The number of structural features of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.GuardImpl
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getGuard()
     * @generated
     */
    int GUARD = 8;

    /**
     * The feature id for the '<em><b>Event Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUARD__EVENT_TYPE = 0;

    /**
     * The number of structural features of the '<em>Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUARD_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Guard</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUARD_OPERATION_COUNT = 0;


    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel <em>Internal Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Internal Model</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel
     * @generated
     */
    EClass getInternalModel();

    /**
     * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getAutomata <em>Automata</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Automata</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getAutomata()
     * @see #getInternalModel()
     * @generated
     */
    EReference getInternalModel_Automata();

    /**
     * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getLatestEvent <em>Latest Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Latest Event</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getLatestEvent()
     * @see #getInternalModel()
     * @generated
     */
    EReference getInternalModel_LatestEvent();

    /**
     * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getEventTokens <em>Event Tokens</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Event Tokens</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.InternalModel#getEventTokens()
     * @see #getInternalModel()
     * @generated
     */
    EReference getInternalModel_EventTokens();

    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Automaton <em>Automaton</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Automaton</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Automaton
     * @generated
     */
    EClass getAutomaton();

    /**
     * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getStates <em>States</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>States</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getStates()
     * @see #getAutomaton()
     * @generated
     */
    EReference getAutomaton_States();

    /**
     * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getEventPattern <em>Event Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Event Pattern</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Automaton#getEventPattern()
     * @see #getAutomaton()
     * @generated
     */
    EReference getAutomaton_EventPattern();

    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.EventToken <em>Event Token</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Token</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.EventToken
     * @generated
     */
    EClass getEventToken();

    /**
     * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.automaton.EventToken#getCurrentState <em>Current State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Current State</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.EventToken#getCurrentState()
     * @see #getEventToken()
     * @generated
     */
    EReference getEventToken_CurrentState();

    /**
     * Returns the meta object for the reference list '{@link hu.bme.mit.incquery.cep.metamodels.automaton.EventToken#getRecordedEvents <em>Recorded Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Recorded Events</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.EventToken#getRecordedEvents()
     * @see #getEventToken()
     * @generated
     */
    EReference getEventToken_RecordedEvents();

    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State <em>State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>State</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.State
     * @generated
     */
    EClass getState();

    /**
     * Returns the meta object for the reference list '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getInTransitions <em>In Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>In Transitions</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.State#getInTransitions()
     * @see #getState()
     * @generated
     */
    EReference getState_InTransitions();

    /**
     * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getOutTransitions <em>Out Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Out Transitions</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.State#getOutTransitions()
     * @see #getState()
     * @generated
     */
    EReference getState_OutTransitions();

    /**
     * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.State#getLabel()
     * @see #getState()
     * @generated
     */
    EAttribute getState_Label();

    /**
     * Returns the meta object for the reference list '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getEventTokens <em>Event Tokens</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Event Tokens</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.State#getEventTokens()
     * @see #getState()
     * @generated
     */
    EReference getState_EventTokens();

    /**
     * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.automaton.State#getLastProcessedEvent <em>Last Processed Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Last Processed Event</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.State#getLastProcessedEvent()
     * @see #getState()
     * @generated
     */
    EReference getState_LastProcessedEvent();

    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.InitState <em>Init State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Init State</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.InitState
     * @generated
     */
    EClass getInitState();

    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.FinalState <em>Final State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Final State</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.FinalState
     * @generated
     */
    EClass getFinalState();

    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.TrapState <em>Trap State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trap State</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.TrapState
     * @generated
     */
    EClass getTrapState();

    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transition</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Transition
     * @generated
     */
    EClass getTransition();

    /**
     * Returns the meta object for the container reference '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPreState <em>Pre State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pre State</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPreState()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_PreState();

    /**
     * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPostState <em>Post State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Post State</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getPostState()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_PostState();

    /**
     * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getGuard <em>Guard</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Guard</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Transition#getGuard()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_Guard();

    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Guard <em>Guard</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Guard</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Guard
     * @generated
     */
    EClass getGuard();

    /**
     * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.automaton.Guard#getEventType <em>Event Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Event Type</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.automaton.Guard#getEventType()
     * @see #getGuard()
     * @generated
     */
    EReference getGuard_EventType();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    AutomatonFactory getAutomatonFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.InternalModelImpl <em>Internal Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.InternalModelImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getInternalModel()
         * @generated
         */
        EClass INTERNAL_MODEL = eINSTANCE.getInternalModel();

        /**
         * The meta object literal for the '<em><b>Automata</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERNAL_MODEL__AUTOMATA = eINSTANCE.getInternalModel_Automata();

        /**
         * The meta object literal for the '<em><b>Latest Event</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERNAL_MODEL__LATEST_EVENT = eINSTANCE.getInternalModel_LatestEvent();

        /**
         * The meta object literal for the '<em><b>Event Tokens</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERNAL_MODEL__EVENT_TOKENS = eINSTANCE.getInternalModel_EventTokens();

        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonImpl <em>Automaton</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getAutomaton()
         * @generated
         */
        EClass AUTOMATON = eINSTANCE.getAutomaton();

        /**
         * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference AUTOMATON__STATES = eINSTANCE.getAutomaton_States();

        /**
         * The meta object literal for the '<em><b>Event Pattern</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference AUTOMATON__EVENT_PATTERN = eINSTANCE.getAutomaton_EventPattern();

        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.EventTokenImpl <em>Event Token</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.EventTokenImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getEventToken()
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
         * The meta object literal for the '<em><b>Recorded Events</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EVENT_TOKEN__RECORDED_EVENTS = eINSTANCE.getEventToken_RecordedEvents();

        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.StateImpl <em>State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.StateImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getState()
         * @generated
         */
        EClass STATE = eINSTANCE.getState();

        /**
         * The meta object literal for the '<em><b>In Transitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATE__IN_TRANSITIONS = eINSTANCE.getState_InTransitions();

        /**
         * The meta object literal for the '<em><b>Out Transitions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATE__OUT_TRANSITIONS = eINSTANCE.getState_OutTransitions();

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
         * The meta object literal for the '<em><b>Last Processed Event</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATE__LAST_PROCESSED_EVENT = eINSTANCE.getState_LastProcessedEvent();

        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.InitStateImpl <em>Init State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.InitStateImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getInitState()
         * @generated
         */
        EClass INIT_STATE = eINSTANCE.getInitState();

        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.FinalStateImpl <em>Final State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.FinalStateImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getFinalState()
         * @generated
         */
        EClass FINAL_STATE = eINSTANCE.getFinalState();

        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.TrapStateImpl <em>Trap State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.TrapStateImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getTrapState()
         * @generated
         */
        EClass TRAP_STATE = eINSTANCE.getTrapState();

        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.TransitionImpl <em>Transition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.TransitionImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getTransition()
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
         * The meta object literal for the '<em><b>Post State</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__POST_STATE = eINSTANCE.getTransition_PostState();

        /**
         * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.automaton.impl.GuardImpl <em>Guard</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.GuardImpl
         * @see hu.bme.mit.incquery.cep.metamodels.automaton.impl.AutomatonPackageImpl#getGuard()
         * @generated
         */
        EClass GUARD = eINSTANCE.getGuard();

        /**
         * The meta object literal for the '<em><b>Event Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GUARD__EVENT_TYPE = eINSTANCE.getGuard_EventType();

    }

} //AutomatonPackage
