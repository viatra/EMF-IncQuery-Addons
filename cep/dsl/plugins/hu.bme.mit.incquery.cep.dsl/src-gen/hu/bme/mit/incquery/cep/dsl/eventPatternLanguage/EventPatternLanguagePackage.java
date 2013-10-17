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
   * The feature id for the '<em><b>Packaged Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL__PACKAGED_MODEL = 0;

  /**
   * The number of structural features of the '<em>Event Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PackagedModelImpl <em>Packaged Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PackagedModelImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getPackagedModel()
   * @generated
   */
  int PACKAGED_MODEL = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGED_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Usages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGED_MODEL__USAGES = 1;

  /**
   * The feature id for the '<em><b>Model Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGED_MODEL__MODEL_ELEMENTS = 2;

  /**
   * The number of structural features of the '<em>Packaged Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGED_MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.UsageImpl <em>Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.UsageImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getUsage()
   * @generated
   */
  int USAGE = 2;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ModelElementImpl <em>Model Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ModelElementImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getModelElement()
   * @generated
   */
  int MODEL_ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Model Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternImpl <em>Event Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventPattern()
   * @generated
   */
  int EVENT_PATTERN = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PATTERN__NAME = MODEL_ELEMENT__NAME;

  /**
   * The number of structural features of the '<em>Event Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PATTERN_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AbstractAtomicEventPatternImpl <em>Abstract Atomic Event Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AbstractAtomicEventPatternImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAbstractAtomicEventPattern()
   * @generated
   */
  int ABSTRACT_ATOMIC_EVENT_PATTERN = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATOMIC_EVENT_PATTERN__NAME = EVENT_PATTERN__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATOMIC_EVENT_PATTERN__PARAMETERS = EVENT_PATTERN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Atomic Event Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ATOMIC_EVENT_PATTERN_FEATURE_COUNT = EVENT_PATTERN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventPatternImpl <em>Atomic Event Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventPatternImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAtomicEventPattern()
   * @generated
   */
  int ATOMIC_EVENT_PATTERN = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT_PATTERN__NAME = ABSTRACT_ATOMIC_EVENT_PATTERN__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT_PATTERN__PARAMETERS = ABSTRACT_ATOMIC_EVENT_PATTERN__PARAMETERS;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT_PATTERN__SOURCE = ABSTRACT_ATOMIC_EVENT_PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Static Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT_PATTERN__STATIC_BINDINGS = ABSTRACT_ATOMIC_EVENT_PATTERN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Atomic Event Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_EVENT_PATTERN_FEATURE_COUNT = ABSTRACT_ATOMIC_EVENT_PATTERN_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventPatternImpl <em>IQ Pattern Event Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventPatternImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getIQPatternEventPattern()
   * @generated
   */
  int IQ_PATTERN_EVENT_PATTERN = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT_PATTERN__NAME = ABSTRACT_ATOMIC_EVENT_PATTERN__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT_PATTERN__PARAMETERS = ABSTRACT_ATOMIC_EVENT_PATTERN__PARAMETERS;

  /**
   * The feature id for the '<em><b>Iq Pattern Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF = ABSTRACT_ATOMIC_EVENT_PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Iq Change Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT_PATTERN__IQ_CHANGE_TYPE = ABSTRACT_ATOMIC_EVENT_PATTERN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>IQ Pattern Event Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IQ_PATTERN_EVENT_PATTERN_FEATURE_COUNT = ABSTRACT_ATOMIC_EVENT_PATTERN_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventPatternImpl <em>Complex Event Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventPatternImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getComplexEventPattern()
   * @generated
   */
  int COMPLEX_EVENT_PATTERN = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_PATTERN__NAME = EVENT_PATTERN__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_PATTERN__PARAMETERS = EVENT_PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_PATTERN__PRIORITY = EVENT_PATTERN_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Complex Event Expressions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSIONS = EVENT_PATTERN_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Complex Event Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_PATTERN_FEATURE_COUNT = EVENT_PATTERN_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RuleImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getRule()
   * @generated
   */
  int RULE = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Event Patterns</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__EVENT_PATTERNS = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__ACTION = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OnAppearRuleImpl <em>On Appear Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OnAppearRuleImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getOnAppearRule()
   * @generated
   */
  int ON_APPEAR_RULE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ON_APPEAR_RULE__NAME = RULE__NAME;

  /**
   * The feature id for the '<em><b>Event Patterns</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ON_APPEAR_RULE__EVENT_PATTERNS = RULE__EVENT_PATTERNS;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ON_APPEAR_RULE__ACTION = RULE__ACTION;

  /**
   * The number of structural features of the '<em>On Appear Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ON_APPEAR_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FailDiagnosticRuleImpl <em>Fail Diagnostic Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FailDiagnosticRuleImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFailDiagnosticRule()
   * @generated
   */
  int FAIL_DIAGNOSTIC_RULE = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_DIAGNOSTIC_RULE__NAME = RULE__NAME;

  /**
   * The feature id for the '<em><b>Event Patterns</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_DIAGNOSTIC_RULE__EVENT_PATTERNS = RULE__EVENT_PATTERNS;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_DIAGNOSTIC_RULE__ACTION = RULE__ACTION;

  /**
   * The number of structural features of the '<em>Fail Diagnostic Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_DIAGNOSTIC_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TypedParameterListImpl <em>Typed Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TypedParameterListImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTypedParameterList()
   * @generated
   */
  int TYPED_PARAMETER_LIST = 12;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_PARAMETER_LIST__PARAMETERS = 0;

  /**
   * The number of structural features of the '<em>Typed Parameter List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_PARAMETER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TypedParameterImpl <em>Typed Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TypedParameterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTypedParameter()
   * @generated
   */
  int TYPED_PARAMETER = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_PARAMETER__TYPE = 1;

  /**
   * The number of structural features of the '<em>Typed Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternParameterListImpl <em>Event Pattern Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternParameterListImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventPatternParameterList()
   * @generated
   */
  int EVENT_PATTERN_PARAMETER_LIST = 14;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PATTERN_PARAMETER_LIST__PARAMETERS = 0;

  /**
   * The number of structural features of the '<em>Event Pattern Parameter List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PATTERN_PARAMETER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterImpl <em>Event Typed Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventTypedParameter()
   * @generated
   */
  int EVENT_TYPED_PARAMETER = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPED_PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPED_PARAMETER__TYPE = 1;

  /**
   * The number of structural features of the '<em>Event Typed Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPED_PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParametrizedIncQueryPatternReferenceImpl <em>Parametrized Inc Query Pattern Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParametrizedIncQueryPatternReferenceImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getParametrizedIncQueryPatternReference()
   * @generated
   */
  int PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE = 16;

  /**
   * The feature id for the '<em><b>Iqpattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN = 0;

  /**
   * The feature id for the '<em><b>Parameter List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST = 1;

  /**
   * The number of structural features of the '<em>Parametrized Inc Query Pattern Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.MultiplicityImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getMultiplicity()
   * @generated
   */
  int MULTIPLICITY = 17;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__MULTIPLICITY = 0;

  /**
   * The number of structural features of the '<em>Multiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimewindowImpl <em>Timewindow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimewindowImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTimewindow()
   * @generated
   */
  int TIMEWINDOW = 18;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerEventStructureImpl <em>Follower Event Structure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerEventStructureImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowerEventStructure()
   * @generated
   */
  int FOLLOWER_EVENT_STRUCTURE = 30;

  /**
   * The number of structural features of the '<em>Follower Event Structure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWER_EVENT_STRUCTURE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterWithMultiplicityImpl <em>Event Typed Parameter With Multiplicity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterWithMultiplicityImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventTypedParameterWithMultiplicity()
   * @generated
   */
  int EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY = 19;

  /**
   * The feature id for the '<em><b>Event Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN = FOLLOWER_EVENT_STRUCTURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameter List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST = FOLLOWER_EVENT_STRUCTURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY = FOLLOWER_EVENT_STRUCTURE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Event Typed Parameter With Multiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY_FEATURE_COUNT = FOLLOWER_EVENT_STRUCTURE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PatternCallParameterListImpl <em>Pattern Call Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PatternCallParameterListImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getPatternCallParameterList()
   * @generated
   */
  int PATTERN_CALL_PARAMETER_LIST = 20;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL_PARAMETER_LIST__PARAMETERS = 0;

  /**
   * The number of structural features of the '<em>Pattern Call Parameter List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL_PARAMETER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PatternCallParameterImpl <em>Pattern Call Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PatternCallParameterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getPatternCallParameter()
   * @generated
   */
  int PATTERN_CALL_PARAMETER = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL_PARAMETER__NAME = 0;

  /**
   * The number of structural features of the '<em>Pattern Call Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL_PARAMETER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventExpressionImpl <em>Complex Event Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getComplexEventExpression()
   * @generated
   */
  int COMPLEX_EVENT_EXPRESSION = 22;

  /**
   * The number of structural features of the '<em>Complex Event Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AugmentedExpressionImpl <em>Augmented Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AugmentedExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAugmentedExpression()
   * @generated
   */
  int AUGMENTED_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUGMENTED_EXPRESSION__EXPRESSION = COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Augmented Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUGMENTED_EXPRESSION_FEATURE_COUNT = COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedExpressionImpl <em>Timed Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTimedExpression()
   * @generated
   */
  int TIMED_EXPRESSION = 24;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_EXPRESSION__EXPRESSION = AUGMENTED_EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Timewindow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_EXPRESSION__TIMEWINDOW = AUGMENTED_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Timed Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_EXPRESSION_FEATURE_COUNT = AUGMENTED_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.MultiplicityExpressionImpl <em>Multiplicity Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.MultiplicityExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getMultiplicityExpression()
   * @generated
   */
  int MULTIPLICITY_EXPRESSION = 25;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_EXPRESSION__EXPRESSION = AUGMENTED_EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_EXPRESSION__MULTIPLICITY = AUGMENTED_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Multiplicity Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_EXPRESSION_FEATURE_COUNT = AUGMENTED_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedMultiplicityExpressionImpl <em>Timed Multiplicity Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedMultiplicityExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTimedMultiplicityExpression()
   * @generated
   */
  int TIMED_MULTIPLICITY_EXPRESSION = 26;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_MULTIPLICITY_EXPRESSION__EXPRESSION = AUGMENTED_EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY = AUGMENTED_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Timewindow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW = AUGMENTED_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Timed Multiplicity Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_MULTIPLICITY_EXPRESSION_FEATURE_COUNT = AUGMENTED_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 27;

  /**
   * The feature id for the '<em><b>Event Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EVENT_PATTERNS = COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = COMPLEX_EVENT_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsExpressionImpl <em>Follows Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsExpression()
   * @generated
   */
  int FOLLOWS_EXPRESSION = 28;

  /**
   * The feature id for the '<em><b>Event Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_EXPRESSION__EVENT_PATTERNS = EXPRESSION__EVENT_PATTERNS;

  /**
   * The feature id for the '<em><b>Follower Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Follows Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerExpressionImpl <em>Follower Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowerExpression()
   * @generated
   */
  int FOLLOWER_EXPRESSION = 29;

  /**
   * The feature id for the '<em><b>Follows Operator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Event Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWER_EXPRESSION__EVENT_PATTERN = 1;

  /**
   * The number of structural features of the '<em>Follower Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOLLOWER_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.InnerBranchExpressionImpl <em>Inner Branch Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.InnerBranchExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getInnerBranchExpression()
   * @generated
   */
  int INNER_BRANCH_EXPRESSION = 31;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INNER_BRANCH_EXPRESSION__EXPRESSION = FOLLOWER_EVENT_STRUCTURE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Inner Branch Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INNER_BRANCH_EXPRESSION_FEATURE_COUNT = FOLLOWER_EVENT_STRUCTURE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.BranchExpressionImpl <em>Branch Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.BranchExpressionImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getBranchExpression()
   * @generated
   */
  int BRANCH_EXPRESSION = 32;

  /**
   * The feature id for the '<em><b>Event Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRANCH_EXPRESSION__EVENT_PATTERNS = EXPRESSION__EVENT_PATTERNS;

  /**
   * The number of structural features of the '<em>Branch Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRANCH_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorImpl <em>Follows Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowsOperatorImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowsOperator()
   * @generated
   */
  int FOLLOWS_OPERATOR = 33;

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
  int FOLLOWS_OPERATOR_NO_TW = 34;

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
  int FOLLOWS_OPERATOR_VIA_TW = 35;

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
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingImpl <em>Static Binding</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getStaticBinding()
   * @generated
   */
  int STATIC_BINDING = 36;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_BINDING__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Binding Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_BINDING__BINDING_RULE = 1;

  /**
   * The number of structural features of the '<em>Static Binding</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_BINDING_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingRuleImpl <em>Static Binding Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingRuleImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getStaticBindingRule()
   * @generated
   */
  int STATIC_BINDING_RULE = 37;

  /**
   * The number of structural features of the '<em>Static Binding Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_BINDING_RULE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeFilterImpl <em>Range Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeFilterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getRangeFilter()
   * @generated
   */
  int RANGE_FILTER = 38;

  /**
   * The feature id for the '<em><b>Neg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FILTER__NEG = STATIC_BINDING_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FILTER__RANGE = STATIC_BINDING_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Range Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FILTER_FEATURE_COUNT = STATIC_BINDING_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeImpl <em>Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RangeImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getRange()
   * @generated
   */
  int RANGE = 39;

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
  int OPEN_OPEN = 40;

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
  int OPEN_CLOSED = 41;

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
  int CLOSED_CLOSED = 42;

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
  int CLOSED_OPEN = 43;

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
  int NUMERIC_FILTER = 44;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_FILTER__OPERATOR = STATIC_BINDING_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_FILTER__VALUE = STATIC_BINDING_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Numeric Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_FILTER_FEATURE_COUNT = STATIC_BINDING_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.LiteralFilterImpl <em>Literal Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.LiteralFilterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getLiteralFilter()
   * @generated
   */
  int LITERAL_FILTER = 45;

  /**
   * The feature id for the '<em><b>Neg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FILTER__NEG = STATIC_BINDING_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FILTER__OPERATOR = STATIC_BINDING_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FILTER__VALUE = STATIC_BINDING_RULE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Literal Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FILTER_FEATURE_COUNT = STATIC_BINDING_RULE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SourceImpl <em>Source</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.SourceImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getSource()
   * @generated
   */
  int SOURCE = 46;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Adapter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__ADAPTER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Source</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AdapterImpl <em>Adapter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AdapterImpl
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAdapter()
   * @generated
   */
  int ADAPTER = 47;

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
  int IQ_PATTERN_CHANGE_TYPE = 48;


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
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getPackagedModel <em>Packaged Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Packaged Model</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel#getPackagedModel()
   * @see #getEventModel()
   * @generated
   */
  EReference getEventModel_PackagedModel();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel <em>Packaged Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Packaged Model</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel
   * @generated
   */
  EClass getPackagedModel();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel#getName()
   * @see #getPackagedModel()
   * @generated
   */
  EAttribute getPackagedModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel#getUsages <em>Usages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Usages</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel#getUsages()
   * @see #getPackagedModel()
   * @generated
   */
  EReference getPackagedModel_Usages();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel#getModelElements <em>Model Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Model Elements</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel#getModelElements()
   * @see #getPackagedModel()
   * @generated
   */
  EReference getPackagedModel_ModelElements();

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
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
   * @generated
   */
  EClass getModelElement();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement#getName()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_Name();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern <em>Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Pattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern
   * @generated
   */
  EClass getEventPattern();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEventPattern <em>Abstract Atomic Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Atomic Event Pattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEventPattern
   * @generated
   */
  EClass getAbstractAtomicEventPattern();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEventPattern#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameters</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEventPattern#getParameters()
   * @see #getAbstractAtomicEventPattern()
   * @generated
   */
  EReference getAbstractAtomicEventPattern_Parameters();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern <em>Atomic Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic Event Pattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern
   * @generated
   */
  EClass getAtomicEventPattern();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern#getSource()
   * @see #getAtomicEventPattern()
   * @generated
   */
  EReference getAtomicEventPattern_Source();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern#getStaticBindings <em>Static Bindings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Static Bindings</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern#getStaticBindings()
   * @see #getAtomicEventPattern()
   * @generated
   */
  EReference getAtomicEventPattern_StaticBindings();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern <em>IQ Pattern Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IQ Pattern Event Pattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern
   * @generated
   */
  EClass getIQPatternEventPattern();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern#getIqPatternRef <em>Iq Pattern Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iq Pattern Ref</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern#getIqPatternRef()
   * @see #getIQPatternEventPattern()
   * @generated
   */
  EReference getIQPatternEventPattern_IqPatternRef();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern#getIqChangeType <em>Iq Change Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Iq Change Type</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern#getIqChangeType()
   * @see #getIQPatternEventPattern()
   * @generated
   */
  EAttribute getIQPatternEventPattern_IqChangeType();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern <em>Complex Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Event Pattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
   * @generated
   */
  EClass getComplexEventPattern();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameters</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getParameters()
   * @see #getComplexEventPattern()
   * @generated
   */
  EReference getComplexEventPattern_Parameters();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getPriority()
   * @see #getComplexEventPattern()
   * @generated
   */
  EAttribute getComplexEventPattern_Priority();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getComplexEventExpressions <em>Complex Event Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Complex Event Expressions</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getComplexEventExpressions()
   * @see #getComplexEventPattern()
   * @generated
   */
  EReference getComplexEventPattern_ComplexEventExpressions();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule
   * @generated
   */
  EClass getRule();

  /**
   * Returns the meta object for the reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule#getEventPatterns <em>Event Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Event Patterns</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule#getEventPatterns()
   * @see #getRule()
   * @generated
   */
  EReference getRule_EventPatterns();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule#getAction()
   * @see #getRule()
   * @generated
   */
  EReference getRule_Action();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OnAppearRule <em>On Appear Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>On Appear Rule</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OnAppearRule
   * @generated
   */
  EClass getOnAppearRule();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FailDiagnosticRule <em>Fail Diagnostic Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fail Diagnostic Rule</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FailDiagnosticRule
   * @generated
   */
  EClass getFailDiagnosticRule();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList <em>Typed Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typed Parameter List</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList
   * @generated
   */
  EClass getTypedParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList#getParameters()
   * @see #getTypedParameterList()
   * @generated
   */
  EReference getTypedParameterList_Parameters();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter <em>Typed Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typed Parameter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter
   * @generated
   */
  EClass getTypedParameter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter#getName()
   * @see #getTypedParameter()
   * @generated
   */
  EAttribute getTypedParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter#getType()
   * @see #getTypedParameter()
   * @generated
   */
  EReference getTypedParameter_Type();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternParameterList <em>Event Pattern Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Pattern Parameter List</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternParameterList
   * @generated
   */
  EClass getEventPatternParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternParameterList#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternParameterList#getParameters()
   * @see #getEventPatternParameterList()
   * @generated
   */
  EReference getEventPatternParameterList_Parameters();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter <em>Event Typed Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Typed Parameter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter
   * @generated
   */
  EClass getEventTypedParameter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter#getName()
   * @see #getEventTypedParameter()
   * @generated
   */
  EAttribute getEventTypedParameter_Name();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter#getType()
   * @see #getEventTypedParameter()
   * @generated
   */
  EReference getEventTypedParameter_Type();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference <em>Parametrized Inc Query Pattern Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parametrized Inc Query Pattern Reference</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference
   * @generated
   */
  EClass getParametrizedIncQueryPatternReference();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference#getIqpattern <em>Iqpattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Iqpattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference#getIqpattern()
   * @see #getParametrizedIncQueryPatternReference()
   * @generated
   */
  EReference getParametrizedIncQueryPatternReference_Iqpattern();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference#getParameterList <em>Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter List</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference#getParameterList()
   * @see #getParametrizedIncQueryPatternReference()
   * @generated
   */
  EReference getParametrizedIncQueryPatternReference_ParameterList();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity
   * @generated
   */
  EClass getMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity#getMultiplicity()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_Multiplicity();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow <em>Timewindow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Timewindow</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow
   * @generated
   */
  EClass getTimewindow();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow#getLength <em>Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Length</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow#getLength()
   * @see #getTimewindow()
   * @generated
   */
  EAttribute getTimewindow_Length();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity <em>Event Typed Parameter With Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Typed Parameter With Multiplicity</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity
   * @generated
   */
  EClass getEventTypedParameterWithMultiplicity();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity#getEventPattern <em>Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event Pattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity#getEventPattern()
   * @see #getEventTypedParameterWithMultiplicity()
   * @generated
   */
  EReference getEventTypedParameterWithMultiplicity_EventPattern();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity#getParameterList <em>Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter List</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity#getParameterList()
   * @see #getEventTypedParameterWithMultiplicity()
   * @generated
   */
  EReference getEventTypedParameterWithMultiplicity_ParameterList();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity#getMultiplicity()
   * @see #getEventTypedParameterWithMultiplicity()
   * @generated
   */
  EReference getEventTypedParameterWithMultiplicity_Multiplicity();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList <em>Pattern Call Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Call Parameter List</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList
   * @generated
   */
  EClass getPatternCallParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList#getParameters()
   * @see #getPatternCallParameterList()
   * @generated
   */
  EReference getPatternCallParameterList_Parameters();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter <em>Pattern Call Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Call Parameter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter
   * @generated
   */
  EClass getPatternCallParameter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter#getName()
   * @see #getPatternCallParameter()
   * @generated
   */
  EAttribute getPatternCallParameter_Name();

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
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression <em>Augmented Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Augmented Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression
   * @generated
   */
  EClass getAugmentedExpression();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression#getExpression()
   * @see #getAugmentedExpression()
   * @generated
   */
  EReference getAugmentedExpression_Expression();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression <em>Timed Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Timed Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression
   * @generated
   */
  EClass getTimedExpression();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression#getTimewindow <em>Timewindow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Timewindow</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression#getTimewindow()
   * @see #getTimedExpression()
   * @generated
   */
  EReference getTimedExpression_Timewindow();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression <em>Multiplicity Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression
   * @generated
   */
  EClass getMultiplicityExpression();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression#getMultiplicity()
   * @see #getMultiplicityExpression()
   * @generated
   */
  EReference getMultiplicityExpression_Multiplicity();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression <em>Timed Multiplicity Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Timed Multiplicity Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression
   * @generated
   */
  EClass getTimedMultiplicityExpression();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression#getMultiplicity()
   * @see #getTimedMultiplicityExpression()
   * @generated
   */
  EReference getTimedMultiplicityExpression_Multiplicity();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression#getTimewindow <em>Timewindow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Timewindow</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression#getTimewindow()
   * @see #getTimedMultiplicityExpression()
   * @generated
   */
  EReference getTimedMultiplicityExpression_Timewindow();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression#getEventPatterns <em>Event Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Event Patterns</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression#getEventPatterns()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_EventPatterns();

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
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression#getFollowerExpressions <em>Follower Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Follower Expressions</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression#getFollowerExpressions()
   * @see #getFollowsExpression()
   * @generated
   */
  EReference getFollowsExpression_FollowerExpressions();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression <em>Follower Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Follower Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression
   * @generated
   */
  EClass getFollowerExpression();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression#getFollowsOperator <em>Follows Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Follows Operator</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression#getFollowsOperator()
   * @see #getFollowerExpression()
   * @generated
   */
  EReference getFollowerExpression_FollowsOperator();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression#getEventPattern <em>Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event Pattern</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression#getEventPattern()
   * @see #getFollowerExpression()
   * @generated
   */
  EReference getFollowerExpression_EventPattern();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerEventStructure <em>Follower Event Structure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Follower Event Structure</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerEventStructure
   * @generated
   */
  EClass getFollowerEventStructure();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.InnerBranchExpression <em>Inner Branch Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inner Branch Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.InnerBranchExpression
   * @generated
   */
  EClass getInnerBranchExpression();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.InnerBranchExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.InnerBranchExpression#getExpression()
   * @see #getInnerBranchExpression()
   * @generated
   */
  EReference getInnerBranchExpression_Expression();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression <em>Branch Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Branch Expression</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression
   * @generated
   */
  EClass getBranchExpression();

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
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding <em>Static Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Static Binding</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding
   * @generated
   */
  EClass getStaticBinding();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding#getParameter()
   * @see #getStaticBinding()
   * @generated
   */
  EReference getStaticBinding_Parameter();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding#getBindingRule <em>Binding Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Binding Rule</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding#getBindingRule()
   * @see #getStaticBinding()
   * @generated
   */
  EReference getStaticBinding_BindingRule();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBindingRule <em>Static Binding Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Static Binding Rule</em>'.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBindingRule
   * @generated
   */
  EClass getStaticBindingRule();

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
     * The meta object literal for the '<em><b>Packaged Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_MODEL__PACKAGED_MODEL = eINSTANCE.getEventModel_PackagedModel();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PackagedModelImpl <em>Packaged Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PackagedModelImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getPackagedModel()
     * @generated
     */
    EClass PACKAGED_MODEL = eINSTANCE.getPackagedModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGED_MODEL__NAME = eINSTANCE.getPackagedModel_Name();

    /**
     * The meta object literal for the '<em><b>Usages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGED_MODEL__USAGES = eINSTANCE.getPackagedModel_Usages();

    /**
     * The meta object literal for the '<em><b>Model Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGED_MODEL__MODEL_ELEMENTS = eINSTANCE.getPackagedModel_ModelElements();

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
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ModelElementImpl <em>Model Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ModelElementImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getModelElement()
     * @generated
     */
    EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternImpl <em>Event Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventPattern()
     * @generated
     */
    EClass EVENT_PATTERN = eINSTANCE.getEventPattern();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AbstractAtomicEventPatternImpl <em>Abstract Atomic Event Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AbstractAtomicEventPatternImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAbstractAtomicEventPattern()
     * @generated
     */
    EClass ABSTRACT_ATOMIC_EVENT_PATTERN = eINSTANCE.getAbstractAtomicEventPattern();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_ATOMIC_EVENT_PATTERN__PARAMETERS = eINSTANCE.getAbstractAtomicEventPattern_Parameters();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventPatternImpl <em>Atomic Event Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AtomicEventPatternImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAtomicEventPattern()
     * @generated
     */
    EClass ATOMIC_EVENT_PATTERN = eINSTANCE.getAtomicEventPattern();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EVENT_PATTERN__SOURCE = eINSTANCE.getAtomicEventPattern_Source();

    /**
     * The meta object literal for the '<em><b>Static Bindings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_EVENT_PATTERN__STATIC_BINDINGS = eINSTANCE.getAtomicEventPattern_StaticBindings();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventPatternImpl <em>IQ Pattern Event Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventPatternImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getIQPatternEventPattern()
     * @generated
     */
    EClass IQ_PATTERN_EVENT_PATTERN = eINSTANCE.getIQPatternEventPattern();

    /**
     * The meta object literal for the '<em><b>Iq Pattern Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF = eINSTANCE.getIQPatternEventPattern_IqPatternRef();

    /**
     * The meta object literal for the '<em><b>Iq Change Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IQ_PATTERN_EVENT_PATTERN__IQ_CHANGE_TYPE = eINSTANCE.getIQPatternEventPattern_IqChangeType();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventPatternImpl <em>Complex Event Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ComplexEventPatternImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getComplexEventPattern()
     * @generated
     */
    EClass COMPLEX_EVENT_PATTERN = eINSTANCE.getComplexEventPattern();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPLEX_EVENT_PATTERN__PARAMETERS = eINSTANCE.getComplexEventPattern_Parameters();

    /**
     * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPLEX_EVENT_PATTERN__PRIORITY = eINSTANCE.getComplexEventPattern_Priority();

    /**
     * The meta object literal for the '<em><b>Complex Event Expressions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSIONS = eINSTANCE.getComplexEventPattern_ComplexEventExpressions();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.RuleImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getRule()
     * @generated
     */
    EClass RULE = eINSTANCE.getRule();

    /**
     * The meta object literal for the '<em><b>Event Patterns</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__EVENT_PATTERNS = eINSTANCE.getRule_EventPatterns();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__ACTION = eINSTANCE.getRule_Action();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OnAppearRuleImpl <em>On Appear Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.OnAppearRuleImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getOnAppearRule()
     * @generated
     */
    EClass ON_APPEAR_RULE = eINSTANCE.getOnAppearRule();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FailDiagnosticRuleImpl <em>Fail Diagnostic Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FailDiagnosticRuleImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFailDiagnosticRule()
     * @generated
     */
    EClass FAIL_DIAGNOSTIC_RULE = eINSTANCE.getFailDiagnosticRule();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TypedParameterListImpl <em>Typed Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TypedParameterListImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTypedParameterList()
     * @generated
     */
    EClass TYPED_PARAMETER_LIST = eINSTANCE.getTypedParameterList();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPED_PARAMETER_LIST__PARAMETERS = eINSTANCE.getTypedParameterList_Parameters();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TypedParameterImpl <em>Typed Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TypedParameterImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTypedParameter()
     * @generated
     */
    EClass TYPED_PARAMETER = eINSTANCE.getTypedParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPED_PARAMETER__NAME = eINSTANCE.getTypedParameter_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPED_PARAMETER__TYPE = eINSTANCE.getTypedParameter_Type();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternParameterListImpl <em>Event Pattern Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternParameterListImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventPatternParameterList()
     * @generated
     */
    EClass EVENT_PATTERN_PARAMETER_LIST = eINSTANCE.getEventPatternParameterList();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_PATTERN_PARAMETER_LIST__PARAMETERS = eINSTANCE.getEventPatternParameterList_Parameters();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterImpl <em>Event Typed Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventTypedParameter()
     * @generated
     */
    EClass EVENT_TYPED_PARAMETER = eINSTANCE.getEventTypedParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_TYPED_PARAMETER__NAME = eINSTANCE.getEventTypedParameter_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_TYPED_PARAMETER__TYPE = eINSTANCE.getEventTypedParameter_Type();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParametrizedIncQueryPatternReferenceImpl <em>Parametrized Inc Query Pattern Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ParametrizedIncQueryPatternReferenceImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getParametrizedIncQueryPatternReference()
     * @generated
     */
    EClass PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE = eINSTANCE.getParametrizedIncQueryPatternReference();

    /**
     * The meta object literal for the '<em><b>Iqpattern</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN = eINSTANCE.getParametrizedIncQueryPatternReference_Iqpattern();

    /**
     * The meta object literal for the '<em><b>Parameter List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST = eINSTANCE.getParametrizedIncQueryPatternReference_ParameterList();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.MultiplicityImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getMultiplicity()
     * @generated
     */
    EClass MULTIPLICITY = eINSTANCE.getMultiplicity();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__MULTIPLICITY = eINSTANCE.getMultiplicity_Multiplicity();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimewindowImpl <em>Timewindow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimewindowImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTimewindow()
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
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterWithMultiplicityImpl <em>Event Typed Parameter With Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventTypedParameterWithMultiplicityImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getEventTypedParameterWithMultiplicity()
     * @generated
     */
    EClass EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY = eINSTANCE.getEventTypedParameterWithMultiplicity();

    /**
     * The meta object literal for the '<em><b>Event Pattern</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN = eINSTANCE.getEventTypedParameterWithMultiplicity_EventPattern();

    /**
     * The meta object literal for the '<em><b>Parameter List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST = eINSTANCE.getEventTypedParameterWithMultiplicity_ParameterList();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY = eINSTANCE.getEventTypedParameterWithMultiplicity_Multiplicity();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PatternCallParameterListImpl <em>Pattern Call Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PatternCallParameterListImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getPatternCallParameterList()
     * @generated
     */
    EClass PATTERN_CALL_PARAMETER_LIST = eINSTANCE.getPatternCallParameterList();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_CALL_PARAMETER_LIST__PARAMETERS = eINSTANCE.getPatternCallParameterList_Parameters();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PatternCallParameterImpl <em>Pattern Call Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.PatternCallParameterImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getPatternCallParameter()
     * @generated
     */
    EClass PATTERN_CALL_PARAMETER = eINSTANCE.getPatternCallParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_CALL_PARAMETER__NAME = eINSTANCE.getPatternCallParameter_Name();

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
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AugmentedExpressionImpl <em>Augmented Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.AugmentedExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getAugmentedExpression()
     * @generated
     */
    EClass AUGMENTED_EXPRESSION = eINSTANCE.getAugmentedExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUGMENTED_EXPRESSION__EXPRESSION = eINSTANCE.getAugmentedExpression_Expression();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedExpressionImpl <em>Timed Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTimedExpression()
     * @generated
     */
    EClass TIMED_EXPRESSION = eINSTANCE.getTimedExpression();

    /**
     * The meta object literal for the '<em><b>Timewindow</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMED_EXPRESSION__TIMEWINDOW = eINSTANCE.getTimedExpression_Timewindow();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.MultiplicityExpressionImpl <em>Multiplicity Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.MultiplicityExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getMultiplicityExpression()
     * @generated
     */
    EClass MULTIPLICITY_EXPRESSION = eINSTANCE.getMultiplicityExpression();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICITY_EXPRESSION__MULTIPLICITY = eINSTANCE.getMultiplicityExpression_Multiplicity();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedMultiplicityExpressionImpl <em>Timed Multiplicity Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.TimedMultiplicityExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getTimedMultiplicityExpression()
     * @generated
     */
    EClass TIMED_MULTIPLICITY_EXPRESSION = eINSTANCE.getTimedMultiplicityExpression();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY = eINSTANCE.getTimedMultiplicityExpression_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Timewindow</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW = eINSTANCE.getTimedMultiplicityExpression_Timewindow();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.ExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Event Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EVENT_PATTERNS = eINSTANCE.getExpression_EventPatterns();

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
     * The meta object literal for the '<em><b>Follower Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS = eINSTANCE.getFollowsExpression_FollowerExpressions();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerExpressionImpl <em>Follower Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowerExpression()
     * @generated
     */
    EClass FOLLOWER_EXPRESSION = eINSTANCE.getFollowerExpression();

    /**
     * The meta object literal for the '<em><b>Follows Operator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR = eINSTANCE.getFollowerExpression_FollowsOperator();

    /**
     * The meta object literal for the '<em><b>Event Pattern</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOLLOWER_EXPRESSION__EVENT_PATTERN = eINSTANCE.getFollowerExpression_EventPattern();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerEventStructureImpl <em>Follower Event Structure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.FollowerEventStructureImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getFollowerEventStructure()
     * @generated
     */
    EClass FOLLOWER_EVENT_STRUCTURE = eINSTANCE.getFollowerEventStructure();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.InnerBranchExpressionImpl <em>Inner Branch Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.InnerBranchExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getInnerBranchExpression()
     * @generated
     */
    EClass INNER_BRANCH_EXPRESSION = eINSTANCE.getInnerBranchExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INNER_BRANCH_EXPRESSION__EXPRESSION = eINSTANCE.getInnerBranchExpression_Expression();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.BranchExpressionImpl <em>Branch Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.BranchExpressionImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getBranchExpression()
     * @generated
     */
    EClass BRANCH_EXPRESSION = eINSTANCE.getBranchExpression();

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
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingImpl <em>Static Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getStaticBinding()
     * @generated
     */
    EClass STATIC_BINDING = eINSTANCE.getStaticBinding();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATIC_BINDING__PARAMETER = eINSTANCE.getStaticBinding_Parameter();

    /**
     * The meta object literal for the '<em><b>Binding Rule</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATIC_BINDING__BINDING_RULE = eINSTANCE.getStaticBinding_BindingRule();

    /**
     * The meta object literal for the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingRuleImpl <em>Static Binding Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.StaticBindingRuleImpl
     * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguagePackageImpl#getStaticBindingRule()
     * @generated
     */
    EClass STATIC_BINDING_RULE = eINSTANCE.getStaticBindingRule();

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

  }

} //EventPatternLanguagePackage
