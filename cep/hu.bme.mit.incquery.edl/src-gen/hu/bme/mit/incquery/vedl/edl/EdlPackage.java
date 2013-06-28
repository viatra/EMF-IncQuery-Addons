/**
 */
package hu.bme.mit.incquery.vedl.edl;

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
 * @see hu.bme.mit.incquery.vedl.edl.EdlFactory
 * @model kind="package"
 * @generated
 */
public interface EdlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "edl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.bme.hu/mit/incquery/vedl/Edl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "edl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EdlPackage eINSTANCE = hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl.init();

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.PackageDeclarationImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getPackageDeclaration()
   * @generated
   */
  int PACKAGE_DECLARATION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Usages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__USAGES = 1;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__MODEL = 2;

  /**
   * The number of structural features of the '<em>Package Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.UsageImpl <em>Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.UsageImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getUsage()
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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.IQUsageImpl <em>IQ Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.IQUsageImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getIQUsage()
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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.EventSourceUsageImpl <em>Event Source Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.EventSourceUsageImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getEventSourceUsage()
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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.ModelImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getModel()
   * @generated
   */
  int MODEL = 4;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ANNOTATIONS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 1;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__EVENTS = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.EventImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getEvent()
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
  int EVENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.AbstractAtomicEventImpl <em>Abstract Atomic Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.AbstractAtomicEventImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getAbstractAtomicEvent()
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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.AtomicEventImpl <em>Atomic Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.AtomicEventImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getAtomicEvent()
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
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT__SOURCE = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT__ID = ABSTRACT_ATOMIC_EVENT_FEATURE_COUNT + 2;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.IQPatternEventImpl <em>IQ Pattern Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.IQPatternEventImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getIQPatternEvent()
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
   * The feature id for the '<em><b>Iqpattern</b></em>' containment reference.
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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ComplexEventImpl <em>Complex Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.ComplexEventImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getComplexEvent()
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
   * The number of structural features of the '<em>Complex Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.CEParamlistImpl <em>CE Paramlist</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.CEParamlistImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getCEParamlist()
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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ParamWithTypeImpl <em>Param With Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.ParamWithTypeImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getParamWithType()
   * @generated
   */
  int PARAM_WITH_TYPE = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_WITH_TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_WITH_TYPE__TYPE = 1;

  /**
   * The number of structural features of the '<em>Param With Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_WITH_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ParameterFilterImpl <em>Parameter Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.ParameterFilterImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getParameterFilter()
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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.IQPatternImpl <em>IQ Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.IQPatternImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getIQPattern()
   * @generated
   */
  int IQ_PATTERN = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN__NAME = 0;

  /**
   * The number of structural features of the '<em>IQ Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.AnnotationsImpl <em>Annotations</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.AnnotationsImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getAnnotations()
   * @generated
   */
  int ANNOTATIONS = 14;

  /**
   * The number of structural features of the '<em>Annotations</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATIONS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ContextAnnotationImpl <em>Context Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.ContextAnnotationImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getContextAnnotation()
   * @generated
   */
  int CONTEXT_ANNOTATION = 15;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.SamplingAnnotationImpl <em>Sampling Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.SamplingAnnotationImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getSamplingAnnotation()
   * @generated
   */
  int SAMPLING_ANNOTATION = 16;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.PriorityAnnotationImpl <em>Priority Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.PriorityAnnotationImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getPriorityAnnotation()
   * @generated
   */
  int PRIORITY_ANNOTATION = 17;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ParameterFilterRuleImpl <em>Parameter Filter Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.ParameterFilterRuleImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getParameterFilterRule()
   * @generated
   */
  int PARAMETER_FILTER_RULE = 18;

  /**
   * The number of structural features of the '<em>Parameter Filter Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FILTER_RULE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.RangeFilterImpl <em>Range Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.RangeFilterImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getRangeFilter()
   * @generated
   */
  int RANGE_FILTER = 19;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.RangeImpl <em>Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.RangeImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getRange()
   * @generated
   */
  int RANGE = 20;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.OpenOpenImpl <em>Open Open</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.OpenOpenImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getOpenOpen()
   * @generated
   */
  int OPEN_OPEN = 21;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.OpenClosedImpl <em>Open Closed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.OpenClosedImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getOpenClosed()
   * @generated
   */
  int OPEN_CLOSED = 22;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ClosedClosedImpl <em>Closed Closed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.ClosedClosedImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getClosedClosed()
   * @generated
   */
  int CLOSED_CLOSED = 23;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ClosedOpenImpl <em>Closed Open</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.ClosedOpenImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getClosedOpen()
   * @generated
   */
  int CLOSED_OPEN = 24;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.NumericFilterImpl <em>Numeric Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.NumericFilterImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getNumericFilter()
   * @generated
   */
  int NUMERIC_FILTER = 25;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.impl.LiteralFilterImpl <em>Literal Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.impl.LiteralFilterImpl
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getLiteralFilter()
   * @generated
   */
  int LITERAL_FILTER = 26;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.IQPatternChangeType <em>IQ Pattern Change Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.IQPatternChangeType
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getIQPatternChangeType()
   * @generated
   */
  int IQ_PATTERN_CHANGE_TYPE = 27;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.vedl.edl.Context <em>Context</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.vedl.edl.Context
   * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 28;


  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Declaration</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.PackageDeclaration
   * @generated
   */
  EClass getPackageDeclaration();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getName()
   * @see #getPackageDeclaration()
   * @generated
   */
  EAttribute getPackageDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getUsages <em>Usages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Usages</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getUsages()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_Usages();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.PackageDeclaration#getModel()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_Model();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.Usage <em>Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Usage</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Usage
   * @generated
   */
  EClass getUsage();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.Usage#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Usage#getImportedNamespace()
   * @see #getUsage()
   * @generated
   */
  EAttribute getUsage_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.IQUsage <em>IQ Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IQ Usage</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.IQUsage
   * @generated
   */
  EClass getIQUsage();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.EventSourceUsage <em>Event Source Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Source Usage</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.EventSourceUsage
   * @generated
   */
  EClass getEventSourceUsage();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.vedl.edl.Model#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Model#getAnnotations()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Annotations();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.vedl.edl.Model#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Model#getEvents()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Events();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.Event#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Event#getName()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Name();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.AbstractAtomicEvent <em>Abstract Atomic Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Atomic Event</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.AbstractAtomicEvent
   * @generated
   */
  EClass getAbstractAtomicEvent();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.AtomicEvent <em>Atomic Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic Event</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.AtomicEvent
   * @generated
   */
  EClass getAtomicEvent();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.vedl.edl.AtomicEvent#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.AtomicEvent#getAnnotations()
   * @see #getAtomicEvent()
   * @generated
   */
  EReference getAtomicEvent_Annotations();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.vedl.edl.AtomicEvent#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.AtomicEvent#getSource()
   * @see #getAtomicEvent()
   * @generated
   */
  EReference getAtomicEvent_Source();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.AtomicEvent#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.AtomicEvent#getId()
   * @see #getAtomicEvent()
   * @generated
   */
  EAttribute getAtomicEvent_Id();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.vedl.edl.AtomicEvent#getParameterFilters <em>Parameter Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Filters</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.AtomicEvent#getParameterFilters()
   * @see #getAtomicEvent()
   * @generated
   */
  EReference getAtomicEvent_ParameterFilters();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.IQPatternEvent <em>IQ Pattern Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IQ Pattern Event</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.IQPatternEvent
   * @generated
   */
  EClass getIQPatternEvent();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.vedl.edl.IQPatternEvent#getIqpattern <em>Iqpattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iqpattern</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.IQPatternEvent#getIqpattern()
   * @see #getIQPatternEvent()
   * @generated
   */
  EReference getIQPatternEvent_Iqpattern();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.IQPatternEvent#getChangeType <em>Change Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Change Type</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.IQPatternEvent#getChangeType()
   * @see #getIQPatternEvent()
   * @generated
   */
  EAttribute getIQPatternEvent_ChangeType();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.ComplexEvent <em>Complex Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Event</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ComplexEvent
   * @generated
   */
  EClass getComplexEvent();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.vedl.edl.ComplexEvent#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ComplexEvent#getAnnotations()
   * @see #getComplexEvent()
   * @generated
   */
  EReference getComplexEvent_Annotations();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.vedl.edl.ComplexEvent#getParamlist <em>Paramlist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Paramlist</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ComplexEvent#getParamlist()
   * @see #getComplexEvent()
   * @generated
   */
  EReference getComplexEvent_Paramlist();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.CEParamlist <em>CE Paramlist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CE Paramlist</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.CEParamlist
   * @generated
   */
  EClass getCEParamlist();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.vedl.edl.CEParamlist#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.CEParamlist#getParams()
   * @see #getCEParamlist()
   * @generated
   */
  EReference getCEParamlist_Params();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.ParamWithType <em>Param With Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param With Type</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ParamWithType
   * @generated
   */
  EClass getParamWithType();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.ParamWithType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ParamWithType#getName()
   * @see #getParamWithType()
   * @generated
   */
  EAttribute getParamWithType_Name();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.vedl.edl.ParamWithType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ParamWithType#getType()
   * @see #getParamWithType()
   * @generated
   */
  EReference getParamWithType_Type();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.ParameterFilter <em>Parameter Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Filter</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ParameterFilter
   * @generated
   */
  EClass getParameterFilter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.ParameterFilter#getAttributeName <em>Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attribute Name</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ParameterFilter#getAttributeName()
   * @see #getParameterFilter()
   * @generated
   */
  EAttribute getParameterFilter_AttributeName();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.vedl.edl.ParameterFilter#getParamFilterRule <em>Param Filter Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param Filter Rule</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ParameterFilter#getParamFilterRule()
   * @see #getParameterFilter()
   * @generated
   */
  EReference getParameterFilter_ParamFilterRule();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.IQPattern <em>IQ Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IQ Pattern</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.IQPattern
   * @generated
   */
  EClass getIQPattern();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.IQPattern#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.IQPattern#getName()
   * @see #getIQPattern()
   * @generated
   */
  EAttribute getIQPattern_Name();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.Annotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotations</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Annotations
   * @generated
   */
  EClass getAnnotations();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.ContextAnnotation <em>Context Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Annotation</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ContextAnnotation
   * @generated
   */
  EClass getContextAnnotation();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.ContextAnnotation#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Context</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ContextAnnotation#getContext()
   * @see #getContextAnnotation()
   * @generated
   */
  EAttribute getContextAnnotation_Context();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.SamplingAnnotation <em>Sampling Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sampling Annotation</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.SamplingAnnotation
   * @generated
   */
  EClass getSamplingAnnotation();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.SamplingAnnotation#getSampling <em>Sampling</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sampling</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.SamplingAnnotation#getSampling()
   * @see #getSamplingAnnotation()
   * @generated
   */
  EAttribute getSamplingAnnotation_Sampling();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.PriorityAnnotation <em>Priority Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Priority Annotation</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.PriorityAnnotation
   * @generated
   */
  EClass getPriorityAnnotation();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.PriorityAnnotation#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.PriorityAnnotation#getPriority()
   * @see #getPriorityAnnotation()
   * @generated
   */
  EAttribute getPriorityAnnotation_Priority();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.ParameterFilterRule <em>Parameter Filter Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Filter Rule</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ParameterFilterRule
   * @generated
   */
  EClass getParameterFilterRule();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.RangeFilter <em>Range Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Filter</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.RangeFilter
   * @generated
   */
  EClass getRangeFilter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.RangeFilter#getNeg <em>Neg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Neg</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.RangeFilter#getNeg()
   * @see #getRangeFilter()
   * @generated
   */
  EAttribute getRangeFilter_Neg();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.vedl.edl.RangeFilter#getRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.RangeFilter#getRange()
   * @see #getRangeFilter()
   * @generated
   */
  EReference getRangeFilter_Range();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Range
   * @generated
   */
  EClass getRange();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.Range#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Range#getLowerBound()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.Range#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Range#getUpperBound()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_UpperBound();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.OpenOpen <em>Open Open</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Open Open</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.OpenOpen
   * @generated
   */
  EClass getOpenOpen();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.OpenClosed <em>Open Closed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Open Closed</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.OpenClosed
   * @generated
   */
  EClass getOpenClosed();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.ClosedClosed <em>Closed Closed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Closed Closed</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ClosedClosed
   * @generated
   */
  EClass getClosedClosed();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.ClosedOpen <em>Closed Open</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Closed Open</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.ClosedOpen
   * @generated
   */
  EClass getClosedOpen();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.NumericFilter <em>Numeric Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Filter</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.NumericFilter
   * @generated
   */
  EClass getNumericFilter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.NumericFilter#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.NumericFilter#getOperator()
   * @see #getNumericFilter()
   * @generated
   */
  EAttribute getNumericFilter_Operator();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.NumericFilter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.NumericFilter#getValue()
   * @see #getNumericFilter()
   * @generated
   */
  EAttribute getNumericFilter_Value();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.vedl.edl.LiteralFilter <em>Literal Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Filter</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.LiteralFilter
   * @generated
   */
  EClass getLiteralFilter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.LiteralFilter#getNeg <em>Neg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Neg</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.LiteralFilter#getNeg()
   * @see #getLiteralFilter()
   * @generated
   */
  EAttribute getLiteralFilter_Neg();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.LiteralFilter#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.LiteralFilter#getOperator()
   * @see #getLiteralFilter()
   * @generated
   */
  EAttribute getLiteralFilter_Operator();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.vedl.edl.LiteralFilter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.LiteralFilter#getValue()
   * @see #getLiteralFilter()
   * @generated
   */
  EAttribute getLiteralFilter_Value();

  /**
   * Returns the meta object for enum '{@link hu.bme.mit.incquery.vedl.edl.IQPatternChangeType <em>IQ Pattern Change Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>IQ Pattern Change Type</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.IQPatternChangeType
   * @generated
   */
  EEnum getIQPatternChangeType();

  /**
   * Returns the meta object for enum '{@link hu.bme.mit.incquery.vedl.edl.Context <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Context</em>'.
   * @see hu.bme.mit.incquery.vedl.edl.Context
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
  EdlFactory getEdlFactory();

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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.PackageDeclarationImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getPackageDeclaration()
     * @generated
     */
    EClass PACKAGE_DECLARATION = eINSTANCE.getPackageDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_DECLARATION__NAME = eINSTANCE.getPackageDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Usages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__USAGES = eINSTANCE.getPackageDeclaration_Usages();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__MODEL = eINSTANCE.getPackageDeclaration_Model();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.UsageImpl <em>Usage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.UsageImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getUsage()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.IQUsageImpl <em>IQ Usage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.IQUsageImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getIQUsage()
     * @generated
     */
    EClass IQ_USAGE = eINSTANCE.getIQUsage();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.EventSourceUsageImpl <em>Event Source Usage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.EventSourceUsageImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getEventSourceUsage()
     * @generated
     */
    EClass EVENT_SOURCE_USAGE = eINSTANCE.getEventSourceUsage();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.ModelImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ANNOTATIONS = eINSTANCE.getModel_Annotations();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__EVENTS = eINSTANCE.getModel_Events();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.EventImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.AbstractAtomicEventImpl <em>Abstract Atomic Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.AbstractAtomicEventImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getAbstractAtomicEvent()
     * @generated
     */
    EClass ABSTRACT_ATOMIC_EVENT = eINSTANCE.getAbstractAtomicEvent();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.AtomicEventImpl <em>Atomic Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.AtomicEventImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getAtomicEvent()
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
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EVENT__SOURCE = eINSTANCE.getAtomicEvent_Source();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOMIC_EVENT__ID = eINSTANCE.getAtomicEvent_Id();

    /**
     * The meta object literal for the '<em><b>Parameter Filters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EVENT__PARAMETER_FILTERS = eINSTANCE.getAtomicEvent_ParameterFilters();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.IQPatternEventImpl <em>IQ Pattern Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.IQPatternEventImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getIQPatternEvent()
     * @generated
     */
    EClass IQ_PATTERN_EVENT = eINSTANCE.getIQPatternEvent();

    /**
     * The meta object literal for the '<em><b>Iqpattern</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IQ_PATTERN_EVENT__IQPATTERN = eINSTANCE.getIQPatternEvent_Iqpattern();

    /**
     * The meta object literal for the '<em><b>Change Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IQ_PATTERN_EVENT__CHANGE_TYPE = eINSTANCE.getIQPatternEvent_ChangeType();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ComplexEventImpl <em>Complex Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.ComplexEventImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getComplexEvent()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.CEParamlistImpl <em>CE Paramlist</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.CEParamlistImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getCEParamlist()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ParamWithTypeImpl <em>Param With Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.ParamWithTypeImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getParamWithType()
     * @generated
     */
    EClass PARAM_WITH_TYPE = eINSTANCE.getParamWithType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM_WITH_TYPE__NAME = eINSTANCE.getParamWithType_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM_WITH_TYPE__TYPE = eINSTANCE.getParamWithType_Type();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ParameterFilterImpl <em>Parameter Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.ParameterFilterImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getParameterFilter()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.IQPatternImpl <em>IQ Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.IQPatternImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getIQPattern()
     * @generated
     */
    EClass IQ_PATTERN = eINSTANCE.getIQPattern();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IQ_PATTERN__NAME = eINSTANCE.getIQPattern_Name();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.AnnotationsImpl <em>Annotations</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.AnnotationsImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getAnnotations()
     * @generated
     */
    EClass ANNOTATIONS = eINSTANCE.getAnnotations();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ContextAnnotationImpl <em>Context Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.ContextAnnotationImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getContextAnnotation()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.SamplingAnnotationImpl <em>Sampling Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.SamplingAnnotationImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getSamplingAnnotation()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.PriorityAnnotationImpl <em>Priority Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.PriorityAnnotationImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getPriorityAnnotation()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ParameterFilterRuleImpl <em>Parameter Filter Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.ParameterFilterRuleImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getParameterFilterRule()
     * @generated
     */
    EClass PARAMETER_FILTER_RULE = eINSTANCE.getParameterFilterRule();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.RangeFilterImpl <em>Range Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.RangeFilterImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getRangeFilter()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.RangeImpl <em>Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.RangeImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getRange()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.OpenOpenImpl <em>Open Open</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.OpenOpenImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getOpenOpen()
     * @generated
     */
    EClass OPEN_OPEN = eINSTANCE.getOpenOpen();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.OpenClosedImpl <em>Open Closed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.OpenClosedImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getOpenClosed()
     * @generated
     */
    EClass OPEN_CLOSED = eINSTANCE.getOpenClosed();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ClosedClosedImpl <em>Closed Closed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.ClosedClosedImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getClosedClosed()
     * @generated
     */
    EClass CLOSED_CLOSED = eINSTANCE.getClosedClosed();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.ClosedOpenImpl <em>Closed Open</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.ClosedOpenImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getClosedOpen()
     * @generated
     */
    EClass CLOSED_OPEN = eINSTANCE.getClosedOpen();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.NumericFilterImpl <em>Numeric Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.NumericFilterImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getNumericFilter()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.impl.LiteralFilterImpl <em>Literal Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.impl.LiteralFilterImpl
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getLiteralFilter()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.IQPatternChangeType <em>IQ Pattern Change Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.IQPatternChangeType
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getIQPatternChangeType()
     * @generated
     */
    EEnum IQ_PATTERN_CHANGE_TYPE = eINSTANCE.getIQPatternChangeType();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.vedl.edl.Context <em>Context</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.vedl.edl.Context
     * @see hu.bme.mit.incquery.vedl.edl.impl.EdlPackageImpl#getContext()
     * @generated
     */
    EEnum CONTEXT = eINSTANCE.getContext();

  }

} //EdlPackage
