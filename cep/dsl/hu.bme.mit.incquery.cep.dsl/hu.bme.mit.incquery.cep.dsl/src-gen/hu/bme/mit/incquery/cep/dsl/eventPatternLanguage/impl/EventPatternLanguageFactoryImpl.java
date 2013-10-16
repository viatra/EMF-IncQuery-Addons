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
      case EventPatternLanguagePackage.USAGE: return createUsage();
      case EventPatternLanguagePackage.IQ_USAGE: return createIQUsage();
      case EventPatternLanguagePackage.EVENT_SOURCE_USAGE: return createEventSourceUsage();
      case EventPatternLanguagePackage.MODEL_ELEMENTS: return createModelElements();
      case EventPatternLanguagePackage.EVENT: return createEvent();
      case EventPatternLanguagePackage.ABSTRACT_ATOMIC_EVENT: return createAbstractAtomicEvent();
      case EventPatternLanguagePackage.ATOMIC_EVENT: return createAtomicEvent();
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT: return createIQPatternEvent();
      case EventPatternLanguagePackage.COMPLEX_EVENT: return createComplexEvent();
      case EventPatternLanguagePackage.RULE: return createRule();
      case EventPatternLanguagePackage.TYPED_PARAMETER_LIST: return createTypedParameterList();
      case EventPatternLanguagePackage.TYPED_PARAMETER: return createTypedParameter();
      case EventPatternLanguagePackage.EVENT_PARAMETER_LIST: return createEventParameterList();
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER: return createEventTypedParameter();
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
      case EventPatternLanguagePackage.COMPLEX_EVENT_EXPRESSION: return createComplexEventExpression();
      case EventPatternLanguagePackage.FOLLOWS_EXPRESSION: return createFollowsExpression();
      case EventPatternLanguagePackage.EVENT_WITH_FOLLOWS_OPERATOR: return createEventWithFollowsOperator();
      case EventPatternLanguagePackage.FOLLOWS_OPERATOR: return createFollowsOperator();
      case EventPatternLanguagePackage.FOLLOWS_OPERATOR_NO_TW: return createFollowsOperatorNoTW();
      case EventPatternLanguagePackage.FOLLOWS_OPERATOR_VIA_TW: return createFollowsOperatorViaTW();
      case EventPatternLanguagePackage.FOLLOWER_EVENT_STRUCTURE: return createFollowerEventStructure();
      case EventPatternLanguagePackage.BRANCH_EXPRESSION: return createBranchExpression();
      case EventPatternLanguagePackage.EVENT_WITH_MULTIPLICITY: return createEventWithMultiplicity();
      case EventPatternLanguagePackage.PATTERN_CALL_PARAMETER_LIST: return createPatternCallParameterList();
      case EventPatternLanguagePackage.PATTERN_CALL_PARAMETER: return createPatternCallParameter();
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
  public IQUsage createIQUsage()
  {
    IQUsageImpl iqUsage = new IQUsageImpl();
    return iqUsage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventSourceUsage createEventSourceUsage()
  {
    EventSourceUsageImpl eventSourceUsage = new EventSourceUsageImpl();
    return eventSourceUsage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElements createModelElements()
  {
    ModelElementsImpl modelElements = new ModelElementsImpl();
    return modelElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event createEvent()
  {
    EventImpl event = new EventImpl();
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractAtomicEvent createAbstractAtomicEvent()
  {
    AbstractAtomicEventImpl abstractAtomicEvent = new AbstractAtomicEventImpl();
    return abstractAtomicEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicEvent createAtomicEvent()
  {
    AtomicEventImpl atomicEvent = new AtomicEventImpl();
    return atomicEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IQPatternEvent createIQPatternEvent()
  {
    IQPatternEventImpl iqPatternEvent = new IQPatternEventImpl();
    return iqPatternEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexEvent createComplexEvent()
  {
    ComplexEventImpl complexEvent = new ComplexEventImpl();
    return complexEvent;
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
  public EventParameterList createEventParameterList()
  {
    EventParameterListImpl eventParameterList = new EventParameterListImpl();
    return eventParameterList;
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
  public EventWithFollowsOperator createEventWithFollowsOperator()
  {
    EventWithFollowsOperatorImpl eventWithFollowsOperator = new EventWithFollowsOperatorImpl();
    return eventWithFollowsOperator;
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
  public FollowsOperatorViaTW createFollowsOperatorViaTW()
  {
    FollowsOperatorViaTWImpl followsOperatorViaTW = new FollowsOperatorViaTWImpl();
    return followsOperatorViaTW;
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
  public EventWithMultiplicity createEventWithMultiplicity()
  {
    EventWithMultiplicityImpl eventWithMultiplicity = new EventWithMultiplicityImpl();
    return eventWithMultiplicity;
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
