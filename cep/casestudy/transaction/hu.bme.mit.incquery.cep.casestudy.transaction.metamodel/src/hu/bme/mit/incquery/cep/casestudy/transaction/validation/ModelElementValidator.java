/**
 *
 * $Id$
 */
package hu.bme.mit.incquery.cep.casestudy.transaction.validation;


/**
 * A sample validator interface for {@link hu.bme.mit.incquery.cep.casestudy.transaction.ModelElement}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ModelElementValidator {
	boolean validate();

	boolean validateTransactionId(String value);
}
