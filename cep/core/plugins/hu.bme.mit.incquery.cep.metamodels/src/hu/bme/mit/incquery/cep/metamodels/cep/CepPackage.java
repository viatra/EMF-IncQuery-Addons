/**
 */
package hu.bme.mit.incquery.cep.metamodels.cep;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
    String eNS_PREFIX = "hu.bme.mit.incquery.cep.metamodels";

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
     * The feature id for the '<em><b>Automaton</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_PATTERN__AUTOMATON = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_PATTERN__ID = 1;

    /**
     * The number of structural features of the '<em>Event Pattern</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_PATTERN_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Event Pattern</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_PATTERN_OPERATION_COUNT = 0;

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
     * The feature id for the '<em><b>Automaton</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATOMIC_EVENT_PATTERN__AUTOMATON = EVENT_PATTERN__AUTOMATON;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATOMIC_EVENT_PATTERN__ID = EVENT_PATTERN__ID;

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
     * The number of operations of the '<em>Atomic Event Pattern</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATOMIC_EVENT_PATTERN_OPERATION_COUNT = EVENT_PATTERN_OPERATION_COUNT + 0;

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
     * The feature id for the '<em><b>Automaton</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPLEX_EVENT_PATTERN__AUTOMATON = EVENT_PATTERN__AUTOMATON;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPLEX_EVENT_PATTERN__ID = EVENT_PATTERN__ID;

    /**
     * The feature id for the '<em><b>Composition Events</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS = EVENT_PATTERN_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Complex Event Pattern</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPLEX_EVENT_PATTERN_FEATURE_COUNT = EVENT_PATTERN_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Add Composition Event Pattern</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPLEX_EVENT_PATTERN___ADD_COMPOSITION_EVENT_PATTERN__EVENTPATTERN = EVENT_PATTERN_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Evaluate Parameter Bindigs</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPLEX_EVENT_PATTERN___EVALUATE_PARAMETER_BINDIGS__EVENT = EVENT_PATTERN_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>Complex Event Pattern</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPLEX_EVENT_PATTERN_OPERATION_COUNT = EVENT_PATTERN_OPERATION_COUNT + 2;

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
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT__SOURCE = 2;

    /**
     * The number of structural features of the '<em>Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_OPERATION_COUNT = 0;

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
     * The operation id for the '<em>Get Id</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEVENT_SOURCE___GET_ID = 0;

    /**
     * The number of operations of the '<em>IEvent Source</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEVENT_SOURCE_OPERATION_COUNT = 1;

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
     * The number of operations of the '<em>Timewindow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMEWINDOW_OPERATION_COUNT = 0;


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
     * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getAutomaton <em>Automaton</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Automaton</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.cep.EventPattern#getAutomaton()
     * @see #getEventPattern()
     * @generated
     */
    EReference getEventPattern_Automaton();

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
     * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getCompositionEvents <em>Composition Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Composition Events</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#getCompositionEvents()
     * @see #getComplexEventPattern()
     * @generated
     */
    EReference getComplexEventPattern_CompositionEvents();

    /**
     * Returns the meta object for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#addCompositionEventPattern(hu.bme.mit.incquery.cep.metamodels.cep.EventPattern) <em>Add Composition Event Pattern</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Add Composition Event Pattern</em>' operation.
     * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#addCompositionEventPattern(hu.bme.mit.incquery.cep.metamodels.cep.EventPattern)
     * @generated
     */
    EOperation getComplexEventPattern__AddCompositionEventPattern__EventPattern();

    /**
     * Returns the meta object for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#evaluateParameterBindigs(hu.bme.mit.incquery.cep.metamodels.cep.Event) <em>Evaluate Parameter Bindigs</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Evaluate Parameter Bindigs</em>' operation.
     * @see hu.bme.mit.incquery.cep.metamodels.cep.ComplexEventPattern#evaluateParameterBindigs(hu.bme.mit.incquery.cep.metamodels.cep.Event)
     * @generated
     */
    EOperation getComplexEventPattern__EvaluateParameterBindigs__Event();

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
     * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.metamodels.cep.Event#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see hu.bme.mit.incquery.cep.metamodels.cep.Event#getSource()
     * @see #getEvent()
     * @generated
     */
    EReference getEvent_Source();

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
     * Returns the meta object for the '{@link hu.bme.mit.incquery.cep.metamodels.cep.IEventSource#getId() <em>Get Id</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Id</em>' operation.
     * @see hu.bme.mit.incquery.cep.metamodels.cep.IEventSource#getId()
     * @generated
     */
    EOperation getIEventSource__GetId();

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
     *   <li>each operation of each class,</li>
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
         * The meta object literal for the '<em><b>Automaton</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EVENT_PATTERN__AUTOMATON = eINSTANCE.getEventPattern_Automaton();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_PATTERN__ID = eINSTANCE.getEventPattern_Id();

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
         * The meta object literal for the '<em><b>Composition Events</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS = eINSTANCE.getComplexEventPattern_CompositionEvents();

        /**
         * The meta object literal for the '<em><b>Add Composition Event Pattern</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation COMPLEX_EVENT_PATTERN___ADD_COMPOSITION_EVENT_PATTERN__EVENTPATTERN = eINSTANCE.getComplexEventPattern__AddCompositionEventPattern__EventPattern();

        /**
         * The meta object literal for the '<em><b>Evaluate Parameter Bindigs</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation COMPLEX_EVENT_PATTERN___EVALUATE_PARAMETER_BINDIGS__EVENT = eINSTANCE.getComplexEventPattern__EvaluateParameterBindigs__Event();

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
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EVENT__SOURCE = eINSTANCE.getEvent_Source();

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
         * The meta object literal for the '<em><b>Get Id</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEVENT_SOURCE___GET_ID = eINSTANCE.getIEventSource__GetId();

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

    }

} //CepPackage
