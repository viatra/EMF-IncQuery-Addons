package hu.bme.mit.incquery.cep.dsl.jvmmodel

import com.google.common.collect.Lists
import com.google.inject.Inject
import hu.bme.mit.incquery.cep.api.AbstractEventInstance
import hu.bme.mit.incquery.cep.api.ICepRule
import hu.bme.mit.incquery.cep.api.evm.CepActivationStates
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OnAppearRule
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.StaticBinding
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameter
import hu.bme.mit.incquery.cep.dsl.generator.EventPatternLanguageGenerator
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl
import java.io.FileWriter
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.incquery.runtime.evm.api.Activation
import org.eclipse.incquery.runtime.evm.api.Context
import org.eclipse.incquery.runtime.evm.api.Job
import org.eclipse.incquery.runtime.evm.api.event.ActivationState
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

import static extension org.eclipse.xtext.util.Strings.*
import org.eclipse.emf.ecore.EClass
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguageFactory
import org.eclipse.emf.ecore.EcoreFactory
import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl

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
	@Inject extension TypeReferenceSerializer typeReferenceSerializer
	@Inject private TypesFactory factory = TypesFactory.eINSTANCE;
	@Inject extension EventPatternLanguageGenerator generator

	private static int lastRule = 0;

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
		var patterns = element.packagedModel.modelElements.filter[e|(e instanceof AtomicEventPattern)]
		patterns.generateAtomicEventClasses(acceptor)
		patterns.generateAtomicEventPatterns(acceptor)

		var complexPatterns = element.packagedModel.modelElements.filter[e|(e instanceof ComplexEventPattern)]
		complexPatterns.generateComplexEventPatterns(acceptor)

		var rules = element.packagedModel.modelElements.filter[e|(e instanceof OnAppearRule)]
		rules.generateRulesAndJobs(acceptor)
	}

	def private generateAtomicEventClasses(Iterable<ModelElement> patterns, IJvmDeclaredTypeAcceptor acceptor) {
		for (pattern : patterns) {
			acceptor.accept(pattern.toClass(pattern.getFqn(AtomicPatternFqnPurpose.EVENT))).initializeLater [
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
	}

	def void generateAtomicEventPatterns(Iterable<ModelElement> patterns, IJvmDeclaredTypeAcceptor acceptor) {
		for (pattern : patterns) {
			acceptor.accept(pattern.toClass(pattern.getFqn(AtomicPatternFqnPurpose.PATTERN))).initializeLater [
				documentation = pattern.documentation
				superTypes += pattern.newTypeRef(AtomicEventPatternImpl)
				members += pattern.toConstructor [
					body = [
						append(
							'''
							super();
							setType(«pattern.getFqn(AtomicPatternFqnPurpose.EVENT)».class.getCanonicalName());
							setId("«pattern.getFqn(AtomicPatternFqnPurpose.PATTERN).lastSegment»");''')]
				]
			]
		}
	}

	def private generateComplexEventPatterns(Iterable<ModelElement> patterns, IJvmDeclaredTypeAcceptor acceptor) {
		for (pattern : patterns) {
			acceptor.accept(pattern.toClass(pattern.fqn)).initializeLater [
				documentation = pattern.documentation
				superTypes += pattern.newTypeRef(ComplexEventPatternImpl)
				members += pattern.toConstructor [
					body = [
						append(
							'''
							super();
							// TODO register ordering
							// TODO register events
							// TODO register timewindow
							setId("«pattern.name + "Pattern"»");''')]
				]
			]
		}
	}

	def private generateRulesAndJobs(Iterable<ModelElement> rules, IJvmDeclaredTypeAcceptor acceptor) {
		var generatedRuleClassNames = Lists.newArrayList

		for (rule : rules) {
			val appRule = rule as OnAppearRule

			//generate RULE class
			acceptor.accept(appRule.toClass(appRule.fqn)).initializeLater [
				documentation = appRule.documentation
				superTypes += appRule.newTypeRef(ICepRule)
				val eventPatterns = appRule.eventPatterns
				//TODO add the related eventPatterns
				members += appRule.toField("eventPatterns", appRule.newTypeRef(List, it.newTypeRef(EventPattern))) [
					initializer = [append('''«referClass(appRule, Lists)».newArrayList()''')]
				]
				members += appRule.toField("job", appRule.newTypeRef(Job, it.newTypeRef(ObservedComplexEventPattern))) [
					initializer = [
						append('''new «appRule.jobClassName»(''').append(
							'''«referClass(appRule, CepActivationStates)».ACTIVE)''')]
				]
				members += appRule.toConstructor [
					body = [
						append('''«enumerateAssignableEventPatterns(it, appRule)»''')
					]
				]
				members += appRule.toGetter("eventPatterns", appRule.newTypeRef(List, it.newTypeRef(EventPattern)))
				members += appRule.toGetter("job", appRule.newTypeRef(Job, it.newTypeRef(ObservedComplexEventPattern)))
			]

			//generate JOB class
			acceptor.accept(appRule.action.toClass(appRule.jobClassName)).initializeLater [
				documentation = appRule.documentation
				superTypes += appRule.newTypeRef(Job, it.newTypeRef(ObservedComplexEventPattern))
				members += appRule.toConstructor [
					parameters += appRule.toParameter("activationState", appRule.newTypeRef(ActivationState))
					body = [
						append(
							'''
								super(activationState);
							''')]
				]
				members += appRule.toMethod("execute", appRule.newTypeRef("void")) [
					parameters += appRule.toParameter("activation",
						appRule.newTypeRef(typeof(Activation),
							cloneWithProxies(appRule.newTypeRef(ObservedComplexEventPattern)).wildCardExtends))
					parameters += appRule.toParameter("context", appRule.newTypeRef(Context))
					body = appRule.action
				]
				members += appRule.toMethod("handleError", appRule.newTypeRef("void")) [
					parameters += appRule.toParameter("activation",
						appRule.newTypeRef(typeof(Activation),
							cloneWithProxies(appRule.newTypeRef(ObservedComplexEventPattern)).wildCardExtends))
					parameters += appRule.toParameter("exception", appRule.newTypeRef(Exception))
					parameters += appRule.toParameter("context", appRule.newTypeRef(Context))
					body = [
						append(
							'''
								//not gonna happen
							''')]
				]
			]

			generatedRuleClassNames.add(appRule.fqn)
		}

		//		fsa.generateFile(
		//			"hu.bme.mit.incquery.cep.casestudy.transaction.rulepackage".replace(".", "/") +
		//				"/TransactionRulePackage.java", rulePackageTemplate(generatedRuleClassNames))
		//generateRulePackage(generatedRuleClassNames)
		}

		def enumerateAssignableEventPatterns(ITreeAppendable appendable, OnAppearRule rule) {
			if (rule == null || rule.eventPatterns.empty) {
				return ""
			}

			for (ep : rule.eventPatterns) {
				appendable.append('''eventPatterns.add(new «getFqn(ep)»());''')
			}
		}

		def wildCardExtends(JvmTypeReference clone) {
			var result = factory.createJvmWildcardTypeReference();
			var upperBound = factory.createJvmUpperBound();
			upperBound.setTypeReference(clone);
			result.getConstraints().add(upperBound);
			return result;
		}

		def referClass(ITreeAppendable appendable, EObject ctx, Class<?> clazz, JvmTypeReference... typeArgs) {
			val ref = ctx.newTypeRef(clazz, typeArgs)
			if (ref != null) {
				appendable.serialize(ref, ctx)
			} else {

				//Class resolution error - error handling required here
				//A fallback to writing out the fqn of the class
				appendable.append(clazz.canonicalName)
			}
		}

		def serialize(ITreeAppendable appendable, JvmTypeReference ref, EObject ctx) {
			typeReferenceSerializer.serialize(ref, ctx, appendable)
		}

		def generateRulePackage(List<QualifiedName> mappedRules) {
			var fileWriter = new FileWriter(
				"hu.bme.mit.incquery.cep.casestudy.transaction.transactionpackage".replace(".", "/") +
					"/TransactionCepPackage.java")
			fileWriter.append(rulePackageTemplate(mappedRules))
			fileWriter.close()
		}

		def rulePackageTemplate(List<QualifiedName> mappedRules) '''
			package hu.bme.mit.incquery.cep.casestudy.transaction.transactionpackage;
			
			import hu.bme.mit.incquery.cep.api.ICepRule;
			import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;
			
			import java.util.List;
			
			import com.google.common.collect.Lists;
			
			public final class TransactionCepPackage implements ICepDomainPackage {
				private static TransactionCepPackage instance;
				private List<ICepRule> rules = Lists.newArrayList();
				
				public static TransactionCepPackage getInstance() {
					if (instance == null) {
						instance = new TransactionRulePackage();
					}
					return instance;
				}
			
				private TransactionRulePackage() {
					rules.add(new R1());
					«FOR r : mappedRules»
						rules.add(new «r.lastSegment»());
					«ENDFOR»
				}
				
				public List<ICepRule> getRules() {
					return rules;
				}
			}
		'''

		def private isStaticallyBound(
			TypedParameter parameter,
			List<StaticBinding> staticBindings
		) {
			for (sb : staticBindings) {
				if(sb.parameter.equals(parameter)) return true
			}
			return false
		}

		def private getJobClassName(Rule rule) {
			var className = rule.fullyQualifiedName.lastSegment
			var packageName = rule.fullyQualifiedName.skipLast(1)
			return packageName.append("jobs").append(className.toFirstUpper + "Job")
		}

		def private getFqn(ModelElement element, AtomicPatternFqnPurpose purpose) {
			var className = element.fullyQualifiedName.lastSegment
			var packageName = element.fullyQualifiedName.skipLast(1)
			switch (purpose) {
				case AtomicPatternFqnPurpose.EVENT:
					return packageName.append("events").append(className.toFirstUpper)
				case AtomicPatternFqnPurpose.PATTERN:
					return packageName.append("patterns.atomic").append(className.toFirstUpper + "Pattern")
			}
		}

		def private getFqn(ModelElement element) {
			var className = element.fullyQualifiedName.lastSegment
			var packageName = element.fullyQualifiedName.skipLast(1)

			switch element {
				ComplexEventPattern:
					return packageName.append("patterns.complex").append(className.toFirstUpper + "Pattern")
				OnAppearRule:
					if (!element.name.nullOrEmpty) {
						return packageName.append("rules").append(className.toFirstUpper)
					} else {
						lastRule = lastRule + 1
						return packageName.append("rules").append("Rule" + lastRule)
					}
			}
		}
	}
	