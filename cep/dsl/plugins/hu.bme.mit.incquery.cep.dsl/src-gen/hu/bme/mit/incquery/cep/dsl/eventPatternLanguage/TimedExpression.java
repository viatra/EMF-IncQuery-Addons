/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression#getTimewindow <em>Timewindow</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getTimedExpression()
 * @model
 * @generated
 */
public interface TimedExpression extends AugmentedExpression
{
  /**
   * Returns the value of the '<em><b>Timewindow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timewindow</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timewindow</em>' containment reference.
   * @see #setTimewindow(Timewindow)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getTimedExpression_Timewindow()
   * @model containment="true"
   * @generated
   */
  Timewindow getTimewindow();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression#getTimewindow <em>Timewindow</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timewindow</em>' containment reference.
   * @see #getTimewindow()
   * @generated
   */
  void setTimewindow(Timewindow value);

} // TimedExpression
