/**
 */
package hu.bme.mit.incquery.vedl.edl.impl;

import hu.bme.mit.incquery.vedl.edl.*;

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
public class EdlFactoryImpl extends EFactoryImpl implements EdlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EdlFactory init()
  {
    try
    {
      EdlFactory theEdlFactory = (EdlFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.bme.hu/mit/incquery/vedl/Edl"); 
      if (theEdlFactory != null)
      {
        return theEdlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EdlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EdlFactoryImpl()
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
      case EdlPackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case EdlPackage.USAGE: return createUsage();
      case EdlPackage.IQ_USAGE: return createIQUsage();
      case EdlPackage.EVENT_SOURCE_USAGE: return createEventSourceUsage();
      case EdlPackage.MODEL: return createModel();
      case EdlPackage.EVENT: return createEvent();
      case EdlPackage.ABSTRACT_ATOMIC_EVENT: return createAbstractAtomicEvent();
      case EdlPackage.ATOMIC_EVENT: return createAtomicEvent();
      case EdlPackage.IQ_PATTERN_EVENT: return createIQPatternEvent();
      case EdlPackage.COMPLEX_EVENT: return createComplexEvent();
      case EdlPackage.CE_PARAMLIST: return createCEParamlist();
      case EdlPackage.PARAM_WITH_TYPE: return createParamWithType();
      case EdlPackage.PARAMETER_FILTER: return createParameterFilter();
      case EdlPackage.IQ_PATTERN: return createIQPattern();
      case EdlPackage.ANNOTATIONS: return createAnnotations();
      case EdlPackage.CONTEXT_ANNOTATION: return createContextAnnotation();
      case EdlPackage.SAMPLING_ANNOTATION: return createSamplingAnnotation();
      case EdlPackage.PRIORITY_ANNOTATION: return createPriorityAnnotation();
      case EdlPackage.PARAMETER_FILTER_RULE: return createParameterFilterRule();
      case EdlPackage.RANGE_FILTER: return createRangeFilter();
      case EdlPackage.RANGE: return createRange();
      case EdlPackage.OPEN_OPEN: return createOpenOpen();
      case EdlPackage.OPEN_CLOSED: return createOpenClosed();
      case EdlPackage.CLOSED_CLOSED: return createClosedClosed();
      case EdlPackage.CLOSED_OPEN: return createClosedOpen();
      case EdlPackage.NUMERIC_FILTER: return createNumericFilter();
      case EdlPackage.LITERAL_FILTER: return createLiteralFilter();
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
      case EdlPackage.IQ_PATTERN_CHANGE_TYPE:
        return createIQPatternChangeTypeFromString(eDataType, initialValue);
      case EdlPackage.CONTEXT:
        return createContextFromString(eDataType, initialValue);
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
      case EdlPackage.IQ_PATTERN_CHANGE_TYPE:
        return convertIQPatternChangeTypeToString(eDataType, instanceValue);
      case EdlPackage.CONTEXT:
        return convertContextToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
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
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
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
  public CEParamlist createCEParamlist()
  {
    CEParamlistImpl ceParamlist = new CEParamlistImpl();
    return ceParamlist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParamWithType createParamWithType()
  {
    ParamWithTypeImpl paramWithType = new ParamWithTypeImpl();
    return paramWithType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterFilter createParameterFilter()
  {
    ParameterFilterImpl parameterFilter = new ParameterFilterImpl();
    return parameterFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IQPattern createIQPattern()
  {
    IQPatternImpl iqPattern = new IQPatternImpl();
    return iqPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotations createAnnotations()
  {
    AnnotationsImpl annotations = new AnnotationsImpl();
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextAnnotation createContextAnnotation()
  {
    ContextAnnotationImpl contextAnnotation = new ContextAnnotationImpl();
    return contextAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SamplingAnnotation createSamplingAnnotation()
  {
    SamplingAnnotationImpl samplingAnnotation = new SamplingAnnotationImpl();
    return samplingAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PriorityAnnotation createPriorityAnnotation()
  {
    PriorityAnnotationImpl priorityAnnotation = new PriorityAnnotationImpl();
    return priorityAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterFilterRule createParameterFilterRule()
  {
    ParameterFilterRuleImpl parameterFilterRule = new ParameterFilterRuleImpl();
    return parameterFilterRule;
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
  public Context createContextFromString(EDataType eDataType, String initialValue)
  {
    Context result = Context.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertContextToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EdlPackage getEdlPackage()
  {
    return (EdlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EdlPackage getPackage()
  {
    return EdlPackage.eINSTANCE;
  }

} //EdlFactoryImpl
