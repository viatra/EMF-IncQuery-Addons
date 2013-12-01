/*
 * generated by Xtext
 */
package hu.bme.mit.incquery.cep.dsl.validation

import com.google.inject.Inject
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.AtomicEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ComplexEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventPatternLanguagePackage
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.EventTypedParameterWithMultiplicity
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.IQPatternEventPattern
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.ModelElement
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PackagedModel
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.Rule
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.TypedParameterList
import hu.bme.mit.incquery.cep.dsl.jvmmodel.Utils
import org.eclipse.xtext.validation.Check

import static extension com.google.common.base.Strings.*
import hu.bme.mit.incquery.cep.dsl.eventPatternLanguage.PatternUsage

//import org.eclipse.xtext.validation.Check
/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class EventPatternLanguageValidator extends AbstractEventPatternLanguageValidator {

	private static val INVALID_NAME = 'invalidName'
	private static val INVALID_ARGUMENTS = 'invalidArguments'
	private static val INVALID_ACTION_IN_RULE = "invalidRuleActions"
	private static val MISSING_IQPATTERN_USAGE = "missingIqPatternUsage"

	@Inject extension Utils

	@Check
	def uniqueName(ModelElement modelElement) {
		if(modelElement.name.nullOrEmpty) return;
		if(!(modelElement.eContainer instanceof PackagedModel)) return;

		var model = (modelElement.eContainer as PackagedModel)

		for (me : model.modelElements) {
			checkUniqueness(modelElement, me)
		}
	}

	def private checkUniqueness(ModelElement modelElement1, ModelElement modelElement2) {
		if (modelElement1.equals(modelElement2)) {
			return
		}
		if (modelElement1.name.equalsIgnoreCase(modelElement2.name))
			error("All model elements must have a unique name!",
				EventPatternLanguagePackage.Literals.MODEL_ELEMENT__NAME, INVALID_NAME)
	}

	@Check
	def validPatternCallArguments(EventTypedParameterWithMultiplicity eventTypedParameterWithMultiplicity) {
		if(eventTypedParameterWithMultiplicity.parameterList == null) return

		var parameterList = eventTypedParameterWithMultiplicity.parameterList
		var eventPatternParameter = eventTypedParameterWithMultiplicity.eventPattern
		var patternParameterNumber = getParameterNumber(eventPatternParameter)

		if (parameterList.parameters.empty && patternParameterNumber != 0) {
			error("Pattern call parameters must be specified!",
				EventPatternLanguagePackage.Literals.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST,
				INVALID_ARGUMENTS)
		}
		if (parameterList.parameters.size != patternParameterNumber) {
			error("The exact number of parameters in the referred pattern must be specified!",
				EventPatternLanguagePackage.Literals.EVENT_TYPED_PARAMETER_WITH_MULTIPLICITY__PARAMETER_LIST,
				INVALID_ARGUMENTS)
		}
	}

	@Check
	def checkRuleActions(Rule rule) {
		var actionHandler = rule.unwrapActionHandler
		var action = rule.unwrapAction

		if (actionHandler == null && action == null) {
			error("There must be either an action handler or an action registered for this rule.",
				EventPatternLanguagePackage.Literals.MODEL_ELEMENT__NAME, INVALID_ACTION_IN_RULE)
		}

		if (actionHandler != null && action != null) {
			warning("The rule has both an action handler and additional actions defined.",
				EventPatternLanguagePackage.Literals.MODEL_ELEMENT__NAME, INVALID_ACTION_IN_RULE)
		}
	}

	def private int getParameterNumber(EventPattern eventPattern) {
		switch (eventPattern) {
			AtomicEventPattern: getTypedParamterListSize(eventPattern.parameters)
			IQPatternEventPattern: getTypedParamterListSize(eventPattern.parameters)
			ComplexEventPattern: getTypedParamterListSize(eventPattern.parameters)
			default: 0
		}
	}

	def private int getTypedParamterListSize(TypedParameterList parameterList) {
		if(parameterList == null) return 0
		if(parameterList.parameters.empty) return 0
		return parameterList.parameters.size
	}

	@Check
	def explicitlyImportedIQPatternPackage(IQPatternEventPattern iqPatternEventPattern) {
		var packagedModel = (iqPatternEventPattern.eContainer as PackagedModel)
		if(!(packagedModel.usages.filter[u | u instanceof PatternUsage].size==1)){
			error("Missing 'uses-patterns' statement for IncQuery patterns.",
				EventPatternLanguagePackage.Literals.IQ_PATTERN_EVENT_PATTERN__IQ_PATTERN_REF, MISSING_IQPATTERN_USAGE
			)
		}
	}
}
