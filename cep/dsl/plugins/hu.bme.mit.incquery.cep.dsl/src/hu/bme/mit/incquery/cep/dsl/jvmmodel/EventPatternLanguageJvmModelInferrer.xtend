package hu.bme.mit.incquery.cep.dsl.jvmmodel

import com.google.inject.Inject
import hu.bme.mit.incquery.cep.api.AbstractEventInstance
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import java.util.List
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class EventPatternLanguageJvmModelInferrer extends AbstractModelInferrer {
	/**
     * convenience API to build and initialize JVM types and their members.
     */
	@Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider

	/**
	 * The dispatch method {@code infer} is called for each instance of the
	 * given element's type that is contained in a resource.
	 * 
	 * @param element
	 *            the model to create one or more
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType declared
	 *            types} from.
	 * @param acceptor
	 *            each created
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType type}
	 *            without a container should be passed to the acceptor in order
	 *            get attached to the current resource. The acceptor's
	 *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
	 *            accept(..)} method takes the constructed empty type for the
	 *            pre-indexing phase. This one is further initialized in the
	 *            indexing phase using the closure you pass to the returned
	 *            {@link org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
	 *            initializeLater(..)}.
	 * @param isPreIndexingPhase
	 *            whether the method is called in a pre-indexing phase, i.e.
	 *            when the global index is not yet fully updated. You must not
	 *            rely on linking using the index if isPreIndexingPhase is
	 *            <code>true</code>.
	 */
	def dispatch void infer(EventModel element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {

		// Here you explain how your model is mapped to Java elements, by writing the actual translation code.
		var atomicPatterns = element.packagedModel.modelElements.filter[e|(e instanceof AtomicEventPattern)]

		for (atomicPattern : atomicPatterns) {
			acceptor.accept(atomicPattern.toClass(atomicPattern.fullyQualifiedName)).initializeLater [
				documentation = atomicPattern.documentation
				superTypes += atomicPattern.newTypeRef(AbstractEventInstance)
				members += atomicPattern.toConstructor [
					parameters += toParameter("eventSource", atomicPattern.newTypeRef(IEventSource))
					body = [append('''super(eventSource);''')]
				]
				var staticBindings = (atomicPattern as AtomicEventPattern).staticBindings
				var paramList = (atomicPattern as AtomicEventPattern).parameters
				for (dynamicParameter : paramList.parameters) {
					members += atomicPattern.toField(dynamicParameter.name, dynamicParameter.type)
					members += atomicPattern.toGetter(dynamicParameter.name, dynamicParameter.type)
					if(!dynamicParameter.isStaticallyBound(staticBindings)){
						members += atomicPattern.toSetter(dynamicParameter.name, dynamicParameter.type)	
					}
				}
			]
		}
	}

	def private isStaticallyBound(TypedParameter parameter, List<StaticBinding> staticBindings) {
		for (sb : staticBindings) {
			if(sb.parameter.equals(parameter)) return true
		}
		return false
	}
}
