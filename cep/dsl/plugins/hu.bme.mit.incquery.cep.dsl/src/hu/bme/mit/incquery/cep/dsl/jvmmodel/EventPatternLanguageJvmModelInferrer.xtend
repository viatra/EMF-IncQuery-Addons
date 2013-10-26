package hu.bme.mit.incquery.cep.dsl.jvmmodel

import com.google.common.collect.Lists
import com.google.inject.Inject
import hu.bme.mit.incquery.cep.api.AbstractEventInstance
import hu.bme.mit.incquery.cep.api.ICepRule
import hu.bme.mit.incquery.cep.api.evm.CepActivationStates
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.OnAppearRule
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression
import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern
import hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource
import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl
import hu.bme.mit.incquery.cep.metamodels.cep.impl.ComplexEventPatternImpl
import java.io.FileWriter
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.incquery.runtime.evm.api.Activation
import org.eclipse.incquery.runtime.evm.api.Context
import org.eclipse.incquery.runtime.evm.api.Job
import org.eclipse.incquery.runtime.evm.api.event.ActivationState
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule
import com.google.common.base.Preconditions
import org.eclipse.xtext.xbase.XExpression
import hu.bme.mit.incquery.cep.api.IActionHandler
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import java.util.Map
import com.google.common.collect.Maps

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
	@Inject extension JvmTypesBuilder jvmTypesBuilder
	@Inject extension Utils
	@Inject extension XbaseCompiler xbaseCompiler

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
				members += pattern.toField("parameters",
					pattern.newTypeRef(List, jvmTypesBuilder.newTypeRef(pattern, Object))) [
					initializer = [
						append('''«referClass(pattern, Lists)»''').append('''.newArrayList()''')
					]
				]
				val paramList = (pattern as AtomicEventPattern).parameters
				for (parameter : paramList.parameters) {
					members += pattern.toField(parameter.name, parameter.type)
				}
				members += pattern.toConstructor [
					parameters += toParameter("eventSource", pattern.newTypeRef(IEventSource))
					body = [
						append(
							'''
								super(eventSource);
							''').append(
							'''
								«FOR parameter : paramList.parameters»
									parameters.add(«parameter.name»);
								«ENDFOR»
							''')
					]
				]
				members +=
					pattern.toGetter("parameters", pattern.newTypeRef(List, jvmTypesBuilder.newTypeRef(pattern, Object)))
				members +=
					pattern.toMethod("getParameter", pattern.newTypeRef(Object))[
						parameters += pattern.toParameter("i", pattern.newTypeRef(int))
						body=[
							append('''return parameters.get(i);''')
						]
					]
				for (parameter : paramList.parameters) {
					members += pattern.toGetter(parameter.name, parameter.type)
					members += pattern.toSetter(parameter.name, parameter.type)
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
								setId("«pattern.getFqn(AtomicPatternFqnPurpose.PATTERN).lastSegment»");
							'''
						)]
				]
				members += pattern.toMethod("checkStaticBindings", pattern.newTypeRef("boolean")) [
					if ((pattern as AtomicEventPattern).staticBindings == null) {
						body = [
							append('''return true;''')
						]
					} else {
						body = (pattern as AtomicEventPattern).staticBindings
					}
				]
			]
		}
	}

	def private generateComplexEventPatterns(Iterable<ModelElement> patterns, IJvmDeclaredTypeAcceptor acceptor) {
		for (pattern : patterns) {
			acceptor.accept(pattern.toClass(pattern.fqn)).initializeLater [
				documentation = pattern.documentation
				superTypes += pattern.newTypeRef(ComplexEventPatternImpl)
				members += pattern.toField("paramValues",
					pattern.newTypeRef(Map, jvmTypesBuilder.newTypeRef(pattern, String),
						jvmTypesBuilder.newTypeRef(pattern, Object))) [
					initializer = [
						append('''«referClass(pattern, Maps)»''').append('''.newHashMap()''')
					]
				]
				members += pattern.toConstructor [
					body = [
						append(
							'''
								super();
							'''
						)
						createOrdering(
							it,
							pattern,
							(pattern as ComplexEventPattern).complexEventExpression
						)
						defineCompositionEvents(
							it,
							pattern,
							(pattern as ComplexEventPattern).complexEventExpression
						)
						createGlobalTimewindow(
							it,
							pattern,
							(pattern as ComplexEventPattern).complexEventExpression
						)
						setId(it, pattern, pattern.name)
					]
				]
			]
		}
	}

	def private createOrdering(ITreeAppendable appendable, EObject ctx, ComplexEventExpression expression) {
		appendable.append('''setOperator(''').append('''«referClass(appendable, ctx, ComplexOperator)».''').append(
			'''«getOperator(expression)»''').append(
			''');
				''')
	}

	def private getOperator(ComplexEventExpression expression) {
		var ex = expression.unwrapExpression
		return ex.getComplexOperator
	}

	def private defineCompositionEvents(ITreeAppendable appendable, EObject ctx, ComplexEventExpression expression) {
		appendable.append(
			'''
				
				// composition events
			''').append(
			'''
			«referClass(appendable, ctx, List, jvmTypesBuilder.newTypeRef(ctx, EventPattern))» ''').append(
			'''
			atomicEventPatternsForCP = ''').append(
			'''
				«referClass(appendable, ctx, Lists)».newArrayList();
			''')

		var ex = expression.unwrapExpression

		for (ep : ex.assignedEventPatterns) {
			appendable.append(
				'''
				atomicEventPatternsForCP.add(new '''
			).append(
				'''«ep.getFqn(AtomicPatternFqnPurpose.PATTERN)»());
					'''
			)
		}
		appendable.append(
			'''
				getCompositionEvents().addAll(atomicEventPatternsForCP);
			'''
		)

	}

	def private createGlobalTimewindow(ITreeAppendable appendable, EObject ctx, ComplexEventExpression expression) {
		if (!((expression instanceof TimedExpression) || (expression instanceof TimedMultiplicityExpression))) {
			return ""
		}

		appendable.append(
			'''
				
				// timewindows
			''').append(
			'''
			«referClass(appendable, ctx, GlobalTimewindow)» timewindow = ''').append(
			'''
				«referClass(appendable, ctx, CepFactory)».eINSTANCE.createGlobalTimewindow();
			''')

		if (expression instanceof TimedExpression) {
			var tw = (expression as TimedExpression).timewindow
			appendable.append(
				'''
					timewindow.setLength(«tw.length»l);
					setGlobalTimewindow(timewindow);
					
				''');
		}

		if (expression instanceof TimedMultiplicityExpression) {
			var tw = (expression as TimedMultiplicityExpression).timewindow
			appendable.append(
				'''
					timewindow.setLength(«tw.length»l);
					setGlobalTimewindow(timewindow);
				''');
		}
	}

	def private setId(ITreeAppendable appendable, EObject ctx, String patternName) {
		appendable.append('''setId("«patternName.toFirstUpper»Pattern");''')
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
				members += appRule.toField("job",
					appRule.newTypeRef(Job, it.newTypeRef(ObservedComplexEventPattern))) [
					initializer = [
						append('''new «appRule.jobClassName»(''').append(
							'''«referClass(appRule, CepActivationStates)».ACTIVE)''')]
				]
				members += appRule.toConstructor [
					body = [
						append('''«enumerateAssignableEventPatterns(it, appRule)»''')
					]
				]
				members +=
					appRule.toGetter("eventPatterns", appRule.newTypeRef(List, it.newTypeRef(EventPattern)))
				members += appRule.toGetter("job",
					appRule.newTypeRef(Job, it.newTypeRef(ObservedComplexEventPattern)))
			]

			//generate JOB class
			acceptor.accept(appRule.toClass(appRule.jobClassName)).initializeLater [
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
					if (appRule.action != null) {
						body = appRule.action
					}
					if (appRule.actionHandler != null) {
						body = [
							generateActionHandlerBody(appRule)
						]
					}
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

		def private generateActionHandlerBody(ITreeAppendable appendable, EObject ctx) {
			var actionHandler = (ctx as OnAppearRule).actionHandler
			appendable.append(
				'''
					«referClass(appendable, ctx, IActionHandler)» actionHandler = new «actionHandler»();
					actionHandler.handle(activation);
				'''
			)
		}

		def enumerateAssignableEventPatterns(ITreeAppendable appendable, OnAppearRule rule) {
			if (rule == null || rule.eventPatterns.empty) {
				return ""
			}

			for (ep : rule.eventPatterns) {
				appendable.append(
					'''eventPatterns.add(new «getFqn(ep)»());
						''')
			}
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
	}
	