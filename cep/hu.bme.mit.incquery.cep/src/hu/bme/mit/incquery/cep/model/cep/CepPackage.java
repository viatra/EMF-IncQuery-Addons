/**
 */
package hu.bme.mit.incquery.cep.model.cep;

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
 * @see hu.bme.mit.incquery.cep.model.cep.CepFactory
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
	String eNS_PREFIX = "hu.bme.mit.incquery.cep.emf.metamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CepPackage eINSTANCE = hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.EventProcessingModelImpl <em>Event Processing Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.EventProcessingModelImpl
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getEventProcessingModel()
	 * @generated
	 */
	int EVENT_PROCESSING_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Event Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PROCESSING_MODEL__EVENT_PATTERNS = 0;

	/**
	 * The number of structural features of the '<em>Event Processing Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PROCESSING_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.AbstractEventPatternImpl <em>Abstract Event Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.AbstractEventPatternImpl
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getAbstractEventPattern()
	 * @generated
	 */
	int ABSTRACT_EVENT_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Composition Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS = 0;

	/**
	 * The number of structural features of the '<em>Abstract Event Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EVENT_PATTERN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.AtomicEventPatternImpl <em>Atomic Event Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.AtomicEventPatternImpl
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getAtomicEventPattern()
	 * @generated
	 */
	int ATOMIC_EVENT_PATTERN = 2;

	/**
	 * The feature id for the '<em><b>Composition Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN__COMPOSITION_EVENTS = ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN__TYPE = ABSTRACT_EVENT_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atomic Event Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EVENT_PATTERN_FEATURE_COUNT = ABSTRACT_EVENT_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.ComplexEventPatternImpl <em>Complex Event Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.ComplexEventPatternImpl
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getComplexEventPattern()
	 * @generated
	 */
	int COMPLEX_EVENT_PATTERN = 3;

	/**
	 * The feature id for the '<em><b>Composition Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__COMPOSITION_EVENTS = ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__OPERATOR = ABSTRACT_EVENT_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Timewindow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN__TIMEWINDOW = ABSTRACT_EVENT_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complex Event Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_PATTERN_FEATURE_COUNT = ABSTRACT_EVENT_PATTERN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.EventImpl
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ID = 0;

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
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.model.cep.IEventSource <em>IEvent Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.model.cep.IEventSource
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getIEventSource()
	 * @generated
	 */
	int IEVENT_SOURCE = 5;

	/**
	 * The number of structural features of the '<em>IEvent Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEVENT_SOURCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.TimewindowImpl <em>Timewindow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.TimewindowImpl
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getTimewindow()
	 * @generated
	 */
	int TIMEWINDOW = 6;

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
	 * The meta object id for the '{@link hu.bme.mit.incquery.cep.model.cep.ComplexOperator <em>Complex Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.incquery.cep.model.cep.ComplexOperator
	 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getComplexOperator()
	 * @generated
	 */
	int COMPLEX_OPERATOR = 7;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.model.cep.EventProcessingModel <em>Event Processing Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Processing Model</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.EventProcessingModel
	 * @generated
	 */
	EClass getEventProcessingModel();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.model.cep.EventProcessingModel#getEventPatterns <em>Event Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event Patterns</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.EventProcessingModel#getEventPatterns()
	 * @see #getEventProcessingModel()
	 * @generated
	 */
	EReference getEventProcessingModel_EventPatterns();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern <em>Abstract Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Event Pattern</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern
	 * @generated
	 */
	EClass getAbstractEventPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern#getCompositionEvents <em>Composition Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composition Events</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern#getCompositionEvents()
	 * @see #getAbstractEventPattern()
	 * @generated
	 */
	EReference getAbstractEventPattern_CompositionEvents();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.model.cep.AtomicEventPattern <em>Atomic Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Event Pattern</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.AtomicEventPattern
	 * @generated
	 */
	EClass getAtomicEventPattern();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.model.cep.AtomicEventPattern#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.AtomicEventPattern#getType()
	 * @see #getAtomicEventPattern()
	 * @generated
	 */
	EAttribute getAtomicEventPattern_Type();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern <em>Complex Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Event Pattern</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern
	 * @generated
	 */
	EClass getComplexEventPattern();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern#getOperator()
	 * @see #getComplexEventPattern()
	 * @generated
	 */
	EAttribute getComplexEventPattern_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern#getTimewindow <em>Timewindow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Timewindow</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern#getTimewindow()
	 * @see #getComplexEventPattern()
	 * @generated
	 */
	EReference getComplexEventPattern_Timewindow();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.model.cep.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.model.cep.Event#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.Event#getId()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Id();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.model.cep.Event#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.Event#getTimestamp()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Timestamp();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.model.cep.Event#getEventSource <em>Event Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Source</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.Event#getEventSource()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_EventSource();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.model.cep.IEventSource <em>IEvent Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEvent Source</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.IEventSource
	 * @generated
	 */
	EClass getIEventSource();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.model.cep.Timewindow <em>Timewindow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timewindow</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.Timewindow
	 * @generated
	 */
	EClass getTimewindow();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.model.cep.Timewindow#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.Timewindow#getLength()
	 * @see #getTimewindow()
	 * @generated
	 */
	EAttribute getTimewindow_Length();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.incquery.cep.model.cep.ComplexOperator <em>Complex Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Complex Operator</em>'.
	 * @see hu.bme.mit.incquery.cep.model.cep.ComplexOperator
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
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.EventProcessingModelImpl <em>Event Processing Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.EventProcessingModelImpl
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getEventProcessingModel()
		 * @generated
		 */
		EClass EVENT_PROCESSING_MODEL = eINSTANCE.getEventProcessingModel();

		/**
		 * The meta object literal for the '<em><b>Event Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_PROCESSING_MODEL__EVENT_PATTERNS = eINSTANCE.getEventProcessingModel_EventPatterns();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.AbstractEventPatternImpl <em>Abstract Event Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.AbstractEventPatternImpl
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getAbstractEventPattern()
		 * @generated
		 */
		EClass ABSTRACT_EVENT_PATTERN = eINSTANCE.getAbstractEventPattern();

		/**
		 * The meta object literal for the '<em><b>Composition Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_EVENT_PATTERN__COMPOSITION_EVENTS = eINSTANCE.getAbstractEventPattern_CompositionEvents();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.AtomicEventPatternImpl <em>Atomic Event Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.AtomicEventPatternImpl
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getAtomicEventPattern()
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
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.ComplexEventPatternImpl <em>Complex Event Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.ComplexEventPatternImpl
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getComplexEventPattern()
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
		 * The meta object literal for the '<em><b>Timewindow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT_PATTERN__TIMEWINDOW = eINSTANCE.getComplexEventPattern_Timewindow();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.EventImpl
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__ID = eINSTANCE.getEvent_Id();

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
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.model.cep.IEventSource <em>IEvent Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.model.cep.IEventSource
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getIEventSource()
		 * @generated
		 */
		EClass IEVENT_SOURCE = eINSTANCE.getIEventSource();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.model.cep.impl.TimewindowImpl <em>Timewindow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.TimewindowImpl
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getTimewindow()
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
		 * The meta object literal for the '{@link hu.bme.mit.incquery.cep.model.cep.ComplexOperator <em>Complex Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.incquery.cep.model.cep.ComplexOperator
		 * @see hu.bme.mit.incquery.cep.model.cep.impl.CepPackageImpl#getComplexOperator()
		 * @generated
		 */
		EEnum COMPLEX_OPERATOR = eINSTANCE.getComplexOperator();

	}

} //CepPackage
