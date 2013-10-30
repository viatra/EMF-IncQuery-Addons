/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Parameter List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getTypedParameterList()
 * @model
 * @generated
 */
public interface TypedParameterList extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getTypedParameterList_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<TypedParameter> getParameters();

} // TypedParameterList
