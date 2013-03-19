/**
 */
package hu.bme.mit.incquery.cep.model.cep.impl;

import hu.bme.mit.incquery.cep.model.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.model.cep.CepFactory;
import hu.bme.mit.incquery.cep.model.cep.CepPackage;
import hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.model.cep.ComplexOperator;
import hu.bme.mit.incquery.cep.model.cep.Event;
import hu.bme.mit.incquery.cep.model.cep.EventProcessingModel;
import hu.bme.mit.incquery.cep.model.cep.Timewindow;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CepFactoryImpl extends EFactoryImpl implements CepFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CepFactory init() {
		try {
			CepFactory theCepFactory = (CepFactory)EPackage.Registry.INSTANCE.getEFactory("cep.meta"); 
			if (theCepFactory != null) {
				return theCepFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CepFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CepFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CepPackage.EVENT_PROCESSING_MODEL: return createEventProcessingModel();
			case CepPackage.ATOMIC_EVENT_PATTERN: return createAtomicEventPattern();
			case CepPackage.COMPLEX_EVENT_PATTERN: return createComplexEventPattern();
			case CepPackage.EVENT: return createEvent();
			case CepPackage.TIMEWINDOW: return createTimewindow();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CepPackage.COMPLEX_OPERATOR:
				return createComplexOperatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CepPackage.COMPLEX_OPERATOR:
				return convertComplexOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventProcessingModel createEventProcessingModel() {
		EventProcessingModelImpl eventProcessingModel = new EventProcessingModelImpl();
		return eventProcessingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicEventPattern createAtomicEventPattern() {
		AtomicEventPatternImpl atomicEventPattern = new AtomicEventPatternImpl();
		return atomicEventPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexEventPattern createComplexEventPattern() {
		ComplexEventPatternImpl complexEventPattern = new ComplexEventPatternImpl();
		return complexEventPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timewindow createTimewindow() {
		TimewindowImpl timewindow = new TimewindowImpl();
		return timewindow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexOperator createComplexOperatorFromString(EDataType eDataType, String initialValue) {
		ComplexOperator result = ComplexOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComplexOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CepPackage getCepPackage() {
		return (CepPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CepPackage getPackage() {
		return CepPackage.eINSTANCE;
	}

} //CepFactoryImpl
