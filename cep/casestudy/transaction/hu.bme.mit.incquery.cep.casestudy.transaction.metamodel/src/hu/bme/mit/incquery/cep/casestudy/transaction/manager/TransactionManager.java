package hu.bme.mit.incquery.cep.casestudy.transaction.manager;

import hu.bme.mit.incquery.cep.casestudy.transaction.Component;
import hu.bme.mit.incquery.cep.casestudy.transaction.CompoundTransactionEvent;
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

        public void setLatestComponentEvent(Component component) {
                model.setLatestComponentEvent(component);
        }

        public void addCompoundTransactionEvent(
                        CompoundTransactionEvent compoundTransactionEvent) {
                model.getCompoundTransactionEvents().add(compoundTransactionEvent);
        }
        
        public void deleteCompoundTransactionEvents(){
                model.getCompoundTransactionEvents().clear();
        }
}