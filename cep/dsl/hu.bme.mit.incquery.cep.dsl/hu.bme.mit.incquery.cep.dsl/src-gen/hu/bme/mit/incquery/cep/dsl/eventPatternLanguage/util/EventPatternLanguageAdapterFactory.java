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
      public Adapter caseUsage(Usage object)
      {
        return createUsageAdapter();
      }
      @Override
      public Adapter caseIQUsage(IQUsage object)
      {
        return createIQUsageAdapter();
      }
      @Override
      public Adapter caseEventSourceUsage(EventSourceUsage object)
      {
        return createEventSourceUsageAdapter();
      }
      @Override
      public Adapter caseModelElements(ModelElements object)
      {
        return createModelElementsAdapter();
      }
      @Override
      public Adapter caseEvent(Event object)
      {
        return createEventAdapter();
      }
      @Override
      public Adapter caseAbstractAtomicEvent(AbstractAtomicEvent object)
      {
        return createAbstractAtomicEventAdapter();
      }
      @Override
      public Adapter caseAtomicEvent(AtomicEvent object)
      {
        return createAtomicEventAdapter();
      }
      @Override
      public Adapter caseIQPatternEvent(IQPatternEvent object)
      {
        return createIQPatternEventAdapter();
      }
      @Override
      public Adapter caseComplexEvent(ComplexEvent object)
      {
        return createComplexEventAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseCEParamlist(CEParamlist object)
      {
        return createCEParamlistAdapter();
      }
      @Override
      public Adapter caseEventParamWithType(EventParamWithType object)
      {
        return createEventParamWithTypeAdapter();
      }
      @Override
      public Adapter caseParameterFilter(ParameterFilter object)
      {
        return createParameterFilterAdapter();
      }
      @Override
      public Adapter caseParameterFilterRule(ParameterFilterRule object)
      {
        return createParameterFilterRuleAdapter();
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
      public Adapter caseComplexEventExpression(ComplexEventExpression object)
      {
        return createComplexEventExpressionAdapter();
      }
      @Override
      public Adapter caseFollowsExpression(FollowsExpression object)
      {
        return createFollowsExpressionAdapter();
      }
      @Override
      public Adapter caseEventWithFollowsOperator(EventWithFollowsOperator object)
      {
        return createEventWithFollowsOperatorAdapter();
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
      public Adapter caseFollowsOperatorViaTW(FollowsOperatorViaTW object)
      {
        return createFollowsOperatorViaTWAdapter();
      }
      @Override
      public Adapter caseFollowerEventStructure(FollowerEventStructure object)
      {
        return createFollowerEventStructureAdapter();
      }
      @Override
      public Adapter caseBranchExpression(BranchExpression object)
      {
        return createBranchExpressionAdapter();
      }
      @Override
      public Adapter caseEventWithMultiplicity(EventWithMultiplicity object)
      {
        return createEventWithMultiplicityAdapter();
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
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQUsage <em>IQ Usage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQUsage
   * @generated
   */
  public Adapter createIQUsageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventSourceUsage <em>Event Source Usage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventSourceUsage
   * @generated
   */
  public Adapter createEventSourceUsageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElements <em>Model Elements</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElements
   * @generated
   */
  public Adapter createModelElementsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Event
   * @generated
   */
  public Adapter createEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEvent <em>Abstract Atomic Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AbstractAtomicEvent
   * @generated
   */
  public Adapter createAbstractAtomicEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent <em>Atomic Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEvent
   * @generated
   */
  public Adapter createAtomicEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent <em>IQ Pattern Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEvent
   * @generated
   */
  public Adapter createIQPatternEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent <em>Complex Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEvent
   * @generated
   */
  public Adapter createComplexEventAdapter()
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
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.CEParamlist <em>CE Paramlist</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.CEParamlist
   * @generated
   */
  public Adapter createCEParamlistAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType <em>Event Param With Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventParamWithType
   * @generated
   */
  public Adapter createEventParamWithTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter <em>Parameter Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilter
   * @generated
   */
  public Adapter createParameterFilterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilterRule <em>Parameter Filter Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ParameterFilterRule
   * @generated
   */
  public Adapter createParameterFilterRuleAdapter()
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
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator <em>Event With Follows Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithFollowsOperator
   * @generated
   */
  public Adapter createEventWithFollowsOperatorAdapter()
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
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW <em>Follows Operator Via TW</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW
   * @generated
   */
  public Adapter createFollowsOperatorViaTWAdapter()
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
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithMultiplicity <em>Event With Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventWithMultiplicity
   * @generated
   */
  public Adapter createEventWithMultiplicityAdapter()
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
