/**
 */
package hu.bme.mit.incquery.cep.casestudy.transaction;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.casestudy.transaction.TransactionFactory
 * @model kind="package"
 * @generated
 */
public interface TransactionPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "transaction";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "transaction.meta";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "hu.bme.mit.incquery.cep.casestudy.transaction";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    TransactionPackage eINSTANCE = hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl.init();

    /**
     * The meta object id for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl <em>Compound Transaction Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl
     * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getCompoundTransactionEvent()
     * @generated
     */
    int COMPOUND_TRANSACTION_EVENT = 0;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOUND_TRANSACTION_EVENT__TIMESTAMP = 0;

    /**
     * The number of structural features of the '<em>Compound Transaction Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOUND_TRANSACTION_EVENT_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Compound Transaction Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOUND_TRANSACTION_EVENT_OPERATION_COUNT = 0;


    /**
     * Returns the meta object for class '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent <em>Compound Transaction Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Compound Transaction Event</em>'.
     * @see hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent
     * @generated
     */
    EClass getCompoundTransactionEvent();

    /**
     * Returns the meta object for the attribute '{@link hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestamp <em>Timestamp</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timestamp</em>'.
     * @see hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent#getTimestamp()
     * @see #getCompoundTransactionEvent()
     * @generated
     */
    EAttribute getCompoundTransactionEvent_Timestamp();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    TransactionFactory getTransactionFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl <em>Compound Transaction Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.CompoundTransactionEventImpl
         * @see hu.bme.mit.incquery.cep.casestudy.transaction.impl.TransactionPackageImpl#getCompoundTransactionEvent()
         * @generated
         */
        EClass COMPOUND_TRANSACTION_EVENT = eINSTANCE.getCompoundTransactionEvent();

        /**
         * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPOUND_TRANSACTION_EVENT__TIMESTAMP = eINSTANCE.getCompoundTransactionEvent_Timestamp();

    }

} //TransactionPackage
