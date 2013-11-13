/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.util;

import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.*;

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
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage
 * @generated
 */
public class EventPatternLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EventPatternLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventPatternLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = EventPatternLanguagePackage.eINSTANCE;
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
      case EventPatternLanguagePackage.EVENT_MODEL:
      {
        EventModel eventModel = (EventModel)theEObject;
        T result = caseEventModel(eventModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.PACKAGED_MODEL:
      {
        PackagedModel packagedModel = (PackagedModel)theEObject;
        T result = casePackagedModel(packagedModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.USAGE:
      {
        Usage usage = (Usage)theEObject;
        T result = caseUsage(usage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.MODEL_ELEMENT:
      {
        ModelElement modelElement = (ModelElement)theEObject;
        T result = caseModelElement(modelElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.EVENT_PATTERN:
      {
        EventPattern eventPattern = (EventPattern)theEObject;
        T result = caseEventPattern(eventPattern);
        if (result == null) result = caseModelElement(eventPattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.ABSTRACT_ATOMIC_EVENT_PATTERN:
      {
        AbstractAtomicEventPattern abstractAtomicEventPattern = (AbstractAtomicEventPattern)theEObject;
        T result = caseAbstractAtomicEventPattern(abstractAtomicEventPattern);
        if (result == null) result = caseEventPattern(abstractAtomicEventPattern);
        if (result == null) result = caseModelElement(abstractAtomicEventPattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.ATOMIC_EVENT_PATTERN:
      {
        AtomicEventPattern atomicEventPattern = (AtomicEventPattern)theEObject;
        T result = caseAtomicEventPattern(atomicEventPattern);
        if (result == null) result = caseAbstractAtomicEventPattern(atomicEventPattern);
        if (result == null) result = caseEventPattern(atomicEventPattern);
        if (result == null) result = caseModelElement(atomicEventPattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.IQ_PATTERN_EVENT_PATTERN:
      {
        IQPatternEventPattern iqPatternEventPattern = (IQPatternEventPattern)theEObject;
        T result = caseIQPatternEventPattern(iqPatternEventPattern);
        if (result == null) result = caseAbstractAtomicEventPattern(iqPatternEventPattern);
        if (result == null) result = caseEventPattern(iqPatternEventPattern);
        if (result == null) result = caseModelElement(iqPatternEventPattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.COMPLEX_EVENT_PATTERN:
      {
        ComplexEventPattern complexEventPattern = (ComplexEventPattern)theEObject;
        T result = caseComplexEventPattern(complexEventPattern);
        if (result == null) result = caseEventPattern(complexEventPattern);
        if (result == null) result = caseModelElement(complexEventPattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.RULE:
      {
        Rule rule = (Rule)theEObject;
        T result = caseRule(rule);
        if (result == null) result = caseModelElement(rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.TYPED_PARAMETER_LIST:
      {
        TypedParameterList typedParameterList = (TypedParameterList)theEObject;
        T result = caseTypedParameterList(typedParameterList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.TYPED_PARAMETER:
      {
        TypedParameter typedParameter = (TypedParameter)theEObject;
        T result = caseTypedParameter(typedParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.EVENT_PATTERN_PARAMETER_LIST:
      {
        EventPatternParameterList eventPatternParameterList = (EventPatternParameterList)theEObject;
        T result = caseEventPatternParameterList(eventPatternParameterList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER:
      {
        EventTypedParameter eventTypedParameter = (EventTypedParameter)theEObject;
        T result = caseEventTypedParameter(eventTypedParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.PARAMETRIZED_INC_QUERY_PATTERN_REFERENCE:
      {
        ParametrizedIncQueryPatternReference parametrizedIncQueryPatternReference = (ParametrizedIncQueryPatternReference)theEObject;
        T result = caseParametrizedIncQueryPatternReference(parametrizedIncQueryPatternReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.MULTIPLICITY:
      {
        Multiplicity multiplicity = (Multiplicity)theEObject;
        T result = caseMultiplicity(multiplicity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.TIMEWINDOW:
      {
        Timewindow timewindow = (Timewindow)theEObject;
        T result = caseTimewindow(timewindow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY:
      {
        EventTypedParameterWithMultiplicity eventTypedParameterWithMultiplicity = (EventTypedParameterWithMultiplicity)theEObject;
        T result = caseEventTypedParameterWithMultiplicity(eventTypedParameterWithMultiplicity);
        if (result == null) result = caseFollowerEventStructure(eventTypedParameterWithMultiplicity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.PATTERN_CALL_PARAMETER_LIST:
      {
        PatternCallParameterList patternCallParameterList = (PatternCallParameterList)theEObject;
        T result = casePatternCallParameterList(patternCallParameterList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.PATTERN_CALL_PARAMETER:
      {
        PatternCallParameter patternCallParameter = (PatternCallParameter)theEObject;
        T result = casePatternCallParameter(patternCallParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.COMPLEX_EVENT_EXPRESSION:
      {
        ComplexEventExpression complexEventExpression = (ComplexEventExpression)theEObject;
        T result = caseComplexEventExpression(complexEventExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.AUGMENTED_EXPRESSION:
      {
        AugmentedExpression augmentedExpression = (AugmentedExpression)theEObject;
        T result = caseAugmentedExpression(augmentedExpression);
        if (result == null) result = caseComplexEventExpression(augmentedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.TIMED_EXPRESSION:
      {
        TimedExpression timedExpression = (TimedExpression)theEObject;
        T result = caseTimedExpression(timedExpression);
        if (result == null) result = caseAugmentedExpression(timedExpression);
        if (result == null) result = caseComplexEventExpression(timedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.MULTIPLICITY_EXPRESSION:
      {
        MultiplicityExpression multiplicityExpression = (MultiplicityExpression)theEObject;
        T result = caseMultiplicityExpression(multiplicityExpression);
        if (result == null) result = caseAugmentedExpression(multiplicityExpression);
        if (result == null) result = caseComplexEventExpression(multiplicityExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.TIMED_MULTIPLICITY_EXPRESSION:
      {
        TimedMultiplicityExpression timedMultiplicityExpression = (TimedMultiplicityExpression)theEObject;
        T result = caseTimedMultiplicityExpression(timedMultiplicityExpression);
        if (result == null) result = caseAugmentedExpression(timedMultiplicityExpression);
        if (result == null) result = caseComplexEventExpression(timedMultiplicityExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseComplexEventExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.FOLLOWS_EXPRESSION:
      {
        FollowsExpression followsExpression = (FollowsExpression)theEObject;
        T result = caseFollowsExpression(followsExpression);
        if (result == null) result = caseExpression(followsExpression);
        if (result == null) result = caseComplexEventExpression(followsExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.FOLLOWER_EXPRESSION:
      {
        FollowerExpression followerExpression = (FollowerExpression)theEObject;
        T result = caseFollowerExpression(followerExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.FOLLOWER_EVENT_STRUCTURE:
      {
        FollowerEventStructure followerEventStructure = (FollowerEventStructure)theEObject;
        T result = caseFollowerEventStructure(followerEventStructure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.INNER_BRANCH_EXPRESSION:
      {
        InnerBranchExpression innerBranchExpression = (InnerBranchExpression)theEObject;
        T result = caseInnerBranchExpression(innerBranchExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.BRANCH_EXPRESSION:
      {
        BranchExpression branchExpression = (BranchExpression)theEObject;
        T result = caseBranchExpression(branchExpression);
        if (result == null) result = caseExpression(branchExpression);
        if (result == null) result = caseComplexEventExpression(branchExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.FOLLOWS_OPERATOR:
      {
        FollowsOperator followsOperator = (FollowsOperator)theEObject;
        T result = caseFollowsOperator(followsOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.FOLLOWS_OPERATOR_NO_TW:
      {
        FollowsOperatorNoTW followsOperatorNoTW = (FollowsOperatorNoTW)theEObject;
        T result = caseFollowsOperatorNoTW(followsOperatorNoTW);
        if (result == null) result = caseFollowsOperator(followsOperatorNoTW);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.STATIC_BINDING:
      {
        StaticBinding staticBinding = (StaticBinding)theEObject;
        T result = caseStaticBinding(staticBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.STATIC_BINDING_RULE:
      {
        StaticBindingRule staticBindingRule = (StaticBindingRule)theEObject;
        T result = caseStaticBindingRule(staticBindingRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.RANGE_FILTER:
      {
        RangeFilter rangeFilter = (RangeFilter)theEObject;
        T result = caseRangeFilter(rangeFilter);
        if (result == null) result = caseStaticBindingRule(rangeFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.RANGE:
      {
        Range range = (Range)theEObject;
        T result = caseRange(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.OPEN_OPEN:
      {
        OpenOpen openOpen = (OpenOpen)theEObject;
        T result = caseOpenOpen(openOpen);
        if (result == null) result = caseRange(openOpen);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.OPEN_CLOSED:
      {
        OpenClosed openClosed = (OpenClosed)theEObject;
        T result = caseOpenClosed(openClosed);
        if (result == null) result = caseRange(openClosed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.CLOSED_CLOSED:
      {
        ClosedClosed closedClosed = (ClosedClosed)theEObject;
        T result = caseClosedClosed(closedClosed);
        if (result == null) result = caseRange(closedClosed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.CLOSED_OPEN:
      {
        ClosedOpen closedOpen = (ClosedOpen)theEObject;
        T result = caseClosedOpen(closedOpen);
        if (result == null) result = caseRange(closedOpen);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.NUMERIC_FILTER:
      {
        NumericFilter numericFilter = (NumericFilter)theEObject;
        T result = caseNumericFilter(numericFilter);
        if (result == null) result = caseStaticBindingRule(numericFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.LITERAL_FILTER:
      {
        LiteralFilter literalFilter = (LiteralFilter)theEObject;
        T result = caseLiteralFilter(literalFilter);
        if (result == null) result = caseStaticBindingRule(literalFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.SOURCE:
      {
        Source source = (Source)theEObject;
        T result = caseSource(source);
        if (result == null) result = caseModelElement(source);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EventPatternLanguagePackage.ADAPTER:
      {
        Adapter adapter = (Adapter)theEObject;
        T result = caseAdapter(adapter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventModel(EventModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Packaged Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Packaged Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackagedModel(PackagedModel object)
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
   * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelElement(ModelElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventPattern(EventPattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Atomic Event Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Atomic Event Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractAtomicEventPattern(AbstractAtomicEventPattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atomic Event Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atomic Event Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomicEventPattern(AtomicEventPattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IQ Pattern Event Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IQ Pattern Event Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIQPatternEventPattern(IQPatternEventPattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Event Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Event Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexEventPattern(ComplexEventPattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule(Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Typed Parameter List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Typed Parameter List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypedParameterList(TypedParameterList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Typed Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Typed Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypedParameter(TypedParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Pattern Parameter List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Pattern Parameter List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventPatternParameterList(EventPatternParameterList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Typed Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Typed Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventTypedParameter(EventTypedParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parametrized Inc Query Pattern Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parametrized Inc Query Pattern Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParametrizedIncQueryPatternReference(ParametrizedIncQueryPatternReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicity(Multiplicity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Timewindow</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Timewindow</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimewindow(Timewindow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Typed Parameter With Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Typed Parameter With Multiplicity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventTypedParameterWithMultiplicity(EventTypedParameterWithMultiplicity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Call Parameter List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Call Parameter List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternCallParameterList(PatternCallParameterList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Call Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Call Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternCallParameter(PatternCallParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Event Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Event Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexEventExpression(ComplexEventExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Augmented Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Augmented Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAugmentedExpression(AugmentedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Timed Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Timed Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimedExpression(TimedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicityExpression(MultiplicityExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Timed Multiplicity Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Timed Multiplicity Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimedMultiplicityExpression(TimedMultiplicityExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Follows Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Follows Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFollowsExpression(FollowsExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Follower Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Follower Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFollowerExpression(FollowerExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Follower Event Structure</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Follower Event Structure</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFollowerEventStructure(FollowerEventStructure object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inner Branch Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inner Branch Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInnerBranchExpression(InnerBranchExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Branch Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Branch Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBranchExpression(BranchExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Follows Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Follows Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFollowsOperator(FollowsOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Follows Operator No TW</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Follows Operator No TW</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFollowsOperatorNoTW(FollowsOperatorNoTW object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Static Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Static Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStaticBinding(StaticBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Static Binding Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Static Binding Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStaticBindingRule(StaticBindingRule object)
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
   * Returns the result of interpreting the object as an instance of '<em>Source</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Source</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSource(Source object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Adapter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Adapter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdapter(Adapter object)
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

} //EventPatternLanguageSwitch
