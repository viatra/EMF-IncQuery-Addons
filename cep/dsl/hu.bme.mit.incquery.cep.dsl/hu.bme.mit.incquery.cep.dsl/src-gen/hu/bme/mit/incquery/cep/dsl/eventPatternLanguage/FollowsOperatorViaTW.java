/**
 */
package hu.bme.mit.incquery.cep.dsl.eventPatternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Follows Operator Via TW</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW#getTimewindow <em>Timewindow</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getFollowsOperatorViaTW()
 * @model
 * @generated
 */
public interface FollowsOperatorViaTW extends FollowsOperator
{
  /**
   * Returns the value of the '<em><b>Timewindow</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timewindow</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timewindow</em>' attribute.
   * @see #setTimewindow(int)
   * @see hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage#getFollowsOperatorViaTW_Timewindow()
   * @model
   * @generated
   */
  int getTimewindow();

  /**
   * Sets the value of the '{@link hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.FollowsOperatorViaTW#getTimewindow <em>Timewindow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timewindow</em>' attribute.
   * @see #getTimewindow()
   * @generated
   */
  void setTimewindow(int value);

} // FollowsOperatorViaTW
