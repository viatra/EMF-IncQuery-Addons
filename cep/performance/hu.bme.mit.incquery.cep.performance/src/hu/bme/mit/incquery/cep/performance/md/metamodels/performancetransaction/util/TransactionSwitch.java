/**
 */
package hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.util;

import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionPackage
 * @generated
 */
public class TransactionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TransactionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionSwitch() {
		if (modelPackage == null) {
			modelPackage = TransactionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TransactionPackage.TRANSACTION_MODEL: {
				TransactionModel transactionModel = (TransactionModel)theEObject;
				T result = caseTransactionModel(transactionModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.MODEL_ELEMENT: {
				ModelElement modelElement = (ModelElement)theEObject;
				T result = caseModelElement(modelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseModelElement(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_A: {
				TransactionComponentA transactionComponentA = (TransactionComponentA)theEObject;
				T result = caseTransactionComponentA(transactionComponentA);
				if (result == null) result = caseComponent(transactionComponentA);
				if (result == null) result = caseModelElement(transactionComponentA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_B: {
				TransactionComponentB transactionComponentB = (TransactionComponentB)theEObject;
				T result = caseTransactionComponentB(transactionComponentB);
				if (result == null) result = caseComponent(transactionComponentB);
				if (result == null) result = caseModelElement(transactionComponentB);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_C: {
				TransactionComponentC transactionComponentC = (TransactionComponentC)theEObject;
				T result = caseTransactionComponentC(transactionComponentC);
				if (result == null) result = caseComponent(transactionComponentC);
				if (result == null) result = caseModelElement(transactionComponentC);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_D: {
				TransactionComponentD transactionComponentD = (TransactionComponentD)theEObject;
				T result = caseTransactionComponentD(transactionComponentD);
				if (result == null) result = caseComponent(transactionComponentD);
				if (result == null) result = caseModelElement(transactionComponentD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_E: {
				TransactionComponentE transactionComponentE = (TransactionComponentE)theEObject;
				T result = caseTransactionComponentE(transactionComponentE);
				if (result == null) result = caseComponent(transactionComponentE);
				if (result == null) result = caseModelElement(transactionComponentE);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_F: {
				TransactionComponentF transactionComponentF = (TransactionComponentF)theEObject;
				T result = caseTransactionComponentF(transactionComponentF);
				if (result == null) result = caseComponent(transactionComponentF);
				if (result == null) result = caseModelElement(transactionComponentF);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_G: {
				TransactionComponentG transactionComponentG = (TransactionComponentG)theEObject;
				T result = caseTransactionComponentG(transactionComponentG);
				if (result == null) result = caseComponent(transactionComponentG);
				if (result == null) result = caseModelElement(transactionComponentG);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_H: {
				TransactionComponentH transactionComponentH = (TransactionComponentH)theEObject;
				T result = caseTransactionComponentH(transactionComponentH);
				if (result == null) result = caseComponent(transactionComponentH);
				if (result == null) result = caseModelElement(transactionComponentH);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_I: {
				TransactionComponentI transactionComponentI = (TransactionComponentI)theEObject;
				T result = caseTransactionComponentI(transactionComponentI);
				if (result == null) result = caseComponent(transactionComponentI);
				if (result == null) result = caseModelElement(transactionComponentI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.TRANSACTION_COMPONENT_J: {
				TransactionComponentJ transactionComponentJ = (TransactionComponentJ)theEObject;
				T result = caseTransactionComponentJ(transactionComponentJ);
				if (result == null) result = caseComponent(transactionComponentJ);
				if (result == null) result = caseModelElement(transactionComponentJ);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransactionPackage.COMPOUND_TRANSACTION_EVENT: {
				CompoundTransactionEvent compoundTransactionEvent = (CompoundTransactionEvent)theEObject;
				T result = caseCompoundTransactionEvent(compoundTransactionEvent);
				if (result == null) result = caseModelElement(compoundTransactionEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionModel(TransactionModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElement(ModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component A</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component A</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentA(TransactionComponentA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component B</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component B</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentB(TransactionComponentB object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component C</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component C</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentC(TransactionComponentC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentD(TransactionComponentD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component E</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component E</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentE(TransactionComponentE object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component F</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component F</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentF(TransactionComponentF object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component G</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component G</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentG(TransactionComponentG object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component H</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component H</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentH(TransactionComponentH object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component I</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component I</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentI(TransactionComponentI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component J</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component J</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionComponentJ(TransactionComponentJ object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Transaction Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Transaction Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundTransactionEvent(CompoundTransactionEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TransactionSwitch
