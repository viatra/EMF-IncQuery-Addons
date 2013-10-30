/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventPatternLanguageFactoryImpl extends EFactoryImpl implements EventPatternLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EventPatternLanguageFactory init()
  {
    try
    {
      EventPatternLanguageFactory theEventPatternLanguageFactory = (EventPatternLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(EventPatternLanguagePackage.eNS_URI);
      if (theEventPatternLanguageFactory != null)
      {
        return theEventPatternLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EventPatternLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventPatternLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case EventPatternLanguagePackage.EVENT_MODEL: return createEventModel();
      case EventPatternLanguagePackage.PACKAGED_MODEL: return createPackagedModel();
      case EventPatternLanguagePackage.USAGE: return createUsage();
      case EventPatternLanguagePackage.MODEL_ELEMENT: return createModelElement();
      case EventPatternLanguagePackage.EVENT_PATTERN: return createEventPattern();
      case EventPatternLanguagePackage.ABSTRACT_ATOMIC_EVENT_PATTERN: return createAbstractAtomicEventPattern();
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN: return createAtomicEventPattern();
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN: return createIQPatternEventPattern();
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN: return createComplexEventPattern();
      case EventPatternLanguagePackage.RULE: return createRule();
      case EventPatternLanguagePackage.ON_APPEAR_RULE: return createOnAppearRule();
      case EventPatternLanguagePackage.FAIL_DIAGNOSTIC_RULE: return createFailDiagnosticRule();
      case EventPatternLanguagePackage.TYPED_PARAMETER_LIST: return createTypedParameterList();
      case EventPatternLanguagePackage.TYPED_PARAMETER: return createTypedParameter();
      case EventPatternLanguagePackage.EVENT_PATTERN_PARAMETER_LIST: return createEventPatternParameterList();
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER: return createEventTypedParameter();
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE: return createParametrizedIncQueryPatternReference();
      case EventPatternLanguagePackage.MULTIPLICITY: return createMultiplicity();
      case EventPatternLanguagePackage.TIMEWINDOW: return createTimewindow();
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY: return createEventTypedParameterWithMultiplicity();
      case EventPatternLanguagePackage.PATTERN_CALL_PARAMETER_LIST: return createPatternCallParameterList();
      case EventPatternLanguagePackage.PATTERN_CALL_PARAMETER: return createPatternCallParameter();
      case EventPatternLanguagePackage.COMPLEX_EVENT_EXPRESSION: return createComplexEventExpression();
      case EventPatternLanguagePackage.AUGMENTED_EXPRESSION: return createAugmentedExpression();
      case EventPatternLanguagePackage.TIMED_EXPRESSION: return createTimedExpression();
      case EventPatternLanguagePackage.MULTIPLICITY_EXPRESSION: return createMultiplicityExpression();
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION: return createTimedMultiplicityExpression();
      case EventPatternLanguagePackage.EXPRESSION: return createExpression();
      case EventPatternLanguagePackage.FOLLOWS_EXPRESSION: return createFollowsExpression();
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION: return createFollowerExpression();
      case EventPatternLanguagePackage.FOLLOWER_EVENT_STRUCTURE: return createFollowerEventStructure();
      case EventPatternLanguagePackage.INNER_BRANCH_EXPRESSION: return createInnerBranchExpression();
      case EventPatternLanguagePackage.BRANCH_EXPRESSION: return createBranchExpression();
      case EventPatternLanguagePackage.FOLLOWS_OPERATOR: return createFollowsOperator();
      case EventPatternLanguagePackage.FOLLOWS_OPERATOR_NO_TW: return createFollowsOperatorNoTW();
      case EventPatternLanguagePackage.STATIC_BINDING: return createStaticBinding();
      case EventPatternLanguagePackage.STATIC_BINDING_RULE: return createStaticBindingRule();
      case EventPatternLanguagePackage.RANGE_FILTER: return createRangeFilter();
      case EventPatternLanguagePackage.RANGE: return createRange();
      case EventPatternLanguagePackage.OPEN_OPEN: return createOpenOpen();
      case EventPatternLanguagePackage.OPEN_CLOSED: return createOpenClosed();
      case EventPatternLanguagePackage.CLOSED_CLOSED: return createClosedClosed();
      case EventPatternLanguagePackage.CLOSED_OPEN: return createClosedOpen();
      case EventPatternLanguagePackage.NUMERIC_FILTER: return createNumericFilter();
      case EventPatternLanguagePackage.LITERAL_FILTER: return createLiteralFilter();
      case EventPatternLanguagePackage.SOURCE: return createSource();
      case EventPatternLanguagePackage.ADAPTER: return createAdapter();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case EventPatternLanguagePackage.IQ_PATTERN_CHANGE_TYPE:
        return createIQPatternChangeTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case EventPatternLanguagePackage.IQ_PATTERN_CHANGE_TYPE:
        return convertIQPatternChangeTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventModel createEventModel()
  {
    EventModelImpl eventModel = new EventModelImpl();
    return eventModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackagedModel createPackagedModel()
  {
    PackagedModelImpl packagedModel = new PackagedModelImpl();
    return packagedModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Usage createUsage()
  {
    UsageImpl usage = new UsageImpl();
    return usage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement createModelElement()
  {
    ModelElementImpl modelElement = new ModelElementImpl();
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventPattern createEventPattern()
  {
    EventPatternImpl eventPattern = new EventPatternImpl();
    return eventPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractAtomicEventPattern createAbstractAtomicEventPattern()
  {
    AbstractAtomicEventPatternImpl abstractAtomicEventPattern = new AbstractAtomicEventPatternImpl();
    return abstractAtomicEventPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicEventPattern createAtomicEventPattern()
  {
    AtomicEventPatternImpl atomicEventPattern = new AtomicEventPatternImpl();
    return atomicEventPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IQPatternEventPattern createIQPatternEventPattern()
  {
    IQPatternEventPatternImpl iqPatternEventPattern = new IQPatternEventPatternImpl();
    return iqPatternEventPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexEventPattern createComplexEventPattern()
  {
    ComplexEventPatternImpl complexEventPattern = new ComplexEventPatternImpl();
    return complexEventPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule createRule()
  {
    RuleImpl rule = new RuleImpl();
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OnAppearRule createOnAppearRule()
  {
    OnAppearRuleImpl onAppearRule = new OnAppearRuleImpl();
    return onAppearRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailDiagnosticRule createFailDiagnosticRule()
  {
    FailDiagnosticRuleImpl failDiagnosticRule = new FailDiagnosticRuleImpl();
    return failDiagnosticRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedParameterList createTypedParameterList()
  {
    TypedParameterListImpl typedParameterList = new TypedParameterListImpl();
    return typedParameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedParameter createTypedParameter()
  {
    TypedParameterImpl typedParameter = new TypedParameterImpl();
    return typedParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventPatternParameterList createEventPatternParameterList()
  {
    EventPatternParameterListImpl eventPatternParameterList = new EventPatternParameterListImpl();
    return eventPatternParameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventTypedParameter createEventTypedParameter()
  {
    EventTypedParameterImpl eventTypedParameter = new EventTypedParameterImpl();
    return eventTypedParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParametrizedIncQueryPatternReference createParametrizedIncQueryPatternReference()
  {
    ParametrizedIncQueryPatternReferenceImpl parametrizedIncQueryPatternReference = new ParametrizedIncQueryPatternReferenceImpl();
    return parametrizedIncQueryPatternReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiplicity createMultiplicity()
  {
    MultiplicityImpl multiplicity = new MultiplicityImpl();
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Timewindow createTimewindow()
  {
    TimewindowImpl timewindow = new TimewindowImpl();
    return timewindow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventTypedParameterWithMultiplicity createEventTypedParameterWithMultiplicity()
  {
    EventTypedParameterWithMultiplicityImpl eventTypedParameterWithMultiplicity = new EventTypedParameterWithMultiplicityImpl();
    return eventTypedParameterWithMultiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternCallParameterList createPatternCallParameterList()
  {
    PatternCallParameterListImpl patternCallParameterList = new PatternCallParameterListImpl();
    return patternCallParameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternCallParameter createPatternCallParameter()
  {
    PatternCallParameterImpl patternCallParameter = new PatternCallParameterImpl();
    return patternCallParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexEventExpression createComplexEventExpression()
  {
    ComplexEventExpressionImpl complexEventExpression = new ComplexEventExpressionImpl();
    return complexEventExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AugmentedExpression createAugmentedExpression()
  {
    AugmentedExpressionImpl augmentedExpression = new AugmentedExpressionImpl();
    return augmentedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimedExpression createTimedExpression()
  {
    TimedExpressionImpl timedExpression = new TimedExpressionImpl();
    return timedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityExpression createMultiplicityExpression()
  {
    MultiplicityExpressionImpl multiplicityExpression = new MultiplicityExpressionImpl();
    return multiplicityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimedMultiplicityExpression createTimedMultiplicityExpression()
  {
    TimedMultiplicityExpressionImpl timedMultiplicityExpression = new TimedMultiplicityExpressionImpl();
    return timedMultiplicityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowsExpression createFollowsExpression()
  {
    FollowsExpressionImpl followsExpression = new FollowsExpressionImpl();
    return followsExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowerExpression createFollowerExpression()
  {
    FollowerExpressionImpl followerExpression = new FollowerExpressionImpl();
    return followerExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowerEventStructure createFollowerEventStructure()
  {
    FollowerEventStructureImpl followerEventStructure = new FollowerEventStructureImpl();
    return followerEventStructure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InnerBranchExpression createInnerBranchExpression()
  {
    InnerBranchExpressionImpl innerBranchExpression = new InnerBranchExpressionImpl();
    return innerBranchExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BranchExpression createBranchExpression()
  {
    BranchExpressionImpl branchExpression = new BranchExpressionImpl();
    return branchExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowsOperator createFollowsOperator()
  {
    FollowsOperatorImpl followsOperator = new FollowsOperatorImpl();
    return followsOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FollowsOperatorNoTW createFollowsOperatorNoTW()
  {
    FollowsOperatorNoTWImpl followsOperatorNoTW = new FollowsOperatorNoTWImpl();
    return followsOperatorNoTW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StaticBinding createStaticBinding()
  {
    StaticBindingImpl staticBinding = new StaticBindingImpl();
    return staticBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StaticBindingRule createStaticBindingRule()
  {
    StaticBindingRuleImpl staticBindingRule = new StaticBindingRuleImpl();
    return staticBindingRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RangeFilter createRangeFilter()
  {
    RangeFilterImpl rangeFilter = new RangeFilterImpl();
    return rangeFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Range createRange()
  {
    RangeImpl range = new RangeImpl();
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OpenOpen createOpenOpen()
  {
    OpenOpenImpl openOpen = new OpenOpenImpl();
    return openOpen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OpenClosed createOpenClosed()
  {
    OpenClosedImpl openClosed = new OpenClosedImpl();
    return openClosed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClosedClosed createClosedClosed()
  {
    ClosedClosedImpl closedClosed = new ClosedClosedImpl();
    return closedClosed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClosedOpen createClosedOpen()
  {
    ClosedOpenImpl closedOpen = new ClosedOpenImpl();
    return closedOpen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericFilter createNumericFilter()
  {
    NumericFilterImpl numericFilter = new NumericFilterImpl();
    return numericFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralFilter createLiteralFilter()
  {
    LiteralFilterImpl literalFilter = new LiteralFilterImpl();
    return literalFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Source createSource()
  {
    SourceImpl source = new SourceImpl();
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Adapter createAdapter()
  {
    AdapterImpl adapter = new AdapterImpl();
    return adapter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IQPatternChangeType createIQPatternChangeTypeFromString(EDataType eDataType, String initialValue)
  {
    IQPatternChangeType result = IQPatternChangeType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIQPatternChangeTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventPatternLanguagePackage getEventPatternLanguagePackage()
  {
    return (EventPatternLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EventPatternLanguagePackage getPackage()
  {
    return EventPatternLanguagePackage.eINSTANCE;
  }

} //EventPatternLanguageFactoryImpl
