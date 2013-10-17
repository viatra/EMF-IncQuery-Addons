/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Expression#getEventPatterns <em>Event Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends ComplexEventExpression
{
  /**
   * Returns the value of the '<em><b>Event Patterns</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event Patterns</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event Patterns</em>' containment reference list.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getExpression_EventPatterns()
   * @model containment="true"
   * @generated
   */
  EList<EventTypedParameterWithMultiplicity> getEventPatterns();

} // Expression
