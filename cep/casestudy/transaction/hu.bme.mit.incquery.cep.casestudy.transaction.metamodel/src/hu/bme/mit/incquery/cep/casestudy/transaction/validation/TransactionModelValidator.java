/**
 *
 * $Id$
 */
package hu.bme.mit.incquery.cep.casestudy.transaction.validation;

import hu.bme.mit.incquery.cep.casestudy.transaction.ModelElement;
import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link hu.bme.mit.incquery.cep.casestudy.transaction.TransactionModel}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TransactionModelValidator {
	boolean validate();

	boolean validateElements(EList<ModelElement> value);

	boolean validateElements(ModelElement value);
}