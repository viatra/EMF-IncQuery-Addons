/**
 */
package hu.bme.mit.incquery.vedl.edl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.vedl.edl.EdlPackage
 * @generated
 */
public interface EdlFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EdlFactory eINSTANCE = hu.bme.mit.incquery.vedl.edl.impl.EdlFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Declaration</em>'.
   * @generated
   */
  PackageDeclaration createPackageDeclaration();

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
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

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
   * Returns a new object of class '<em>CE Paramlist</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CE Paramlist</em>'.
   * @generated
   */
  CEParamlist createCEParamlist();

  /**
   * Returns a new object of class '<em>Param With Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Param With Type</em>'.
   * @generated
   */
  ParamWithType createParamWithType();

  /**
   * Returns a new object of class '<em>Parameter Filter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Filter</em>'.
   * @generated
   */
  ParameterFilter createParameterFilter();

  /**
   * Returns a new object of class '<em>IQ Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IQ Pattern</em>'.
   * @generated
   */
  IQPattern createIQPattern();

  /**
   * Returns a new object of class '<em>Annotations</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotations</em>'.
   * @generated
   */
  Annotations createAnnotations();

  /**
   * Returns a new object of class '<em>Context Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Context Annotation</em>'.
   * @generated
   */
  ContextAnnotation createContextAnnotation();

  /**
   * Returns a new object of class '<em>Sampling Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sampling Annotation</em>'.
   * @generated
   */
  SamplingAnnotation createSamplingAnnotation();

  /**
   * Returns a new object of class '<em>Priority Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Priority Annotation</em>'.
   * @generated
   */
  PriorityAnnotation createPriorityAnnotation();

  /**
   * Returns a new object of class '<em>Parameter Filter Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Filter Rule</em>'.
   * @generated
   */
  ParameterFilterRule createParameterFilterRule();

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
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EdlPackage getEdlPackage();

} //EdlFactory