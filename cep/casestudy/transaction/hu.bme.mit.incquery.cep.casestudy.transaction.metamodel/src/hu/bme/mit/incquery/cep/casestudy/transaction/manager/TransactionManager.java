package hu.bme.mit.incquery.cep.casestudy.transaction.manager;

import org.eclipse.emf.common.util.EList;

import hu.bme.mit.incquery.cep.casestudy.transaction.Component;
import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
import hu.bme.mit.incquery.cep.casestudy.transaction.ModelElement;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionFactory;
import hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel;

public class TransactionManager {
	private static TransactionManager instance;

	private TransactionModel model;

	public static TransactionManager getInstance() {
		if (instance == null) {
			instance = new TransactionManager();
		}

		return instance;
	}

	private TransactionManager() {
		this.model = TransactionFactory.eINSTANCE.createTransactionModel();
	}

	public void addComponent(Component component) {
		model.getElements().add(component);
	}

	public void addCompoundTransactionEvent(
			CompoundTransactionEvent compoundTransactionEvent) {
		model.getElements().add(compoundTransactionEvent);
	}
	
	public EList<ModelElement> getModelElements(){
		return model.getElements();
	}
}
