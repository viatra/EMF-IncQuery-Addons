/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IQ Pattern Event Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern#getIqPatternRef <em>Iq Pattern Ref</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern#getIqChangeType <em>Iq Change Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getIQPatternEventPattern()
 * @model
 * @generated
 */
public interface IQPatternEventPattern extends AbstractAtomicEventPattern
{
  /**
   * Returns the value of the '<em><b>Iq Pattern Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iq Pattern Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iq Pattern Ref</em>' containment reference.
   * @see #setIqPatternRef(ParametrizedIncQueryPatternReference)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getIQPatternEventPattern_IqPatternRef()
   * @model containment="true"
   * @generated
   */
  ParametrizedIncQueryPatternReference getIqPatternRef();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern#getIqPatternRef <em>Iq Pattern Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Iq Pattern Ref</em>' containment reference.
   * @see #getIqPatternRef()
   * @generated
   */
  void setIqPatternRef(ParametrizedIncQueryPatternReference value);

  /**
   * Returns the value of the '<em><b>Iq Change Type</b></em>' attribute.
   * The literals are from the enumeration {@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iq Change Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iq Change Type</em>' attribute.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType
   * @see #setIqChangeType(IQPatternChangeType)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getIQPatternEventPattern_IqChangeType()
   * @model
   * @generated
   */
  IQPatternChangeType getIqChangeType();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern#getIqChangeType <em>Iq Change Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Iq Change Type</em>' attribute.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternChangeType
   * @see #getIqChangeType()
   * @generated
   */
  void setIqChangeType(IQPatternChangeType value);

} // IQPatternEventPattern
