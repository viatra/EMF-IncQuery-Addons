package hu.bme.mit.incquery.cep.dsl.jvmmodel

import com.google.common.collect.Lists
import com.google.inject.Inject
import hu.bme.mit.incquery.cep.api.IActionHandler
import hu.bme.mit.incquery.cep.api.ICepRule
import hu.bme.mit.incquery.cep.api.ParameterizableComplexEventPattern
import hu.bme.mit.incquery.cep.api.ParameterizableEventInstance
import hu.bme.mit.incquery.cep.api.evm.CepActivationStates
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventModel
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TimedMultiplicityExpression
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.impl.IQPatternEventPatternImpl
import hu.bme.mit.incquery.cep.metamodels.cep.CepFactory
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern
import hu.bme.mit.incquery.cep.metamodels.cep.GlobalTimewindow
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource
import hu.bme.mit.incquery.cep.metamodels.cep.impl.AtomicEventPatternImpl
import java.io.FileWriter
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.incquery.runtime.evm.api.Activation
import org.eclipse.incquery.runtime.evm.api.Context
import org.eclipse.incquery.runtime.evm.api.Job
import org.eclipse.incquery.runtime.evm.api.event.ActivationState
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

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

		var iqPatterns = element.packagedModel.modelElements.filter[e|(e instanceof IQPatternEventPattern)]
		iqPatterns.generateAtomicEventClasses(acceptor)
		iqPatterns.generateAtomicEventPatterns(acceptor)

		var complexPatterns = element.packagedModel.modelElements.filter[e|(e instanceof ComplexEventPattern)]
		complexPatterns.generateComplexEventPatterns(acceptor)

		var rules = element.packagedModel.modelElements.filter[e|(e instanceof Rule)]
		rules.generateRulesAndJobs(acceptor)
	}

	def private getParamList(ModelElement modelElement) {
		switch (modelElement) {
			AtomicEventPattern:
				return getParamList(modelElement)
			IQPatternEventPattern:
				return getParamList(modelElement)
		}
	}

	def private dispatch getParamList(AtomicEventPattern pattern) {
		return (pattern as AtomicEventPattern).parameters
	}

	def private dispatch getParamList(IQPatternEventPattern pattern) {
		return (pattern as IQPatternEventPattern).parameters
	}

	def private generateAtomicEventClasses(Iterable<ModelElement> patterns, IJvmDeclaredTypeAcceptor acceptor) {
		for (pattern : patterns) {
			acceptor.accept(pattern.toClass(pattern.getFqn(AtomicPatternFqnPurpose.EVENT))).initializeLater [
				documentation = pattern.documentation
				superTypes += pattern.newTypeRef(ParameterizableEventInstance)
				val paramList = getParamList(pattern)
				if (paramList != null) {
					for (parameter : paramList.parameters) {
						members += pattern.toField(parameter.name, parameter.type)
					}
				}
				members += pattern.toConstructor [
					parameters += toParameter("eventSource", pattern.newTypeRef(IEventSource))
					body = [
						append(
							'''
								super(eventSource);
							''').append(
							'''
								«IF paramList != null»
									«FOR parameter : paramList.parameters»
										getParameters().add(«parameter.name»);
									«ENDFOR»
								«ENDIF»
							''')
					]
				]
				if (paramList != null) {
					var i = 0
					for (parameter : paramList.parameters) {
						members += pattern.toGetter(parameter.name, parameter.type)
						members += pattern.toAdvancedSetter(parameter.name, parameter.type, i)
						i = i + 1
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
								setId("«pattern.getFqn(AtomicPatternFqnPurpose.PATTERN).lastSegment»");
							'''
						)]
				]
				members += pattern.toMethod("checkStaticBindings", pattern.newTypeRef("boolean")) [
					if (pattern.staticBindings == null) {
						body = [
							append('''return true;''')
						]
					} else {
						body = pattern.staticBindings
					}
				]
			]
		}
	}

	def private getStaticBindings(ModelElement element) {
		switch (element) {
			AtomicEventPattern:
				return (element as AtomicEventPattern).staticBindings
			default:
				return null
		}
	}

	def private generateComplexEventPatterns(Iterable<ModelElement> patterns, IJvmDeclaredTypeAcceptor acceptor) {
		for (pattern : patterns) {
			acceptor.accept(pattern.toClass(pattern.fqn)).initializeLater [
				documentation = pattern.documentation
				superTypes += pattern.newTypeRef(ParameterizableComplexEventPattern)
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
				members += (pattern as ComplexEventPattern).toImplementingBindingMethod()
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
		appendable.append('''setId("«patternName.toFirstUpper»_Pattern");''')
	}

	def private generateRulesAndJobs(Iterable<ModelElement> rules, IJvmDeclaredTypeAcceptor acceptor) {
		var generatedRuleClassNames = Lists.newArrayList

		for (r : rules) {
			val rule = r as Rule

			//generate RULE class
			rule.generateRuleClass(acceptor)

			//generate JOB class
			rule.generateJobClass(acceptor)

			generatedRuleClassNames.add(rule.fqn)
		}
	}

	def private generateRuleClass(Rule rule, IJvmDeclaredTypeAcceptor acceptor) {
		acceptor.accept(rule.toClass(rule.fqn)).initializeLater [
			documentation = rule.documentation
			superTypes += rule.newTypeRef(ICepRule)
			val eventPatterns = rule.eventPatterns
			members += rule.toField("eventPatterns", rule.newTypeRef(List, it.newTypeRef(EventPattern))) [
				initializer = [append('''«referClass(rule, Lists)».newArrayList()''')]
			]
			members += rule.toField("job", rule.newTypeRef(Job, it.newTypeRef(IObservableComplexEventPattern))) [
				initializer = [
					append('''new «rule.jobClassName»(''').append(
						'''«referClass(rule, CepActivationStates)».ACTIVE)''')]
			]
			members += rule.toConstructor [
				body = [
					append('''«enumerateAssignableEventPatterns(it, rule)»''')
				]
			]
			var patternsGetter = rule.toGetter("eventPatterns", rule.newTypeRef(List, it.newTypeRef(EventPattern)))
			var jobGetter = rule.toGetter("job",
				rule.newTypeRef(Job, it.newTypeRef(IObservableComplexEventPattern)))
			patternsGetter.addOverrideAnnotation(rule)
			jobGetter.addOverrideAnnotation(rule)
			members += patternsGetter
			members += jobGetter
		]
	}

	def private generateJobClass(Rule appRule, IJvmDeclaredTypeAcceptor acceptor) {
		acceptor.accept(appRule.toClass(appRule.jobClassName)).initializeLater [
			documentation = appRule.documentation
			superTypes += appRule.newTypeRef(Job, it.newTypeRef(IObservableComplexEventPattern))
			members += appRule.toConstructor [
				parameters += appRule.toParameter("activationState", appRule.newTypeRef(ActivationState))
				body = [
					append(
						'''
						super(activationState);''')]
			]
			var executeMethod = appRule.toMethod("execute", appRule.newTypeRef("void")) [
				parameters += appRule.toParameter("activation",
					appRule.newTypeRef(typeof(Activation),
						cloneWithProxies(appRule.newTypeRef(IObservableComplexEventPattern)).wildCardExtends))
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
			executeMethod.addOverrideAnnotation(appRule)
			var errorMethod = appRule.toMethod("handleError", appRule.newTypeRef("void")) [
				parameters += appRule.toParameter("activation",
					appRule.newTypeRef(typeof(Activation),
						cloneWithProxies(appRule.newTypeRef(IObservableComplexEventPattern)).wildCardExtends))
				parameters += appRule.toParameter("exception", appRule.newTypeRef(Exception))
				parameters += appRule.toParameter("context", appRule.newTypeRef(Context))
				body = [
					append(
						'''
						//not gonna happen''')]
			]
			errorMethod.addOverrideAnnotation(appRule)
			members += executeMethod
			members += errorMethod
		]
	}

	def private generateActionHandlerBody(ITreeAppendable appendable, EObject ctx) {
		var actionHandler = (ctx as Rule).actionHandler
		appendable.append(
			'''
			«referClass(appendable, ctx, IActionHandler)» actionHandler = new «actionHandler»();
			actionHandler.handle(activation);'''
		)
	}

	def enumerateAssignableEventPatterns(ITreeAppendable appendable, Rule rule) {
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
