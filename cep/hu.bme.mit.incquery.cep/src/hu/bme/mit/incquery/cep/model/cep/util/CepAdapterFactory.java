/**
 */
package hu.bme.mit.incquery.cep.model.cep.util;

import hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern;
import hu.bme.mit.incquery.cep.model.cep.AtomicEventPattern;
import hu.bme.mit.incquery.cep.model.cep.CepPackage;
import hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern;
import hu.bme.mit.incquery.cep.model.cep.Event;
import hu.bme.mit.incquery.cep.model.cep.EventProcessingModel;
import hu.bme.mit.incquery.cep.model.cep.IEventSource;
import hu.bme.mit.incquery.cep.model.cep.Timewindow;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.incquery.cep.model.cep.CepPackage
 * @generated
 */
public class CepAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CepPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CepAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CepPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CepSwitch<Adapter> modelSwitch =
		new CepSwitch<Adapter>() {
			@Override
			public Adapter caseEventProcessingModel(EventProcessingModel object) {
				return createEventProcessingModelAdapter();
			}
			@Override
			public Adapter caseAbstractEventPattern(AbstractEventPattern object) {
				return createAbstractEventPatternAdapter();
			}
			@Override
			public Adapter caseAtomicEventPattern(AtomicEventPattern object) {
				return createAtomicEventPatternAdapter();
			}
			@Override
			public Adapter caseComplexEventPattern(ComplexEventPattern object) {
				return createComplexEventPatternAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseIEventSource(IEventSource object) {
				return createIEventSourceAdapter();
			}
			@Override
			public Adapter caseTimewindow(Timewindow object) {
				return createTimewindowAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.model.cep.EventProcessingModel <em>Event Processing Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.model.cep.EventProcessingModel
	 * @generated
	 */
	public Adapter createEventProcessingModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern <em>Abstract Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.model.cep.AbstractEventPattern
	 * @generated
	 */
	public Adapter createAbstractEventPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.model.cep.AtomicEventPattern <em>Atomic Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.model.cep.AtomicEventPattern
	 * @generated
	 */
	public Adapter createAtomicEventPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern <em>Complex Event Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.model.cep.ComplexEventPattern
	 * @generated
	 */
	public Adapter createComplexEventPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.model.cep.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.model.cep.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.model.cep.IEventSource <em>IEvent Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.model.cep.IEventSource
	 * @generated
	 */
	public Adapter createIEventSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.bme.mit.incquery.cep.model.cep.Timewindow <em>Timewindow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.bme.mit.incquery.cep.model.cep.Timewindow
	 * @generated
	 */
	public Adapter createTimewindowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CepAdapterFactory
