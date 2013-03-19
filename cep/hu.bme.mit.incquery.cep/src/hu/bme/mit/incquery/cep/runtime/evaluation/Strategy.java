package hu.bme.mit.incquery.cep.runtime.evaluation;

//TODO 	This would be a the perfect place to connect the single
// 		evaluation strategies to the entire framework. This could
//		be achieved by a provided extension point and some implementing
//		extensions in order to provide an interface for custom strategies.
public enum Strategy {
	CHRONICLE, RECENT, UNRESTRICTED;
}