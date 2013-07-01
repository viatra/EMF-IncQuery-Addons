package hu.bme.mit.incquery.cep.api.strategy;

import hu.bme.mit.incquery.cep.metamodels.internalsm.EventProcessingContext;

//TODO 	This would be a the perfect place to connect the single
// 		evaluation strategies to the entire framework. This could
//		be achieved by a provided extension point and some implementing
//		extensions in order to provide an interface for custom strategies.

//TODO	Also an important aspect: if we want to capture multiple occurrences
//		of an event pattern (and why wouldn't we?), on the transition leaving
//		the InitState, a new state machine shall be instantiated and initialized.
//		This behavior could be specified here as well.
/**
 * @deprecated use the generated enum instead ({@link EventProcessingContext})
 * @author idavid
 *
 */
@Deprecated
public enum Strategy {
	/**
	 * Chronicle is the default behavior of event processing state machines.
	 */
	CHRONICLE, RECENT, UNRESTRICTED;
	
	public static Strategy getDefault() {
		return CHRONICLE;
	}
}