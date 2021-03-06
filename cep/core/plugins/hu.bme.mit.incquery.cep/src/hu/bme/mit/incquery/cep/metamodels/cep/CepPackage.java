/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

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
 * @see hu.bme.mit.incquery.cep.metamodels.cep.CepFactory
 * @model kind="package"
 * @generated
 */
public interface CepPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cep";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "cep.meta";

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
	CepPackage eINSTANCE = hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl <em>Event Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getEventPattern()
	 * @generated
	 */
	int EVENT_PATTERN = 0;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PATTERN__STATE_MACHINE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PATTERN__ID = 1;

	/**
	 * The feature id for the '<em><b>Holding Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PATTERN__HOLDING_TIME = 2;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PATTERN__PRIORITY = 3;

	/**
	 * The number of structural features of the '<em>Event Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PATTERN_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl <em>Atomic Event Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getAtomicEventPattern()
	 * @generated
	 */
	int ATOMIC_EVENT_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN__STATE_MACHINE = EVENT_PATTERN__STATE_MACHINE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN__ID = EVENT_PATTERN__ID;

	/**
	 * The feature id for the '<em><b>Holding Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN__HOLDING_TIME = EVENT_PATTERN__HOLDING_TIME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN__PRIORITY = EVENT_PATTERN__PRIORITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN__TYPE = EVENT_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atomic Event Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN_FEATURE_COUNT = EVENT_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl <em>Complex Event Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getComplexEventPattern()
	 * @generated
	 */
	int COMPLEX_EVENT_PATTERN = 2;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__STATE_MACHINE = EVENT_PATTERN__STATE_MACHINE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__ID = EVENT_PATTERN__ID;

	/**
	 * The feature id for the '<em><b>Holding Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__HOLDING_TIME = EVENT_PATTERN__HOLDING_TIME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__PRIORITY = EVENT_PATTERN__PRIORITY;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__OPERATOR = EVENT_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global Timewindow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__GLOBAL_TIMEWINDOW = EVENT_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composition Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS = EVENT_PATTERN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partial Time Windows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__PARTIAL_TIME_WINDOWS = EVENT_PATTERN_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Complex Event Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN_FEATURE_COUNT = EVENT_PATTERN_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.EventImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TIMESTAMP = 1;

	/**
	 * The feature id for the '<em><b>Event Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__EVENT_SOURCE = 2;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.IEventSource <em>IEvent Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.IEventSource
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getIEventSource()
	 * @generated
	 */
	int IEVENT_SOURCE = 4;

	/**
	 * The number of structural features of the '<em>IEvent Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEVENT_SOURCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.TimewindowImpl <em>Timewindow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.TimewindowImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getTimewindow()
	 * @generated
	 */
	int TIMEWINDOW = 5;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEWINDOW__LENGTH = 0;

	/**
	 * The number of structural features of the '<em>Timewindow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEWINDOW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.PartialTimewindowImpl <em>Partial Timewindow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.PartialTimewindowImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getPartialTimewindow()
	 * @generated
	 */
	int PARTIAL_TIMEWINDOW = 6;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TIMEWINDOW__LENGTH = TIMEWINDOW__LENGTH;

	/**
	 * The feature id for the '<em><b>Stop Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TIMEWINDOW__STOP_EVENT = TIMEWINDOW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Check Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TIMEWINDOW__CHECK_EVENTS = TIMEWINDOW_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TIMEWINDOW__START_EVENT = TIMEWINDOW_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Partial Timewindow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TIMEWINDOW_FEATURE_COUNT = TIMEWINDOW_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.GlobalTimewindowImpl <em>Global Timewindow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.GlobalTimewindowImpl
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getGlobalTimewindow()
	 * @generated
	 */
	int GLOBAL_TIMEWINDOW = 7;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TIMEWINDOW__LENGTH = TIMEWINDOW__LENGTH;

	/**
	 * The number of structural features of the '<em>Global Timewindow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TIMEWINDOW_FEATURE_COUNT = TIMEWINDOW_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator <em>Complex Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getComplexOperator()
	 * @generated
	 */
	int COMPLEX_OPERATOR = 8;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern <em>Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Pattern</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.EventPattern
	 * @generated
	 */
	EClass getEventPattern();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Machine</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getStateMachine()
	 * @see #getEventPattern()
	 * @generated
	 */
	EReference getEventPattern_StateMachine();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getId()
	 * @see #getEventPattern()
	 * @generated
	 */
	EAttribute getEventPattern_Id();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getHoldingTime <em>Holding Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Holding Time</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getHoldingTime()
	 * @see #getEventPattern()
	 * @generated
	 */
	EAttribute getEventPattern_HoldingTime();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getPriority()
	 * @see #getEventPattern()
	 * @generated
	 */
	EAttribute getEventPattern_Priority();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern <em>Atomic Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Event Pattern</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern
	 * @generated
	 */
	EClass getAtomicEventPattern();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.AtomicEventPattern#getType()
	 * @see #getAtomicEventPattern()
	 * @generated
	 */
	EAttribute getAtomicEventPattern_Type();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern <em>Complex Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Event Pattern</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern
	 * @generated
	 */
	EClass getComplexEventPattern();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getOperator()
	 * @see #getComplexEventPattern()
	 * @generated
	 */
	EAttribute getComplexEventPattern_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getGlobalTimewindow <em>Global Timewindow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Global Timewindow</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getGlobalTimewindow()
	 * @see #getComplexEventPattern()
	 * @generated
	 */
	EReference getComplexEventPattern_GlobalTimewindow();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getCompositionEvents <em>Composition Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composition Events</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getCompositionEvents()
	 * @see #getComplexEventPattern()
	 * @generated
	 */
	EReference getComplexEventPattern_CompositionEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getPartialTimeWindows <em>Partial Time Windows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partial Time Windows</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getPartialTimeWindows()
	 * @see #getComplexEventPattern()
	 * @generated
	 */
	EReference getComplexEventPattern_PartialTimeWindows();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.cep.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Type();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.Event#getTimestamp()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Timestamp();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getEventSource <em>Event Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Source</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.Event#getEventSource()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_EventSource();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.cep.IEventSource <em>IEvent Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEvent Source</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.IEventSource
	 * @generated
	 */
	EClass getIEventSource();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.cep.Timewindow <em>Timewindow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timewindow</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.Timewindow
	 * @generated
	 */
	EClass getTimewindow();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.metamodels.cep.Timewindow#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.Timewindow#getLength()
	 * @see #getTimewindow()
	 * @generated
	 */
	EAttribute getTimewindow_Length();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow <em>Partial Timewindow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partial Timewindow</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow
	 * @generated
	 */
	EClass getPartialTimewindow();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getStopEvent <em>Stop Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stop Event</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getStopEvent()
	 * @see #getPartialTimewindow()
	 * @generated
	 */
	EReference getPartialTimewindow_StopEvent();

	/**
	 * Returns the meta object for the reference list '{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getCheckEvents <em>Check Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Check Events</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getCheckEvents()
	 * @see #getPartialTimewindow()
	 * @generated
	 */
	EReference getPartialTimewindow_CheckEvents();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getStartEvent <em>Start Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Event</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.PartialTimewindow#getStartEvent()
	 * @see #getPartialTimewindow()
	 * @generated
	 */
	EReference getPartialTimewindow_StartEvent();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow <em>Global Timewindow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Timewindow</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow
	 * @generated
	 */
	EClass getGlobalTimewindow();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator <em>Complex Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Complex Operator</em>'.
	 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator
	 * @generated
	 */
	EEnum getComplexOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CepFactory getCepFactory();

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
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl <em>Event Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.EventPatternImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getEventPattern()
		 * @generated
		 */
		EClass EVENT_PATTERN = eINSTANCE.getEventPattern();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_PATTERN__STATE_MACHINE = eINSTANCE.getEventPattern_StateMachine();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_PATTERN__ID = eINSTANCE.getEventPattern_Id();

		/**
		 * The meta object literal for the '<em><b>Holding Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_PATTERN__HOLDING_TIME = eINSTANCE.getEventPattern_HoldingTime();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_PATTERN__PRIORITY = eINSTANCE.getEventPattern_Priority();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl <em>Atomic Event Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getAtomicEventPattern()
		 * @generated
		 */
		EClass ATOMIC_EVENT_PATTERN = eINSTANCE.getAtomicEventPattern();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_EVENT_PATTERN__TYPE = eINSTANCE.getAtomicEventPattern_Type();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl <em>Complex Event Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getComplexEventPattern()
		 * @generated
		 */
		EClass COMPLEX_EVENT_PATTERN = eINSTANCE.getComplexEventPattern();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX_EVENT_PATTERN__OPERATOR = eINSTANCE.getComplexEventPattern_Operator();

		/**
		 * The meta object literal for the '<em><b>Global Timewindow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT_PATTERN__GLOBAL_TIMEWINDOW = eINSTANCE.getComplexEventPattern_GlobalTimewindow();

		/**
		 * The meta object literal for the '<em><b>Composition Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS = eINSTANCE.getComplexEventPattern_CompositionEvents();

		/**
		 * The meta object literal for the '<em><b>Partial Time Windows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT_PATTERN__PARTIAL_TIME_WINDOWS = eINSTANCE.getComplexEventPattern_PartialTimeWindows();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.EventImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TIMESTAMP = eINSTANCE.getEvent_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Event Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__EVENT_SOURCE = eINSTANCE.getEvent_EventSource();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.IEventSource <em>IEvent Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.IEventSource
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getIEventSource()
		 * @generated
		 */
		EClass IEVENT_SOURCE = eINSTANCE.getIEventSource();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.TimewindowImpl <em>Timewindow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.TimewindowImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getTimewindow()
		 * @generated
		 */
		EClass TIMEWINDOW = eINSTANCE.getTimewindow();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMEWINDOW__LENGTH = eINSTANCE.getTimewindow_Length();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.PartialTimewindowImpl <em>Partial Timewindow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.PartialTimewindowImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getPartialTimewindow()
		 * @generated
		 */
		EClass PARTIAL_TIMEWINDOW = eINSTANCE.getPartialTimewindow();

		/**
		 * The meta object literal for the '<em><b>Stop Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_TIMEWINDOW__STOP_EVENT = eINSTANCE.getPartialTimewindow_StopEvent();

		/**
		 * The meta object literal for the '<em><b>Check Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_TIMEWINDOW__CHECK_EVENTS = eINSTANCE.getPartialTimewindow_CheckEvents();

		/**
		 * The meta object literal for the '<em><b>Start Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_TIMEWINDOW__START_EVENT = eINSTANCE.getPartialTimewindow_StartEvent();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.impl.GlobalTimewindowImpl <em>Global Timewindow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.GlobalTimewindowImpl
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getGlobalTimewindow()
		 * @generated
		 */
		EClass GLOBAL_TIMEWINDOW = eINSTANCE.getGlobalTimewindow();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator <em>Complex Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator
		 * @see hu.bme.mit.incquery.cep.metamodels.cep.impl.CepPackageImpl#getComplexOperator()
		 * @generated
		 */
		EEnum COMPLEX_OPERATOR = eINSTANCE.getComplexOperator();

	}

} //CepPackage
