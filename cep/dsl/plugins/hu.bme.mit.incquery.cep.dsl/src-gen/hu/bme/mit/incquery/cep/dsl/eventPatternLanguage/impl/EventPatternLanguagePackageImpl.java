/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedClosed;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedOpen;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguageFactory;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternParameterList;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FailDiagnosticRule;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerEventStructure;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperator;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorNoTW;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.InnerBranchExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OnAppearRule;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenClosed;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenOpen;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBindingRule;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList;
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

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
  private EClass packagedModelEClass = null;

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
  private EClass modelElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractAtomicEventPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomicEventPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iqPatternEventPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complexEventPatternEClass = null;

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
  private EClass onAppearRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass failDiagnosticRuleEClass = null;

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
  private EClass eventPatternParameterListEClass = null;

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
  private EClass parametrizedIncQueryPatternReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timewindowEClass = null;

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
  private EClass complexEventExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass augmentedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timedMultiplicityExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

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
  private EClass followerExpressionEClass = null;

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
  private EClass innerBranchExpressionEClass = null;

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
    PatternLanguagePackage.eINSTANCE.eClass();

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
  public EReference getEventModel_PackagedModel()
  {
    return (EReference)eventModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackagedModel()
  {
    return packagedModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPackagedModel_Name()
  {
    return (EAttribute)packagedModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackagedModel_Usages()
  {
    return (EReference)packagedModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackagedModel_ModelElements()
  {
    return (EReference)packagedModelEClass.getEStructuralFeatures().get(2);
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
  public EClass getModelElement()
  {
    return modelElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelElement_Name()
  {
    return (EAttribute)modelElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventPattern()
  {
    return eventPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractAtomicEventPattern()
  {
    return abstractAtomicEventPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractAtomicEventPattern_Parameters()
  {
    return (EReference)abstractAtomicEventPatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtomicEventPattern()
  {
    return atomicEventPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicEventPattern_Source()
  {
    return (EReference)atomicEventPatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicEventPattern_StaticBindings()
  {
    return (EReference)atomicEventPatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIQPatternEventPattern()
  {
    return iqPatternEventPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIQPatternEventPattern_IqPatternRef()
  {
    return (EReference)iqPatternEventPatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIQPatternEventPattern_IqChangeType()
  {
    return (EAttribute)iqPatternEventPatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplexEventPattern()
  {
    return complexEventPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComplexEventPattern_Parameters()
  {
    return (EReference)complexEventPatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplexEventPattern_Priority()
  {
    return (EAttribute)complexEventPatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComplexEventPattern_ComplexEventExpressions()
  {
    return (EReference)complexEventPatternEClass.getEStructuralFeatures().get(2);
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
  public EReference getRule_EventPatterns()
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
  public EClass getOnAppearRule()
  {
    return onAppearRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFailDiagnosticRule()
  {
    return failDiagnosticRuleEClass;
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
  public EClass getEventPatternParameterList()
  {
    return eventPatternParameterListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventPatternParameterList_Parameters()
  {
    return (EReference)eventPatternParameterListEClass.getEStructuralFeatures().get(0);
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
  public EClass getParametrizedIncQueryPatternReference()
  {
    return parametrizedIncQueryPatternReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParametrizedIncQueryPatternReference_Iqpattern()
  {
    return (EReference)parametrizedIncQueryPatternReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParametrizedIncQueryPatternReference_ParameterList()
  {
    return (EReference)parametrizedIncQueryPatternReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicity()
  {
    return multiplicityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity_Multiplicity()
  {
    return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimewindow()
  {
    return timewindowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimewindow_Length()
  {
    return (EAttribute)timewindowEClass.getEStructuralFeatures().get(0);
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
  public EReference getEventTypedParameterWithMultiplicity_EventPattern()
  {
    return (EReference)eventTypedParameterWithMultiplicityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventTypedParameterWithMultiplicity_ParameterList()
  {
    return (EReference)eventTypedParameterWithMultiplicityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventTypedParameterWithMultiplicity_Multiplicity()
  {
    return (EReference)eventTypedParameterWithMultiplicityEClass.getEStructuralFeatures().get(2);
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
  public EClass getComplexEventExpression()
  {
    return complexEventExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAugmentedExpression()
  {
    return augmentedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAugmentedExpression_Expression()
  {
    return (EReference)augmentedExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimedExpression()
  {
    return timedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimedExpression_Timewindow()
  {
    return (EReference)timedExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicityExpression()
  {
    return multiplicityExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicityExpression_Multiplicity()
  {
    return (EReference)multiplicityExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimedMultiplicityExpression()
  {
    return timedMultiplicityExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimedMultiplicityExpression_Multiplicity()
  {
    return (EReference)timedMultiplicityExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimedMultiplicityExpression_Timewindow()
  {
    return (EReference)timedMultiplicityExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_EventPatterns()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(0);
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
  public EReference getFollowsExpression_FollowerExpressions()
  {
    return (EReference)followsExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFollowerExpression()
  {
    return followerExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFollowerExpression_FollowsOperator()
  {
    return (EReference)followerExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFollowerExpression_EventPattern()
  {
    return (EReference)followerExpressionEClass.getEStructuralFeatures().get(1);
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
  public EClass getInnerBranchExpression()
  {
    return innerBranchExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInnerBranchExpression_Expression()
  {
    return (EReference)innerBranchExpressionEClass.getEStructuralFeatures().get(0);
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
    createEReference(eventModelEClass, EVENT_MODEL__PACKAGED_MODEL);

    packagedModelEClass = createEClass(PACKAGED_MODEL);
    createEAttribute(packagedModelEClass, PACKAGED_MODEL__NAME);
    createEReference(packagedModelEClass, PACKAGED_MODEL__USAGES);
    createEReference(packagedModelEClass, PACKAGED_MODEL__MODEL_ELEMENTS);

    usageEClass = createEClass(USAGE);
    createEAttribute(usageEClass, USAGE__IMPORTED_NAMESPACE);

    modelElementEClass = createEClass(MODEL_ELEMENT);
    createEAttribute(modelElementEClass, MODEL_ELEMENT__NAME);

    eventPatternEClass = createEClass(EVENT_PATTERN);

    abstractAtomicEventPatternEClass = createEClass(ABSTRACT_ATOMIC_EVENT_PATTERN);
    createEReference(abstractAtomicEventPatternEClass, ABSTRACT_ATOMIC_EVENT_PATTERN__PARAMETERS);

    atomicEventPatternEClass = createEClass(ATOMIC_EVENT_PATTERN);
    createEReference(atomicEventPatternEClass, ATOMIC_EVENT_PATTERN__SOURCE);
    createEReference(atomicEventPatternEClass, ATOMIC_EVENT_PATTERN__STATIC_BINDINGS);

    iqPatternEventPatternEClass = createEClass(IQ_PATTERN_EVENT_PATTERN);
    createEReference(iqPatternEventPatternEClass, IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF);
    createEAttribute(iqPatternEventPatternEClass, IQ_PATTERN_EVENT_PATTERN__IQ_CHANGE_TYPE);

    complexEventPatternEClass = createEClass(COMPLEX_EVENT_PATTERN);
    createEReference(complexEventPatternEClass, COMPLEX_EVENT_PATTERN__PARAMETERS);
    createEAttribute(complexEventPatternEClass, COMPLEX_EVENT_PATTERN__PRIORITY);
    createEReference(complexEventPatternEClass, COMPLEX_EVENT_PATTERN__COMPLEX_EVENT_EXPRESSIONS);

    ruleEClass = createEClass(RULE);
    createEReference(ruleEClass, RULE__EVENT_PATTERNS);
    createEReference(ruleEClass, RULE__ACTION);

    onAppearRuleEClass = createEClass(ON_APPEAR_RULE);

    failDiagnosticRuleEClass = createEClass(FAIL_DIAGNOSTIC_RULE);

    typedParameterListEClass = createEClass(TYPED_PARAMETER_LIST);
    createEReference(typedParameterListEClass, TYPED_PARAMETER_LIST__PARAMETERS);

    typedParameterEClass = createEClass(TYPED_PARAMETER);
    createEAttribute(typedParameterEClass, TYPED_PARAMETER__NAME);
    createEReference(typedParameterEClass, TYPED_PARAMETER__TYPE);

    eventPatternParameterListEClass = createEClass(EVENT_PATTERN_PARAMETER_LIST);
    createEReference(eventPatternParameterListEClass, EVENT_PATTERN_PARAMETER_LIST__PARAMETERS);

    eventTypedParameterEClass = createEClass(EVENT_TYPED_PARAMETER);
    createEAttribute(eventTypedParameterEClass, EVENT_TYPED_PARAMETER__NAME);
    createEReference(eventTypedParameterEClass, EVENT_TYPED_PARAMETER__TYPE);

    parametrizedIncQueryPatternReferenceEClass = createEClass(PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE);
    createEReference(parametrizedIncQueryPatternReferenceEClass, PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__IQPATTERN);
    createEReference(parametrizedIncQueryPatternReferenceEClass, PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE__PARAMETER_LIST);

    multiplicityEClass = createEClass(MULTIPLICITY);
    createEAttribute(multiplicityEClass, MULTIPLICITY__MULTIPLICITY);

    timewindowEClass = createEClass(TIMEWINDOW);
    createEAttribute(timewindowEClass, TIMEWINDOW__LENGTH);

    eventTypedParameterWithMultiplicityEClass = createEClass(EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY);
    createEReference(eventTypedParameterWithMultiplicityEClass, EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__EVENT_PATTERN);
    createEReference(eventTypedParameterWithMultiplicityEClass, EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST);
    createEReference(eventTypedParameterWithMultiplicityEClass, EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__MULTIPLICITY);

    patternCallParameterListEClass = createEClass(PATTERN_CALL_PARAMETER_LIST);
    createEReference(patternCallParameterListEClass, PATTERN_CALL_PARAMETER_LIST__PARAMETERS);

    patternCallParameterEClass = createEClass(PATTERN_CALL_PARAMETER);
    createEAttribute(patternCallParameterEClass, PATTERN_CALL_PARAMETER__NAME);

    complexEventExpressionEClass = createEClass(COMPLEX_EVENT_EXPRESSION);

    augmentedExpressionEClass = createEClass(AUGMENTED_EXPRESSION);
    createEReference(augmentedExpressionEClass, AUGMENTED_EXPRESSION__EXPRESSION);

    timedExpressionEClass = createEClass(TIMED_EXPRESSION);
    createEReference(timedExpressionEClass, TIMED_EXPRESSION__TIMEWINDOW);

    multiplicityExpressionEClass = createEClass(MULTIPLICITY_EXPRESSION);
    createEReference(multiplicityExpressionEClass, MULTIPLICITY_EXPRESSION__MULTIPLICITY);

    timedMultiplicityExpressionEClass = createEClass(TIMED_MULTIPLICITY_EXPRESSION);
    createEReference(timedMultiplicityExpressionEClass, TIMED_MULTIPLICITY_EXPRESSION__MULTIPLICITY);
    createEReference(timedMultiplicityExpressionEClass, TIMED_MULTIPLICITY_EXPRESSION__TIMEWINDOW);

    expressionEClass = createEClass(EXPRESSION);
    createEReference(expressionEClass, EXPRESSION__EVENT_PATTERNS);

    followsExpressionEClass = createEClass(FOLLOWS_EXPRESSION);
    createEReference(followsExpressionEClass, FOLLOWS_EXPRESSION__FOLLOWER_EXPRESSIONS);

    followerExpressionEClass = createEClass(FOLLOWER_EXPRESSION);
    createEReference(followerExpressionEClass, FOLLOWER_EXPRESSION__FOLLOWS_OPERATOR);
    createEReference(followerExpressionEClass, FOLLOWER_EXPRESSION__EVENT_PATTERN);

    followerEventStructureEClass = createEClass(FOLLOWER_EVENT_STRUCTURE);

    innerBranchExpressionEClass = createEClass(INNER_BRANCH_EXPRESSION);
    createEReference(innerBranchExpressionEClass, INNER_BRANCH_EXPRESSION__EXPRESSION);

    branchExpressionEClass = createEClass(BRANCH_EXPRESSION);

    followsOperatorEClass = createEClass(FOLLOWS_OPERATOR);

    followsOperatorNoTWEClass = createEClass(FOLLOWS_OPERATOR_NO_TW);

    followsOperatorViaTWEClass = createEClass(FOLLOWS_OPERATOR_VIA_TW);
    createEAttribute(followsOperatorViaTWEClass, FOLLOWS_OPERATOR_VIA_TW__TIMEWINDOW);

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
    PatternLanguagePackage thePatternLanguagePackage = (PatternLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(PatternLanguagePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    eventPatternEClass.getESuperTypes().add(this.getModelElement());
    abstractAtomicEventPatternEClass.getESuperTypes().add(this.getEventPattern());
    atomicEventPatternEClass.getESuperTypes().add(this.getAbstractAtomicEventPattern());
    iqPatternEventPatternEClass.getESuperTypes().add(this.getAbstractAtomicEventPattern());
    complexEventPatternEClass.getESuperTypes().add(this.getEventPattern());
    ruleEClass.getESuperTypes().add(this.getModelElement());
    onAppearRuleEClass.getESuperTypes().add(this.getRule());
    failDiagnosticRuleEClass.getESuperTypes().add(this.getRule());
    eventTypedParameterWithMultiplicityEClass.getESuperTypes().add(this.getFollowerEventStructure());
    augmentedExpressionEClass.getESuperTypes().add(this.getComplexEventExpression());
    timedExpressionEClass.getESuperTypes().add(this.getAugmentedExpression());
    multiplicityExpressionEClass.getESuperTypes().add(this.getAugmentedExpression());
    timedMultiplicityExpressionEClass.getESuperTypes().add(this.getAugmentedExpression());
    expressionEClass.getESuperTypes().add(this.getComplexEventExpression());
    followsExpressionEClass.getESuperTypes().add(this.getExpression());
    innerBranchExpressionEClass.getESuperTypes().add(this.getFollowerEventStructure());
    branchExpressionEClass.getESuperTypes().add(this.getExpression());
    followsOperatorNoTWEClass.getESuperTypes().add(this.getFollowsOperator());
    followsOperatorViaTWEClass.getESuperTypes().add(this.getFollowsOperator());
    rangeFilterEClass.getESuperTypes().add(this.getStaticBindingRule());
    openOpenEClass.getESuperTypes().add(this.getRange());
    openClosedEClass.getESuperTypes().add(this.getRange());
    closedClosedEClass.getESuperTypes().add(this.getRange());
    closedOpenEClass.getESuperTypes().add(this.getRange());
    numericFilterEClass.getESuperTypes().add(this.getStaticBindingRule());
    literalFilterEClass.getESuperTypes().add(this.getStaticBindingRule());
    sourceEClass.getESuperTypes().add(this.getModelElement());

    // Initialize classes and features; add operations and parameters
    initEClass(eventModelEClass, EventModel.class, "EventModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventModel_PackagedModel(), this.getPackagedModel(), null, "packagedModel", null, 0, 1, EventModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packagedModelEClass, PackagedModel.class, "PackagedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPackagedModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, PackagedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackagedModel_Usages(), this.getUsage(), null, "usages", null, 0, -1, PackagedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackagedModel_ModelElements(), this.getModelElement(), null, "modelElements", null, 0, -1, PackagedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(usageEClass, Usage.class, "Usage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUsage_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Usage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelElementEClass, ModelElement.class, "ModelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventPatternEClass, EventPattern.class, "EventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractAtomicEventPatternEClass, AbstractAtomicEventPattern.class, "AbstractAtomicEventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractAtomicEventPattern_Parameters(), this.getTypedParameterList(), null, "parameters", null, 0, 1, AbstractAtomicEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomicEventPatternEClass, AtomicEventPattern.class, "AtomicEventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtomicEventPattern_Source(), this.getSource(), null, "source", null, 0, 1, AtomicEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAtomicEventPattern_StaticBindings(), this.getStaticBinding(), null, "staticBindings", null, 0, -1, AtomicEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iqPatternEventPatternEClass, IQPatternEventPattern.class, "IQPatternEventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIQPatternEventPattern_IqPatternRef(), this.getParametrizedIncQueryPatternReference(), null, "iqPatternRef", null, 0, 1, IQPatternEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIQPatternEventPattern_IqChangeType(), this.getIQPatternChangeType(), "iqChangeType", null, 0, 1, IQPatternEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(complexEventPatternEClass, ComplexEventPattern.class, "ComplexEventPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComplexEventPattern_Parameters(), this.getEventPatternParameterList(), null, "parameters", null, 0, 1, ComplexEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComplexEventPattern_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, ComplexEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComplexEventPattern_ComplexEventExpressions(), this.getComplexEventExpression(), null, "complexEventExpressions", null, 0, 1, ComplexEventPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRule_EventPatterns(), this.getEventPattern(), null, "eventPatterns", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_Action(), theXbasePackage.getXExpression(), null, "action", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(onAppearRuleEClass, OnAppearRule.class, "OnAppearRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(failDiagnosticRuleEClass, FailDiagnosticRule.class, "FailDiagnosticRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typedParameterListEClass, TypedParameterList.class, "TypedParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypedParameterList_Parameters(), this.getTypedParameter(), null, "parameters", null, 0, -1, TypedParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typedParameterEClass, TypedParameter.class, "TypedParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypedParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypedParameter_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, TypedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventPatternParameterListEClass, EventPatternParameterList.class, "EventPatternParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventPatternParameterList_Parameters(), this.getEventTypedParameter(), null, "parameters", null, 0, -1, EventPatternParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventTypedParameterEClass, EventTypedParameter.class, "EventTypedParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEventTypedParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, EventTypedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventTypedParameter_Type(), this.getEventPattern(), null, "type", null, 0, 1, EventTypedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parametrizedIncQueryPatternReferenceEClass, ParametrizedIncQueryPatternReference.class, "ParametrizedIncQueryPatternReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParametrizedIncQueryPatternReference_Iqpattern(), thePatternLanguagePackage.getPattern(), null, "iqpattern", null, 0, 1, ParametrizedIncQueryPatternReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParametrizedIncQueryPatternReference_ParameterList(), this.getPatternCallParameterList(), null, "parameterList", null, 0, 1, ParametrizedIncQueryPatternReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicityEClass, Multiplicity.class, "Multiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultiplicity_Multiplicity(), ecorePackage.getEInt(), "multiplicity", null, 0, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timewindowEClass, Timewindow.class, "Timewindow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimewindow_Length(), ecorePackage.getEInt(), "length", null, 0, 1, Timewindow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventTypedParameterWithMultiplicityEClass, EventTypedParameterWithMultiplicity.class, "EventTypedParameterWithMultiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventTypedParameterWithMultiplicity_EventPattern(), this.getEventTypedParameter(), null, "eventPattern", null, 0, 1, EventTypedParameterWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventTypedParameterWithMultiplicity_ParameterList(), this.getPatternCallParameterList(), null, "parameterList", null, 0, 1, EventTypedParameterWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventTypedParameterWithMultiplicity_Multiplicity(), this.getMultiplicity(), null, "multiplicity", null, 0, 1, EventTypedParameterWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(patternCallParameterListEClass, PatternCallParameterList.class, "PatternCallParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPatternCallParameterList_Parameters(), this.getPatternCallParameter(), null, "parameters", null, 0, -1, PatternCallParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(patternCallParameterEClass, PatternCallParameter.class, "PatternCallParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPatternCallParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, PatternCallParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(complexEventExpressionEClass, ComplexEventExpression.class, "ComplexEventExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(augmentedExpressionEClass, AugmentedExpression.class, "AugmentedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAugmentedExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, AugmentedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timedExpressionEClass, TimedExpression.class, "TimedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTimedExpression_Timewindow(), this.getTimewindow(), null, "timewindow", null, 0, 1, TimedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicityExpressionEClass, MultiplicityExpression.class, "MultiplicityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplicityExpression_Multiplicity(), this.getMultiplicity(), null, "multiplicity", null, 0, 1, MultiplicityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timedMultiplicityExpressionEClass, TimedMultiplicityExpression.class, "TimedMultiplicityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTimedMultiplicityExpression_Multiplicity(), this.getMultiplicity(), null, "multiplicity", null, 0, 1, TimedMultiplicityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimedMultiplicityExpression_Timewindow(), this.getTimewindow(), null, "timewindow", null, 0, 1, TimedMultiplicityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_EventPatterns(), this.getEventTypedParameterWithMultiplicity(), null, "eventPatterns", null, 0, -1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(followsExpressionEClass, FollowsExpression.class, "FollowsExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFollowsExpression_FollowerExpressions(), this.getFollowerExpression(), null, "followerExpressions", null, 0, -1, FollowsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(followerExpressionEClass, FollowerExpression.class, "FollowerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFollowerExpression_FollowsOperator(), this.getFollowsOperator(), null, "followsOperator", null, 0, 1, FollowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFollowerExpression_EventPattern(), this.getFollowerEventStructure(), null, "eventPattern", null, 0, 1, FollowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(followerEventStructureEClass, FollowerEventStructure.class, "FollowerEventStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(innerBranchExpressionEClass, InnerBranchExpression.class, "InnerBranchExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInnerBranchExpression_Expression(), this.getBranchExpression(), null, "expression", null, 0, 1, InnerBranchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(branchExpressionEClass, BranchExpression.class, "BranchExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsOperatorEClass, FollowsOperator.class, "FollowsOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsOperatorNoTWEClass, FollowsOperatorNoTW.class, "FollowsOperatorNoTW", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(followsOperatorViaTWEClass, FollowsOperatorViaTW.class, "FollowsOperatorViaTW", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFollowsOperatorViaTW_Timewindow(), ecorePackage.getEInt(), "timewindow", null, 0, 1, FollowsOperatorViaTW.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

    initEClass(sourceEClass, Source.class, "Source", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSource_Adapter(), this.getAdapter(), null, "adapter", null, 0, -1, Source.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(adapterEClass, Adapter.class, "Adapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAdapter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(iqPatternChangeTypeEEnum, IQPatternChangeType.class, "IQPatternChangeType");
    addEEnumLiteral(iqPatternChangeTypeEEnum, IQPatternChangeType.NEW_MATCH_FOUND);
    addEEnumLiteral(iqPatternChangeTypeEEnum, IQPatternChangeType.EXISTING_MATCH_LOST);

    // Create resource
    createResource(eNS_URI);
  }

} //EventPatternLanguagePackageImpl
