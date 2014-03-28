/**
 *
 * $Id$
 */
package hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.validation;

import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.Component;
import hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.CompoundTransactionEvent;

/**
 * A sample validator interface for {@link hu.bme.mit.incquery.cep.performance.md.metamodels.performancetransaction.TransactionModel}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TransactionModelValidator {
	boolean validate();

	boolean validateLatestComponentEvent(Component value);
	boolean validateLatestCompoundEvent(CompoundTransactionEvent value);
}