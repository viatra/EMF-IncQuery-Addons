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
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
import org.eclipse.xtext.xbase.XExpression

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
		var patterns = element.packagedModel.modelElements.filter[e|(e instanceof AtomicEventPattern)]

		for (pattern : patterns) {
			acceptor.accept(pattern.toClass(pattern.fqn)).initializeLater [
				documentation = pattern.documentation
				superTypes += pattern.newTypeRef(AbstractEventInstance)
				members += pattern.toConstructor [
					parameters += toParameter("eventSource", pattern.newTypeRef(IEventSource))
					body = [append('''super(eventSource);''')]
				]
				var staticBindings = (pattern as AtomicEventPattern).staticBindings
				var paramList = (pattern as AtomicEventPattern).parameters
				for (dynamicParameter : paramList.parameters) {
					members += pattern.toField(dynamicParameter.name, dynamicParameter.type)
					members += pattern.toGetter(dynamicParameter.name, dynamicParameter.type)
					if (!dynamicParameter.isStaticallyBound(staticBindings)) {
						members += pattern.toSetter(dynamicParameter.name, dynamicParameter.type)
					}
				}
			]
		}

		var complexPatterns = element.packagedModel.modelElements.filter[e|(e instanceof ComplexEventPattern)]

		for (pattern : complexPatterns) {
			acceptor.accept(pattern.toClass(pattern.fqn)).initializeLater [
				documentation = pattern.documentation
				superTypes += pattern.newTypeRef(ComplexEventPatternImpl)
				members += pattern.toConstructor [
					body = [append('''
						super();
						// TODO register ordering
						// TODO register events
						// TODO register timewindow
						setId("«pattern.name+"Pattern"»");''')]
				]
			]
		}
	}

	def private isStaticallyBound(TypedParameter parameter, List<StaticBinding> staticBindings) {
		for (sb : staticBindings) {
			if(sb.parameter.equals(parameter)) return true
		}
		return false
	}

	def private getFqn(ModelElement element) {
		var className = element.fullyQualifiedName.lastSegment
		var packageName = element.fullyQualifiedName.skipLast(1)

		switch element {
			AtomicEventPattern: return packageName.append("events").append(className.toFirstUpper)
			ComplexEventPattern: return packageName.append("patterns").append(className.toFirstUpper+"_Pattern")
		}
	}
}
