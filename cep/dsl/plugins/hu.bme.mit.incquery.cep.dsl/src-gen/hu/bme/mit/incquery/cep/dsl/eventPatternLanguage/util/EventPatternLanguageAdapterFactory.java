/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.util;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage
 * @generated
 */
public class EventPatternLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EventPatternLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventPatternLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = EventPatternLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventPatternLanguageSwitch<Adapter> modelSwitch =
    new EventPatternLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseEventModel(EventModel object)
      {
        return createEventModelAdapter();
      }
      @Override
      public Adapter casePackagedModel(PackagedModel object)
      {
        return createPackagedModelAdapter();
      }
      @Override
      public Adapter caseUsage(Usage object)
      {
        return createUsageAdapter();
      }
      @Override
      public Adapter caseModelElement(ModelElement object)
      {
        return createModelElementAdapter();
      }
      @Override
      public Adapter caseEventPattern(EventPattern object)
      {
        return createEventPatternAdapter();
      }
      @Override
      public Adapter caseAbstractAtomicEventPattern(AbstractAtomicEventPattern object)
      {
        return createAbstractAtomicEventPatternAdapter();
      }
      @Override
      public Adapter caseAtomicEventPattern(AtomicEventPattern object)
      {
        return createAtomicEventPatternAdapter();
      }
      @Override
      public Adapter caseIQPatternEventPattern(IQPatternEventPattern object)
      {
        return createIQPatternEventPatternAdapter();
      }
      @Override
      public Adapter caseComplexEventPattern(ComplexEventPattern object)
      {
        return createComplexEventPatternAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseTypedParameterList(TypedParameterList object)
      {
        return createTypedParameterListAdapter();
      }
      @Override
      public Adapter caseTypedParameter(TypedParameter object)
      {
        return createTypedParameterAdapter();
      }
      @Override
      public Adapter caseEventPatternParameterList(EventPatternParameterList object)
      {
        return createEventPatternParameterListAdapter();
      }
      @Override
      public Adapter caseEventTypedParameter(EventTypedParameter object)
      {
        return createEventTypedParameterAdapter();
      }
      @Override
      public Adapter caseParametrizedIncQueryPatternReference(ParametrizedIncQueryPatternReference object)
      {
        return createParametrizedIncQueryPatternReferenceAdapter();
      }
      @Override
      public Adapter caseMultiplicity(Multiplicity object)
      {
        return createMultiplicityAdapter();
      }
      @Override
      public Adapter caseTimewindow(Timewindow object)
      {
        return createTimewindowAdapter();
      }
      @Override
      public Adapter caseEventTypedParameterWithMultiplicity(EventTypedParameterWithMultiplicity object)
      {
        return createEventTypedParameterWithMultiplicityAdapter();
      }
      @Override
      public Adapter casePatternCallParameterList(PatternCallParameterList object)
      {
        return createPatternCallParameterListAdapter();
      }
      @Override
      public Adapter casePatternCallParameter(PatternCallParameter object)
      {
        return createPatternCallParameterAdapter();
      }
      @Override
      public Adapter caseComplexEventExpression(ComplexEventExpression object)
      {
        return createComplexEventExpressionAdapter();
      }
      @Override
      public Adapter caseAugmentedExpression(AugmentedExpression object)
      {
        return createAugmentedExpressionAdapter();
      }
      @Override
      public Adapter caseTimedExpression(TimedExpression object)
      {
        return createTimedExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplicityExpression(MultiplicityExpression object)
      {
        return createMultiplicityExpressionAdapter();
      }
      @Override
      public Adapter caseTimedMultiplicityExpression(TimedMultiplicityExpression object)
      {
        return createTimedMultiplicityExpressionAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseFollowsExpression(FollowsExpression object)
      {
        return createFollowsExpressionAdapter();
      }
      @Override
      public Adapter caseFollowerExpression(FollowerExpression object)
      {
        return createFollowerExpressionAdapter();
      }
      @Override
      public Adapter caseFollowerEventStructure(FollowerEventStructure object)
      {
        return createFollowerEventStructureAdapter();
      }
      @Override
      public Adapter caseInnerBranchExpression(InnerBranchExpression object)
      {
        return createInnerBranchExpressionAdapter();
      }
      @Override
      public Adapter caseBranchExpression(BranchExpression object)
      {
        return createBranchExpressionAdapter();
      }
      @Override
      public Adapter caseFollowsOperator(FollowsOperator object)
      {
        return createFollowsOperatorAdapter();
      }
      @Override
      public Adapter caseFollowsOperatorNoTW(FollowsOperatorNoTW object)
      {
        return createFollowsOperatorNoTWAdapter();
      }
      @Override
      public Adapter caseStaticBinding(StaticBinding object)
      {
        return createStaticBindingAdapter();
      }
      @Override
      public Adapter caseStaticBindingRule(StaticBindingRule object)
      {
        return createStaticBindingRuleAdapter();
      }
      @Override
      public Adapter caseRangeFilter(RangeFilter object)
      {
        return createRangeFilterAdapter();
      }
      @Override
      public Adapter caseRange(Range object)
      {
        return createRangeAdapter();
      }
      @Override
      public Adapter caseOpenOpen(OpenOpen object)
      {
        return createOpenOpenAdapter();
      }
      @Override
      public Adapter caseOpenClosed(OpenClosed object)
      {
        return createOpenClosedAdapter();
      }
      @Override
      public Adapter caseClosedClosed(ClosedClosed object)
      {
        return createClosedClosedAdapter();
      }
      @Override
      public Adapter caseClosedOpen(ClosedOpen object)
      {
        return createClosedOpenAdapter();
      }
      @Override
      public Adapter caseNumericFilter(NumericFilter object)
      {
        return createNumericFilterAdapter();
      }
      @Override
      public Adapter caseLiteralFilter(LiteralFilter object)
      {
        return createLiteralFilterAdapter();
      }
      @Override
      public Adapter caseSource(Source object)
      {
        return createSourceAdapter();
      }
      @Override
      public Adapter caseAdapter(hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter object)
      {
        return createAdapterAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel <em>Event Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel
   * @generated
   */
  public Adapter createEventModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel <em>Packaged Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel
   * @generated
   */
  public Adapter createPackagedModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage <em>Usage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Usage
   * @generated
   */
  public Adapter createUsageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
   * @generated
   */
  public Adapter createModelElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern <em>Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern
   * @generated
   */
  public Adapter createEventPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEventPattern <em>Abstract Atomic Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEventPattern
   * @generated
   */
  public Adapter createAbstractAtomicEventPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern <em>Atomic Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern
   * @generated
   */
  public Adapter createAtomicEventPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern <em>IQ Pattern Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern
   * @generated
   */
  public Adapter createIQPatternEventPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern <em>Complex Event Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
   * @generated
   */
  public Adapter createComplexEventPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList <em>Typed Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList
   * @generated
   */
  public Adapter createTypedParameterListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter <em>Typed Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter
   * @generated
   */
  public Adapter createTypedParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternParameterList <em>Event Pattern Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternParameterList
   * @generated
   */
  public Adapter createEventPatternParameterListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter <em>Event Typed Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameter
   * @generated
   */
  public Adapter createEventTypedParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference <em>Parametrized Inc Query Pattern Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParametrizedIncQueryPatternReference
   * @generated
   */
  public Adapter createParametrizedIncQueryPatternReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Multiplicity
   * @generated
   */
  public Adapter createMultiplicityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow <em>Timewindow</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Timewindow
   * @generated
   */
  public Adapter createTimewindowAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity <em>Event Typed Parameter With Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity
   * @generated
   */
  public Adapter createEventTypedParameterWithMultiplicityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList <em>Pattern Call Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameterList
   * @generated
   */
  public Adapter createPatternCallParameterListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter <em>Pattern Call Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternCallParameter
   * @generated
   */
  public Adapter createPatternCallParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression <em>Complex Event Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression
   * @generated
   */
  public Adapter createComplexEventExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression <em>Augmented Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AugmentedExpression
   * @generated
   */
  public Adapter createAugmentedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression <em>Timed Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression
   * @generated
   */
  public Adapter createTimedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression <em>Multiplicity Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.MultiplicityExpression
   * @generated
   */
  public Adapter createMultiplicityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression <em>Timed Multiplicity Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression
   * @generated
   */
  public Adapter createTimedMultiplicityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression <em>Follows Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsExpression
   * @generated
   */
  public Adapter createFollowsExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression <em>Follower Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerExpression
   * @generated
   */
  public Adapter createFollowerExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerEventStructure <em>Follower Event Structure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowerEventStructure
   * @generated
   */
  public Adapter createFollowerEventStructureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.InnerBranchExpression <em>Inner Branch Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.InnerBranchExpression
   * @generated
   */
  public Adapter createInnerBranchExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression <em>Branch Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.BranchExpression
   * @generated
   */
  public Adapter createBranchExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperator <em>Follows Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperator
   * @generated
   */
  public Adapter createFollowsOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorNoTW <em>Follows Operator No TW</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorNoTW
   * @generated
   */
  public Adapter createFollowsOperatorNoTWAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding <em>Static Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding
   * @generated
   */
  public Adapter createStaticBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBindingRule <em>Static Binding Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBindingRule
   * @generated
   */
  public Adapter createStaticBindingRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter <em>Range Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.RangeFilter
   * @generated
   */
  public Adapter createRangeFilterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Range
   * @generated
   */
  public Adapter createRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenOpen <em>Open Open</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenOpen
   * @generated
   */
  public Adapter createOpenOpenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenClosed <em>Open Closed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OpenClosed
   * @generated
   */
  public Adapter createOpenClosedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedClosed <em>Closed Closed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedClosed
   * @generated
   */
  public Adapter createClosedClosedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedOpen <em>Closed Open</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ClosedOpen
   * @generated
   */
  public Adapter createClosedOpenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter <em>Numeric Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.NumericFilter
   * @generated
   */
  public Adapter createNumericFilterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter <em>Literal Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.LiteralFilter
   * @generated
   */
  public Adapter createLiteralFilterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Source
   * @generated
   */
  public Adapter createSourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Adapter
   * @generated
   */
  public Adapter createAdapterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //EventPatternLanguageAdapterFactory
