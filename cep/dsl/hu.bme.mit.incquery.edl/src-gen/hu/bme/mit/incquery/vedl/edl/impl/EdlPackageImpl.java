/**
 */
package hu.bme.mit.incquery.vedl.edl.impl;

import hu.bme.mit.incquery.srct.srct.SrctPackage;

import hu.bme.mit.incquery.vedl.edl.AbstractAtomicEvent;
import hu.bme.mit.incquery.vedl.edl.Annotations;
import hu.bme.mit.incquery.vedl.edl.AtomicEvent;
import hu.bme.mit.incquery.vedl.edl.CEParamlist;
import hu.bme.mit.incquery.vedl.edl.ClosedClosed;
import hu.bme.mit.incquery.vedl.edl.ClosedOpen;
import hu.bme.mit.incquery.vedl.edl.ComplexEvent;
import hu.bme.mit.incquery.vedl.edl.ComplexEventExpression;
import hu.bme.mit.incquery.vedl.edl.Context;
import hu.bme.mit.incquery.vedl.edl.ContextAnnotation;
import hu.bme.mit.incquery.vedl.edl.EdlFactory;
import hu.bme.mit.incquery.vedl.edl.EdlPackage;
import hu.bme.mit.incquery.vedl.edl.Event;
import hu.bme.mit.incquery.vedl.edl.EventParamWithType;
import hu.bme.mit.incquery.vedl.edl.EventSourceUsage;
import hu.bme.mit.incquery.vedl.edl.EventWithFollowsOperator;
import hu.bme.mit.incquery.vedl.edl.EventWithMultiplicity;
import hu.bme.mit.incquery.vedl.edl.FollowsExpression;
import hu.bme.mit.incquery.vedl.edl.FollowsOperator;
import hu.bme.mit.incquery.vedl.edl.FollowsOperatorNoTW;
import hu.bme.mit.incquery.vedl.edl.FollowsOperatorViaTW;
import hu.bme.mit.incquery.vedl.edl.IQPatternChangeType;
import hu.bme.mit.incquery.vedl.edl.IQPatternEvent;
import hu.bme.mit.incquery.vedl.edl.IQUsage;
import hu.bme.mit.incquery.vedl.edl.LiteralFilter;
import hu.bme.mit.incquery.vedl.edl.Model;
import hu.bme.mit.incquery.vedl.edl.NumericFilter;
import hu.bme.mit.incquery.vedl.edl.OpenClosed;
import hu.bme.mit.incquery.vedl.edl.OpenOpen;
import hu.bme.mit.incquery.vedl.edl.PackageDeclaration;
import hu.bme.mit.incquery.vedl.edl.ParameterFilter;
import hu.bme.mit.incquery.vedl.edl.ParameterFilterRule;
import hu.bme.mit.incquery.vedl.edl.PriorityAnnotation;
import hu.bme.mit.incquery.vedl.edl.Range;
import hu.bme.mit.incquery.vedl.edl.RangeFilter;
import hu.bme.mit.incquery.vedl.edl.SamplingAnnotation;
import hu.bme.mit.incquery.vedl.edl.Usage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdlPackageImpl extends EPackageImpl implements EdlPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass usageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iqUsageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventSourceUsageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractAtomicEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomicEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iqPatternEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complexEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ceParamlistEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventParamWithTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass samplingAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass priorityAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterFilterRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rangeFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rangeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass openOpenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass openClosedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass closedClosedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass closedOpenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complexEventExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass followsExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventWithFollowsOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass followsOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass followsOperatorNoTWEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass followsOperatorViaTWEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventWithMultiplicityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum iqPatternChangeTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum contextEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see hu.bme.mit.incquery.vedl.edl.EdlPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EdlPackageImpl()
  {
    super(eNS_URI, EdlFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link EdlPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EdlPackage init()
  {
    if (isInited) return (EdlPackage)EPackage.Registry.INSTANCE.getEPackage(EdlPackage.eNS_URI);

    // Obtain or create and register package
    EdlPackageImpl theEdlPackage = (EdlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EdlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EdlPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    SrctPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theEdlPackage.createPackageContents();

    // Initialize created meta-data
    theEdlPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEdlPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EdlPackage.eNS_URI, theEdlPackage);
    return theEdlPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDeclaration()
  {
    return packageDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPackageDeclaration_Name()
  {
    return (EAttribute)packageDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_Usages()
  {
    return (EReference)packageDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_Model()
  {
    return (EReference)packageDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUsage()
  {
    return usageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUsage_ImportedNamespace()
  {
    return (EAttribute)usageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIQUsage()
  {
    return iqUsageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventSourceUsage()
  {
    return eventSourceUsageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Annotations()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Name()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Events()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvent()
  {
    return eventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvent_Name()
  {
    return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractAtomicEvent()
  {
    return abstractAtomicEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtomicEvent()
  {
    return atomicEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicEvent_Annotations()
  {
    return (EReference)atomicEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAtomicEvent_Id()
  {
    return (EAttribute)atomicEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicEvent_Source()
  {
    return (EReference)atomicEventEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicEvent_ParameterFilters()
  {
    return (EReference)atomicEventEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIQPatternEvent()
  {
    return iqPatternEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIQPatternEvent_Iqpattern()
  {
    return (EAttribute)iqPatternEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIQPatternEvent_ChangeType()
  {
    return (EAttribute)iqPatternEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplexEvent()
  {
    return complexEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComplexEvent_Annotations()
  {
    return (EReference)complexEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComplexEvent_Paramlist()
  {
    return (EReference)complexEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComplexEvent_ComplexEventExpressions()
  {
    return (EReference)complexEventEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCEParamlist()
  {
    return ceParamlistEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCEParamlist_Params()
  {
    return (EReference)ceParamlistEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventParamWithType()
  {
    return eventParamWithTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventParamWithType_Name()
  {
    return (EAttribute)eventParamWithTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventParamWithType_Type()
  {
    return (EReference)eventParamWithTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterFilter()
  {
    return parameterFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterFilter_AttributeName()
  {
    return (EAttribute)parameterFilterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterFilter_ParamFilterRule()
  {
    return (EReference)parameterFilterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotations()
  {
    return annotationsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContextAnnotation()
  {
    return contextAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContextAnnotation_Context()
  {
    return (EAttribute)contextAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSamplingAnnotation()
  {
    return samplingAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSamplingAnnotation_Sampling()
  {
    return (EAttribute)samplingAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPriorityAnnotation()
  {
    return priorityAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPriorityAnnotation_Priority()
  {
    return (EAttribute)priorityAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterFilterRule()
  {
    return parameterFilterRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRangeFilter()
  {
    return rangeFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRangeFilter_Neg()
  {
    return (EAttribute)rangeFilterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRangeFilter_Range()
  {
    return (EReference)rangeFilterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRange()
  {
    return rangeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_LowerBound()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_UpperBound()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOpenOpen()
  {
    return openOpenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOpenClosed()
  {
    return openClosedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClosedClosed()
  {
    return closedClosedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClosedOpen()
  {
    return closedOpenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericFilter()
  {
    return numericFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumericFilter_Operator()
  {
    return (EAttribute)numericFilterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumericFilter_Value()
  {
    return (EAttribute)numericFilterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteralFilter()
  {
    return literalFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteralFilter_Neg()
  {
    return (EAttribute)literalFilterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteralFilter_Operator()
  {
    return (EAttribute)literalFilterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteralFilter_Value()
  {
    return (EAttribute)literalFilterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplexEventExpression()
  {
    return complexEventExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFollowsExpression()
  {
    return followsExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFollowsExpression_FirstEvent()
  {
    return (EReference)followsExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFollowsExpression_Events()
  {
    return (EReference)followsExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventWithFollowsOperator()
  {
    return eventWithFollowsOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventWithFollowsOperator_Operator()
  {
    return (EReference)eventWithFollowsOperatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventWithFollowsOperator_Event()
  {
    return (EReference)eventWithFollowsOperatorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFollowsOperator()
  {
    return followsOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFollowsOperatorNoTW()
  {
    return followsOperatorNoTWEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFollowsOperatorViaTW()
  {
    return followsOperatorViaTWEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFollowsOperatorViaTW_Timewindow()
  {
    return (EAttribute)followsOperatorViaTWEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventWithMultiplicity()
  {
    return eventWithMultiplicityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventWithMultiplicity_Event()
  {
    return (EReference)eventWithMultiplicityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventWithMultiplicity_Multiplicity()
  {
    return (EAttribute)eventWithMultiplicityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getIQPatternChangeType()
  {
    return iqPatternChangeTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getContext()
  {
    return contextEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EdlFactory getEdlFactory()
  {
    return (EdlFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    packageDeclarationEClass = createEClass(PACKAGE_DECLARATION);
    createEAttribute(packageDeclarationEClass, PACKAGE_DECLARATION__NAME);
    createEReference(packageDeclarationEClass, PACKAGE_DECLARATION__USAGES);
    createEReference(packageDeclarationEClass, PACKAGE_DECLARATION__MODEL);

    usageEClass = createEClass(USAGE);
    createEAttribute(usageEClass, USAGE__IMPORTED_NAMESPACE);

    iqUsageEClass = createEClass(IQ_USAGE);

    eventSourceUsageEClass = createEClass(EVENT_SOURCE_USAGE);

    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__ANNOTATIONS);
    createEAttribute(modelEClass, MODEL__NAME);
    createEReference(modelEClass, MODEL__EVENTS);

    eventEClass = createEClass(EVENT);
    createEAttribute(eventEClass, EVENT__NAME);

    abstractAtomicEventEClass = createEClass(ABSTRACT_ATOMIC_EVENT);

    atomicEventEClass = createEClass(ATOMIC_EVENT);
    createEReference(atomicEventEClass, ATOMIC_EVENT__ANNOTATIONS);
    createEAttribute(atomicEventEClass, ATOMIC_EVENT__ID);
    createEReference(atomicEventEClass, ATOMIC_EVENT__SOURCE);
    createEReference(atomicEventEClass, ATOMIC_EVENT__PARAMETER_FILTERS);

    iqPatternEventEClass = createEClass(IQ_PATTERN_EVENT);
    createEAttribute(iqPatternEventEClass, IQ_PATTERN_EVENT__IQPATTERN);
    createEAttribute(iqPatternEventEClass, IQ_PATTERN_EVENT__CHANGE_TYPE);

    complexEventEClass = createEClass(COMPLEX_EVENT);
    createEReference(complexEventEClass, COMPLEX_EVENT__ANNOTATIONS);
    createEReference(complexEventEClass, COMPLEX_EVENT__PARAMLIST);
    createEReference(complexEventEClass, COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS);

    ceParamlistEClass = createEClass(CE_PARAMLIST);
    createEReference(ceParamlistEClass, CE_PARAMLIST__PARAMS);

    eventParamWithTypeEClass = createEClass(EVENT_PARAM_WITH_TYPE);
    createEAttribute(eventParamWithTypeEClass, EVENT_PARAM_WITH_TYPE__NAME);
    createEReference(eventParamWithTypeEClass, EVENT_PARAM_WITH_TYPE__TYPE);

    parameterFilterEClass = createEClass(PARAMETER_FILTER);
    createEAttribute(parameterFilterEClass, PARAMETER_FILTER__ATTRIBUTE_NAME);
    createEReference(parameterFilterEClass, PARAMETER_FILTER__PARAM_FILTER_RULE);

    annotationsEClass = createEClass(ANNOTATIONS);

    contextAnnotationEClass = createEClass(CONTEXT_ANNOTATION);
    createEAttribute(contextAnnotationEClass, CONTEXT_ANNOTATION__CONTEXT);

    samplingAnnotationEClass = createEClass(SAMPLING_ANNOTATION);
    createEAttribute(samplingAnnotationEClass, SAMPLING_ANNOTATION__SAMPLING);

    priorityAnnotationEClass = createEClass(PRIORITY_ANNOTATION);
    createEAttribute(priorityAnnotationEClass, PRIORITY_ANNOTATION__PRIORITY);

    parameterFilterRuleEClass = createEClass(PARAMETER_FILTER_RULE);

    rangeFilterEClass = createEClass(RANGE_FILTER);
    createEAttribute(rangeFilterEClass, RANGE_FILTER__NEG);
    createEReference(rangeFilterEClass, RANGE_FILTER__RANGE);

    rangeEClass = createEClass(RANGE);
    createEAttribute(rangeEClass, RANGE__LOWER_BOUND);
    createEAttribute(rangeEClass, RANGE__UPPER_BOUND);

    openOpenEClass = createEClass(OPEN_OPEN);

    openClosedEClass = createEClass(OPEN_CLOSED);

    closedClosedEClass = createEClass(CLOSED_CLOSED);

    closedOpenEClass = createEClass(CLOSED_OPEN);

    numericFilterEClass = createEClass(NUMERIC_FILTER);
    createEAttribute(numericFilterEClass, NUMERIC_FILTER__OPERATOR);
    createEAttribute(numericFilterEClass, NUMERIC_FILTER__VALUE);

    literalFilterEClass = createEClass(LITERAL_FILTER);
    createEAttribute(literalFilterEClass, LITERAL_FILTER__NEG);
    createEAttribute(literalFilterEClass, LITERAL_FILTER__OPERATOR);
    createEAttribute(literalFilterEClass, LITERAL_FILTER__VALUE);

    complexEventExpressionEClass = createEClass(COMPLEX_EVENT_EXPRESSION);

    followsExpressionEClass = createEClass(FOLLOWS_EXPRESSION);
    createEReference(followsExpressionEClass, FOLLOWS_EXPRESSION__FIRST_EVENT);
    createEReference(followsExpressionEClass, FOLLOWS_EXPRESSION__EVENTS);

    eventWithFollowsOperatorEClass = createEClass(EVENT_WITH_FOLLOWS_OPERATOR);
    createEReference(eventWithFollowsOperatorEClass, EVENT_WITH_FOLLOWS_OPERATOR__OPERATOR);
    createEReference(eventWithFollowsOperatorEClass, EVENT_WITH_FOLLOWS_OPERATOR__EVENT);

    followsOperatorEClass = createEClass(FOLLOWS_OPERATOR);

    followsOperatorNoTWEClass = createEClass(FOLLOWS_OPERATOR_NO_TW);

    followsOperatorViaTWEClass = createEClass(FOLLOWS_OPERATOR_VIA_TW);
    createEAttribute(followsOperatorViaTWEClass, FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW);

    eventWithMultiplicityEClass = createEClass(EVENT_WITH_MULTIPLICITY);
    createEReference(eventWithMultiplicityEClass, EVENT_WITH_MULTIPLICITY__EVENT);
    createEAttribute(eventWithMultiplicityEClass, EVENT_WITH_MULTIPLICITY__MULTIPLICITY);

    // Create enums
    iqPatternChangeTypeEEnum = createEEnum(IQ_PATTERN_CHANGE_TYPE);
    contextEEnum = createEEnum(CONTEXT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    SrctPackage theSrctPackage = (SrctPackage)EPackage.Registry.INSTANCE.getEPackage(SrctPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    iqUsageEClass.getESuperTypes().add(this.getUsage());
    eventSourceUsageEClass.getESuperTypes().add(this.getUsage());
    abstractAtomicEventEClass.getESuperTypes().add(this.getEvent());
    atomicEventEClass.getESuperTypes().add(this.getAbstractAtomicEvent());
    iqPatternEventEClass.getESuperTypes().add(this.getAbstractAtomicEvent());
    complexEventEClass.getESuperTypes().add(this.getEvent());
    contextAnnotationEClass.getESuperTypes().add(this.getAnnotations());
    samplingAnnotationEClass.getESuperTypes().add(this.getAnnotations());
    priorityAnnotationEClass.getESuperTypes().add(this.getAnnotations());
    rangeFilterEClass.getESuperTypes().add(this.getParameterFilterRule());
    openOpenEClass.getESuperTypes().add(this.getRange());
    openClosedEClass.getESuperTypes().add(this.getRange());
    closedClosedEClass.getESuperTypes().add(this.getRange());
    closedOpenEClass.getESuperTypes().add(this.getRange());
    numericFilterEClass.getESuperTypes().add(this.getParameterFilterRule());
    literalFilterEClass.getESuperTypes().add(this.getParameterFilterRule());
    followsExpressionEClass.getESuperTypes().add(this.getComplexEventExpression());
    followsOperatorNoTWEClass.getESuperTypes().add(this.getFollowsOperator());
    followsOperatorViaTWEClass.getESuperTypes().add(this.getFollowsOperator());

    // Initialize classes and features; add operations and parameters
    initEClass(packageDeclarationEClass, PackageDeclaration.class, "PackageDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPackageDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDeclaration_Usages(), this.getUsage(), null, "usages", null, 0, -1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDeclaration_Model(), this.getModel(), null, "model", null, 0, 1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(usageEClass, Usage.class, "Usage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUsage_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Usage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iqUsageEClass, IQUsage.class, "IQUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(eventSourceUsageEClass, EventSourceUsage.class, "EventSourceUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Annotations(), this.getAnnotations(), null, "annotations", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Events(), this.getEvent(), null, "events", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEvent_Name(), ecorePackage.getEString(), "name", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractAtomicEventEClass, AbstractAtomicEvent.class, "AbstractAtomicEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(atomicEventEClass, AtomicEvent.class, "AtomicEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtomicEvent_Annotations(), this.getAnnotations(), null, "annotations", null, 0, -1, AtomicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAtomicEvent_Id(), ecorePackage.getEString(), "id", null, 0, 1, AtomicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAtomicEvent_Source(), theSrctPackage.getSource(), null, "source", null, 0, 1, AtomicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAtomicEvent_ParameterFilters(), this.getParameterFilter(), null, "parameterFilters", null, 0, -1, AtomicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iqPatternEventEClass, IQPatternEvent.class, "IQPatternEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIQPatternEvent_Iqpattern(), ecorePackage.getEString(), "iqpattern", null, 0, 1, IQPatternEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIQPatternEvent_ChangeType(), this.getIQPatternChangeType(), "changeType", null, 0, 1, IQPatternEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(complexEventEClass, ComplexEvent.class, "ComplexEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComplexEvent_Annotations(), this.getAnnotations(), null, "annotations", null, 0, -1, ComplexEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComplexEvent_Paramlist(), this.getCEParamlist(), null, "paramlist", null, 0, 1, ComplexEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComplexEvent_ComplexEventExpressions(), this.getComplexEventExpression(), null, "complexEventExpressions", null, 0, -1, ComplexEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ceParamlistEClass, CEParamlist.class, "CEParamlist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCEParamlist_Params(), this.getEventParamWithType(), null, "params", null, 0, -1, CEParamlist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventParamWithTypeEClass, EventParamWithType.class, "EventParamWithType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEventParamWithType_Name(), ecorePackage.getEString(), "name", null, 0, 1, EventParamWithType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventParamWithType_Type(), this.getEvent(), null, "type", null, 0, 1, EventParamWithType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterFilterEClass, ParameterFilter.class, "ParameterFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameterFilter_AttributeName(), ecorePackage.getEString(), "attributeName", null, 0, 1, ParameterFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameterFilter_ParamFilterRule(), this.getParameterFilterRule(), null, "paramFilterRule", null, 0, 1, ParameterFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(annotationsEClass, Annotations.class, "Annotations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(contextAnnotationEClass, ContextAnnotation.class, "ContextAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContextAnnotation_Context(), this.getContext(), "context", null, 0, 1, ContextAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(samplingAnnotationEClass, SamplingAnnotation.class, "SamplingAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSamplingAnnotation_Sampling(), ecorePackage.getEInt(), "sampling", null, 0, 1, SamplingAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(priorityAnnotationEClass, PriorityAnnotation.class, "PriorityAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPriorityAnnotation_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, PriorityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterFilterRuleEClass, ParameterFilterRule.class, "ParameterFilterRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(rangeFilterEClass, RangeFilter.class, "RangeFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRangeFilter_Neg(), ecorePackage.getEString(), "neg", null, 0, 1, RangeFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRangeFilter_Range(), this.getRange(), null, "range", null, 0, 1, RangeFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rangeEClass, Range.class, "Range", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRange_LowerBound(), ecorePackage.getEString(), "lowerBound", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRange_UpperBound(), ecorePackage.getEString(), "upperBound", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(openOpenEClass, OpenOpen.class, "OpenOpen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(openClosedEClass, OpenClosed.class, "OpenClosed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(closedClosedEClass, ClosedClosed.class, "ClosedClosed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(closedOpenEClass, ClosedOpen.class, "ClosedOpen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numericFilterEClass, NumericFilter.class, "NumericFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumericFilter_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, NumericFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNumericFilter_Value(), ecorePackage.getEString(), "value", null, 0, 1, NumericFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalFilterEClass, LiteralFilter.class, "LiteralFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteralFilter_Neg(), ecorePackage.getEString(), "neg", null, 0, 1, LiteralFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLiteralFilter_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, LiteralFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLiteralFilter_Value(), ecorePackage.getEString(), "value", null, 0, 1, LiteralFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(complexEventExpressionEClass, ComplexEventExpression.class, "ComplexEventExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsExpressionEClass, FollowsExpression.class, "FollowsExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFollowsExpression_FirstEvent(), this.getEventWithMultiplicity(), null, "firstEvent", null, 0, -1, FollowsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFollowsExpression_Events(), this.getEventWithFollowsOperator(), null, "events", null, 0, -1, FollowsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventWithFollowsOperatorEClass, EventWithFollowsOperator.class, "EventWithFollowsOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventWithFollowsOperator_Operator(), this.getFollowsOperator(), null, "operator", null, 0, 1, EventWithFollowsOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventWithFollowsOperator_Event(), this.getEventWithMultiplicity(), null, "event", null, 0, 1, EventWithFollowsOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(followsOperatorEClass, FollowsOperator.class, "FollowsOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsOperatorNoTWEClass, FollowsOperatorNoTW.class, "FollowsOperatorNoTW", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsOperatorViaTWEClass, FollowsOperatorViaTW.class, "FollowsOperatorViaTW", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFollowsOperatorViaTW_Timewindow(), ecorePackage.getEInt(), "timewindow", null, 0, 1, FollowsOperatorViaTW.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventWithMultiplicityEClass, EventWithMultiplicity.class, "EventWithMultiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventWithMultiplicity_Event(), this.getEventParamWithType(), null, "event", null, 0, 1, EventWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEventWithMultiplicity_Multiplicity(), ecorePackage.getEInt(), "multiplicity", null, 0, 1, EventWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(iqPatternChangeTypeEEnum, IQPatternChangeType.class, "IQPatternChangeType");
    addEEnumLiteral(iqPatternChangeTypeEEnum, IQPatternChangeType.FOUND);
    addEEnumLiteral(iqPatternChangeTypeEEnum, IQPatternChangeType.LOST);

    initEEnum(contextEEnum, Context.class, "Context");
    addEEnumLiteral(contextEEnum, Context.CHRONICLE);
    addEEnumLiteral(contextEEnum, Context.RECENT);
    addEEnumLiteral(contextEEnum, Context.UNRESTRICTED);

    // Create resource
    createResource(eNS_URI);
  }

} //EdlPackageImpl
