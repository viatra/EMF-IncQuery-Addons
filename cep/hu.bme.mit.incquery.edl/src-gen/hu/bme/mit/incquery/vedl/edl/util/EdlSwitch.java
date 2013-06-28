/**
 */
package hu.bme.mit.incquery.vedl.edl.util;

import hu.bme.mit.incquery.vedl.edl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage
 * @generated
 */
public class EdlSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EdlPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EdlSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = EdlPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case EdlPackage.PACKAGE_DECLARATION:
      {
        PackageDeclaration packageDeclaration = (PackageDeclaration)theEObject;
        T result = casePackageDeclaration(packageDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.USAGE:
      {
        Usage usage = (Usage)theEObject;
        T result = caseUsage(usage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.IQ_USAGE:
      {
        IQUsage iqUsage = (IQUsage)theEObject;
        T result = caseIQUsage(iqUsage);
        if (result == null) result = caseUsage(iqUsage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.EVENT_SOURCE_USAGE:
      {
        EventSourceUsage eventSourceUsage = (EventSourceUsage)theEObject;
        T result = caseEventSourceUsage(eventSourceUsage);
        if (result == null) result = caseUsage(eventSourceUsage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.EVENT:
      {
        Event event = (Event)theEObject;
        T result = caseEvent(event);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.ABSTRACT_ATOMIC_EVENT:
      {
        AbstractAtomicEvent abstractAtomicEvent = (AbstractAtomicEvent)theEObject;
        T result = caseAbstractAtomicEvent(abstractAtomicEvent);
        if (result == null) result = caseEvent(abstractAtomicEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.ATOMIC_EVENT:
      {
        AtomicEvent atomicEvent = (AtomicEvent)theEObject;
        T result = caseAtomicEvent(atomicEvent);
        if (result == null) result = caseAbstractAtomicEvent(atomicEvent);
        if (result == null) result = caseEvent(atomicEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.IQ_PATTERN_EVENT:
      {
        IQPatternEvent iqPatternEvent = (IQPatternEvent)theEObject;
        T result = caseIQPatternEvent(iqPatternEvent);
        if (result == null) result = caseAbstractAtomicEvent(iqPatternEvent);
        if (result == null) result = caseEvent(iqPatternEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.COMPLEX_EVENT:
      {
        ComplexEvent complexEvent = (ComplexEvent)theEObject;
        T result = caseComplexEvent(complexEvent);
        if (result == null) result = caseEvent(complexEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.CE_PARAMLIST:
      {
        CEParamlist ceParamlist = (CEParamlist)theEObject;
        T result = caseCEParamlist(ceParamlist);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.PARAM_WITH_TYPE:
      {
        ParamWithType paramWithType = (ParamWithType)theEObject;
        T result = caseParamWithType(paramWithType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.PARAMETER_FILTER:
      {
        ParameterFilter parameterFilter = (ParameterFilter)theEObject;
        T result = caseParameterFilter(parameterFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.IQ_PATTERN:
      {
        IQPattern iqPattern = (IQPattern)theEObject;
        T result = caseIQPattern(iqPattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.ANNOTATIONS:
      {
        Annotations annotations = (Annotations)theEObject;
        T result = caseAnnotations(annotations);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.CONTEXT_ANNOTATION:
      {
        ContextAnnotation contextAnnotation = (ContextAnnotation)theEObject;
        T result = caseContextAnnotation(contextAnnotation);
        if (result == null) result = caseAnnotations(contextAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.SAMPLING_ANNOTATION:
      {
        SamplingAnnotation samplingAnnotation = (SamplingAnnotation)theEObject;
        T result = caseSamplingAnnotation(samplingAnnotation);
        if (result == null) result = caseAnnotations(samplingAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.PRIORITY_ANNOTATION:
      {
        PriorityAnnotation priorityAnnotation = (PriorityAnnotation)theEObject;
        T result = casePriorityAnnotation(priorityAnnotation);
        if (result == null) result = caseAnnotations(priorityAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.PARAMETER_FILTER_RULE:
      {
        ParameterFilterRule parameterFilterRule = (ParameterFilterRule)theEObject;
        T result = caseParameterFilterRule(parameterFilterRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.RANGE_FILTER:
      {
        RangeFilter rangeFilter = (RangeFilter)theEObject;
        T result = caseRangeFilter(rangeFilter);
        if (result == null) result = caseParameterFilterRule(rangeFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.RANGE:
      {
        Range range = (Range)theEObject;
        T result = caseRange(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.OPEN_OPEN:
      {
        OpenOpen openOpen = (OpenOpen)theEObject;
        T result = caseOpenOpen(openOpen);
        if (result == null) result = caseRange(openOpen);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.OPEN_CLOSED:
      {
        OpenClosed openClosed = (OpenClosed)theEObject;
        T result = caseOpenClosed(openClosed);
        if (result == null) result = caseRange(openClosed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.CLOSED_CLOSED:
      {
        ClosedClosed closedClosed = (ClosedClosed)theEObject;
        T result = caseClosedClosed(closedClosed);
        if (result == null) result = caseRange(closedClosed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.CLOSED_OPEN:
      {
        ClosedOpen closedOpen = (ClosedOpen)theEObject;
        T result = caseClosedOpen(closedOpen);
        if (result == null) result = caseRange(closedOpen);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.NUMERIC_FILTER:
      {
        NumericFilter numericFilter = (NumericFilter)theEObject;
        T result = caseNumericFilter(numericFilter);
        if (result == null) result = caseParameterFilterRule(numericFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EdlPackage.LITERAL_FILTER:
      {
        LiteralFilter literalFilter = (LiteralFilter)theEObject;
        T result = caseLiteralFilter(literalFilter);
        if (result == null) result = caseParameterFilterRule(literalFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDeclaration(PackageDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Usage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Usage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUsage(Usage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IQ Usage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IQ Usage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIQUsage(IQUsage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Source Usage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Source Usage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventSourceUsage(EventSourceUsage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvent(Event object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Atomic Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Atomic Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractAtomicEvent(AbstractAtomicEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atomic Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atomic Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomicEvent(AtomicEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IQ Pattern Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IQ Pattern Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIQPatternEvent(IQPatternEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexEvent(ComplexEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CE Paramlist</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CE Paramlist</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCEParamlist(CEParamlist object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Param With Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Param With Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParamWithType(ParamWithType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterFilter(ParameterFilter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IQ Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IQ Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIQPattern(IQPattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotations</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotations</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotations(Annotations object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextAnnotation(ContextAnnotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sampling Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sampling Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSamplingAnnotation(SamplingAnnotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Priority Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Priority Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePriorityAnnotation(PriorityAnnotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Filter Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Filter Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterFilterRule(ParameterFilterRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRangeFilter(RangeFilter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRange(Range object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Open Open</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Open Open</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOpenOpen(OpenOpen object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Open Closed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Open Closed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOpenClosed(OpenClosed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Closed Closed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Closed Closed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClosedClosed(ClosedClosed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Closed Open</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Closed Open</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClosedOpen(ClosedOpen object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numeric Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numeric Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericFilter(NumericFilter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralFilter(LiteralFilter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //EdlSwitch
