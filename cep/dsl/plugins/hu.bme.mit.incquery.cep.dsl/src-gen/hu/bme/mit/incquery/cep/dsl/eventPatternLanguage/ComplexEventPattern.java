/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getPriority <em>Priority</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getComplexEventExpression <em>Complex Event Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getComplexEventPattern()
 * @model
 * @generated
 */
public interface ComplexEventPattern extends EventPattern
{
  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference.
   * @see #setParameters(EventPatternParameterList)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getComplexEventPattern_Parameters()
   * @model containment="true"
   * @generated
   */
  EventPatternParameterList getParameters();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getParameters <em>Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameters</em>' containment reference.
   * @see #getParameters()
   * @generated
   */
  void setParameters(EventPatternParameterList value);

  /**
   * Returns the value of the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' attribute.
   * @see #setPriority(int)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getComplexEventPattern_Priority()
   * @model
   * @generated
   */
  int getPriority();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getPriority <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' attribute.
   * @see #getPriority()
   * @generated
   */
  void setPriority(int value);

  /**
   * Returns the value of the '<em><b>Complex Event Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Complex Event Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Complex Event Expression</em>' containment reference.
   * @see #setComplexEventExpression(ComplexEventExpression)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getComplexEventPattern_ComplexEventExpression()
   * @model containment="true"
   * @generated
   */
  ComplexEventExpression getComplexEventExpression();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern#getComplexEventExpression <em>Complex Event Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Complex Event Expression</em>' containment reference.
   * @see #getComplexEventExpression()
   * @generated
   */
  void setComplexEventExpression(ComplexEventExpression value);

} // ComplexEventPattern
