/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding#getBindingRule <em>Binding Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getStaticBinding()
 * @model
 * @generated
 */
public interface StaticBinding extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' reference.
   * @see #setParameter(TypedParameter)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getStaticBinding_Parameter()
   * @model
   * @generated
   */
  TypedParameter getParameter();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding#getParameter <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' reference.
   * @see #getParameter()
   * @generated
   */
  void setParameter(TypedParameter value);

  /**
   * Returns the value of the '<em><b>Binding Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binding Rule</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binding Rule</em>' containment reference.
   * @see #setBindingRule(StaticBindingRule)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getStaticBinding_BindingRule()
   * @model containment="true"
   * @generated
   */
  StaticBindingRule getBindingRule();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding#getBindingRule <em>Binding Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Binding Rule</em>' containment reference.
   * @see #getBindingRule()
   * @generated
   */
  void setBindingRule(StaticBindingRule value);

} // StaticBinding
