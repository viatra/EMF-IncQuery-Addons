/**
 */
package hu.bme.mit.incquery.vedl.edl.util;

import hu.bme.mit.incquery.vedl.edl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage
 * @generated
 */
public class EdlAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EdlPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EdlAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = EdlPackage.eINSTANCE;
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
  protected EdlSwitch<Adapter> modelSwitch =
    new EdlSwitch<Adapter>()
    {
      @Override
      public Adapter casePackageDeclaration(PackageDeclaration object)
      {
        return createPackageDeclarationAdapter();
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
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
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
      public Adapter caseCEParamlist(CEParamlist object)
      {
        return createCEParamlistAdapter();
      }
      @Override
      public Adapter caseParamWithType(ParamWithType object)
      {
        return createParamWithTypeAdapter();
      }
      @Override
      public Adapter caseParameterFilter(ParameterFilter object)
      {
        return createParameterFilterAdapter();
      }
      @Override
      public Adapter caseIQPattern(IQPattern object)
      {
        return createIQPatternAdapter();
      }
      @Override
      public Adapter caseAnnotations(Annotations object)
      {
        return createAnnotationsAdapter();
      }
      @Override
      public Adapter caseContextAnnotation(ContextAnnotation object)
      {
        return createContextAnnotationAdapter();
      }
      @Override
      public Adapter caseSamplingAnnotation(SamplingAnnotation object)
      {
        return createSamplingAnnotationAdapter();
      }
      @Override
      public Adapter casePriorityAnnotation(PriorityAnnotation object)
      {
        return createPriorityAnnotationAdapter();
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
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.PackageDeclaration
   * @generated
   */
  public Adapter createPackageDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.Usage <em>Usage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.Usage
   * @generated
   */
  public Adapter createUsageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.IQUsage <em>IQ Usage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.IQUsage
   * @generated
   */
  public Adapter createIQUsageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.EventSourceUsage <em>Event Source Usage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.EventSourceUsage
   * @generated
   */
  public Adapter createEventSourceUsageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.Event
   * @generated
   */
  public Adapter createEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.AbstractAtomicEvent <em>Abstract Atomic Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.AbstractAtomicEvent
   * @generated
   */
  public Adapter createAbstractAtomicEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.AtomicEvent <em>Atomic Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.AtomicEvent
   * @generated
   */
  public Adapter createAtomicEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.IQPatternEvent <em>IQ Pattern Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.IQPatternEvent
   * @generated
   */
  public Adapter createIQPatternEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.ComplexEvent <em>Complex Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.ComplexEvent
   * @generated
   */
  public Adapter createComplexEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.CEParamlist <em>CE Paramlist</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.CEParamlist
   * @generated
   */
  public Adapter createCEParamlistAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.ParamWithType <em>Param With Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.ParamWithType
   * @generated
   */
  public Adapter createParamWithTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.ParameterFilter <em>Parameter Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.ParameterFilter
   * @generated
   */
  public Adapter createParameterFilterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.IQPattern <em>IQ Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.IQPattern
   * @generated
   */
  public Adapter createIQPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.Annotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.Annotations
   * @generated
   */
  public Adapter createAnnotationsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.ContextAnnotation <em>Context Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.ContextAnnotation
   * @generated
   */
  public Adapter createContextAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.SamplingAnnotation <em>Sampling Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.SamplingAnnotation
   * @generated
   */
  public Adapter createSamplingAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.PriorityAnnotation <em>Priority Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.PriorityAnnotation
   * @generated
   */
  public Adapter createPriorityAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.ParameterFilterRule <em>Parameter Filter Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.ParameterFilterRule
   * @generated
   */
  public Adapter createParameterFilterRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.RangeFilter <em>Range Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.RangeFilter
   * @generated
   */
  public Adapter createRangeFilterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.Range
   * @generated
   */
  public Adapter createRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.OpenOpen <em>Open Open</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.OpenOpen
   * @generated
   */
  public Adapter createOpenOpenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.OpenClosed <em>Open Closed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.OpenClosed
   * @generated
   */
  public Adapter createOpenClosedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.ClosedClosed <em>Closed Closed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.ClosedClosed
   * @generated
   */
  public Adapter createClosedClosedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.ClosedOpen <em>Closed Open</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.ClosedOpen
   * @generated
   */
  public Adapter createClosedOpenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.NumericFilter <em>Numeric Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.NumericFilter
   * @generated
   */
  public Adapter createNumericFilterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.vedl.edl.LiteralFilter <em>Literal Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see hu.bme.mit.incquery.vedl.edl.LiteralFilter
   * @generated
   */
  public Adapter createLiteralFilterAdapter()
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

} //EdlAdapterFactory
