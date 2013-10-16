/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage
 * @generated
 */
public interface EventPatternLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EventPatternLanguageFactory eINSTANCE = hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.EventPatternLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Event Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Model</em>'.
   * @generated
   */
  EventModel createEventModel();

  /**
   * Returns a new object of class '<em>Usage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Usage</em>'.
   * @generated
   */
  Usage createUsage();

  /**
   * Returns a new object of class '<em>IQ Usage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IQ Usage</em>'.
   * @generated
   */
  IQUsage createIQUsage();

  /**
   * Returns a new object of class '<em>Event Source Usage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Source Usage</em>'.
   * @generated
   */
  EventSourceUsage createEventSourceUsage();

  /**
   * Returns a new object of class '<em>Model Elements</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Elements</em>'.
   * @generated
   */
  ModelElements createModelElements();

  /**
   * Returns a new object of class '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event</em>'.
   * @generated
   */
  Event createEvent();

  /**
   * Returns a new object of class '<em>Abstract Atomic Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Atomic Event</em>'.
   * @generated
   */
  AbstractAtomicEvent createAbstractAtomicEvent();

  /**
   * Returns a new object of class '<em>Atomic Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Event</em>'.
   * @generated
   */
  AtomicEvent createAtomicEvent();

  /**
   * Returns a new object of class '<em>IQ Pattern Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IQ Pattern Event</em>'.
   * @generated
   */
  IQPatternEvent createIQPatternEvent();

  /**
   * Returns a new object of class '<em>Complex Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Complex Event</em>'.
   * @generated
   */
  ComplexEvent createComplexEvent();

  /**
   * Returns a new object of class '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule</em>'.
   * @generated
   */
  Rule createRule();

  /**
   * Returns a new object of class '<em>Typed Parameter List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typed Parameter List</em>'.
   * @generated
   */
  TypedParameterList createTypedParameterList();

  /**
   * Returns a new object of class '<em>Typed Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typed Parameter</em>'.
   * @generated
   */
  TypedParameter createTypedParameter();

  /**
   * Returns a new object of class '<em>Event Parameter List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Parameter List</em>'.
   * @generated
   */
  EventParameterList createEventParameterList();

  /**
   * Returns a new object of class '<em>Event Typed Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Typed Parameter</em>'.
   * @generated
   */
  EventTypedParameter createEventTypedParameter();

  /**
   * Returns a new object of class '<em>Static Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Static Binding</em>'.
   * @generated
   */
  StaticBinding createStaticBinding();

  /**
   * Returns a new object of class '<em>Static Binding Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Static Binding Rule</em>'.
   * @generated
   */
  StaticBindingRule createStaticBindingRule();

  /**
   * Returns a new object of class '<em>Range Filter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range Filter</em>'.
   * @generated
   */
  RangeFilter createRangeFilter();

  /**
   * Returns a new object of class '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range</em>'.
   * @generated
   */
  Range createRange();

  /**
   * Returns a new object of class '<em>Open Open</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Open Open</em>'.
   * @generated
   */
  OpenOpen createOpenOpen();

  /**
   * Returns a new object of class '<em>Open Closed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Open Closed</em>'.
   * @generated
   */
  OpenClosed createOpenClosed();

  /**
   * Returns a new object of class '<em>Closed Closed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Closed Closed</em>'.
   * @generated
   */
  ClosedClosed createClosedClosed();

  /**
   * Returns a new object of class '<em>Closed Open</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Closed Open</em>'.
   * @generated
   */
  ClosedOpen createClosedOpen();

  /**
   * Returns a new object of class '<em>Numeric Filter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numeric Filter</em>'.
   * @generated
   */
  NumericFilter createNumericFilter();

  /**
   * Returns a new object of class '<em>Literal Filter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Filter</em>'.
   * @generated
   */
  LiteralFilter createLiteralFilter();

  /**
   * Returns a new object of class '<em>Complex Event Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Complex Event Expression</em>'.
   * @generated
   */
  ComplexEventExpression createComplexEventExpression();

  /**
   * Returns a new object of class '<em>Follows Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Follows Expression</em>'.
   * @generated
   */
  FollowsExpression createFollowsExpression();

  /**
   * Returns a new object of class '<em>Event With Follows Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event With Follows Operator</em>'.
   * @generated
   */
  EventWithFollowsOperator createEventWithFollowsOperator();

  /**
   * Returns a new object of class '<em>Follows Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Follows Operator</em>'.
   * @generated
   */
  FollowsOperator createFollowsOperator();

  /**
   * Returns a new object of class '<em>Follows Operator No TW</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Follows Operator No TW</em>'.
   * @generated
   */
  FollowsOperatorNoTW createFollowsOperatorNoTW();

  /**
   * Returns a new object of class '<em>Follows Operator Via TW</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Follows Operator Via TW</em>'.
   * @generated
   */
  FollowsOperatorViaTW createFollowsOperatorViaTW();

  /**
   * Returns a new object of class '<em>Follower Event Structure</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Follower Event Structure</em>'.
   * @generated
   */
  FollowerEventStructure createFollowerEventStructure();

  /**
   * Returns a new object of class '<em>Branch Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Branch Expression</em>'.
   * @generated
   */
  BranchExpression createBranchExpression();

  /**
   * Returns a new object of class '<em>Event With Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event With Multiplicity</em>'.
   * @generated
   */
  EventWithMultiplicity createEventWithMultiplicity();

  /**
   * Returns a new object of class '<em>Pattern Call Parameter List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Call Parameter List</em>'.
   * @generated
   */
  PatternCallParameterList createPatternCallParameterList();

  /**
   * Returns a new object of class '<em>Pattern Call Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Call Parameter</em>'.
   * @generated
   */
  PatternCallParameter createPatternCallParameter();

  /**
   * Returns a new object of class '<em>Source</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Source</em>'.
   * @generated
   */
  Source createSource();

  /**
   * Returns a new object of class '<em>Adapter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Adapter</em>'.
   * @generated
   */
  Adapter createAdapter();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EventPatternLanguagePackage getEventPatternLanguagePackage();

} //EventPatternLanguageFactory
