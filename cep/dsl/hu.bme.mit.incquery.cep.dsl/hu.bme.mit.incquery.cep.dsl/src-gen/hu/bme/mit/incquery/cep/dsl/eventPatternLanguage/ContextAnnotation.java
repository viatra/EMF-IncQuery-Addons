/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ContextAnnotation#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getContextAnnotation()
 * @model
 * @generated
 */
public interface ContextAnnotation extends Annotations
{
  /**
   * Returns the value of the '<em><b>Context</b></em>' attribute.
   * The literals are from the enumeration {@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context</em>' attribute.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context
   * @see #setContext(Context)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getContextAnnotation_Context()
   * @model
   * @generated
   */
  Context getContext();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ContextAnnotation#getContext <em>Context</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context</em>' attribute.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Context
   * @see #getContext()
   * @generated
   */
  void setContext(Context value);

} // ContextAnnotation
