/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

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
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface EventPatternLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "eventPatternLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.bme.hu/mit/incquery/cep/dsl/EventPatternLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "eventPatternLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EventPatternLanguagePackage eINSTANCE = hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelImpl <em>Event Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventModel()
   * @generated
   */
  int EVENT_MODEL = 0;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL__PACKAGE_NAME = 0;

  /**
   * The feature id for the '<em><b>Usages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL__USAGES = 1;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL__ANNOTATIONS = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL__NAME = 3;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL__EVENTS = 4;

  /**
   * The number of structural features of the '<em>Event Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.UsageImpl <em>Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.UsageImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getUsage()
   * @generated
   */
  int USAGE = 1;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USAGE__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>Usage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USAGE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQUsageImpl <em>IQ Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQUsageImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getIQUsage()
   * @generated
   */
  int IQ_USAGE = 2;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_USAGE__IMPORTED_NAMESPACE = USAGE__IMPORTED_NAMESPACE;

  /**
   * The number of structural features of the '<em>IQ Usage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_USAGE_FEATURE_COUNT = USAGE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventSourceUsageImpl <em>Event Source Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventSourceUsageImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventSourceUsage()
   * @generated
   */
  int EVENT_SOURCE_USAGE = 3;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_SOURCE_USAGE__IMPORTED_NAMESPACE = USAGE__IMPORTED_NAMESPACE;

  /**
   * The number of structural features of the '<em>Event Source Usage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_SOURCE_USAGE_FEATURE_COUNT = USAGE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelElementsImpl <em>Event Model Elements</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelElementsImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventModelElements()
   * @generated
   */
  int EVENT_MODEL_ELEMENTS = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL_ELEMENTS__NAME = 0;

  /**
   * The number of structural features of the '<em>Event Model Elements</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL_ELEMENTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEvent()
   * @generated
   */
  int EVENT = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__NAME = EVENT_MODEL_ELEMENTS__NAME;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = EVENT_MODEL_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AbstractAtomicEventImpl <em>Abstract Atomic Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AbstractAtomicEventImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAbstractAtomicEvent()
   * @generated
   */
  int ABSTRACT_ATOMIC_EVENT = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATOMIC_EVENT__NAME = EVENT__NAME;

  /**
   * The number of structural features of the '<em>Abstract Atomic Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventImpl <em>Atomic Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAtomicEvent()
   * @generated
   */
  int ATOMIC_EVENT = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT__NAME = ABSTRACT_ATOMIC_EVENT__NAME;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT__ANNOTATIONS = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT__ID = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT__SOURCE = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Parameter Filters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT__PARAMETER_FILTERS = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Atomic Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT_FEATURE_COUNT = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventImpl <em>IQ Pattern Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getIQPatternEvent()
   * @generated
   */
  int IQ_PATTERN_EVENT = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT__NAME = ABSTRACT_ATOMIC_EVENT__NAME;

  /**
   * The feature id for the '<em><b>Iqpattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT__IQPATTERN = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Change Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT__CHANGE_TYPE = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>IQ Pattern Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT_FEATURE_COUNT = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventImpl <em>Complex Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getComplexEvent()
   * @generated
   */
  int COMPLEX_EVENT = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT__NAME = EVENT__NAME;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT__ANNOTATIONS = EVENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Paramlist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT__PARAMLIST = EVENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Complex Event Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS = EVENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Complex Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.CEParamlistImpl <em>CE Paramlist</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.CEParamlistImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getCEParamlist()
   * @generated
   */
  int CE_PARAMLIST = 10;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CE_PARAMLIST__PARAMS = 0;

  /**
   * The number of structural features of the '<em>CE Paramlist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CE_PARAMLIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventParamWithTypeImpl <em>Event Param With Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventParamWithTypeImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventParamWithType()
   * @generated
   */
  int EVENT_PARAM_WITH_TYPE = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PARAM_WITH_TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PARAM_WITH_TYPE__TYPE = 1;

  /**
   * The number of structural features of the '<em>Event Param With Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PARAM_WITH_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterImpl <em>Parameter Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getParameterFilter()
   * @generated
   */
  int PARAMETER_FILTER = 12;

  /**
   * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FILTER__ATTRIBUTE_NAME = 0;

  /**
   * The feature id for the '<em><b>Param Filter Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FILTER__PARAM_FILTER_RULE = 1;

  /**
   * The number of structural features of the '<em>Parameter Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FILTER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AnnotationsImpl <em>Annotations</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AnnotationsImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAnnotations()
   * @generated
   */
  int ANNOTATIONS = 13;

  /**
   * The number of structural features of the '<em>Annotations</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATIONS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ContextAnnotationImpl <em>Context Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ContextAnnotationImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getContextAnnotation()
   * @generated
   */
  int CONTEXT_ANNOTATION = 14;

  /**
   * The feature id for the '<em><b>Context</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ANNOTATION__CONTEXT = ANNOTATIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Context Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ANNOTATION_FEATURE_COUNT = ANNOTATIONS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SamplingAnnotationImpl <em>Sampling Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SamplingAnnotationImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getSamplingAnnotation()
   * @generated
   */
  int SAMPLING_ANNOTATION = 15;

  /**
   * The feature id for the '<em><b>Sampling</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAMPLING_ANNOTATION__SAMPLING = ANNOTATIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Sampling Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAMPLING_ANNOTATION_FEATURE_COUNT = ANNOTATIONS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PriorityAnnotationImpl <em>Priority Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PriorityAnnotationImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getPriorityAnnotation()
   * @generated
   */
  int PRIORITY_ANNOTATION = 16;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_ANNOTATION__PRIORITY = ANNOTATIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Priority Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_ANNOTATION_FEATURE_COUNT = ANNOTATIONS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterRuleImpl <em>Parameter Filter Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterRuleImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getParameterFilterRule()
   * @generated
   */
  int PARAMETER_FILTER_RULE = 17;

  /**
   * The number of structural features of the '<em>Parameter Filter Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FILTER_RULE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeFilterImpl <em>Range Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeFilterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getRangeFilter()
   * @generated
   */
  int RANGE_FILTER = 18;

  /**
   * The feature id for the '<em><b>Neg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FILTER__NEG = PARAMETER_FILTER_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FILTER__RANGE = PARAMETER_FILTER_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Range Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FILTER_FEATURE_COUNT = PARAMETER_FILTER_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeImpl <em>Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getRange()
   * @generated
   */
  int RANGE = 19;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__LOWER_BOUND = 0;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__UPPER_BOUND = 1;

  /**
   * The number of structural features of the '<em>Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OpenOpenImpl <em>Open Open</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OpenOpenImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getOpenOpen()
   * @generated
   */
  int OPEN_OPEN = 20;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_OPEN__LOWER_BOUND = RANGE__LOWER_BOUND;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_OPEN__UPPER_BOUND = RANGE__UPPER_BOUND;

  /**
   * The number of structural features of the '<em>Open Open</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_OPEN_FEATURE_COUNT = RANGE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OpenClosedImpl <em>Open Closed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OpenClosedImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getOpenClosed()
   * @generated
   */
  int OPEN_CLOSED = 21;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_CLOSED__LOWER_BOUND = RANGE__LOWER_BOUND;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_CLOSED__UPPER_BOUND = RANGE__UPPER_BOUND;

  /**
   * The number of structural features of the '<em>Open Closed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_CLOSED_FEATURE_COUNT = RANGE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ClosedClosedImpl <em>Closed Closed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ClosedClosedImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getClosedClosed()
   * @generated
   */
  int CLOSED_CLOSED = 22;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_CLOSED__LOWER_BOUND = RANGE__LOWER_BOUND;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_CLOSED__UPPER_BOUND = RANGE__UPPER_BOUND;

  /**
   * The number of structural features of the '<em>Closed Closed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_CLOSED_FEATURE_COUNT = RANGE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ClosedOpenImpl <em>Closed Open</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ClosedOpenImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getClosedOpen()
   * @generated
   */
  int CLOSED_OPEN = 23;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_OPEN__LOWER_BOUND = RANGE__LOWER_BOUND;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_OPEN__UPPER_BOUND = RANGE__UPPER_BOUND;

  /**
   * The number of structural features of the '<em>Closed Open</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSED_OPEN_FEATURE_COUNT = RANGE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.NumericFilterImpl <em>Numeric Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.NumericFilterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getNumericFilter()
   * @generated
   */
  int NUMERIC_FILTER = 24;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_FILTER__OPERATOR = PARAMETER_FILTER_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_FILTER__VALUE = PARAMETER_FILTER_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Numeric Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_FILTER_FEATURE_COUNT = PARAMETER_FILTER_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.LiteralFilterImpl <em>Literal Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.LiteralFilterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getLiteralFilter()
   * @generated
   */
  int LITERAL_FILTER = 25;

  /**
   * The feature id for the '<em><b>Neg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FILTER__NEG = PARAMETER_FILTER_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FILTER__OPERATOR = PARAMETER_FILTER_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FILTER__VALUE = PARAMETER_FILTER_RULE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Literal Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FILTER_FEATURE_COUNT = PARAMETER_FILTER_RULE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventExpressionImpl <em>Complex Event Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getComplexEventExpression()
   * @generated
   */
  int COMPLEX_EVENT_EXPRESSION = 26;

  /**
   * The number of structural features of the '<em>Complex Event Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsExpressionImpl <em>Follows Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsExpression()
   * @generated
   */
  int FOLLOWS_EXPRESSION = 27;

  /**
   * The feature id for the '<em><b>First Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_EXPRESSION__FIRST_EVENT = COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_EXPRESSION__EVENTS = COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Follows Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_EXPRESSION_FEATURE_COUNT = COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithFollowsOperatorImpl <em>Event With Follows Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithFollowsOperatorImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventWithFollowsOperator()
   * @generated
   */
  int EVENT_WITH_FOLLOWS_OPERATOR = 28;

  /**
   * The feature id for the '<em><b>Operator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_WITH_FOLLOWS_OPERATOR__EVENT = 1;

  /**
   * The number of structural features of the '<em>Event With Follows Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_WITH_FOLLOWS_OPERATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorImpl <em>Follows Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsOperator()
   * @generated
   */
  int FOLLOWS_OPERATOR = 29;

  /**
   * The number of structural features of the '<em>Follows Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_OPERATOR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorNoTWImpl <em>Follows Operator No TW</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorNoTWImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsOperatorNoTW()
   * @generated
   */
  int FOLLOWS_OPERATOR_NO_TW = 30;

  /**
   * The number of structural features of the '<em>Follows Operator No TW</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_OPERATOR_NO_TW_FEATURE_COUNT = FOLLOWS_OPERATOR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorViaTWImpl <em>Follows Operator Via TW</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorViaTWImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsOperatorViaTW()
   * @generated
   */
  int FOLLOWS_OPERATOR_VIA_TW = 31;

  /**
   * The feature id for the '<em><b>Timewindow</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW = FOLLOWS_OPERATOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Follows Operator Via TW</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_OPERATOR_VIA_TW_FEATURE_COUNT = FOLLOWS_OPERATOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithMultiplicityImpl <em>Event With Multiplicity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithMultiplicityImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventWithMultiplicity()
   * @generated
   */
  int EVENT_WITH_MULTIPLICITY = 32;

  /**
   * The feature id for the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_WITH_MULTIPLICITY__EVENT = 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_WITH_MULTIPLICITY__MULTIPLICITY = 1;

  /**
   * The number of structural features of the '<em>Event With Multiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_WITH_MULTIPLICITY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SourceImpl <em>Source</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SourceImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getSource()
   * @generated
   */
  int SOURCE = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__NAME = EVENT_MODEL_ELEMENTS__NAME;

  /**
   * The feature id for the '<em><b>Adapter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__ADAPTER = EVENT_MODEL_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Source</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_FEATURE_COUNT = EVENT_MODEL_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AdapterImpl <em>Adapter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AdapterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAdapter()
   * @generated
   */
  int ADAPTER = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADAPTER__NAME = 0;

  /**
   * The number of structural features of the '<em>Adapter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADAPTER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType <em>IQ Pattern Change Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getIQPatternChangeType()
   * @generated
   */
  int IQ_PATTERN_CHANGE_TYPE = 35;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context <em>Context</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 36;


  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel <em>Event Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Model</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel
   * @generated
   */
  EClass getEventModel();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getPackageName <em>Package Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getPackageName()
   * @see #getEventModel()
   * @generated
   */
  EAttribute getEventModel_PackageName();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getUsages <em>Usages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Usages</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getUsages()
   * @see #getEventModel()
   * @generated
   */
  EReference getEventModel_Usages();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getAnnotations()
   * @see #getEventModel()
   * @generated
   */
  EReference getEventModel_Annotations();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getName()
   * @see #getEventModel()
   * @generated
   */
  EAttribute getEventModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getEvents()
   * @see #getEventModel()
   * @generated
   */
  EReference getEventModel_Events();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage <em>Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Usage</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage
   * @generated
   */
  EClass getUsage();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage#getImportedNamespace()
   * @see #getUsage()
   * @generated
   */
  EAttribute getUsage_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQUsage <em>IQ Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IQ Usage</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQUsage
   * @generated
   */
  EClass getIQUsage();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventSourceUsage <em>Event Source Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Source Usage</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventSourceUsage
   * @generated
   */
  EClass getEventSourceUsage();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModelElements <em>Event Model Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Model Elements</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModelElements
   * @generated
   */
  EClass getEventModelElements();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModelElements#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModelElements#getName()
   * @see #getEventModelElements()
   * @generated
   */
  EAttribute getEventModelElements_Name();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEvent <em>Abstract Atomic Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Atomic Event</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEvent
   * @generated
   */
  EClass getAbstractAtomicEvent();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent <em>Atomic Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic Event</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent
   * @generated
   */
  EClass getAtomicEvent();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent#getAnnotations()
   * @see #getAtomicEvent()
   * @generated
   */
  EReference getAtomicEvent_Annotations();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent#getId()
   * @see #getAtomicEvent()
   * @generated
   */
  EAttribute getAtomicEvent_Id();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent#getSource()
   * @see #getAtomicEvent()
   * @generated
   */
  EReference getAtomicEvent_Source();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent#getParameterFilters <em>Parameter Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Filters</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent#getParameterFilters()
   * @see #getAtomicEvent()
   * @generated
   */
  EReference getAtomicEvent_ParameterFilters();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent <em>IQ Pattern Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IQ Pattern Event</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent
   * @generated
   */
  EClass getIQPatternEvent();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent#getIqpattern <em>Iqpattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Iqpattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent#getIqpattern()
   * @see #getIQPatternEvent()
   * @generated
   */
  EAttribute getIQPatternEvent_Iqpattern();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent#getChangeType <em>Change Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Change Type</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent#getChangeType()
   * @see #getIQPatternEvent()
   * @generated
   */
  EAttribute getIQPatternEvent_ChangeType();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent <em>Complex Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Event</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent
   * @generated
   */
  EClass getComplexEvent();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent#getAnnotations()
   * @see #getComplexEvent()
   * @generated
   */
  EReference getComplexEvent_Annotations();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent#getParamlist <em>Paramlist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Paramlist</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent#getParamlist()
   * @see #getComplexEvent()
   * @generated
   */
  EReference getComplexEvent_Paramlist();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent#getComplexEventExpressions <em>Complex Event Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Complex Event Expressions</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent#getComplexEventExpressions()
   * @see #getComplexEvent()
   * @generated
   */
  EReference getComplexEvent_ComplexEventExpressions();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.CEParamlist <em>CE Paramlist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CE Paramlist</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.CEParamlist
   * @generated
   */
  EClass getCEParamlist();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.CEParamlist#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.CEParamlist#getParams()
   * @see #getCEParamlist()
   * @generated
   */
  EReference getCEParamlist_Params();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType <em>Event Param With Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Param With Type</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType
   * @generated
   */
  EClass getEventParamWithType();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType#getName()
   * @see #getEventParamWithType()
   * @generated
   */
  EAttribute getEventParamWithType_Name();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType#getType()
   * @see #getEventParamWithType()
   * @generated
   */
  EReference getEventParamWithType_Type();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter <em>Parameter Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Filter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter
   * @generated
   */
  EClass getParameterFilter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter#getAttributeName <em>Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attribute Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter#getAttributeName()
   * @see #getParameterFilter()
   * @generated
   */
  EAttribute getParameterFilter_AttributeName();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter#getParamFilterRule <em>Param Filter Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param Filter Rule</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter#getParamFilterRule()
   * @see #getParameterFilter()
   * @generated
   */
  EReference getParameterFilter_ParamFilterRule();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Annotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotations</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Annotations
   * @generated
   */
  EClass getAnnotations();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ContextAnnotation <em>Context Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Annotation</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ContextAnnotation
   * @generated
   */
  EClass getContextAnnotation();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ContextAnnotation#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Context</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ContextAnnotation#getContext()
   * @see #getContextAnnotation()
   * @generated
   */
  EAttribute getContextAnnotation_Context();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.SamplingAnnotation <em>Sampling Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sampling Annotation</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.SamplingAnnotation
   * @generated
   */
  EClass getSamplingAnnotation();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.SamplingAnnotation#getSampling <em>Sampling</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sampling</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.SamplingAnnotation#getSampling()
   * @see #getSamplingAnnotation()
   * @generated
   */
  EAttribute getSamplingAnnotation_Sampling();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PriorityAnnotation <em>Priority Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Priority Annotation</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PriorityAnnotation
   * @generated
   */
  EClass getPriorityAnnotation();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PriorityAnnotation#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PriorityAnnotation#getPriority()
   * @see #getPriorityAnnotation()
   * @generated
   */
  EAttribute getPriorityAnnotation_Priority();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilterRule <em>Parameter Filter Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Filter Rule</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilterRule
   * @generated
   */
  EClass getParameterFilterRule();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter <em>Range Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Filter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter
   * @generated
   */
  EClass getRangeFilter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter#getNeg <em>Neg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Neg</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter#getNeg()
   * @see #getRangeFilter()
   * @generated
   */
  EAttribute getRangeFilter_Neg();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter#getRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter#getRange()
   * @see #getRangeFilter()
   * @generated
   */
  EReference getRangeFilter_Range();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range
   * @generated
   */
  EClass getRange();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range#getLowerBound()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range#getUpperBound()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_UpperBound();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenOpen <em>Open Open</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Open Open</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenOpen
   * @generated
   */
  EClass getOpenOpen();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenClosed <em>Open Closed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Open Closed</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenClosed
   * @generated
   */
  EClass getOpenClosed();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedClosed <em>Closed Closed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Closed Closed</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedClosed
   * @generated
   */
  EClass getClosedClosed();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedOpen <em>Closed Open</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Closed Open</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedOpen
   * @generated
   */
  EClass getClosedOpen();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter <em>Numeric Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Filter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter
   * @generated
   */
  EClass getNumericFilter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter#getOperator()
   * @see #getNumericFilter()
   * @generated
   */
  EAttribute getNumericFilter_Operator();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter#getValue()
   * @see #getNumericFilter()
   * @generated
   */
  EAttribute getNumericFilter_Value();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter <em>Literal Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Filter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter
   * @generated
   */
  EClass getLiteralFilter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter#getNeg <em>Neg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Neg</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter#getNeg()
   * @see #getLiteralFilter()
   * @generated
   */
  EAttribute getLiteralFilter_Neg();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter#getOperator()
   * @see #getLiteralFilter()
   * @generated
   */
  EAttribute getLiteralFilter_Operator();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter#getValue()
   * @see #getLiteralFilter()
   * @generated
   */
  EAttribute getLiteralFilter_Value();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression <em>Complex Event Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Event Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression
   * @generated
   */
  EClass getComplexEventExpression();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression <em>Follows Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Follows Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression
   * @generated
   */
  EClass getFollowsExpression();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression#getFirstEvent <em>First Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>First Event</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression#getFirstEvent()
   * @see #getFollowsExpression()
   * @generated
   */
  EReference getFollowsExpression_FirstEvent();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression#getEvents()
   * @see #getFollowsExpression()
   * @generated
   */
  EReference getFollowsExpression_Events();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator <em>Event With Follows Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event With Follows Operator</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator
   * @generated
   */
  EClass getEventWithFollowsOperator();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operator</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator#getOperator()
   * @see #getEventWithFollowsOperator()
   * @generated
   */
  EReference getEventWithFollowsOperator_Operator();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator#getEvent()
   * @see #getEventWithFollowsOperator()
   * @generated
   */
  EReference getEventWithFollowsOperator_Event();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperator <em>Follows Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Follows Operator</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperator
   * @generated
   */
  EClass getFollowsOperator();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorNoTW <em>Follows Operator No TW</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Follows Operator No TW</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorNoTW
   * @generated
   */
  EClass getFollowsOperatorNoTW();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW <em>Follows Operator Via TW</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Follows Operator Via TW</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW
   * @generated
   */
  EClass getFollowsOperatorViaTW();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW#getTimewindow <em>Timewindow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timewindow</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW#getTimewindow()
   * @see #getFollowsOperatorViaTW()
   * @generated
   */
  EAttribute getFollowsOperatorViaTW_Timewindow();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithMultiplicity <em>Event With Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event With Multiplicity</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithMultiplicity
   * @generated
   */
  EClass getEventWithMultiplicity();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithMultiplicity#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithMultiplicity#getEvent()
   * @see #getEventWithMultiplicity()
   * @generated
   */
  EReference getEventWithMultiplicity_Event();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithMultiplicity#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithMultiplicity#getMultiplicity()
   * @see #getEventWithMultiplicity()
   * @generated
   */
  EAttribute getEventWithMultiplicity_Multiplicity();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source
   * @generated
   */
  EClass getSource();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source#getAdapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Adapter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source#getAdapter()
   * @see #getSource()
   * @generated
   */
  EReference getSource_Adapter();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Adapter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter
   * @generated
   */
  EClass getAdapter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter#getName()
   * @see #getAdapter()
   * @generated
   */
  EAttribute getAdapter_Name();

  /**
   * Returns the meta object for enum '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType <em>IQ Pattern Change Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>IQ Pattern Change Type</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType
   * @generated
   */
  EEnum getIQPatternChangeType();

  /**
   * Returns the meta object for enum '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Context</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context
   * @generated
   */
  EEnum getContext();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EventPatternLanguageFactory getEventPatternLanguageFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelImpl <em>Event Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventModel()
     * @generated
     */
    EClass EVENT_MODEL = eINSTANCE.getEventModel();

    /**
     * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_MODEL__PACKAGE_NAME = eINSTANCE.getEventModel_PackageName();

    /**
     * The meta object literal for the '<em><b>Usages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_MODEL__USAGES = eINSTANCE.getEventModel_Usages();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_MODEL__ANNOTATIONS = eINSTANCE.getEventModel_Annotations();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_MODEL__NAME = eINSTANCE.getEventModel_Name();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_MODEL__EVENTS = eINSTANCE.getEventModel_Events();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.UsageImpl <em>Usage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.UsageImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getUsage()
     * @generated
     */
    EClass USAGE = eINSTANCE.getUsage();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USAGE__IMPORTED_NAMESPACE = eINSTANCE.getUsage_ImportedNamespace();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQUsageImpl <em>IQ Usage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQUsageImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getIQUsage()
     * @generated
     */
    EClass IQ_USAGE = eINSTANCE.getIQUsage();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventSourceUsageImpl <em>Event Source Usage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventSourceUsageImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventSourceUsage()
     * @generated
     */
    EClass EVENT_SOURCE_USAGE = eINSTANCE.getEventSourceUsage();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelElementsImpl <em>Event Model Elements</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventModelElementsImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventModelElements()
     * @generated
     */
    EClass EVENT_MODEL_ELEMENTS = eINSTANCE.getEventModelElements();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_MODEL_ELEMENTS__NAME = eINSTANCE.getEventModelElements_Name();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AbstractAtomicEventImpl <em>Abstract Atomic Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AbstractAtomicEventImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAbstractAtomicEvent()
     * @generated
     */
    EClass ABSTRACT_ATOMIC_EVENT = eINSTANCE.getAbstractAtomicEvent();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventImpl <em>Atomic Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAtomicEvent()
     * @generated
     */
    EClass ATOMIC_EVENT = eINSTANCE.getAtomicEvent();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EVENT__ANNOTATIONS = eINSTANCE.getAtomicEvent_Annotations();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOMIC_EVENT__ID = eINSTANCE.getAtomicEvent_Id();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EVENT__SOURCE = eINSTANCE.getAtomicEvent_Source();

    /**
     * The meta object literal for the '<em><b>Parameter Filters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EVENT__PARAMETER_FILTERS = eINSTANCE.getAtomicEvent_ParameterFilters();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventImpl <em>IQ Pattern Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getIQPatternEvent()
     * @generated
     */
    EClass IQ_PATTERN_EVENT = eINSTANCE.getIQPatternEvent();

    /**
     * The meta object literal for the '<em><b>Iqpattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IQ_PATTERN_EVENT__IQPATTERN = eINSTANCE.getIQPatternEvent_Iqpattern();

    /**
     * The meta object literal for the '<em><b>Change Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IQ_PATTERN_EVENT__CHANGE_TYPE = eINSTANCE.getIQPatternEvent_ChangeType();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventImpl <em>Complex Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getComplexEvent()
     * @generated
     */
    EClass COMPLEX_EVENT = eINSTANCE.getComplexEvent();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPLEX_EVENT__ANNOTATIONS = eINSTANCE.getComplexEvent_Annotations();

    /**
     * The meta object literal for the '<em><b>Paramlist</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPLEX_EVENT__PARAMLIST = eINSTANCE.getComplexEvent_Paramlist();

    /**
     * The meta object literal for the '<em><b>Complex Event Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS = eINSTANCE.getComplexEvent_ComplexEventExpressions();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.CEParamlistImpl <em>CE Paramlist</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.CEParamlistImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getCEParamlist()
     * @generated
     */
    EClass CE_PARAMLIST = eINSTANCE.getCEParamlist();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CE_PARAMLIST__PARAMS = eINSTANCE.getCEParamlist_Params();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventParamWithTypeImpl <em>Event Param With Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventParamWithTypeImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventParamWithType()
     * @generated
     */
    EClass EVENT_PARAM_WITH_TYPE = eINSTANCE.getEventParamWithType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_PARAM_WITH_TYPE__NAME = eINSTANCE.getEventParamWithType_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_PARAM_WITH_TYPE__TYPE = eINSTANCE.getEventParamWithType_Type();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterImpl <em>Parameter Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getParameterFilter()
     * @generated
     */
    EClass PARAMETER_FILTER = eINSTANCE.getParameterFilter();

    /**
     * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_FILTER__ATTRIBUTE_NAME = eINSTANCE.getParameterFilter_AttributeName();

    /**
     * The meta object literal for the '<em><b>Param Filter Rule</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_FILTER__PARAM_FILTER_RULE = eINSTANCE.getParameterFilter_ParamFilterRule();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AnnotationsImpl <em>Annotations</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AnnotationsImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAnnotations()
     * @generated
     */
    EClass ANNOTATIONS = eINSTANCE.getAnnotations();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ContextAnnotationImpl <em>Context Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ContextAnnotationImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getContextAnnotation()
     * @generated
     */
    EClass CONTEXT_ANNOTATION = eINSTANCE.getContextAnnotation();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT_ANNOTATION__CONTEXT = eINSTANCE.getContextAnnotation_Context();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SamplingAnnotationImpl <em>Sampling Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SamplingAnnotationImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getSamplingAnnotation()
     * @generated
     */
    EClass SAMPLING_ANNOTATION = eINSTANCE.getSamplingAnnotation();

    /**
     * The meta object literal for the '<em><b>Sampling</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAMPLING_ANNOTATION__SAMPLING = eINSTANCE.getSamplingAnnotation_Sampling();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PriorityAnnotationImpl <em>Priority Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PriorityAnnotationImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getPriorityAnnotation()
     * @generated
     */
    EClass PRIORITY_ANNOTATION = eINSTANCE.getPriorityAnnotation();

    /**
     * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIORITY_ANNOTATION__PRIORITY = eINSTANCE.getPriorityAnnotation_Priority();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterRuleImpl <em>Parameter Filter Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParameterFilterRuleImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getParameterFilterRule()
     * @generated
     */
    EClass PARAMETER_FILTER_RULE = eINSTANCE.getParameterFilterRule();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeFilterImpl <em>Range Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeFilterImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getRangeFilter()
     * @generated
     */
    EClass RANGE_FILTER = eINSTANCE.getRangeFilter();

    /**
     * The meta object literal for the '<em><b>Neg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE_FILTER__NEG = eINSTANCE.getRangeFilter_Neg();

    /**
     * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE_FILTER__RANGE = eINSTANCE.getRangeFilter_Range();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeImpl <em>Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getRange()
     * @generated
     */
    EClass RANGE = eINSTANCE.getRange();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__LOWER_BOUND = eINSTANCE.getRange_LowerBound();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__UPPER_BOUND = eINSTANCE.getRange_UpperBound();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OpenOpenImpl <em>Open Open</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OpenOpenImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getOpenOpen()
     * @generated
     */
    EClass OPEN_OPEN = eINSTANCE.getOpenOpen();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OpenClosedImpl <em>Open Closed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OpenClosedImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getOpenClosed()
     * @generated
     */
    EClass OPEN_CLOSED = eINSTANCE.getOpenClosed();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ClosedClosedImpl <em>Closed Closed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ClosedClosedImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getClosedClosed()
     * @generated
     */
    EClass CLOSED_CLOSED = eINSTANCE.getClosedClosed();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ClosedOpenImpl <em>Closed Open</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ClosedOpenImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getClosedOpen()
     * @generated
     */
    EClass CLOSED_OPEN = eINSTANCE.getClosedOpen();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.NumericFilterImpl <em>Numeric Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.NumericFilterImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getNumericFilter()
     * @generated
     */
    EClass NUMERIC_FILTER = eINSTANCE.getNumericFilter();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERIC_FILTER__OPERATOR = eINSTANCE.getNumericFilter_Operator();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERIC_FILTER__VALUE = eINSTANCE.getNumericFilter_Value();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.LiteralFilterImpl <em>Literal Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.LiteralFilterImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getLiteralFilter()
     * @generated
     */
    EClass LITERAL_FILTER = eINSTANCE.getLiteralFilter();

    /**
     * The meta object literal for the '<em><b>Neg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_FILTER__NEG = eINSTANCE.getLiteralFilter_Neg();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_FILTER__OPERATOR = eINSTANCE.getLiteralFilter_Operator();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_FILTER__VALUE = eINSTANCE.getLiteralFilter_Value();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventExpressionImpl <em>Complex Event Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getComplexEventExpression()
     * @generated
     */
    EClass COMPLEX_EVENT_EXPRESSION = eINSTANCE.getComplexEventExpression();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsExpressionImpl <em>Follows Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsExpression()
     * @generated
     */
    EClass FOLLOWS_EXPRESSION = eINSTANCE.getFollowsExpression();

    /**
     * The meta object literal for the '<em><b>First Event</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOLLOWS_EXPRESSION__FIRST_EVENT = eINSTANCE.getFollowsExpression_FirstEvent();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOLLOWS_EXPRESSION__EVENTS = eINSTANCE.getFollowsExpression_Events();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithFollowsOperatorImpl <em>Event With Follows Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithFollowsOperatorImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventWithFollowsOperator()
     * @generated
     */
    EClass EVENT_WITH_FOLLOWS_OPERATOR = eINSTANCE.getEventWithFollowsOperator();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR = eINSTANCE.getEventWithFollowsOperator_Operator();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_WITH_FOLLOWS_OPERATOR__EVENT = eINSTANCE.getEventWithFollowsOperator_Event();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorImpl <em>Follows Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsOperator()
     * @generated
     */
    EClass FOLLOWS_OPERATOR = eINSTANCE.getFollowsOperator();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorNoTWImpl <em>Follows Operator No TW</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorNoTWImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsOperatorNoTW()
     * @generated
     */
    EClass FOLLOWS_OPERATOR_NO_TW = eINSTANCE.getFollowsOperatorNoTW();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorViaTWImpl <em>Follows Operator Via TW</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorViaTWImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsOperatorViaTW()
     * @generated
     */
    EClass FOLLOWS_OPERATOR_VIA_TW = eINSTANCE.getFollowsOperatorViaTW();

    /**
     * The meta object literal for the '<em><b>Timewindow</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW = eINSTANCE.getFollowsOperatorViaTW_Timewindow();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithMultiplicityImpl <em>Event With Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventWithMultiplicityImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventWithMultiplicity()
     * @generated
     */
    EClass EVENT_WITH_MULTIPLICITY = eINSTANCE.getEventWithMultiplicity();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_WITH_MULTIPLICITY__EVENT = eINSTANCE.getEventWithMultiplicity_Event();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_WITH_MULTIPLICITY__MULTIPLICITY = eINSTANCE.getEventWithMultiplicity_Multiplicity();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SourceImpl <em>Source</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SourceImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getSource()
     * @generated
     */
    EClass SOURCE = eINSTANCE.getSource();

    /**
     * The meta object literal for the '<em><b>Adapter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOURCE__ADAPTER = eINSTANCE.getSource_Adapter();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AdapterImpl <em>Adapter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AdapterImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAdapter()
     * @generated
     */
    EClass ADAPTER = eINSTANCE.getAdapter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADAPTER__NAME = eINSTANCE.getAdapter_Name();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType <em>IQ Pattern Change Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getIQPatternChangeType()
     * @generated
     */
    EEnum IQ_PATTERN_CHANGE_TYPE = eINSTANCE.getIQPatternChangeType();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context <em>Context</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getContext()
     * @generated
     */
    EEnum CONTEXT = eINSTANCE.getContext();

  }

} //EventPatternLanguagePackage
