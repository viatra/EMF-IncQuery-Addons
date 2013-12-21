package hu.bme.mit.incquery.cep.performance.test.generator

import com.google.common.collect.Lists
import java.io.FileWriter
import java.util.List
import com.google.common.base.Joiner
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator

class TemplateMD {
	protected FileWriter writer

	def generate(String filename, List<List<String>> perm, ComplexOperator operator) {
		this.writer = new FileWriter(filename)
		writer.append(head)
		generateComplexEvents(perm, operator)
		writer.append(tail(perm.size))
		this.writer.close
	}

	def public static head() '''
		package hu.bme.mit.incquery.cep.performance
		
		uses hu.bme.mit.incquery.cep.api.evm.*
		uses-patterns hu.bme.mit.incquery.cep.performance.md.patterns.*
		
		IQPatternEvent componentA(){
			iqPatternRef : componentA(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		
		IQPatternEvent componentB(){
			iqPatternRef : componentB(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		IQPatternEvent componentC(){
			iqPatternRef : componentC(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		IQPatternEvent componentD(){
			iqPatternRef : componentD(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		IQPatternEvent componentE(){
			iqPatternRef : componentE(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		IQPatternEvent componentF(){
			iqPatternRef : componentF(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		IQPatternEvent componentG(){
			iqPatternRef : componentG(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		IQPatternEvent componentH(){
			iqPatternRef : componentH(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		IQPatternEvent componentI(){
			iqPatternRef : componentI(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		IQPatternEvent componentJ(){
			iqPatternRef : componentJ(_)
			iqChangeType : NEW_MATCH_FOUND
		}
		
	'''

	def public generateComplexEvents(List<List<String>> perm, ComplexOperator operator) {
		var i = 1

		for (p : perm) {
			writer.append(generateComplexEvent(i, generateDefinition(p, operator)))
			i = i + 1
		}
	}

	def private generateDefinition(List<String> atomicEventList, ComplexOperator operator) {
		if (operator.equals(ComplexOperator::ORDERED)) {
			return Joiner::on(" -> ").join(atomicEventList)
		}else if (operator.equals(ComplexOperator::UNORDERED)) {
			return Joiner::on(",").join(atomicEventList)
		}
	}

	def public generateComplexEvent(int index, String definition) '''
		ComplexEvent compoundTransactionEvent«index»(){
			definition : «definition»
		}
		
	'''

	def public tail(int lastComplexEventIndex) '''
		Rule r1 {
			events:
				«FOR ce : getCEList(lastComplexEventIndex) SEPARATOR ", "»
					«ce»
				«ENDFOR»
			actionHandler: hu.bme.mit.incquery.cep.performance.actionhandlers.SimpleActionHandler2MD
		}
	'''

	def private getCEList(int lastComplexEventIndex) {
		var List<String> list = Lists::newArrayList()
		var i = 1

		while (i <= lastComplexEventIndex) {
			list.add("compoundTransactionEvent" + i)
			i = i + 1
		}

		list
	}
}
