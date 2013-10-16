/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEvent;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedClosed;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedOpen;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Event;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParameterList;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguageFactory;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventSourceUsage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerEventStructure;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperator;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorNoTW;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQUsage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElements;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenClosed;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenOpen;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBindingRule;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventPatternLanguagePackageImpl extends EPackageImpl implements EventPatternLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventModelEClass = null;

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
  private EClass modelElementsEClass = null;

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
  private EClass ruleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typedParameterListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typedParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventParameterListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventTypedParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass staticBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass staticBindingRuleEClass = null;

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
  private EClass followerEventStructureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass branchExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventTypedParameterWithMultiplicityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass patternCallParameterListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass patternCallParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sourceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass adapterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum iqPatternChangeTypeEEnum = null;

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
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EventPatternLanguagePackageImpl()
  {
    super(eNS_URI, EventPatternLanguageFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link EventPatternLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EventPatternLanguagePackage init()
  {
    if (isInited) return (EventPatternLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(EventPatternLanguagePackage.eNS_URI);

    // Obtain or create and register package
    EventPatternLanguagePackageImpl theEventPatternLanguagePackage = (EventPatternLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventPatternLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventPatternLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XbasePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theEventPatternLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theEventPatternLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEventPatternLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EventPatternLanguagePackage.eNS_URI, theEventPatternLanguagePackage);
    return theEventPatternLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventModel()
  {
    return eventModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventModel_PackageName()
  {
    return (EAttribute)eventModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventModel_Usages()
  {
    return (EReference)eventModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventModel_Name()
  {
    return (EAttribute)eventModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventModel_Events()
  {
    return (EReference)eventModelEClass.getEStructuralFeatures().get(3);
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
  public EClass getModelElements()
  {
    return modelElementsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelElements_Name()
  {
    return (EAttribute)modelElementsEClass.getEStructuralFeatures().get(0);
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
  public EClass getAbstractAtomicEvent()
  {
    return abstractAtomicEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractAtomicEvent_Parameters()
  {
    return (EReference)abstractAtomicEventEClass.getEStructuralFeatures().get(0);
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
  public EReference getAtomicEvent_Source()
  {
    return (EReference)atomicEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicEvent_StaticBindings()
  {
    return (EReference)atomicEventEClass.getEStructuralFeatures().get(1);
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
  public EReference getComplexEvent_Parameters()
  {
    return (EReference)complexEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplexEvent_Priority()
  {
    return (EAttribute)complexEventEClass.getEStructuralFeatures().get(1);
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
  public EClass getRule()
  {
    return ruleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRule_Events()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRule_Action()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypedParameterList()
  {
    return typedParameterListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypedParameterList_Parameters()
  {
    return (EReference)typedParameterListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypedParameter()
  {
    return typedParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypedParameter_Name()
  {
    return (EAttribute)typedParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypedParameter_Type()
  {
    return (EReference)typedParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventParameterList()
  {
    return eventParameterListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventParameterList_Parameters()
  {
    return (EReference)eventParameterListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventTypedParameter()
  {
    return eventTypedParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventTypedParameter_Name()
  {
    return (EAttribute)eventTypedParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventTypedParameter_Type()
  {
    return (EReference)eventTypedParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStaticBinding()
  {
    return staticBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStaticBinding_Parameter()
  {
    return (EReference)staticBindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStaticBinding_BindingRule()
  {
    return (EReference)staticBindingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStaticBindingRule()
  {
    return staticBindingRuleEClass;
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
  public EClass getFollowerEventStructure()
  {
    return followerEventStructureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBranchExpression()
  {
    return branchExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBranchExpression_Branches()
  {
    return (EReference)branchExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventTypedParameterWithMultiplicity()
  {
    return eventTypedParameterWithMultiplicityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventTypedParameterWithMultiplicity_Event()
  {
    return (EReference)eventTypedParameterWithMultiplicityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventTypedParameterWithMultiplicity_Parameters()
  {
    return (EReference)eventTypedParameterWithMultiplicityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventTypedParameterWithMultiplicity_Multiplicity()
  {
    return (EAttribute)eventTypedParameterWithMultiplicityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPatternCallParameterList()
  {
    return patternCallParameterListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPatternCallParameterList_Parameters()
  {
    return (EReference)patternCallParameterListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPatternCallParameter()
  {
    return patternCallParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPatternCallParameter_Name()
  {
    return (EAttribute)patternCallParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSource()
  {
    return sourceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSource_Adapter()
  {
    return (EReference)sourceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdapter()
  {
    return adapterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAdapter_Name()
  {
    return (EAttribute)adapterEClass.getEStructuralFeatures().get(0);
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
  public EventPatternLanguageFactory getEventPatternLanguageFactory()
  {
    return (EventPatternLanguageFactory)getEFactoryInstance();
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
    eventModelEClass = createEClass(EVENT_MODEL);
    createEAttribute(eventModelEClass, EVENT_MODEL__PACKAGE_NAME);
    createEReference(eventModelEClass, EVENT_MODEL__USAGES);
    createEAttribute(eventModelEClass, EVENT_MODEL__NAME);
    createEReference(eventModelEClass, EVENT_MODEL__EVENTS);

    usageEClass = createEClass(USAGE);
    createEAttribute(usageEClass, USAGE__IMPORTED_NAMESPACE);

    iqUsageEClass = createEClass(IQ_USAGE);

    eventSourceUsageEClass = createEClass(EVENT_SOURCE_USAGE);

    modelElementsEClass = createEClass(MODEL_ELEMENTS);
    createEAttribute(modelElementsEClass, MODEL_ELEMENTS__NAME);

    eventEClass = createEClass(EVENT);

    abstractAtomicEventEClass = createEClass(ABSTRACT_ATOMIC_EVENT);
    createEReference(abstractAtomicEventEClass, ABSTRACT_ATOMIC_EVENT__PARAMETERS);

    atomicEventEClass = createEClass(ATOMIC_EVENT);
    createEReference(atomicEventEClass, ATOMIC_EVENT__SOURCE);
    createEReference(atomicEventEClass, ATOMIC_EVENT__STATIC_BINDINGS);

    iqPatternEventEClass = createEClass(IQ_PATTERN_EVENT);
    createEAttribute(iqPatternEventEClass, IQ_PATTERN_EVENT__IQPATTERN);
    createEAttribute(iqPatternEventEClass, IQ_PATTERN_EVENT__CHANGE_TYPE);

    complexEventEClass = createEClass(COMPLEX_EVENT);
    createEReference(complexEventEClass, COMPLEX_EVENT__PARAMETERS);
    createEAttribute(complexEventEClass, COMPLEX_EVENT__PRIORITY);
    createEReference(complexEventEClass, COMPLEX_EVENT__COMPLEX_EVENT_EXPRESSIONS);

    ruleEClass = createEClass(RULE);
    createEReference(ruleEClass, RULE__EVENTS);
    createEReference(ruleEClass, RULE__ACTION);

    typedParameterListEClass = createEClass(TYPED_PARAMETER_LIST);
    createEReference(typedParameterListEClass, TYPED_PARAMETER_LIST__PARAMETERS);

    typedParameterEClass = createEClass(TYPED_PARAMETER);
    createEAttribute(typedParameterEClass, TYPED_PARAMETER__NAME);
    createEReference(typedParameterEClass, TYPED_PARAMETER__TYPE);

    eventParameterListEClass = createEClass(EVENT_PARAMETER_LIST);
    createEReference(eventParameterListEClass, EVENT_PARAMETER_LIST__PARAMETERS);

    eventTypedParameterEClass = createEClass(EVENT_TYPED_PARAMETER);
    createEAttribute(eventTypedParameterEClass, EVENT_TYPED_PARAMETER__NAME);
    createEReference(eventTypedParameterEClass, EVENT_TYPED_PARAMETER__TYPE);

    staticBindingEClass = createEClass(STATIC_BINDING);
    createEReference(staticBindingEClass, STATIC_BINDING__PARAMETER);
    createEReference(staticBindingEClass, STATIC_BINDING__BINDING_RULE);

    staticBindingRuleEClass = createEClass(STATIC_BINDING_RULE);

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

    followerEventStructureEClass = createEClass(FOLLOWER_EVENT_STRUCTURE);

    branchExpressionEClass = createEClass(BRANCH_EXPRESSION);
    createEReference(branchExpressionEClass, BRANCH_EXPRESSION__BRANCHES);

    eventTypedParameterWithMultiplicityEClass = createEClass(EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY);
    createEReference(eventTypedParameterWithMultiplicityEClass, EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT);
    createEReference(eventTypedParameterWithMultiplicityEClass, EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETERS);
    createEAttribute(eventTypedParameterWithMultiplicityEClass, EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY);

    patternCallParameterListEClass = createEClass(PATTERN_CALL_PARAMETER_LIST);
    createEReference(patternCallParameterListEClass, PATTERN_CALL_PARAMETER_LIST__PARAMETERS);

    patternCallParameterEClass = createEClass(PATTERN_CALL_PARAMETER);
    createEAttribute(patternCallParameterEClass, PATTERN_CALL_PARAMETER__NAME);

    sourceEClass = createEClass(SOURCE);
    createEReference(sourceEClass, SOURCE__ADAPTER);

    adapterEClass = createEClass(ADAPTER);
    createEAttribute(adapterEClass, ADAPTER__NAME);

    // Create enums
    iqPatternChangeTypeEEnum = createEEnum(IQ_PATTERN_CHANGE_TYPE);
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
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    iqUsageEClass.getESuperTypes().add(this.getUsage());
    eventSourceUsageEClass.getESuperTypes().add(this.getUsage());
    eventEClass.getESuperTypes().add(this.getModelElements());
    abstractAtomicEventEClass.getESuperTypes().add(this.getEvent());
    atomicEventEClass.getESuperTypes().add(this.getAbstractAtomicEvent());
    iqPatternEventEClass.getESuperTypes().add(this.getAbstractAtomicEvent());
    complexEventEClass.getESuperTypes().add(this.getEvent());
    ruleEClass.getESuperTypes().add(this.getModelElements());
    rangeFilterEClass.getESuperTypes().add(this.getStaticBindingRule());
    openOpenEClass.getESuperTypes().add(this.getRange());
    openClosedEClass.getESuperTypes().add(this.getRange());
    closedClosedEClass.getESuperTypes().add(this.getRange());
    closedOpenEClass.getESuperTypes().add(this.getRange());
    numericFilterEClass.getESuperTypes().add(this.getStaticBindingRule());
    literalFilterEClass.getESuperTypes().add(this.getStaticBindingRule());
    followsExpressionEClass.getESuperTypes().add(this.getComplexEventExpression());
    followsOperatorNoTWEClass.getESuperTypes().add(this.getFollowsOperator());
    followsOperatorViaTWEClass.getESuperTypes().add(this.getFollowsOperator());
    branchExpressionEClass.getESuperTypes().add(this.getFollowerEventStructure());
    eventTypedParameterWithMultiplicityEClass.getESuperTypes().add(this.getFollowerEventStructure());
    sourceEClass.getESuperTypes().add(this.getModelElements());

    // Initialize classes and features; add operations and parameters
    initEClass(eventModelEClass, EventModel.class, "EventModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEventModel_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, EventModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventModel_Usages(), this.getUsage(), null, "usages", null, 0, -1, EventModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEventModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, EventModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventModel_Events(), this.getModelElements(), null, "events", null, 0, -1, EventModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(usageEClass, Usage.class, "Usage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUsage_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Usage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iqUsageEClass, IQUsage.class, "IQUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(eventSourceUsageEClass, EventSourceUsage.class, "EventSourceUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(modelElementsEClass, ModelElements.class, "ModelElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelElements_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractAtomicEventEClass, AbstractAtomicEvent.class, "AbstractAtomicEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractAtomicEvent_Parameters(), this.getTypedParameterList(), null, "parameters", null, 0, 1, AbstractAtomicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomicEventEClass, AtomicEvent.class, "AtomicEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtomicEvent_Source(), this.getSource(), null, "source", null, 0, 1, AtomicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAtomicEvent_StaticBindings(), this.getStaticBinding(), null, "staticBindings", null, 0, -1, AtomicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iqPatternEventEClass, IQPatternEvent.class, "IQPatternEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIQPatternEvent_Iqpattern(), ecorePackage.getEString(), "iqpattern", null, 0, 1, IQPatternEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIQPatternEvent_ChangeType(), this.getIQPatternChangeType(), "changeType", null, 0, 1, IQPatternEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(complexEventEClass, ComplexEvent.class, "ComplexEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComplexEvent_Parameters(), this.getEventParameterList(), null, "parameters", null, 0, 1, ComplexEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComplexEvent_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, ComplexEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComplexEvent_ComplexEventExpressions(), this.getComplexEventExpression(), null, "complexEventExpressions", null, 0, -1, ComplexEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRule_Events(), this.getEvent(), null, "events", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_Action(), theXbasePackage.getXExpression(), null, "action", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typedParameterListEClass, TypedParameterList.class, "TypedParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypedParameterList_Parameters(), this.getTypedParameter(), null, "parameters", null, 0, -1, TypedParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typedParameterEClass, TypedParameter.class, "TypedParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypedParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypedParameter_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, TypedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventParameterListEClass, EventParameterList.class, "EventParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventParameterList_Parameters(), this.getEventTypedParameter(), null, "parameters", null, 0, -1, EventParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventTypedParameterEClass, EventTypedParameter.class, "EventTypedParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEventTypedParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, EventTypedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventTypedParameter_Type(), this.getEvent(), null, "type", null, 0, 1, EventTypedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(staticBindingEClass, StaticBinding.class, "StaticBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStaticBinding_Parameter(), this.getTypedParameter(), null, "parameter", null, 0, 1, StaticBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStaticBinding_BindingRule(), this.getStaticBindingRule(), null, "bindingRule", null, 0, 1, StaticBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(staticBindingRuleEClass, StaticBindingRule.class, "StaticBindingRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(rangeFilterEClass, RangeFilter.class, "RangeFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRangeFilter_Neg(), ecorePackage.getEString(), "neg", null, 0, 1, RangeFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRangeFilter_Range(), this.getRange(), null, "range", null, 0, 1, RangeFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rangeEClass, Range.class, "Range", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRange_LowerBound(), ecorePackage.getEDouble(), "lowerBound", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRange_UpperBound(), ecorePackage.getEDouble(), "upperBound", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(openOpenEClass, OpenOpen.class, "OpenOpen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(openClosedEClass, OpenClosed.class, "OpenClosed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(closedClosedEClass, ClosedClosed.class, "ClosedClosed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(closedOpenEClass, ClosedOpen.class, "ClosedOpen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numericFilterEClass, NumericFilter.class, "NumericFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumericFilter_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, NumericFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNumericFilter_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, NumericFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalFilterEClass, LiteralFilter.class, "LiteralFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteralFilter_Neg(), ecorePackage.getEString(), "neg", null, 0, 1, LiteralFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLiteralFilter_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, LiteralFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLiteralFilter_Value(), ecorePackage.getEString(), "value", null, 0, 1, LiteralFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(complexEventExpressionEClass, ComplexEventExpression.class, "ComplexEventExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsExpressionEClass, FollowsExpression.class, "FollowsExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFollowsExpression_FirstEvent(), this.getEventTypedParameterWithMultiplicity(), null, "firstEvent", null, 0, -1, FollowsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFollowsExpression_Events(), this.getEventWithFollowsOperator(), null, "events", null, 0, -1, FollowsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventWithFollowsOperatorEClass, EventWithFollowsOperator.class, "EventWithFollowsOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventWithFollowsOperator_Operator(), this.getFollowsOperator(), null, "operator", null, 0, 1, EventWithFollowsOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventWithFollowsOperator_Event(), this.getFollowerEventStructure(), null, "event", null, 0, 1, EventWithFollowsOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(followsOperatorEClass, FollowsOperator.class, "FollowsOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsOperatorNoTWEClass, FollowsOperatorNoTW.class, "FollowsOperatorNoTW", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsOperatorViaTWEClass, FollowsOperatorViaTW.class, "FollowsOperatorViaTW", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFollowsOperatorViaTW_Timewindow(), ecorePackage.getEInt(), "timewindow", null, 0, 1, FollowsOperatorViaTW.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(followerEventStructureEClass, FollowerEventStructure.class, "FollowerEventStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(branchExpressionEClass, BranchExpression.class, "BranchExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBranchExpression_Branches(), this.getEventTypedParameterWithMultiplicity(), null, "branches", null, 0, -1, BranchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventTypedParameterWithMultiplicityEClass, EventTypedParameterWithMultiplicity.class, "EventTypedParameterWithMultiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventTypedParameterWithMultiplicity_Event(), this.getEventTypedParameter(), null, "event", null, 0, 1, EventTypedParameterWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventTypedParameterWithMultiplicity_Parameters(), this.getPatternCallParameterList(), null, "parameters", null, 0, 1, EventTypedParameterWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEventTypedParameterWithMultiplicity_Multiplicity(), ecorePackage.getEInt(), "multiplicity", null, 0, 1, EventTypedParameterWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(patternCallParameterListEClass, PatternCallParameterList.class, "PatternCallParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPatternCallParameterList_Parameters(), this.getPatternCallParameter(), null, "parameters", null, 0, -1, PatternCallParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(patternCallParameterEClass, PatternCallParameter.class, "PatternCallParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPatternCallParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, PatternCallParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sourceEClass, Source.class, "Source", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSource_Adapter(), this.getAdapter(), null, "adapter", null, 0, -1, Source.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(adapterEClass, Adapter.class, "Adapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAdapter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(iqPatternChangeTypeEEnum, IQPatternChangeType.class, "IQPatternChangeType");
    addEEnumLiteral(iqPatternChangeTypeEEnum, IQPatternChangeType.FOUND);
    addEEnumLiteral(iqPatternChangeTypeEEnum, IQPatternChangeType.LOST);

    // Create resource
    createResource(eNS_URI);
  }

} //EventPatternLanguagePackageImpl
